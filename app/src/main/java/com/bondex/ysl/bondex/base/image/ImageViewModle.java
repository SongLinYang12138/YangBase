package com.bondex.ysl.bondex.base.image;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bondex.ysl.bondex.base.R;
import com.gc.materialdesign.views.ButtonFloat;
import com.github.chrisbanes.photoview.OnMatrixChangedListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.OnSingleFlingListener;
import com.github.chrisbanes.photoview.PhotoView;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.CommonUtil;

/**
 * date: 2018/12/25
 * Author: ysl
 * description:
 */
public class ImageViewModle extends BaseViewModel {

    private Context context;
    static final String PHOTO_TAP_TOAST_STRING = "Photo Tap! X: %.2f %% Y:%.2f %% ID: %d";
    static final String SCALE_TOAST_STRING = "Scaled to: %.2ff";
    static final String FLING_LOG_STRING = "Fling velocityX: %.2f, velocityY: %.2f";


    public void setContext(Context context) {
        this.context = context;
    }

    public ImageViewModle(@NonNull Application application) {
        super(application);

    }

    public BindingCommand command = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            show();
        }
    });

    Dialog dialog;

    private void show() {

        if (dialog == null) {

            dialog = new Dialog(context);


            View view = LayoutInflater.from(context).inflate(R.layout.dialog_photoview_layout,null);
            ButtonFloat buttonFloat = view.findViewById(R.id.btn_close);
            PhotoView photoView = view.findViewById(R.id.photoview);
            buttonFloat.setDrawableIcon(context.getResources().getDrawable(R.mipmap.clean_edit));
            buttonFloat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.setContentView(view);

            photoView.setOnMatrixChangeListener(new MatrixChangeListener());
            photoView.setOnPhotoTapListener(new PhotoTapListener());
            photoView.setOnSingleFlingListener(new SingleFlingListener());

            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

            lp.height = CommonUtil.getScreenH(context) - 20;
            lp.width = CommonUtil.getScreenW(context) - 20;
            lp.gravity = Gravity.CENTER;

            dialog.getWindow().setAttributes(lp);

            dialog.show();

        } else {

            if (dialog.isShowing()) {
                dialog.show();

            } else {
                dialog.show();

            }
        }


    }

    private class PhotoTapListener implements OnPhotoTapListener {

        @Override
        public void onPhotoTap(ImageView view, float x, float y) {
            float xPercentage = x * 100f;
            float yPercentage = y * 100f;

            showToast(String.format(PHOTO_TAP_TOAST_STRING, xPercentage, yPercentage, view == null ? 0 : view.getId()));
        }
    }
    private void showToast(CharSequence text) {

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

    }

    private class MatrixChangeListener implements OnMatrixChangedListener {

        @Override
        public void onMatrixChanged(RectF rect) {

        }
    }

    private class SingleFlingListener implements OnSingleFlingListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("PhotoView", String.format(FLING_LOG_STRING, velocityX, velocityY));
            return true;
        }
    }
}
