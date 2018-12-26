package com.bondex.ysl.bondex.base.tab;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * date: 2018/12/19
 * Author: ysl
 * description:
 */
public class FrageMentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;

    public FrageMentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position+"";
    }
}
