package com.feevx.ravan.albumartworksample.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.feevx.ravan.albumartworksample.R;
import com.feevx.ravan.albumartworksample.api.response.albumlist.Album;
import com.feevx.ravan.albumartworksample.databinding.AlbumItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    private final List<Album> mData = new ArrayList<>();
    private AlbumClickHandler mAlbumClickHandler;

    public AlbumsAdapter(AlbumClickHandler albumClickHandler) {
        mAlbumClickHandler = albumClickHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AlbumItemLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.album_item_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Album album = mData.get(position);
        holder.mBinding.setAlbum(album);
        holder.mBinding.albumLayout.setOnClickListener(v -> mAlbumClickHandler.onAlbumClicked(album));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<Album> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public interface AlbumClickHandler {
        void onAlbumClicked(Album album);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final AlbumItemLayoutBinding mBinding;

        ViewHolder(final AlbumItemLayoutBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Album album){
            mBinding.setVariable(BR.album, album);
            mBinding.executePendingBindings();
        }


    }


}
