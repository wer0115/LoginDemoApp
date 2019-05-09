package com.example.logindemoapp.model.presenter;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements BaseView{


    private EditText et_username;
    private EditText et_pwd;
    private Button btn_login;

    private MainPresenter mainPresenter;//声明业务逻辑类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText)findViewById(R.id.et_username);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);

        mainPresenter = new MainPresenter();//实例化业务逻辑类对象
        mainPresenter.attachView(this);//绑定view（把this付给业务逻辑类中的全局变量，
        //业务逻辑类中的逻辑方法会使用到这个全局变量（传进去的this），
        // 从而具体实现业务逻辑类中的业务逻辑）

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new的时候把东西get下来，赋给model Class ，完美！
                User user = new User(et_username.getText().toString(),et_pwd.getText().toString());
                mainPresenter.login(user);//传入数据，调用业务逻辑方法
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String msg) {
        showToast(msg);
    }

    @Override
    public void loginFailed(String msg) {
        showToast(msg);
    }

    //销毁状态周期时解除绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
}

作者：凌川江雪
        链接：https://www.jianshu.com/p/12f87929779a
        来源：简书
        简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。