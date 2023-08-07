package com.devtaghreed.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.devtaghreed.map.databinding.ActivityHomeBinding;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("Gaza", new LatLng(31.5000,34.4667)));
        itemArrayList.add(new Item("Jerusalem", new LatLng(31.771959,35.217018)));
        itemArrayList.add(new Item("Los Anglos", new LatLng(34.052235,-118.243683)));
        itemArrayList.add(new Item("Jaffa", new LatLng( 32.0527,34.7511)));
        itemArrayList.add(new Item("Dubai", new LatLng(25.276987,55.296249)));
        itemArrayList.add(new Item("Doha", new LatLng(25.2854,51.5310)));
        itemArrayList.add(new Item("Amman", new LatLng(31.9539,35.9106)));

        Adapter adapter = new Adapter(itemArrayList, this, new listener() {
            @Override
            public void onClick(int id) {
                Intent intent = new Intent(getBaseContext(),MapsActivity.class);
                double lat = itemArrayList.get(id).latLng.latitude;
                double lng = itemArrayList.get(id).latLng.longitude;
                intent.putExtra("lat",lat);
                intent.putExtra("lng",lng);
                startActivity(intent);
            }
        });
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


    }
}