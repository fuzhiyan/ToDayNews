package com.bawie.todaynews.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.todaynews.R;

/**
 * Created by DELL on 2017/5/11.
 */

public class IndexFragment extends Fragment {


    private TabLayout index_fragment_tablayout;
    private ViewPager index_viewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.indexfragment,null);

        initView(view);

        return view;

    }

    private void initView(View view) {

        index_fragment_tablayout = (TabLayout) view.findViewById(R.id.index_fragment_tablayout);
        index_viewpager = (ViewPager) view.findViewById(R.id.index_viewpager);


        setWhiteMode();
        index_fragment_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public void changeMode(boolean white) {
        if(white){
            index_fragment_tablayout.setBackgroundColor(Color.GRAY);
            setWhiteMode();
        }else {
            index_fragment_tablayout.setBackgroundColor(Color.BLACK);
            setNightMode();
        }

    }


    private void setWhiteMode() {

        index_fragment_tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));
        index_fragment_tablayout.setTabTextColors(getResources().getColor(R.color.iblack),getResources().getColor(R.color.title_color));
    }
    private void setNightMode(){
        index_fragment_tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));
        index_fragment_tablayout.setTabTextColors(getResources().getColor(R.color.iblack),getResources().getColor(R.color.title_color));
    }
}
