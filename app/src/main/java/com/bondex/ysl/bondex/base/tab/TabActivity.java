package com.bondex.ysl.bondex.base.tab;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
//import com.google.android.material.tabs.TabLayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityTabBinding;
import com.bondex.ysl.bondex.base.BR;
import me.goldze.mvvmhabit.widget.IconText;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;

public class TabActivity extends BaseActivity<ActivityTabBinding, TabModleView> {


    private IconText icon1, icon2, icon3, icon4;
    private TextView tv1, tv2, tv3, tv4;
    private ColorStateList normal, selected;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_tab;
    }

    @Override
    public int initVariableId() {
        return BR.tabViewModle;
    }


    @SuppressLint("ResourceType")
    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Tab");



        normal = getResources().getColorStateList(R.color.text_gray);
        selected = getResources().getColorStateList(R.color.colorPrimary);

        TabLayout.Tab tab1 = binding.tabTb.newTab();

        tab1.setCustomView(R.layout.tab_item);

        TabLayout.Tab tab2 = binding.tabTb.newTab();

        tab2.setCustomView(R.layout.tab_item);

        TabLayout.Tab tab3 = binding.tabTb.newTab();
        tab3.setCustomView(R.layout.tab_item);

        TabLayout.Tab tab4 = binding.tabTb.newTab();
        tab4.setCustomView(R.layout.tab_item);


        icon1 = tab1.getCustomView().findViewById(R.id.tab_icon);
        tv1 = tab1.getCustomView().findViewById(R.id.tab_text);

        icon2 = tab2.getCustomView().findViewById(R.id.tab_icon);
        tv2 = tab2.getCustomView().findViewById(R.id.tab_text);

        icon3 = tab3.getCustomView().findViewById(R.id.tab_icon);
        tv3 = tab3.getCustomView().findViewById(R.id.tab_text);

        icon4 = tab4.getCustomView().findViewById(R.id.tab_icon);
        tv4 = tab4.getCustomView().findViewById(R.id.tab_text);

        icon1.setText(R.string.first);
        tv1.setText("首页");

        tab1.setText("菜单一");

        icon2.setText(R.string.contact);
        tv2.setText("通讯录");

        icon3.setText(R.string.data);
        tv3.setText("资料");

        icon4.setText(R.string.setting);
        tv4.setText("设置");

        binding.tabTb.addTab(tab1);
        binding.tabTb.addTab(tab2);
        binding.tabTb.addTab(tab3);
        binding.tabTb.addTab(tab4);

        binding.tabTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("aaa", "  " + binding.tabTb.getSelectedTabPosition());
            }
        });

        binding.tabTb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.tabViewpager.setCurrentItem(tab.getPosition());
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
        TabFragment fragment1 = new TabFragment();
        TabFragment fragment2 = new TabFragment();
        TabFragment fragment3 = new TabFragment();
        TabFragment fragment4 = new TabFragment();

        ArrayList<Fragment> list = new ArrayList<>();

        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);

        FrageMentAdapter adapter = new FrageMentAdapter(getSupportFragmentManager(), list);

        binding.tabViewpager.setAdapter(adapter);


        binding.tabViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                binding.tabTb.setScrollPosition(i, 0, true);
                setTabBack(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        binding.tabViewpager.setCurrentItem(0);

    }

    private void setTabBack(int position) {


        icon1.setTextColor(position == 0 ? selected : normal);
        tv1.setTextColor(position == 0 ? selected : normal);

        icon2.setTextColor(position == 1 ? selected : normal);
        tv2.setTextColor(position == 1 ? selected : normal);

        icon3.setTextColor(position == 2 ? selected : normal);
        tv3.setTextColor(position == 2 ? selected : normal);

        icon4.setTextColor(position == 3 ? selected : normal);
        tv4.setTextColor(position == 3 ? selected : normal);
    }


}
