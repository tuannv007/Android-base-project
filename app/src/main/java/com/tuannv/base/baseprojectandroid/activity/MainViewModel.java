package com.tuannv.base.baseprojectandroid.activity;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.tuannv.base.baseprojectandroid.base.BaseViewModel;
import com.tuannv.base.baseprojectandroid.data.local.dao.LocalRepository;
import com.tuannv.base.baseprojectandroid.data.model.Example2;
import com.tuannv.base.baseprojectandroid.data.remote.AppApiHelperImpl;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {
    private AppApiHelperImpl appApiHelper;
    public MutableLiveData<Boolean> test = new MutableLiveData<>();
    private LocalRepository repository;

    public MainViewModel(@NonNull Application application, Context context) {
        super(application);
        appApiHelper = new AppApiHelperImpl();
        repository = new LocalRepository(context);
    }

    public void fetchUserInfo() {
        getCompositeDisposable().add(appApiHelper.getListData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(data -> {
                test.postValue(true);
                getData(Arrays.asList(data).get(0));
            }, throwable -> {
                Log.e("tuanbg", throwable.getMessage());
            })
        );
    }

    public void getData(Example2 example) {
        getCompositeDisposable().add(repository.insertExample(example)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(data -> {
                Log.e("tuanbg", data + "");
                getExample();
            }, throwable -> {
                Log.e("throwable", throwable + "");
            }));
    }

    public void getExample() {
        getCompositeDisposable().add(repository.getExample2()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(data -> {
                Log.e("tuanbg", data + "");
            }, throwable -> {
                Log.e("throwable", throwable + "");
            }));
    }
}
