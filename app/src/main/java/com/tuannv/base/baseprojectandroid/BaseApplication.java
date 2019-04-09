package com.tuannv.base.baseprojectandroid;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.facebook.stetho.Stetho;

import okhttp3.OkHttpClient;

public class BaseApplication extends Application {
    private static BaseApplication application;

    public static BaseApplication getInstance() {
        if (application == null) {
            application = new BaseApplication();
        }
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//            .connectTimeout(20, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            //.addInterceptor(new TokenInterceptor())
//            .build();
        AndroidNetworking.enableLogging(); // simply enable logging
        AndroidNetworking.initialize(getApplicationContext());
    }
}
