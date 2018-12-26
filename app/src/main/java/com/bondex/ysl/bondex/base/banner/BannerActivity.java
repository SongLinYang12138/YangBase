package com.bondex.ysl.bondex.base.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.ActivityBannerBinding;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BannerActivity extends BaseActivity<ActivityBannerBinding, BannerViewModle> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_banner;
    }

    @Override
    public int initVariableId() {
        return BR.bannerViewModle;
    }


    @Override
    public void initViewObservable() {
        super.initViewObservable();


        showLeft(true,this);
        showTitle(true,"轮播界面");

        ArrayList<Integer> localImages = new ArrayList<>();

        localImages.add(R.mipmap.banner1);
        localImages.add(R.mipmap.banner2);

        CBViewHolderCreator holderCreator = new CBViewHolderCreator() {
            @Override
            public Holder createHolder(View itemView) {
                return new BannerHolderView(itemView);
            }

            @Override
            public int getLayoutId() {
                return R.layout.banner_item;
            }
        };

        binding.bannerBanner.setPages(holderCreator, localImages).setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        binding.bannerBanner.startTurning();
    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.bannerBanner.stopTurning();
    }
}
