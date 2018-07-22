package com.feevx.ravan.albumartworksample.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.feevx.ravan.albumartworksample.R;
import com.feevx.ravan.albumartworksample.api.response.albumdetails.Track;
import com.feevx.ravan.albumartworksample.api.response.albumlist.Album;
import com.feevx.ravan.albumartworksample.databinding.AlbumItemLayoutBinding;
import com.feevx.ravan.albumartworksample.databinding.TrackItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    private final List<Track> mData = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TrackItemLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.track_item_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Track track = mData.get(position);
        holder.mBinding.setTrack(track);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<Track> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final TrackItemLayoutBinding mBinding;

        ViewHolder(final TrackItemLayoutBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Track track){
            mBinding.setVariable(BR.track, track);
            mBinding.executePendingBindings();
        }


    }


}
