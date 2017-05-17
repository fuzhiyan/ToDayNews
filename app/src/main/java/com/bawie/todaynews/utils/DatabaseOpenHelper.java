package com.bawie.todaynews.utils;


import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Date：2017/4/11
 * author: 曹政杰Administrator.
 * function：
 */
public class DatabaseOpenHelper{
private static DbManager.DaoConfig daoConfig;
public static DbManager.DaoConfig getDaoConfig(){
        if(daoConfig==null){
        daoConfig = new DbManager.DaoConfig()
        .setAllowTransaction(true)//设置允许开启事务
        .setDbName("test.db")//创建数据库的名称
        // 不设置dbDir时, 默认存储在app的私有目录.
        .setDbDir(new File("/sdcard")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
        .setDbVersion(1)//数据库版本号
        .setDbOpenListener(new DbManager.DbOpenListener() {
@Override
public void onDbOpened(DbManager db) {
        // 开启WAL, 对写入加速提升巨大
        db.getDatabase().enableWriteAheadLogging();
        }
        })
        .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
@Override
public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
        // TODO: ...
        //db.addColumn(...);
        // db.dropTable(...);
        // ...
        // or
        // db.dropDb();
        }
        });
        }
        return daoConfig;
        }
        DbManager db= x.getDb(daoConfig);
}
/*
public class DatabaseOpenHelper {
    private DbManager.DaoConfig daoConfig;
    private static DbManager db;
    private final String DB_NAME = "mydb";
    private final int VERSION = 1;
    private DatabaseOpenHelper() {
        daoConfig = new DbManager.DaoConfig()
                .setDbName(DB_NAME)
                .setDbVersion(VERSION)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();
                        //开启WAL, 对写入加速提升巨大(作者原话)
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        //数据库升级操作
                    }
                });

         // db = x.getDb(daoConfig);
    }
    public static DbManager getInstance(){
        if (db == null){
            DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper();
        }
        return db;
    }
}
*/
