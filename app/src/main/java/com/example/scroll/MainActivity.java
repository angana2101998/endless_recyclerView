package com.example.scroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
adapter adapter;
boolean isloading= false;
ArrayList<String>dataset=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        populateData();
        setupadapter();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager=(LinearLayoutManager) recyclerView.getLayoutManager();
                if(!isloading){
                    isloading=true;
                    getMOredata();

                }
            }

            private void getMOredata() {
                dataset.add(null);
                adapter.notifyItemInserted(dataset.size()-1);
                dataset.remove(dataset.size()-1);
                int nextsize=dataset.size()+10;
                int currsize=dataset.size();
                while (currsize<nextsize){
                    dataset.add("item"+currsize);
                    currsize++;
                }
            adapter.notifyDataSetChanged();
                isloading=false;
            }
        });
    }

    private void setupadapter() {
        adapter=new adapter(dataset);
        recyclerView.setAdapter(adapter);
    }

    private void populateData() {
        int i=0;
        while (i<10){
            dataset.add("items"+i);
            i++;
        }
        //dataset.add(null);
    }
}