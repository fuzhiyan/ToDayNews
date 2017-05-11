package com.bawie.todaynews;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.bawie.todaynews.event.MainEvent;
import com.bawie.todaynews.fragment.IndexFragment;
import com.bawie.todaynews.fragment.MentLeftFragment;
import com.bawie.todaynews.fragment.MenuRightFragment;
import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

//这是主页面123123123
//wangkai
public class MainActivity extends SlidingFragmentActivity {
    private SlidingMenu slidingMenu;
    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeftRight();

        initGrayBackGround();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

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

    public void initGrayBackGround(){
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSPARENT);
        view = new View(this);
        view.setBackgroundResource(R.color.color_window);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(MainEvent event){
        if (event.isWhite()){
            windowManager.removeViewImmediate(view);
        }else {
            windowManager.addView(view,layoutParams);
        }
        setView();
        switchTextViewColor((ViewGroup) getWindow().getDecorView(),event.isWhite());
        IndexFragment indexFragment = new IndexFragment();
        indexFragment.changeMode(event.isWhite());
    }

    private void setView() {
    //
    }

//
    public void switchTextViewColor(ViewGroup view, boolean white) {
        for (int i = 0; i < view.getChildCount(); i++) {
            if (view.getChildAt(i) instanceof ViewGroup) {
                switchTextViewColor((ViewGroup) view.getChildAt(i),white);
            } else if (view.getChildAt(i) instanceof TextView) {
                //设置颜色
                int resouseId ;
                TextView textView = (TextView) view.getChildAt(i);
                if(white){
                    resouseId = Color.BLACK;
                }else {
                    resouseId = Color.WHITE;
                }
                textView.setTextColor(resouseId);
            }
        }

    }
}


