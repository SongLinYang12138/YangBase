package me.goldze.mvvmhabit.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;

import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class IconText extends TextView {

    private Typeface iconfont = null;

    public IconText(Context context) {
        super(context);
        initTextivew(context);
    }

    public IconText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTextivew(context);
    }

    private void initTextivew(Context context) {

        iconfont   = Typeface.createFromAsset(context.getAssets(), "font/iconfont.ttf");
        setTypeface(iconfont);
    }


}
