package com.bondex.ysl.bondex.base.load;

import android.databinding.DataBindingUtil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.databinding.RecyclerviewItemLoadBinding;

import java.util.ArrayList;

/**
 * date: 2018/12/18
 * Author: ysl
 * description:
 */
public class LoadAdapter extends RecyclerView.Adapter<LoadAdapter.ViewHolder> {

    private ArrayList<String> list;

    public LoadAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_load, parent, false);

        RecyclerviewItemLoadBinding binding = DataBindingUtil.bind(view);

        ViewHolder holder = new ViewHolder(binding.getRoot());

        holder.setBinding(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.binding.loading.setIndicator(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewItemLoadBinding binding;

        public void setBinding(RecyclerviewItemLoadBinding binding) {
            this.binding = binding;
        }

        public ViewHolder(View itemView) {
            super(itemView);


        }
    }

}
