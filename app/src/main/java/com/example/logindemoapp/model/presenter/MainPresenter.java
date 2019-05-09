package com.example.logindemoapp.model.presenter;

import android.text.TextUtils;


/**
 * Created by 700 on 2019/1/12.
 */



public class MainPresenter implements BasePresenter {

    private BaseView baseView;

    @Override
    public void attachView(BaseView v) {
        this.baseView = v;//绑定的时候把view置进来
    }

    @Override
    public void detachView() {
        baseView = null;//解绑时置空即可
    }

    @Override
    public void login(User user) {
        if(!TextUtils.isEmpty(user.getName()) && !TextUtils.isEmpty(user.getPwd())) {
            if (user.getName().equals("jiangxue") && user.getPwd().equals("666666")) {
                baseView.loginSuccess("登陆成功");
            }else {
                baseView.loginFailed("登录失败");
            }
        }else{
            baseView.showToast("用户名或密码不能为空");
        }
    }
}
