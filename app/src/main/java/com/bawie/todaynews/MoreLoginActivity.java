package com.bawie.todaynews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreLoginActivity extends Activity implements View.OnClickListener {

    private Button btn_more_phone_login;
    private Button btn_more_phone_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_login);

        //拿到注册 登录按钮 并设置监听事件
        btn_more_phone_login = (Button) findViewById(R.id.btn_more_phone_login);
        btn_more_phone_register = (Button) findViewById(R.id.btn_more_phone_register);

        btn_more_phone_login.setOnClickListener(this);
        btn_more_phone_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //登录
            case R.id.btn_more_phone_login:
                Intent intent = new Intent(MoreLoginActivity.this,PhoneLoginActivity.class);
                startActivity(intent);
                break;

            //注册
            case R.id.btn_more_phone_register:
                Intent intent1 = new Intent(MoreLoginActivity.this,PhoneRegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
