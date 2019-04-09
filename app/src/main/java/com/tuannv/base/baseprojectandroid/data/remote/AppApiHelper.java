package com.tuannv.base.baseprojectandroid.data.remote;

import com.tuannv.base.baseprojectandroid.data.model.Example2;

import io.reactivex.Single;

/**
 * Create by Tuannv
 * Define function call to sever using RX
 * ex: Single<BlogResponse> getBlogApiCall();
 **/
public interface AppApiHelper {
    Single<Example2[]> getListData();
}
