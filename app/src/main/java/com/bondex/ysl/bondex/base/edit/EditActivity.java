package com.bondex.ysl.bondex.base.edit;

import android.os.Bundle;

import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityEditBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class EditActivity extends BaseActivity<ActivityEditBinding, EditViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_edit;
    }

    @Override
    public int initVariableId() {
        return BR.editModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Editext");

    }
}
