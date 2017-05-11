package com.bawie.todaynews;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.bawie.todaynews.adapter.MyFragmentAdapter;
import com.bawie.todaynews.fragment.MentLeftFragment;
import com.bawie.todaynews.fragment.MenuRightFragment;
import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

//这是主页面123123123
//wangkai
public class MainActivity extends SlidingFragmentActivity {
    private SlidingMenu slidingMenu;
    private List<Fragment> list = new ArrayList<>();

    private TabLayout index_tablayout;
    private ViewPager index_viewpager;
    private MyFragmentAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initLeftRight();

    }

    private void initData() {

            index_tablayout = (TabLayout)findViewById(R.id.index_tablayout);
            index_viewpager = (ViewPager)findViewById(R.id.index_viewpager);

            adapter = new MyFragmentAdapter(getSupportFragmentManager());
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


    private void initLeftRight() {
        Fragment leftFragment=new MentLeftFragment();
        setBehindContentView(R.layout.left_menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_leftmenu_id,leftFragment).commit();
        slidingMenu=getSlidingMenu();
        //设置滑动方式
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        // 设置阴影的宽度
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        // 设置slidingmenu边界的阴影图片
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);

        //设置右边（二级）侧滑菜单
        MenuRightFragment rightMenuFragment = new MenuRightFragment();
//        rightMenuFragment.setShareListener(this);
        slidingMenu.setSecondaryMenu(R.layout.right_menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.id_frame_rightmenu, rightMenuFragment).commit();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}


