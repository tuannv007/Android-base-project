package com.tuannv.base.truyenhh.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public abstract class BaseDialogFragment<T extends ViewDataBinding, V extends BaseViewModel>
    extends DialogFragment {
    ViewModelProvider.Factory viewModelFactory;
    private BaseActivity mActivity;
    private View mRootView;
    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    protected int getBindingVariable() {
        //return com.tuannv.base.baseprojectandroid.BR.viewModel;
        return 0;
    }

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public V getViewModel() {
        return mViewModel;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        // setStyle(DialogFragment.STYLE_NO_TITLE, R.style.colorPickerStyle);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1) {
            name =
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]
                    .getTypeName();
        } else {
            name = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1].toString().replace("class ", "");
        }
        try {
            this.mViewModel =
                ViewModelProviders.of(this, viewModelFactory).get((Class<V>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (!mViewDataBinding.setVariable(getBindingVariable(), mViewModel)) {
            throw new IllegalArgumentException("You should add 'viewModel' variable");
        }
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }
//
//    public void openActivityOnTokenExpire() {
//        if (mActivity != null) {
//            mActivity.openActivityOnTokenExpire();
//        }
//    }

    public interface Callback {
        void onFragmentAttached();
        void onFragmentDetached(String tag);
    }
}