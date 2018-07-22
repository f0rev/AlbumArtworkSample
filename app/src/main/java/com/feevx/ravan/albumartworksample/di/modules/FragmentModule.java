package com.feevx.ravan.albumartworksample.di.modules;

import com.feevx.ravan.albumartworksample.ui.AlbumDetailsFragment;
import com.feevx.ravan.albumartworksample.ui.AlbumsListFragment;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract AlbumsListFragment contributeAlbumsListFragment();

    @ContributesAndroidInjector
    abstract AlbumDetailsFragment contributeAlbumDetailsFragment();

}
