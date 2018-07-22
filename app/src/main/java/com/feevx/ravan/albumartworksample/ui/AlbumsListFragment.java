package com.feevx.ravan.albumartworksample.ui;


import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.feevx.ravan.albumartworksample.MainActivity;
import com.feevx.ravan.albumartworksample.R;
import com.feevx.ravan.albumartworksample.api.ItunesWebservice;
import com.feevx.ravan.albumartworksample.api.response.albumlist.Album;
import com.feevx.ravan.albumartworksample.api.response.albumlist.AlbumsResponse;
import com.feevx.ravan.albumartworksample.utils.RxSearchObservable;
import com.victor.loading.rotate.RotateLoading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class AlbumsListFragment extends Fragment implements AlbumsAdapter.AlbumClickHandler {


    @Inject
    Application mContext;
    @Inject
    ItunesWebservice mItunesWebservice;

    @BindView(R.id.search_view)
    SearchView mSearchView;
    @BindView(R.id.albums_list_view)
    RecyclerView mAlbumsListView;
    Unbinder unbinder;
    @BindView(R.id.rotateloading)
    RotateLoading mRotateloading;
    @BindView(R.id.start_search_btn)
    Button mStartSearchBtn;
    @BindView(R.id.empty_list_layout)
    LinearLayout mEmptyListLayout;

    private View mRootView;
    private AlbumsAdapter mAlbumsAdapter;

    public AlbumsListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_albums_list, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureSearchView();
        configureList();
        configureDagger();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.hideBackButton();


    }

    @SuppressLint("CheckResult")
    private void configureSearchView() {
        mSearchView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        RxSearchObservable.fromView(mSearchView, mRotateloading)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String text) throws Exception {
                        if (text.isEmpty()) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                })

                .distinctUntilChanged()
                .switchMap(new Function<String, ObservableSource<AlbumsResponse>>() {
                    @Override
                    public ObservableSource<AlbumsResponse> apply(String query) throws Exception {
                        return dataFromNetwork(query);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AlbumsResponse>() {
                               @Override
                               public void accept(AlbumsResponse albumsResponse) throws Exception {
                                   List<Album> albums = sortList(albumsResponse.getResults());
                                   updateUI(albums);
                               }
                           },
                        e -> {
                            Log.d("searchError", "configureSearchView:  " + e.getMessage());
                            stopLoading();
                        });

        mStartSearchBtn.setOnClickListener(startSearchBtn -> {
            mSearchView.setIconified(false);
        });
        mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                    mEmptyListLayout.setVisibility(View.GONE);
                else if (mAlbumsAdapter.getItemCount() == 0)
                    mEmptyListLayout.setVisibility(View.VISIBLE);
            }
        });


    }


    private ObservableSource<AlbumsResponse> dataFromNetwork(String query) {
        return mItunesWebservice.getAlbums(query);
    }

    private void configureDagger() {
        AndroidSupportInjection.inject(this);
    }


    private void configureList() {
        mAlbumsListView.setLayoutManager(new LinearLayoutManager(mContext));
        mAlbumsAdapter = new AlbumsAdapter(this);
        mAlbumsListView.setAdapter(mAlbumsAdapter);
    }

    private void updateUI(List<Album> albums) {
        stopLoading();
        mAlbumsAdapter.updateData(albums);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    void startLoading() {
        mRotateloading.start();
    }

    void stopLoading() {
        mRotateloading.stop();
    }

    @Override
    public void onAlbumClicked(Album album) {
        mSearchView.clearFocus();
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction()
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .add(R.id.main_container, AlbumDetailsFragment.newInstance(album.getCollectionId()), null)
                .commit();
    }

    List<Album> sortList(List<Album> list) {
        Collections.sort(list, new Comparator<Album>() {
            @Override
            public int compare(Album album1, Album album2) {
                return album1.getCollectionName().compareTo(album2.getCollectionName());
            }
        });
        return list;
    }
}
