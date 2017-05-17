package com.bawie.todaynews.utils;

import android.util.Log;


import com.bawie.todaynews.bean.TopNews;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.List;

import static org.xutils.x.getDb;

/**
 * Date：2017/4/11
 * author: 曹政杰Administrator.
 * function：
 */

public class TopNewsDB {
    private static DbManager db;

    DbManager.DaoConfig daoConfig = DatabaseOpenHelper.getDaoConfig();
    public TopNewsDB(){
       //db = DatabaseOpenHelper.getInstance();
        db = getDb(daoConfig);
    }

    //db = x.getDb(daoConfig);
    public void savePerson(TopNews top){
        try {

            db.saveOrUpdate(top);
            Log.d("xyz","save succeed!");
        } catch (DbException e) {
            Log.d("xyz",e.toString());
        }
    }

    public static List<TopNews> loadPerson(){
        List<TopNews> list = null;
        try {
            list = db.selector(TopNews.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<TopNews>  getTitle(){
        List<TopNews> list=null;
        try{
        list=db.selector(TopNews.class).where("tag","=","1").findAll();
            Log.d("xyz","取出成功");
        }

        catch (DbException e){
            e.printStackTrace();
        }
        return list;

    }

}
