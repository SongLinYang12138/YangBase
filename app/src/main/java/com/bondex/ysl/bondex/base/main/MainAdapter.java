package com.bondex.ysl.bondex.base.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.banner.BannerActivity;
import com.bondex.ysl.bondex.base.button.ButtonActivity;
import com.bondex.ysl.bondex.base.databinding.MainMenuRecyclerviewItemBinding;
import com.bondex.ysl.bondex.base.dialog.DialogActivity;
import com.bondex.ysl.bondex.base.edit.EditActivity;
import com.bondex.ysl.bondex.base.error.ErrorActivity;
import com.bondex.ysl.bondex.base.image.ImageActivity;
import com.bondex.ysl.bondex.base.load.LoadActivity;
import com.bondex.ysl.bondex.base.network.NetWorkActivity;
import com.bondex.ysl.bondex.base.progress.ProgressActivity;
import com.bondex.ysl.bondex.base.scan.ScanActivity;
import com.bondex.ysl.bondex.base.search.SearchActivity;
import com.bondex.ysl.bondex.base.spinner.SpinnerActivity;
import com.bondex.ysl.bondex.base.switches.SwitchActivity;
import com.bondex.ysl.bondex.base.tab.TabActivity;
import com.bondex.ysl.bondex.base.text.TextActivity;
import com.bondex.ysl.bondex.base.utils.NoDoubleClickListener;
import com.bondex.ysl.bondex.base.video.VideoActivity;
import com.bondex.ysl.bondex.base.webview.WebviewActivity;

import java.util.ArrayList;

/**
 * date: 2018/12/17
 * Author: ysl
 * description:
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<MainMenuBean> list;

    private Context context;

    public MainAdapter(ArrayList<MainMenuBean> list) {

        this.list = list;
    }

    public void update(ArrayList<MainMenuBean> list) {

        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.main_menu_recyclerview_item, null);

        MainMenuRecyclerviewItemBinding binding = DataBindingUtil.bind(view);


        ViewHolder holder = new ViewHolder(binding.getRoot());
        holder.setBinding(binding);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.binding.menuItemTvName.setTag(position);
        holder.binding.menuItemTvName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        MainMenuRecyclerviewItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(MainMenuRecyclerviewItemBinding binding) {
            this.binding = binding;

            this.binding.menuClConent.setOnClickListener(listener);
        }

        public NoDoubleClickListener listener = new NoDoubleClickListener() {
            @Override
            public void noDouble(View v) {

                int postion = (int) binding.menuItemTvName.getTag();

                MainMenuBean bean = list.get(postion);
//
//                tmpList.add(new MainMenuBean("字体","font"));
//                tmpList.add(new MainMenuBean("输入框","edit"));
//                tmpList.add(new MainMenuBean("按钮","button"));
//                tmpList.add(new MainMenuBean("选择开关","switch"));
//                tmpList.add(new MainMenuBean("进度条","progressbar"));
//                tmpList.add(new MainMenuBean("等待框","loading"));
//                tmpList.add(new MainMenuBean("图标","icon"));
//                tmpList.add(new MainMenuBean("下拉框","xiala"));
//                tmpList.add(new MainMenuBean("导航栏","tabbar"));
//                tmpList.add(new MainMenuBean("弹出框","dialog"));
//                tmpList.add(new MainMenuBean("搜索框","search"));
//                tmpList.add(new MainMenuBean("轮播","carousel"));
//                tmpList.add(new MainMenuBean("网络加载失败或超时","error"));
//                tmpList.add(new MainMenuBean("扫码","scan"));

                Intent intent = null;
                switch (bean.getFlag()) {

                    case "font":
                        intent = new Intent(context, TextActivity.class);
                        break;

                    case "edit":
                        intent = new Intent(context, EditActivity.class);
                        break;
                    case "button":
                        intent = new Intent(context, ButtonActivity.class);
                        break;
                    case "switch":
                        intent = new Intent(context, SwitchActivity.class);
                        break;
                    case "progressbar":
                        intent = new Intent(context, ProgressActivity.class);
                        break;
                    case "loading":
                        intent = new Intent(context, LoadActivity.class);
                        break;
                    case "icon":
                        intent = new Intent(context, WebviewActivity.class);
                        break;
                    case "xiala":
                        intent = new Intent(context, SpinnerActivity.class);
                        break;
                    case "tabbar":
                        intent = new Intent(context, TabActivity.class);
                        break;
                    case "dialog":
                        intent = new Intent(context, DialogActivity.class);
                        break;
                    case "search":
                        intent = new Intent(context, SearchActivity.class);
                        break;
                    case "carousel":
                        intent = new Intent(context, BannerActivity.class);
                        break;
                    case "error":
                        intent = new Intent(context, ErrorActivity.class);
                        break;
                    case "scan":
                        intent = new Intent(context, ScanActivity.class);
                        break;
                    case "network":
                        intent = new Intent(context, NetWorkActivity.class);

                        break;
                    case "image":
                        intent = new Intent(context, ImageActivity.class);
                        break;
                    case "video":
                        intent = new Intent(context,VideoActivity.class);
                        break;
                }

                if (intent != null) context.startActivity(intent);
            }
        };


    }
}
