package com.bondex.ysl.bondex.base.scan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.databinding.ActivityScanBinding;
import com.google.zxing.client.android.CaptureActivity;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ScanActivity extends BaseActivity<ActivityScanBinding, ScanModle> {

    private final int REQUEST_CODE = 101;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_scan;
    }

    @Override
    public int initVariableId() {
        return BR.scanViewModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();


        if(checkCallingOrSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},111);
            }

        }

        showLeft(true,this);
        showTitle(true,"Scan");

        binding.scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ScanActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {

            String result = data.getStringExtra(CaptureActivity.SCAN_DATA);
            Log.i("aaa", "result " + result);
            if (!TextUtils.isEmpty(result)) {
                binding.scanText.setText(result);
            }

        }


    }
}
