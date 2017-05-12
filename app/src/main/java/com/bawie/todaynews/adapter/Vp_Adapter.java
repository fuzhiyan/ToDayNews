package com.bawie.todaynews.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawie.todaynews.fragment.Xlv_Fragment;

/**
 * Created by 王占军
 * on 2017/5/10.
 * 类的用途:
 */
public class Vp_Adapter extends FragmentPagerAdapter {

    String[] arr = {"推荐", "热点", "本地", "视频", "社会", "娱乐"
            , "科技", "汽车", "体育", "财经", "军事", "国际", "段子"
            , "趣图", "健康", "美女"};


    public Vp_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Xlv_Fragment frag = new Xlv_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", position);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
