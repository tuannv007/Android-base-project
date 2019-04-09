package com.tuannv.base.baseprojectandroid.activity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.tuannv.base.baseprojectandroid.BaseApplication;
import com.tuannv.base.baseprojectandroid.R;
import com.tuannv.base.baseprojectandroid.base.BaseActivity;
import com.tuannv.base.baseprojectandroid.databinding.ActivityMainBinding;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainViewModel viewModel = new MainViewModel(BaseApplication.getInstance(), this);
        viewModel.fetchUserInfo();
        //requestCameraPermission();
    }

    private void requestCameraPermission() {
        Dexter.withActivity(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(new PermissionListener() {
                @Override
                public void onPermissionGranted(PermissionGrantedResponse response) {
                    // permission is granted
                    //openCamera()
                    Log.e("tuanbg", "open camera");
                }

                @Override
                public void onPermissionDenied(PermissionDeniedResponse response) {
                    //showSettingsDialog();
                    Log.e("tuanbg", "onPermissionDenied");
                }

                @Override
                public void onPermissionRationaleShouldBeShown(PermissionRequest permission,
                                                               PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }).check();
    }
}
