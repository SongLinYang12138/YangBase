package com.bondex.ysl.bondex.base.main;

import android.app.Application;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * date: 2018/12/17
 * Author: ysl
 * description:
 */
public class MainViewModle extends BaseViewModel {


    public MutableLiveData<ArrayList<MainMenuBean>> ui = new MutableLiveData<>();


    public MainViewModle(@NonNull Application application) {
        super(application);


        ArrayList<MainMenuBean> tmpList = new ArrayList<>();
        tmpList.add(new MainMenuBean("字体","font"));
        tmpList.add(new MainMenuBean("输入框","edit"));
        tmpList.add(new MainMenuBean("按钮","button"));
        tmpList.add(new MainMenuBean("选择开关","switch"));
        tmpList.add(new MainMenuBean("进度条","progressbar"));
        tmpList.add(new MainMenuBean("等待框","loading"));
        tmpList.add(new MainMenuBean("图标","icon"));
        tmpList.add(new MainMenuBean("下拉框","xiala"));
        tmpList.add(new MainMenuBean("导航栏","tabbar"));
        tmpList.add(new MainMenuBean("弹出框","dialog"));
        tmpList.add(new MainMenuBean("搜索框","search"));
        tmpList.add(new MainMenuBean("轮播","carousel"));
        tmpList.add(new MainMenuBean("网络加载失败或超时","error"));
        tmpList.add(new MainMenuBean("扫码","scan"));
        tmpList.add(new MainMenuBean("网络设置","network"));
        tmpList.add(new MainMenuBean("图片","image"));
        tmpList.add(new MainMenuBean("视频","video"));
        tmpList.add(new MainMenuBean("菜单","menu"));
//        tmpList.add(new MainMenu("等待框","loading"));
//        tmpList.add(new MainMenu("等待框","loading"));


        ui.setValue(tmpList);
    }



}
