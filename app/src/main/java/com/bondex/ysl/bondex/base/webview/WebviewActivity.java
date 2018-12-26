package com.bondex.ysl.bondex.base.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityWebviewBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class WebviewActivity extends BaseActivity<ActivityWebviewBinding, WebviewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_webview;
    }

    @Override
    public int initVariableId() {
        return BR.webviewModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"icon");

        viewModel.setWebview(binding.webview);

    }
}
