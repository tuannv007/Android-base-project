package com.tuannv.base.truyenhh.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.tuannv.base.truyenhh.BaseApplication;
import com.tuannv.base.truyenhh.R;
import com.tuannv.base.truyenhh.base.BaseActivity;
import com.tuannv.base.truyenhh.databinding.ActivityMainBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    private MainViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        viewModel = new MainViewModel(BaseApplication.getInstance(), this);
        viewModel.fetchUserInfo();
    }

    private void initView() {
        setSupportActionBar(getViewDataBinding().toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        SearchView searchView =
            (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.app_bar_search));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.app_bar_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
