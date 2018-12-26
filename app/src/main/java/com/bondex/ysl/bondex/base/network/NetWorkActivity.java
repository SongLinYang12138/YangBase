package com.bondex.ysl.bondex.base.network;

import android.os.Bundle;

import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityNetWorkBinding;

import me.goldze.mvvmhabit.base.BaseActivity;


public class NetWorkActivity extends BaseActivity<ActivityNetWorkBinding, NetWorkViewModle> {

    @Override
    public int initContentView(Bundle savedInstanceState) {


        return R.layout.activity_net_work;
    }

    @Override
    public int initVariableId() {
        return BR.networkModle;
    }

    @Override
    public void initData() {
        super.initData();

        showLeft(true,this);
        showTitle(true,"网络设置");
        viewModel.setContext(this);
        binding.button.setOnClickListener(viewModel.listener);


    }


}
