package com.bondex.ysl.bondex.base.text;


import android.os.Bundle;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityTextBinding;
import me.goldze.mvvmhabit.base.BaseActivity;

public class TextActivity extends BaseActivity<ActivityTextBinding,TextModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_text;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Text");
    }
}
