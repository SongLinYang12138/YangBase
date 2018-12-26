package com.bondex.ysl.bondex.base.switches;


import android.os.Bundle;

import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivitySwitchBinding;

import me.goldze.mvvmhabit.base.BaseActivity;


public class SwitchActivity extends BaseActivity<ActivitySwitchBinding,SwitchViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_switch;
    }

    @Override
    public int initVariableId() {


        return BR.switchesModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Switches");

    }
}
