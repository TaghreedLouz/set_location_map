package com.devtaghreed.map;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devtaghreed.map.databinding.ItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.App_ViewHolder> {
    ArrayList<Item> itemArrayList;
    Context context;
    listener listener;

    public Adapter(ArrayList<Item> itemArrayList, Context context, com.devtaghreed.map.listener listener) {
        this.itemArrayList = itemArrayList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public App_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new App_ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull App_ViewHolder holder, int position) {
        if (itemArrayList == null)
            return;

          Item item = itemArrayList.get(holder.getAdapterPosition());
          holder.button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  listener.onClick(holder.getAdapterPosition());

              }
          });
          holder.textView.setText(item.getCity());
    }

    @Override
    public int getItemCount() {
        return itemArrayList != null ? itemArrayList.size() : 0;    }

    class App_ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Button button;

        public App_ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            textView = binding.textView;
            button = binding.button;
        }
    }
}
