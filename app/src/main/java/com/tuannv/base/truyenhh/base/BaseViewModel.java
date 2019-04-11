package com.tuannv.base.truyenhh.base;

import android.app.Application;
import android.app.ProgressDialog;

import com.tuannv.base.truyenhh.BaseApplication;
import com.tuannv.base.truyenhh.utils.CommonUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends AndroidViewModel {
    private CompositeDisposable mCompositeDisposable;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.mCompositeDisposable = new CompositeDisposable();
    }
}
