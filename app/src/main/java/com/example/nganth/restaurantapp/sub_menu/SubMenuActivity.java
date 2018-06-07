package com.example.nganth.restaurantapp.sub_menu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.SubMenuBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HV on 6/6/2018.
 */

public class SubMenuActivity extends AppCompatActivity {
    SubMenuBinding binding;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.sub_menu);

        List<Object> objects = new ArrayList<>();

        objects.add(new SubMenuRestaurant("Nha hang 1"));
        objects.add(new SubMenuFood("Food 1", "150000"));
        objects.add(new SubMenuFood("Food 2", "250000"));

        objects.add(new SubMenuRestaurant("Nha hang 2"));
        objects.add(new SubMenuFood("Food 3", "350000"));
        objects.add(new SubMenuFood("Food 4", "450000"));


        SubMenuAdapter adapter = new SubMenuAdapter(objects);

        binding.lstSubMenu.setAdapter(adapter);

        binding.lstSubMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    }
}
