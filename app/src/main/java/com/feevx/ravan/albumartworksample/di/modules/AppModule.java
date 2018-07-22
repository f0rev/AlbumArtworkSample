package com.feevx.ravan.albumartworksample.di.modules;

import android.app.Application;

import com.feevx.ravan.albumartworksample.api.ItunesWebservice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {


    //network injection
    private static String BASE_URL = "https://itunes.apple.com";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    ItunesWebservice provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(ItunesWebservice.class);
    }

//    @Provides
//    @Singleton
//    ConnectionLiveData provideConnectionLiveData(Application application){
//        return new ConnectionLiveData( application);
//    }

}
