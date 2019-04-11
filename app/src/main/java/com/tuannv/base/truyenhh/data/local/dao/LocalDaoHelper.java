package com.tuannv.base.truyenhh.data.local.dao;

import com.tuannv.base.truyenhh.data.model.Example2;

import io.reactivex.Observable;

public interface LocalDaoHelper {
    Observable<Boolean> insertExample(Example2 example);
    Observable<Example2> getExample2();
}
