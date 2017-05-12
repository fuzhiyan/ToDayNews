package com.bawie.todaynews;

import android.app.Application;

import com.igexin.sdk.PushManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Administrator on 2017/5/9.
 * time:
 * author:付智焱
 */

public class MyApplection extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
        getDaoConfig();
        UMShareAPI.get(this);
        Config.DEBUG = true;
//        Config.DEBUG=true;
//        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106031063","cqbtzvAp6NRioSBT");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PushManager.getInstance().initialize(this,DemoPushService.class);
        PushManager.getInstance().initialize(this,DemoIntentService.class);
        ImageLoaderConfiguration fig=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(fig);


    }
    public static DbManager.DaoConfig daoConfig;
    public static DbManager.DaoConfig getDaoConfig(){

        if(daoConfig==null){
            daoConfig=new DbManager.DaoConfig()
                    .setDbVersion(1)
                    .setDbName("fzy.db")
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    });

        }

        return daoConfig;
    }
}
