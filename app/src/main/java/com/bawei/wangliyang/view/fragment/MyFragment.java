package com.bawei.wangliyang.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseFragment;
import com.bawei.wangliyang.base.BasePresenter;
import com.bawei.wangliyang.view.activity.LoginActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends BaseFragment {
    @BindView(R.id.my_image)
    ImageView myImage;
    @BindView(R.id.my_tv)
    TextView myTv;
    private String key = "http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg";

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        if (arguments!=null){
            key = arguments.getString("key");
        }
        Glide.with(getActivity()).load(key)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(myImage);
    }

    @Override
    protected BasePresenter provitePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_my;
    }

    @OnClick(R.id.my_tv)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }

    public static MyFragment getInstance(String a) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",a);
        myFragment.setArguments(bundle);
        return myFragment;
    }


}
