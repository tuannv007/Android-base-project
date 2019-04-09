package com.tuannv.base.baseprojectandroid.data.local.dao;

import android.content.Context;

import com.tuannv.base.baseprojectandroid.data.model.Example2;

import io.reactivex.Observable;

public class LocalDatabaseIplm implements LocalDaoHelper {
    private AppDatabase appDatabase;
    private static LocalDatabaseIplm localDatabaseIplm;

    public static LocalDatabaseIplm getInstance(Context context) {
        if (localDatabaseIplm == null) {
            localDatabaseIplm = new LocalDatabaseIplm(context);
        }
        return localDatabaseIplm;
    }

    public LocalDatabaseIplm(Context context) {
        this.appDatabase =
            AppDatabase.getInMemoryDatabase(context);
    }

    @Override
    public Observable<Boolean> insertExample(Example2 example) {
        return Observable.fromCallable(() -> {
            appDatabase.exampleDao().insertExample(example);
            return true;
        });
    }

    @Override
    public Observable<Example2> getExample2() {
        return Observable.fromCallable(() ->
            appDatabase.exampleDao().getExample()
        );
    }
}
