package com.bawie.todaynews.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawie.todaynews.MainActivity;
import com.bawie.todaynews.QQLogin;
import com.bawie.todaynews.R;
import com.bawie.todaynews.Sign;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 * time:
 * author:付智焱
 */

public class MentLeftFragment extends Fragment {
    private ImageView image;
    private Button but;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menuleft_fragment,container,false);
        return  view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        image= (ImageView) getActivity().findViewById(R.id.left_qqimage);
        but= (Button) getActivity().findViewById(R.id.but);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                login();
                Intent in=new Intent(getActivity(), QQLogin.class);
                startActivity(in);
//                Toast.makeText(getActivity(),"已点击",Toast.LENGTH_LONG).show();
//                startActivityForResult(in, Activity.RESULT_FIRST_USER);

            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), Sign.class);
                startActivity(in);
            }
        });

    }

    private void login() {
        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                Log.i("data",""+share_media);
                String uid=map.get("uid");
                String name=map.get("name");
                String gender=map.get("gender");
                String iconurl=map.get("iconurl");

            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                Log.d("error",""+share_media);
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }
}
