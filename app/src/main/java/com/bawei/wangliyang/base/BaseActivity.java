package com.bawei.wangliyang.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangliyang.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        mPresenter = provitePresenter();
        if (mPresenter!=null){
            mPresenter.actach(this);
        }
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detach();
        }
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P provitePresenter();

    protected abstract int layoutId();
}
