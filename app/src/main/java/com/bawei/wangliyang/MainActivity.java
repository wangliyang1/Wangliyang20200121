package com.bawei.wangliyang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.wangliyang.base.BaseActivity;
import com.bawei.wangliyang.base.BasePresenter;
import com.bawei.wangliyang.view.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.group)
    RadioGroup group;

    List<Fragment> list = new ArrayList<>();
    private String key = "";


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        key = intent.getStringExtra("key");

        OrderFragment orderFragment1 = OrderFragment.getInstance("首页");
        OrderFragment orderFragment2 = OrderFragment.getInstance("频道");
        OrderFragment orderFragment3 = OrderFragment.getInstance("分类");
        OrderFragment orderFragment4 = OrderFragment.getInstance("购物车");
        MyFragment instance = MyFragment.getInstance(key);
        list.add(orderFragment1);
        list.add(orderFragment2);
        list.add(orderFragment3);
        list.add(orderFragment4);
        list.add(instance);

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.bt2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.bt3:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.bt4:
                        pager.setCurrentItem(3);
                        break;
                    case R.id.bt5:
                        pager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected BasePresenter provitePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
