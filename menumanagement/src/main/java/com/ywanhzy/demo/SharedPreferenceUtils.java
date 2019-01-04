package com.ywanhzy.demo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * date: 2019/1/4
 * Author: ysl
 * description:
 */
public class SharedPreferenceUtils {

    private SharedPreferences preferences;
    private static SharedPreferenceUtils  instance;
    private Context context;

    private SharedPreferenceUtils(Context context, String dbName) {
        this.context = context;

        if (context != null)
            preferences = context.getSharedPreferences(dbName, Context.MODE_PRIVATE);
    }


    public static SharedPreferenceUtils getInstance(Context context, String dbName) {

        if (instance == null) instance = new SharedPreferenceUtils(context, dbName);

        return instance;
    }


    public void saveStr(String key, String value) {

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(key,value);
        editor.apply();
    }


    public String getStr(String key) {


        String value = preferences.getString(key, "");

        return value;
    }

}
