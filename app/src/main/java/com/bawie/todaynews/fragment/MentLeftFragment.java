package com.bawie.todaynews.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.todaynews.LixianActivity;
import com.bawie.todaynews.MoreLoginActivity;
import com.bawie.todaynews.QQLogin;
import com.bawie.todaynews.R;
import com.bawie.todaynews.Sign;
import com.bawie.todaynews.constants.Constants;
import com.bawie.todaynews.event.MainEvent;
import com.bawie.todaynews.utils.PreferencesUtils;
import com.kyleduo.switchbutton.SwitchButton;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/5/8.
 * time:
 * author:付智焱
 */

public class MentLeftFragment extends Fragment {

    private TextView but;
    private ImageView imageView;
    private SwitchButton switch_btn;
    private View view;
    private TextView btn_lixian;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menuleft_fragment,container,false);

        initeView(view);

        return view;
    }

    private void initeView(View view) {
        but= (TextView) view.findViewById(R.id.but);
        imageView= (ImageView) view.findViewById(R.id.left_qqimage);
        btn_lixian = (TextView) view.findViewById(R.id.btn_lixian);

        btn_lixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LixianActivity.class);
                startActivity(intent);
            }
        });

        switch_btn = (SwitchButton) view.findViewById(R.id.switch_btn);
        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                System.out.println("isChecked = " + isChecked);
                boolean mode = PreferencesUtils.getValueByKey(getContext(), Constants.isNightMode,isChecked);
                setMode(isChecked);
                EventBus.getDefault().post(new MainEvent(mode));
                setBackGround(mode);
            }
        });

    }

    private void setMode(boolean mode) {

        PreferencesUtils.addConfigInfo(getContext(),Constants.isNightMode,mode);
    }

    private void setBackGround(boolean white){
        if (white){
            view.setBackgroundColor(Color.WHITE);
        }else {
            view.setBackgroundColor(Color.BLACK);
        }
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), MoreLoginActivity.class);
                startActivity(in);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), QQLogin.class);
                startActivity(in);
            }
        });


    }
}
