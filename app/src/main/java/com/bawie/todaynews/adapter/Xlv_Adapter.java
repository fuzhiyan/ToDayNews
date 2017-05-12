package com.bawie.todaynews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.todaynews.R;
import com.bawie.todaynews.bean.Tuijian;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 王占军
 * on 2017/5/11.
 * 类的用途:
 */
public class Xlv_Adapter extends BaseAdapter {
    private Context context;
    List<Tuijian.DataBean> data;

    public Xlv_Adapter(Context context, List<Tuijian.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder_one v1 = null;
        ViewHolder_two v2 = null;
        int type = getItemViewType(position);

        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = View.inflate(context, R.layout.tuijian_xlv_item_one, null);
                    v1 = new ViewHolder_one(convertView);
                    convertView.setTag(v1);
                    break;
                case 1:
                    convertView = View.inflate(context, R.layout.tuijian_xlv_item_two, null);
                    v2 = new ViewHolder_two(convertView);
                    convertView.setTag(v2);
                    break;
            }

        } else {
            switch (type) {
                case 0:
                    v1 = (ViewHolder_one) convertView.getTag();

                    break;
                case 1:

                    v2 = (ViewHolder_two) convertView.getTag();
                    break;
            }
        }


        switch (type) {
            case 0:
                v1.title_one.setText(data.get(position).getTITLE());
                ImageLoader.getInstance().displayImage(data.get(position).getIMAGEURL(), v1.image_url_one);
                v1.time_one.setText(data.get(position).getSHOWTIME() + "");
                break;
            case 1:
                v2.title_two.setText(data.get(position).getTITLE());
                v2.subtitle_two.setText(data.get(position).getSUBTITLE());
                v2.time_two.setText(data.get(position).getSHOWTIME() + "");
                break;

        }


        return convertView;
    }


    public class ViewHolder_one {
        public View rootView;
        public TextView title_one;
        public ImageView image_url_one;
        public TextView time_one;

        public ViewHolder_one(View rootView) {
            this.rootView = rootView;
            this.title_one = (TextView) rootView.findViewById(R.id.title_one);
            this.image_url_one = (ImageView) rootView.findViewById(R.id.image_url_one);
            this.time_one = (TextView) rootView.findViewById(R.id.time_one);
        }

    }

    public class ViewHolder_two {
        public View rootView;
        public TextView title_two;
        public TextView subtitle_two;
        public TextView time_two;

        public ViewHolder_two(View rootView) {
            this.rootView = rootView;
            this.title_two = (TextView) rootView.findViewById(R.id.title_two);
            this.subtitle_two = (TextView) rootView.findViewById(R.id.subtitle_two);
            this.time_two = (TextView) rootView.findViewById(R.id.time_two);
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position).getIMAGEURL() != null) {
            return 0;
        } else {
            return 1;
        }

    }
}
