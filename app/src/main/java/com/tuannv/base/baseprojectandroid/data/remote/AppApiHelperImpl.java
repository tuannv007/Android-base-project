package com.tuannv.base.baseprojectandroid.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.tuannv.base.baseprojectandroid.data.model.Example2;

import io.reactivex.Single;

/**
 * Class AppApiHelperImpl implement AppApiHelper
 * ex: @Override
 * public Single<BlogResponse> getBlogApiCall() {
 * return Rx2AndroidNetworking.get(EndPoint.ENDPOINT)
 * //               .addHeaders(mApiHeader.getProtectedApiHeader()) Add Header when request
 * .build()
 * .getObjectSingle(BlogResponse.class);
 * }
 **/
public class AppApiHelperImpl implements AppApiHelper {
    @Override
    public Single<Example2[]> getListData() {
        return Rx2AndroidNetworking.get(AppEndPoint.BASE_URL)
            .build()
            .getObjectSingle(Example2[].class);
    }
}
