package com.bondex.ysl.bondex.base.image;

import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.databinding.ActivityImageBinding;
import com.github.chrisbanes.photoview.OnMatrixChangedListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.OnSingleFlingListener;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class ImageActivity extends BaseActivity<ActivityImageBinding, ImageViewModle> {



    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_image;
    }

    @Override
    public int initVariableId() {
        return BR.imageViewModle;
    }

    @Override
    public void initData() {
        super.initData();

        viewModel.setContext(this);
        showLeft(true, this);
        showTitle(true, "图片");
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();



    }




}
