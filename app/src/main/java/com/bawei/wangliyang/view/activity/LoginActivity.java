package com.bawei.wangliyang.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangliyang.MainActivity;
import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseActivity;
import com.bawei.wangliyang.bean.LoginBean;
import com.bawei.wangliyang.bean.RegisterBean;
import com.bawei.wangliyang.contract.RegsiteAndLogin;
import com.bawei.wangliyang.presenter.RAndLPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<RAndLPresenter>implements RegsiteAndLogin.RALView {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_check)
    CheckBox loginCheck;
    @BindView(R.id.login_register)
    Button loginRegister;
    @BindView(R.id.login_login)
    Button loginLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RAndLPresenter provitePresenter() {
        return new RAndLPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.login_register, R.id.login_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_register:
                String phone = loginPhone.getText().toString();
                String pwd = loginPwd.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }

                mPresenter.onRegisterData(phone,pwd);
                break;
            case R.id.login_login:
                String phone1 = loginPhone.getText().toString();
                String pwd1 = loginPwd.getText().toString();
                if (TextUtils.isEmpty(phone1)){
                    Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (TextUtils.isEmpty(pwd1)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }

                mPresenter.onLoginData(phone1,pwd1);
                break;
        }
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("key",loginBean.getResult().getHeadPic());
        startActivity(intent);
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
