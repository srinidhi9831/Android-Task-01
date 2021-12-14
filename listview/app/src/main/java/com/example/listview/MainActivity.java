package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CheckBox;

import com.example.listview.RetrofitApi.Myapi;
import com.example.listview.adapters.Myadapter;
import com.example.listview.model.data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public CheckBox ch;
    public RecyclerView p,q,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView name=(RecyclerView) findViewById(R.id.rcView);
        name.setLayoutManager(new LinearLayoutManager(this));




        Call<data> call=new Myapi().getres();
        call.enqueue(new Callback<data>() {
            @Override
            public void onResponse(Call<data> call, Response<data> response) {
                name.setAdapter(new Myadapter(response.body(),MainActivity.this));

            }

            @Override
            public void onFailure(Call<data> call, Throwable t) {

            }
        });

    }

}