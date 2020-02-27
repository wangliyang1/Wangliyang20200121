package com.bawei.wangliyang.presenter;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BasePresenter;
import com.bawei.wangliyang.bean.LoginBean;
import com.bawei.wangliyang.bean.RegisterBean;
import com.bawei.wangliyang.contract.RegsiteAndLogin;
import com.bawei.wangliyang.model.RAndLModel;

public class RAndLPresenter extends BasePresenter<RegsiteAndLogin.RALView>implements RegsiteAndLogin.RALPresenter {

    private RAndLModel rAndLModel;

    @Override
    protected void initModel() {
        rAndLModel = new RAndLModel();
    }

    @Override
    public void onRegisterData(String phone, String pwd) {
        rAndLModel.onRegisterData(phone, pwd, new RegsiteAndLogin.RALModel.RALViewCallback() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                view.onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {

            }

            @Override
            public void onLoginFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public void onLoginData(String phone, String pwd) {
        rAndLModel.onLoginData(phone, pwd, new RegsiteAndLogin.RALModel.RALViewCallback() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {

            }

            @Override
            public void onRegisterFailure(Throwable throwable) {

            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }
}
