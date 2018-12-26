package com.bondex.ysl.bondex.base.progress;

import android.os.Bundle;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityProgressBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ProgressActivity extends BaseActivity<ActivityProgressBinding,PrgoreeViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {

        return R.layout.activity_progress;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"progress");

        binding.slider.setValue(20);
        binding.slider.setMax(50);
        binding.slider.setMin(0);
        binding.slider.setShowNumberIndicator(true);
    }
}
