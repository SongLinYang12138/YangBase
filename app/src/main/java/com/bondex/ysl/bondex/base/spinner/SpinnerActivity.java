package com.bondex.ysl.bondex.base.spinner;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.databinding.ActivitySpinnerBinding;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SpinnerActivity extends BaseActivity<ActivitySpinnerBinding, SpinnerViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_spinner;
    }

    @Override
    public int initVariableId() {
        return BR.spinnerVieModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Spinner");

        viewModel.ui.observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(@Nullable ArrayList<String> strings) {

                binding.spinner.attachDataSource(strings);
            }
        });

    }
}
