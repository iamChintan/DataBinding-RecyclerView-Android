package com.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;


import com.databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        GenerateData();


    }

    public void GenerateData() {
        List<DataModel> modelList = new ArrayList<>();

        modelList.add(new DataModel("8.1","Oreo"));
        modelList.add(new DataModel("9.0","Pie"));
        modelList.add(new DataModel("8.1","Oreo"));
        modelList.add(new DataModel("8.1","Oreo"));
        modelList.add(new DataModel("8.1","Oreo"));
        modelList.add(new DataModel("8.1","Oreo"));
        modelList.add(new DataModel("8.1","Oreo"));
        modelList.add(new DataModel("8.1","Oreo"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(modelList,this);
        binding.setMyAdapter(adapter);
    }
}