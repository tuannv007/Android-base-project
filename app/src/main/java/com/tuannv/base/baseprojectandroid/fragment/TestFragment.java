package com.tuannv.base.baseprojectandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.tuannv.base.baseprojectandroid.R;
import com.tuannv.base.baseprojectandroid.base.BaseFragment;
import com.tuannv.base.baseprojectandroid.databinding.FragmentTestBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TestFragment extends BaseFragment<FragmentTestBinding, TestViewModel> {
    public static TestFragment newInstance() {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public interface ActionSwipeListener {
        void onSwipe(boolean isSwipe);
    }

    private ActionSwipeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ActionSwipeListener) context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener.onSwipe(false);
    }
}
