package com.bondex.ysl.bondex.base.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivitySearchBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SearchActivity extends BaseActivity<ActivitySearchBinding,SearchViewModle> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_search;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"Search");
    }
}
