package com.bondex.ysl.bondex.base.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.databinding.ActivityImageBinding;
import me.goldze.mvvmhabit.base.BaseActivity;

public class ImageActivity extends BaseActivity<ActivityImageBinding,ImageViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_image;
    }

    @Override
    public int initVariableId() {
        return BR.imageViewModle;
    }


    @Override
    public void initViewObservable() {
        super.initViewObservable();


    }
}
