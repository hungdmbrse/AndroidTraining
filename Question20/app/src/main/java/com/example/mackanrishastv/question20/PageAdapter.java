package com.example.mackanrishastv.question20;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {


    public PageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new fragment1();
                break;
            case 1:
                frag = new fragment2();
                break;
            case 2:
                frag = new fragment3();
                break;

        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Page 1";
                break;
            case 1:
                title = "Page 2";
                break;
            case 2:
                title = "Page 3";
                break;
        }
        return title;
    }
}
