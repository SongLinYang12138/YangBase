package com.bondex.ysl.bondex.base.utils;

import android.view.View;

/**
 * date: 2018/12/18
 * Author: ysl
 * description:
 */
public abstract class NoDoubleClickListener implements View.OnClickListener {

    private long lastClick;

    @Override
    public void onClick(View v) {

        if(System.currentTimeMillis() - lastClick > 500){
            noDouble(v);
            lastClick = System.currentTimeMillis();
        }

    }

    public abstract void noDouble(View v);


}
