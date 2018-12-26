package me.goldze.mvvmhabit.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * date: 2018/12/26
 * Author: ysl
 * description:
 */
public class CommonUtil {



    public static int getScreenH(Context context){

        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        return dm.heightPixels;
    }

    public static int getScreenW(Context context){

        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        return dm.widthPixels;
    }




}
