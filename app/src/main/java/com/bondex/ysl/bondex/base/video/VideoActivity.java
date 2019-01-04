package com.bondex.ysl.bondex.base.video;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.FileUtils;
import com.bondex.ysl.bondex.base.databinding.ActivityViedoBinding;


public class VideoActivity extends BaseActivity<ActivityViedoBinding, VideoViewModle> {

    private final int PERMISSION_QREUEST = 111;

    @Override
    public void initParam() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_QREUEST);
            }
        }


    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_viedo;
    }

    @Override
    public int initVariableId() {
        return BR.videoModle;
    }

    @Override
    public void initData() {
        super.initData();

        showLeft(true,this);
        showTitle(true,"VIDEO");

        binding.videoChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("video/*"); //选择视频 （mp4 3gp 是android支持的视频格式）
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            String video_path = null;

            Uri uri=data.getData();
               video_path=FileUtils.getInstance(this).getChooseFileResultPath(uri);

            com.bondex.ysl.videolibrary.VideoActivity.intentTo(VideoActivity.this,video_path,"测试");
        }


    }




}
