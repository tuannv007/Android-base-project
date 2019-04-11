package com.tuannv.base.truyenhh.base;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppBottomNavigationMenu extends BottomNavigationView {
    //private BottomNavigationMenuListener bottomNavigationMenuListener;
    private boolean isDispatchEvent = true;

//    public void setBottomNavigationMenuListener(
//        //BottomNavigationMenuListener bottomNavigationMenuListener) {
//        //this.bottomNavigationMenuListener = bottomNavigationMenuListener;
//    }

    public AppBottomNavigationMenu(Context context) {
        super(context);
        //setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public AppBottomNavigationMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        //setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public AppBottomNavigationMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//        = item -> {
//        if (isDispatchEvent)
//            bottomNavigationMenuListener.changeItemSelect(item.getItemId());
//        isDispatchEvent = true;
//        return true;
//    };
//
//    public interface BottomNavigationMenuListener {
//        void changeItemSelect(int itemId);
//    }

    public void setHighLight(int id) {
        isDispatchEvent = false;
        setSelectedItemId(id);
    }
}
