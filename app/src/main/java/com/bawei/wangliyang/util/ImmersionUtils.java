package com.bawei.wangliyang.util;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
/*
* 沉浸式封装
* */
public class ImmersionUtils {
    public void setImmersion(Window window, ActionBar supprotActionBar){
        if (window!=null){
            if (Build.VERSION.SDK_INT>=21){
                View decorView = window.getDecorView();
                int option = View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
        if (supprotActionBar!=null){
            ActionBar supprotActionBar1 = supprotActionBar;
            supprotActionBar1.hide();
        }
    }

}
