package com.bondex.ysl.bondex.base.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.R;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ImageSecondActivity extends BaseActivity {



    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_image_second;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
    }
}
