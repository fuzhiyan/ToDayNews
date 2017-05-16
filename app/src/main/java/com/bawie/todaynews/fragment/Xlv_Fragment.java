package com.bawie.todaynews.fragment;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawie.todaynews.R;
import com.bawie.todaynews.adapter.Xlv_Adapter;
import com.bawie.todaynews.bean.Tuijian;
import com.bawie.todaynews.utils.GetGson;
import com.bawie.todaynews.utils.MyUrl;
import com.example.xlistview.XListView;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Xlv_Fragment extends Fragment {


    private XListView xlv;
    private Handler handler;
    private List<Tuijian.DataBean> data;
    private Xlv_Adapter adapter;

    public Xlv_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xlv, container, false);


        initView(view);
        initHandler();
        initData();
        return view;
    }

    private void initData() {
        ConnectivityManager connectivityManager= (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if(networkInfo.isAvailable()==false){

            Toast.makeText(getActivity(),"网络链接异常",Toast.LENGTH_LONG).show();
        }else {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                new GetGson(handler, MyUrl.tuijian).start();
                xlv.setPullRefreshEnable(true);
                xlv.setPullLoadEnable(true);

                xlv.setXListViewListener(new XListView.IXListViewListener() {
                    @Override
                    public void onRefresh() {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                data.clear();
                                new GetGson(handler, MyUrl.tuijian).start();
                                adapter.notifyDataSetChanged();
                                xlv.stopRefresh();

                            }
                        }, 1000);
                    }

                    @Override
                    public void onLoadMore() {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                data.addAll(data);
                                adapter.notifyDataSetChanged();
                                xlv.stopLoadMore();

                            }
                        }, 1000);
                    }
                });

            } else {


            }


        }
    }

    private void initHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        String str = (String) msg.obj;
                        Gson gson = new Gson();
                        Tuijian tuijian = gson.fromJson(str, Tuijian.class);
                        data = tuijian.getData();
                        adapter = new Xlv_Adapter(getActivity(), data);
                        xlv.setAdapter(adapter);
                        break;

                    default:
                        break;
                }
            }
        };


    }

    private void initView(View view) {
        xlv = (XListView) view.findViewById(R.id.xlv);
    }
}
