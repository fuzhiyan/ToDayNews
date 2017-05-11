package com.bawie.todaynews.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.bawie.todaynews.R;
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

    private SwitchButton switch_btn;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menuleft_fragment,container,false);

        initeView(view);

        return view;
    }

    private void initeView(View view) {

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
    }
}
