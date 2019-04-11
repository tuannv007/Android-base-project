package com.tuannv.base.truyenhh.data.remote;

import com.tuannv.base.truyenhh.data.model.Example2;

import io.reactivex.Single;

/**
 * Create by Tuannv
 * Define function call to sever using RX
 * ex: Single<BlogResponse> getBlogApiCall();
 **/
public interface AppApiHelper {
    Single<Example2[]> getListData();
}
