package com.example.administrator.flydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class MyAdapter extends BaseAdapter {

    private List list = new ArrayList();
    Context context;

    public MyAdapter(MainActivity mainActivity) {

        this.context = mainActivity;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.view_list_item,null);

            holder = new ViewHolder();

            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);


        }else {

         holder = (ViewHolder) convertView.getTag();
        }

        holder.iv.setImageResource((Integer) list.get(position));

        return convertView;
    }


    class ViewHolder{

        ImageView iv;

    }

    public void setData(List list){
        this.list = list;
    }

    public void clear(){
        list.clear();

    }
}
