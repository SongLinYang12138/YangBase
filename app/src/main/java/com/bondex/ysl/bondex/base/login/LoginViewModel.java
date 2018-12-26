package com.bondex.ysl.bondex.base.login;

import android.app.Application;
import android.content.Context;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.bondex.ysl.bondex.base.main.MainActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * date: 2018/12/13
 * Author: ysl
 * description:
 */
public class LoginViewModel extends BaseViewModel {

    private Context context;
    private static final String TAG = LoginViewModel.class.getSimpleName();


    public LoginViewModel(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();
    }

    public BindingCommand loginCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            startActivity(MainActivity.class);
        }
    });



}
