package com.bawei.wangliyang.model;

import com.bawei.wangliyang.bean.LoginBean;
import com.bawei.wangliyang.bean.RegisterBean;
import com.bawei.wangliyang.contract.RegsiteAndLogin;
import com.bawei.wangliyang.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RAndLModel implements RegsiteAndLogin.RALModel {
    @Override
    public void onRegisterData(String phone, String pwd, RALViewCallback ralViewCallback) {
        NetUtil.getInstance().getApi().register(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                       ralViewCallback.onRegisterSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ralViewCallback.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onLoginData(String phone, String pwd, RALViewCallback ralViewCallback) {
         NetUtil.getInstance().getApi().login(phone,pwd)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<LoginBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(LoginBean loginBean) {
                         ralViewCallback.onLoginSuccess(loginBean);
                     }

                     @Override
                     public void onError(Throwable e) {
                         ralViewCallback.onLoginFailure(e);
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }
}
