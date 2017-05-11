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
import com.bawie.todaynews.adapter.MyFragmentAdapter;

/**
 * Created by r on 2017/5/10.
 *
 */

public class IndexFragment extends Fragment {

    //推荐
    public static IndexFragment newInstance(int type) {
        IndexFragment fragment = new IndexFragment();
        Bundle args = new Bundle();
        args.putInt("args",type);
        fragment.setArguments(args);
        return fragment;
    }

    private TabLayout index_tablayout;
    private ViewPager index_viewpager;
    private MyFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.index_fragment,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        index_tablayout = (TabLayout) view.findViewById(R.id.index_tablayout);
        index_viewpager = (ViewPager) view.findViewById(R.id.index_viewpager);

        adapter = new MyFragmentAdapter(getActivity().getSupportFragmentManager());
        index_viewpager.setAdapter(adapter);
        setWhiteMode();
        index_tablayout.setupWithViewPager(index_viewpager);
        index_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public void changeMode(boolean b){
        if (b){
            index_tablayout.setBackgroundColor(Color.GRAY);
            setWhiteMode();
        }else {
            index_tablayout.setBackgroundColor(Color.BLACK);
            setNightMode();
        }
    }
    private void setWhiteMode() {
        index_tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));
        index_tablayout.setTabTextColors(getResources().getColor(R.color.iblack),getResources().getColor(R.color.title_color));
    }
    private void setNightMode() {
        index_tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));
        index_tablayout.setTabTextColors(getResources().getColor(R.color.iblack),getResources().getColor(R.color.title_color));
    }
}
