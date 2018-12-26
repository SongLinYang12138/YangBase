package com.bondex.ysl.bondex.base.login;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityLoginBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> {



    @Override
    public int initContentView(Bundle savedInstanceState) {

        return R.layout.activity_login;
    }



    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
