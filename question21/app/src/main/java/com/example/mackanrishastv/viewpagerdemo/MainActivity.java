package com.example.mackanrishastv.viewpagerdemo;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.fb,
            R.drawable.inst,
            R.drawable.twiter
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        PagerAdapter adapter = new PageAdapter(fm);
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        setupTabIcon();

    }

    private void setupTabIcon() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

    }
}
