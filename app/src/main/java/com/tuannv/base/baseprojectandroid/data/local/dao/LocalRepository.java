package com.tuannv.base.baseprojectandroid.data.local.dao;

import android.content.Context;

import com.tuannv.base.baseprojectandroid.data.model.Example2;

import io.reactivex.Observable;

public class LocalRepository implements LocalDaoHelper {
    private LocalDatabaseIplm localDatabaseIplm;

    public LocalRepository(Context context) {
        localDatabaseIplm = LocalDatabaseIplm.getInstance(context);
    }

    @Override
    public Observable<Boolean> insertExample(Example2 example) {
        return localDatabaseIplm.insertExample(example);
    }

    @Override
    public Observable<Example2> getExample2() {
        return localDatabaseIplm.getExample2();
    }
}
