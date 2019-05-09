package com.example.logindemoapp.model.presenter;

/**
 * Created by 700 on 2019/1/12.
 */

public interface BaseView {
    void showToast(String msg) ;
    void loginSuccess(String msg) ;
    void loginFailed(String msg) ;
}
