package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
//    public void addExclusions(View view,Exclusion[][] exclusions){
//
//        for(Exclusion[] ex:exclusions){
//                 int op01=ex[0].getOptions_id();
//                 int op02=ex[1].getOptions_id();
//                 if(view.findViewById(op01).isPressed()){
//                     view.findViewById(op02).setEnabled(false);
//
//            }
//                 else if(view.findViewById(op02).isPressed()){
//                     view.findViewById(op01).setEnabled(false);
//                 }
//        }
//    }

}