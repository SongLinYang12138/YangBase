package com.bondex.ysl.bondex.base.spinner;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * date: 2018/12/18
 * Author: ysl
 * description:
 */
public class SpinnerViewModle extends BaseViewModel {

    public MutableLiveData<ArrayList<String>> ui = new MutableLiveData<>();


    public SpinnerViewModle(@NonNull Application application) {
        super(application);

        ArrayList<String> lists = new ArrayList<>();

        lists.add("菜单一");
        lists.add("菜单二");
        lists.add("菜单三");
        lists.add("菜单四");
        lists.add("菜单五");
        lists.add("菜单六");
        lists.add("菜单七");

        ui.postValue(lists);

    }







}
