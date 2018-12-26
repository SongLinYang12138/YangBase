package com.bondex.ysl.bondex.base.welcome;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.login.LoginActivity;

/**
 * date: 2018/12/20
 * Author: ysl
 * description:
 */
public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        welcomeTv = findViewById(R.id.welcome_tv);

        startAnimation();
    }

    private void startAnimation() {


        ObjectAnimator animator = ObjectAnimator.ofFloat(welcomeTv, "ScaleX", 0, 1f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(welcomeTv, "ScaleY", 0, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(welcomeTv, "rotation", 0, 360);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(welcomeTv, "alpha", 0, 1);

        AnimatorSet set = new AnimatorSet();

        set.play(animator).with(animator1).with(animator2).with(animator3);
        set.setDuration(2000);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
