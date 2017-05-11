package com.bawie.todaynews.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by r on 2017/5/10.
 * fragment和viewpager的adapter
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    String [] title = new String[]{"推荐","热点","本地","视频","社会","娱乐","科技","汽车","体育","财经","军事","国际","段子","趣图","健康","美女"};
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){

            TuijianFragment tuijianFragment = new TuijianFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("pos",position);
            tuijianFragment.setArguments(bundle);
            return tuijianFragment;
        }else {
            return new ShipinFragment();
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
