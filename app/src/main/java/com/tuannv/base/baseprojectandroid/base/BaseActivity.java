package com.tuannv.base.baseprojectandroid.base;

import android.os.Bundle;

import com.tuannv.base.baseprojectandroid.BR;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends
    AppCompatActivity {
    private T mViewDataBinding;

    public abstract
    @LayoutRes
    int getLayoutId();

    protected int getBindingVariable() {
        return BR.viewModel;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.executePendingBindings();
    }
    public void addFragment(Fragment frg, int layoutId, String TAG) {
        getSupportFragmentManager().beginTransaction().add(layoutId, frg, TAG).addToBackStack(TAG)
            .commit();
    }
}
