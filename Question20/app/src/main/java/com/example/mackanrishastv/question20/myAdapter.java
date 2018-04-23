package com.example.mackanrishastv.question20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class myAdapter extends PagerAdapter {

    private ArrayList<Face> lstFace;
    private LayoutInflater inflater;

    public myAdapter(Context context, ArrayList<Face> lstFace) {
        this.lstFace = lstFace;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lstFace.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
