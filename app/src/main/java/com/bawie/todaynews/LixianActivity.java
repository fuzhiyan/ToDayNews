package com.bawie.todaynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawie.todaynews.adapter.LixianAdater;

import java.util.ArrayList;
import java.util.List;

public class LixianActivity extends AppCompatActivity {

    private ListView lixian_listview;
    private List<String> list = new ArrayList<>();
    String [] arr = {"订阅","图片","正能量","特卖","房产","电影","推荐","热点","娱乐","财经","国际","趣图","健康"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lixian);
        lixian_listview = (ListView) findViewById(R.id.lixian_listview);

        for (int i = 0;i<arr.length;i++){
            list.add(arr[i]);
        }

        LixianAdater adapter = new LixianAdater(this,list);
        lixian_listview.setAdapter(adapter);
    }
}
