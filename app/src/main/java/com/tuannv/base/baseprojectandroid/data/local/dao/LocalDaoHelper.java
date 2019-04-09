package com.tuannv.base.baseprojectandroid.data.local.dao;

import com.tuannv.base.baseprojectandroid.data.model.Example2;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface LocalDaoHelper {
    Observable<Boolean> insertExample(Example2 example);
    Observable<Example2> getExample2();
}
