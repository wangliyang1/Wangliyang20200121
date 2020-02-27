package com.bawei.wangliyang.contract;

import com.bawei.wangliyang.bean.LoginBean;
import com.bawei.wangliyang.bean.RegisterBean;

public interface RegsiteAndLogin {
    interface RALView{
        void onRegisterSuccess(RegisterBean registerBean);
        void onRegisterFailure(Throwable throwable);

        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);
    }
    interface RALPresenter{
        void onRegisterData(String phone,String pwd);
        void onLoginData(String phone,String pwd);
    }
    interface RALModel{
        void onRegisterData(String phone,String pwd,RALViewCallback ralViewCallback);
        void onLoginData(String phone,String pwd,RALViewCallback ralViewCallback);
        interface RALViewCallback{
            void onRegisterSuccess(RegisterBean registerBean);
            void onRegisterFailure(Throwable throwable);

            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }
    }
}
