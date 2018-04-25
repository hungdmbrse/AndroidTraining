package com.example.mackanrishastv.viewpagerdemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new AndroidFragment();
                break;
            case 1:
                frag = new iOSFragment();
                break;
            case 2:
                frag = new PHPFragment();
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
                title = "Android";
                break;
            case 1:
                title = "iOS";
                break;
            case 2:
                title = "PHP";
                break;
        }
        return title;
    }
}
