package com.feevx.ravan.albumartworksample.di;

import android.app.Application;

import com.feevx.ravan.albumartworksample.AlbumArtworkApp;
import com.feevx.ravan.albumartworksample.di.modules.ActivityModule;
import com.feevx.ravan.albumartworksample.di.modules.AppModule;
import com.feevx.ravan.albumartworksample.di.modules.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(AlbumArtworkApp app);
}
