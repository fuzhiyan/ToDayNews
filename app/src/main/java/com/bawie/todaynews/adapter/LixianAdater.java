package com.bawie.todaynews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawie.todaynews.R;

import java.util.List;

/**
 * Created by r on 2017/5/16.
 */

public class LixianAdater extends BaseAdapter {
    private Context context;
    private List<String> list;

    public LixianAdater(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.lixian_item,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.lixian_textview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView tv;
    }
}
