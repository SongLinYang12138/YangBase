package com.bondex.ysl.bondex.base.button;

import android.os.Build;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityButtonBinding;
import com.gc.materialdesign.views.ProgressBarIndeterminate;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ButtonActivity extends BaseActivity<ActivityButtonBinding, ButtonViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_button;
    }

    @Override
    public int initVariableId() {
        return BR.buttonViewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Button");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            binding.buttonflat.setDrawableIcon(getDrawable(R.mipmap.user_icon));
            binding.buttonSmall.setDrawableIcon(getDrawable(R.mipmap.password_icon));



        }

    }
}
