package com.bawie.todaynews;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawie.todaynews.bean.TuiJianBean;
import com.bawie.todaynews.fragment.MentLeftFragment;
import com.bawie.todaynews.fragment.MenuRightFragment;
import com.bawie.todaynews.utils.MyUrl;
import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;
import com.google.gson.Gson;
import com.umeng.socialize.UMShareAPI;

import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

//这是主页面123123123
//wangkai
public class MainActivity extends SlidingFragmentActivity {
    private SlidingMenu slidingMenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeftRight();
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
    public void getData(){

        RequestParams requestParams=new RequestParams("http://www.93.gov.cn/93app/data.do?channelId=0&startNum=0");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                TuiJianBean bean=  gson.fromJson(result, TuiJianBean.class);

                try {
                    x.getDb(MyApplection.getDaoConfig()).save(bean.getData());
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}


