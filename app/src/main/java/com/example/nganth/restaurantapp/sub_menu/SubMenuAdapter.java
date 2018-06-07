package com.example.nganth.restaurantapp.sub_menu;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.FoodBinding;
import com.example.nganth.restaurantapp.databinding.RestaurantBinding;

import java.util.List;

/**
 * Created by HV on 6/6/2018.
 */

public class SubMenuAdapter extends RecyclerView.Adapter {
    private List<Object> list;

    public SubMenuAdapter(List<Object> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view;
        if (viewType == 2) {
            FoodBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.food, parent, false);
            view = binding.getRoot();
        } else {
            RestaurantBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.restaurant, parent, false);
            view = binding.getRoot();
        }

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object restaurant = list.get(position);
        if (restaurant instanceof SubMenuFood) {
            FoodBinding binding = DataBindingUtil.findBinding(holder.itemView);
            SubMenuFood food = (SubMenuFood) restaurant;
            binding.txtFoodName.setText(food.getFood_name());
            binding.txtFoodPrice.setText(food.getFood_price());
        } else {
            SubMenuRestaurant subMenuRestaurant = (SubMenuRestaurant) restaurant;
            RestaurantBinding binding = DataBindingUtil.findBinding(holder.itemView);
            binding.txtRestaurantName.setText(subMenuRestaurant.getRestaurantName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) { // 1, 2
        Object restaurant = list.get(position);
        if (restaurant instanceof SubMenuFood) {
            return 2;
        }
        return 1;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }
}
