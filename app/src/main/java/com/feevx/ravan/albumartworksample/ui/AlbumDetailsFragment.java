package com.feevx.ravan.albumartworksample.ui;


import android.app.Application;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.feevx.ravan.albumartworksample.MainActivity;
import com.feevx.ravan.albumartworksample.R;
import com.feevx.ravan.albumartworksample.api.ItunesWebservice;
import com.feevx.ravan.albumartworksample.api.response.albumdetails.AlbumDetailsResponse;
import com.feevx.ravan.albumartworksample.api.response.albumdetails.Track;
import com.feevx.ravan.albumartworksample.databinding.FragmentAlbumDetailsBinding;
import com.victor.loading.rotate.RotateLoading;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumDetailsFragment extends Fragment {

    private static final String COLLECTION_ID = "collectionId";
    @Inject
    Application mContext;
    @Inject
    ItunesWebservice mItunesWebservice;

    @BindView(R.id.track_list_view)
    RecyclerView mTrackListView;
    Unbinder unbinder;
    @BindView(R.id.rotateloading)
    RotateLoading mRotateloading;

    private View mRootView;
    private TracksAdapter mTracksAdapter;
    private int collectionId;
    private Disposable mAlbumDtlsDisposable;
    FragmentAlbumDetailsBinding mAlbumDetailsBinding;
    private MainActivity mainActivity;

    public AlbumDetailsFragment() {
    }

    public static AlbumDetailsFragment newInstance(int collectionId) {
        AlbumDetailsFragment albumDetailsFragment = new AlbumDetailsFragment();

        Bundle args = new Bundle();
        args.putInt(COLLECTION_ID, collectionId);
        albumDetailsFragment.setArguments(args);

        return albumDetailsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle args = getArguments();
        if (args != null)
            collectionId = args.getInt(COLLECTION_ID);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAlbumDetailsBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_album_details, container, false);
        unbinder = ButterKnife.bind(this, mAlbumDetailsBinding.getRoot());
        return mAlbumDetailsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.showBackButton();
        configureList();
        configureDagger();
        fetchAlbumData();

    }

    private void configureDagger() {
        AndroidSupportInjection.inject(this);
    }

    private void fetchAlbumData() {
        startLoading();
        mAlbumDtlsDisposable = mItunesWebservice.getAlbums(collectionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateUI);
    }

    private void configureList() {
        mTrackListView.setLayoutManager(new LinearLayoutManager(mContext));
        mTracksAdapter = new TracksAdapter();
        mTrackListView.setAdapter(mTracksAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mainActivity.hideBackButton();
        unbinder.unbind();
    }

    private void updateUI(AlbumDetailsResponse albumDetailsResponse) {
        stopLoading();
        mAlbumDetailsBinding.setTrack(albumDetailsResponse.getResults().get(0));
        List<Track> tracks = albumDetailsResponse.getResults();
        tracks.remove(0);
        mTracksAdapter.updateData(tracks);
    }

    void startLoading() {
        mRotateloading.start();
    }

    void stopLoading() {
        mRotateloading.stop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mAlbumDtlsDisposable.dispose();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
