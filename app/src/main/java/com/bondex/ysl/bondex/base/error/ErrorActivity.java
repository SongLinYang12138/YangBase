package com.bondex.ysl.bondex.base.error;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bondex.ysl.bondex.base.R;


public class ErrorActivity extends AppCompatActivity {

    private TextView  tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.customactivityoncrash_default_error_activity);

        tv = findViewById(R.id.error_text);


    }


    boolean isCut;
    public void cutText(View view){

        if(!isCut){
            isCut = true;
            tv.setText(R.string.customactivityoncrash_error_activity_http_error_occurred_explanation);
        }else {
            isCut =false;
            tv.setText(R.string.customactivityoncrash_error_activity_http_eout_occurred_explanation);
        }



    }

}
