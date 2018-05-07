package com.example.mackanrishastv.question20;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 3;


    public PageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return fragment1.newInstance("F1", 1);
            case 1:
                return fragment1.newInstance("F2", 2);
            case 2:
                return fragment1.newInstance("F3", 3);
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return "Page :" + position;
    }
}
