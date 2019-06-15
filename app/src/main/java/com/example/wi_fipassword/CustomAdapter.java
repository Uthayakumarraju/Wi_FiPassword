package com.example.wi_fipassword;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {
    Context mcontext;
    ArrayList<Devicenamme> namelist;
    public CustomAdapter(MainActivity mainActivity, ArrayList<Devicenamme> namelist) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
