package com.bawie.todaynews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneLoginActivity extends Activity {

    private EditText edit_phone_number;
    private EditText edit_phone_pwd;
    private Button btn_phone_login;
    private TextView textview_phone_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);


        edit_phone_number = (EditText) findViewById(R.id.edit_phone_number);
        edit_phone_pwd = (EditText) findViewById(R.id.edit_phone_pwd);

        btn_phone_login = (Button) findViewById(R.id.btn_phone_login);
        textview_phone_register = (TextView) findViewById(R.id.textview_phone_register);


        //登录监听
        btn_phone_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //判断是否为空
                if (!TextUtils.isEmpty(edit_phone_number.getText().toString()) && !TextUtils.isEmpty(edit_phone_pwd.getText().toString())){
                    Toast.makeText(PhoneLoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(PhoneLoginActivity.this,"请输入手机号和密码!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        textview_phone_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneLoginActivity.this,PhoneRegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
