package com.bawei.wangliyang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFragment extends Fragment {
    @BindView(R.id.order_tv)
    TextView orderTv;
    private String key;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.order, null);
        ButterKnife.bind(this,inflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            key = arguments.getString("key");
            orderTv.setText(key);
        }

        return inflate;
    }

    public static OrderFragment getInstance(String s) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", s);
        orderFragment.setArguments(bundle);
        return orderFragment;
    }
}
