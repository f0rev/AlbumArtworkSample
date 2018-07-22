package com.feevx.ravan.albumartworksample.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.victor.loading.rotate.RotateLoading;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxSearchObservable {


    public static Observable<String> fromView(SearchView searchView, RotateLoading progressBar) {


        final PublishSubject<String> subject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                progressBar.start();
                subject.onComplete();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                if (!text.equals("")) {
                    progressBar.start();
                    subject.onNext(text);
                }
                return true;
            }
        });

        return subject;
    }
}
