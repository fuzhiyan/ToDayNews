package com.bawie.todaynews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/10.
 * time:
 * author:付智焱
 * qq第三方登录与分享
 */

public class QQLogin extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_name,tv_content;
    private ImageView imageView;
    private Button new_loginbtn,new_loginshareqq,new_loginshareqzone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqlogin);
        initView();

    }

    private void initView() {
        tv_name= (TextView) findViewById(R.id.name);
        tv_content= (TextView) findViewById(R.id.content);
        imageView= (ImageView) findViewById(R.id.user_logo);
        new_loginbtn= (Button) findViewById(R.id.new_login_btn);
        new_loginshareqq= (Button) findViewById(R.id.new_login_shareqq);
        new_loginshareqzone= (Button) findViewById(R.id.new_login_shareqzone);
        new_loginbtn.setOnClickListener(this);
        new_loginshareqq.setOnClickListener(this);
        new_loginshareqzone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_login_btn:

                Log.d("AAA","sdsdsds");
                loginQQ();
                break;
            case R.id.new_login_shareqq:
                shareQQ();
                break;
            case R.id.new_login_shareqzone:

                break;
        }

    }

    private void shareQQ() {
        UMImage image=new UMImage(QQLogin.this,R.drawable.btn_qq_normal);
        image.setThumb(image);
               new ShareAction(QQLogin.this).setPlatform(SHARE_MEDIA.QQ)
                       .withText("给你分享")
                       .withMedia(image)
                       .setCallback(new UMShareListener() {
                           @Override
                           public void onStart(SHARE_MEDIA share_media) {

                           }

                           @Override
                           public void onResult(SHARE_MEDIA share_media) {

                               Log.d("plat","platform"+share_media);

                               Toast.makeText(QQLogin.this, share_media + " 分享成功啦", Toast.LENGTH_SHORT).show();
                           }

                           @Override
                           public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                           }

                           @Override
                           public void onCancel(SHARE_MEDIA share_media) {

                           }
                       })
                       .share();
    }

    private void loginQQ() {

        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                String uid=map.get("uid");
                String name=map.get("name");
                String gender=map.get("gender");
                String iconurl=map.get("iconurl");
                tv_name.setText(name);
                tv_content.setText(uid+","+name+","+gender+","+iconurl);
                ImageLoader.getInstance().displayImage(iconurl,imageView);

            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
