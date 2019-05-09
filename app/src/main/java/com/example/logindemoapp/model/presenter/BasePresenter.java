package com.example.logindemoapp.model.presenter;



/**
 * Created by 700 on 2019/1/12.
 */

public interface BasePresenter {

    void attachView(BaseView v);//绑定view | 由原理图可知，presenter需要绑定View才行

    void detachView();

    void login(User user);
}