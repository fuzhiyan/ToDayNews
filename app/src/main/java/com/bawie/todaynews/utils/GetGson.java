package com.bawie.todaynews.utils;

import android.os.Handler;
import android.os.Message;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 王占军
 * on 2017/5/10.
 * 类的用途:
 */
public class GetGson extends Thread {


    private String path;
    private Handler handler;

    public GetGson(Handler handler, String path) {
        this.handler = handler;
        this.path = path;
    }

    public GetGson(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        super.run();

        String str = getString();
        Message me = new Message();
        me.what = 0;
        me.obj = str;
        handler.sendMessage(me);

    }

    public String getString() {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);


            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                int len = 0;
                byte[] by = new byte[1024];

                while ((len = inputStream.read(by)) != -1) {
                    output.write(by, 0, len);
                }
                return output.toString();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

}
