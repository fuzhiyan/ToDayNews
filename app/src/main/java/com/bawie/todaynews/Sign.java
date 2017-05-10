package com.bawie.todaynews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/5/10.
 * time:
 * author:付智焱
 * 登录注册页面
 */

public class Sign extends AppCompatActivity implements View.OnClickListener{
    private EditText edit1,edit2;
    private Button but1,but2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
        initView();
    }

    private void initView() {
        edit1= (EditText) findViewById(R.id.sign_deit1);
        edit2= (EditText) findViewById(R.id.sign_edit2);
        but1= (Button) findViewById(R.id.signbut1);
        but2= (Button) findViewById(R.id.sign_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signbut1:

                break;
            case R.id.sign_btn:
                suiji();

                break;
        }
    }

    private void suiji() {
        String a="";
        but2=new Button(this);
        a=String.valueOf(Math.random()*100000+200000);
        but2.setText(a+"");

    }
}
