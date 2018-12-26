package com.bondex.ysl.bondex.base.main;

import android.annotation.SuppressLint;

import android.arch.lifecycle.Observer;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityMainBinding;


import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.tatarka.bindingcollectionadapter2.BR;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModle> {

    private MainAdapter adapter;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.mainmodle;
    }


    @Override
    public void initViewObservable() {
        super.initViewObservable();

        Observer<ArrayList<MainMenuBean>> observer = new Observer<ArrayList<MainMenuBean>>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChanged(@Nullable ArrayList<MainMenuBean> s) {

                if(adapter == null){

                    adapter = new MainAdapter(s);
                    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                    binding.mainListview.setLayoutManager(manager);
                    DividerItemDecoration divider = new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL);
                    divider.setDrawable(new ColorDrawable(R.color.light_gray));
                    binding.mainListview.addItemDecoration(divider);
                    binding.mainListview.setAdapter(adapter);
                }else {

                    adapter.update(s);
                }
            }
        };

        viewModel.ui.observe(this,observer);


    }
}
