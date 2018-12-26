package com.bondex.ysl.bondex.base.banner;

import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bondex.ysl.bondex.base.R;

/**
 * date: 2018/12/20
 * Author: ysl
 * description:
 */
public class BannerHolderView extends Holder<Integer> {

    private ImageView iv;
    public BannerHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {

        iv = itemView.findViewById(R.id.banner_item);

    }

    @Override
    public void updateUI(Integer data) {

        iv.setImageResource(data);
    }
}
