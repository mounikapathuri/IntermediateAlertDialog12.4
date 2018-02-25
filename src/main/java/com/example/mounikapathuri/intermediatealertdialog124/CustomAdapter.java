package com.example.mounikapathuri.intermediatealertdialog124;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mounikapathuri on 25-02-2018.
 */

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Data> mList;
    private LayoutInflater mLayoutInflater;

    public CustomAdapter(Context mContext, ArrayList mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflating row layout
        view = mLayoutInflater.inflate(R.layout.row,null);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvNumber = (TextView) view.findViewById(R.id.tvNumber);
        TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
        //setting data in texview
        tvName.setText(mList.get(i).getmName());
        tvNumber.setText(String.valueOf(mList.get(i).getmNumber()));
        tvDate.setText(String.valueOf(mList.get(i).getmDate()));
        return view;
    }
}
