package com.bondex.ysl.bondex.base.load;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityLoadBinding;
import com.bondex.ysl.bondex.base.BR;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;

public class LoadActivity extends BaseActivity<ActivityLoadBinding,LoadViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_load;
    }

    @Override
    public int initVariableId() {
        return BR.loadViewModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();

        showLeft(true,this);
        showTitle(true,"loading");

        viewModel.ui.observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(@Nullable ArrayList<String> strings) {

                LoadAdapter adapter = new LoadAdapter(strings);


                RecyclerView.LayoutManager manager = new GridLayoutManager(LoadActivity.this,2){

                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };


                binding.recyclerview.setLayoutManager(manager);
                binding.recyclerview.setAdapter(adapter);
            }
        });

    }
}
