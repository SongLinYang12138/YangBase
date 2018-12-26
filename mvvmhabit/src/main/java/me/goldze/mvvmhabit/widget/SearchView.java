package me.goldze.mvvmhabit.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import me.goldze.mvvmhabit.R;

/**
 * date: 2018/12/26
 * Author: ysl
 * description:
 */
public class SearchView extends LinearLayout {

    private IconText iconSearch;
    private EditText editText;

    public SearchView(Context context) {
        super(context);

        init();
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);


        init();
    }

    private void init() {

        inflate(getContext(), R.layout.search_layout, this);

        iconSearch = findViewById(R.id.search_icon);
        editText = findViewById(R.id.search_editext);

    }


    public Editable getText() {

        return editText.getText();
    }

    public void setIconListener(OnClickListener listener) {
        if (listener != null)
            iconSearch.setOnClickListener(listener);
    }

}
