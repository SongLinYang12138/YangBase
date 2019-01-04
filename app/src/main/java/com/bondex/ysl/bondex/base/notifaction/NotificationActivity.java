package com.bondex.ysl.bondex.base.notifaction;


import android.os.Bundle;

import com.bondex.ysl.bondex.base.R;

import me.goldze.mvvmhabit.base.BaseActivity;

public class NotificationActivity extends BaseActivity {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_notification;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
