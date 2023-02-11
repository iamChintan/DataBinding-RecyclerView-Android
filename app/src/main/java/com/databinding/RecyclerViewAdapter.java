package com.databinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.databinding.databinding.ItemRowBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements IClickLister {

    public List<DataModel> modelList;
    public Context context;

    public RecyclerViewAdapter(List<DataModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        ItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_row, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel dataModel = modelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setClickListener(this);

    }

    @Override
    public int getItemCount() {
        Toast.makeText(context, ""+ modelList.size(), Toast.LENGTH_SHORT).show();
        return modelList.size();
    }

    @Override
    public void cardClicked(DataModel model) {
        Toast.makeText(context, model.androidName, Toast.LENGTH_LONG).show();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemRowBinding itemRowBinding;
        public ViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(DataModel obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }

        public void cardClicked(DataModel model) {
            Toast.makeText(context, model.androidName, Toast.LENGTH_LONG).show();
        }
    }
}
