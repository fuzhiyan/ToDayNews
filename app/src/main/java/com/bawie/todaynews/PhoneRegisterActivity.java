package com.bawie.todaynews;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneRegisterActivity extends Activity {

    private EditText edit_phone_register_number;
    private Button btn_phone_register;
    private CheckBox phone_register_checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_register);


        edit_phone_register_number = (EditText) findViewById(R.id.edit_phone_register_number);
        btn_phone_register = (Button) findViewById(R.id.btn_phone_register);
        phone_register_checkBox = (CheckBox) findViewById(R.id.phone_register_checkBox);

        btn_phone_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edit_phone_register_number.getText().toString()) && phone_register_checkBox.isChecked()){
                    Toast.makeText(PhoneRegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                }else if(!TextUtils.isEmpty(edit_phone_register_number.getText().toString()) && !phone_register_checkBox.isChecked()){
                    Toast.makeText(PhoneRegisterActivity.this,"点击同意阅读用户协议",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(PhoneRegisterActivity.this,"必须输入手机号",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
