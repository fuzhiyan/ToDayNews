package com.bawie.todaynews;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawie.todaynews.bean.LoginBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashSet;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/5/10.
 * time:
 * author:付智焱
 * 登录注册页面
 */

public class Sign extends AppCompatActivity implements View.OnClickListener{
    private EditText edit1,edit2;
    private Button but1,but2;
    private TimerTask task;
    int time=10;
    private void addTime() {

        final Timer timer =new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (time>=0){
                            but2.setText("重新发送:("+time--+"s)");
                        }else {
                            timer.cancel();
                            but2.setText("重新发送");

                            time=10;
                        }
                    }
                });
            }
        };
        timer.schedule(task,0,1000);
    }


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
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signbut1:
                login();

                break;
            case R.id.sign_btn:

                reist();

                break;
        }
    }


    private EditText getPhone() {
        return (EditText) findViewById(R.id.sign_deit1);
    }

    private EditText getPwd() {
        return (EditText) findViewById(R.id.sign_edit2);
    }
    private void login() {
        String phone = getPhone().getText().toString().trim();
        String pwd = getPwd().getText().toString().trim();
//        http://qhb.2dyt.com/Bwei/login?username=110110&password=1234&postkey=1503d
        RequestParams login = new RequestParams("http://qhb.2dyt.com/Bwei/login");
        login.addBodyParameter("username", phone);
        login.addBodyParameter("password", pwd);
        login.addBodyParameter("postkey", "1503d");

        x.http().get(login, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                LoginBean bean = gson.fromJson(result, LoginBean.class);
                if (bean.getRet_code()==200){
                    System.out.println("登陆成功");
                    finish();
                }else {
                    System.out.println("登陆失败");
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {
//                http://qhb.2dyt.com/Bwei/login?username=110110&password=1234&postkey=1503d
            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void reist() {
        String phone = getPhone().getText().toString().trim();


        RequestParams parms = new RequestParams("http://qhb.2dyt.com/Bwei/register");
        parms.addBodyParameter("phone", phone);
        parms.addBodyParameter("password", "1234");
        parms.addBodyParameter("postkey", "1503d");
//        1 register
//        url:http://qhb.2dyt.com/Bwei/register
//        params: phone password postkey(1503d)
//        return : ret_code 0, error 200 ok
        x.http().get(parms, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        addTime();
    }

}
