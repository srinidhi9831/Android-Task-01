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

        //res=(TextView) findViewById(R.id.result);

//        ListView mylistview=findViewById(R.id.lsView);
//        ArrayList<String> groc=new ArrayList<String>();
//
//        groc.add("inchara");
//        groc.add("prathik");
//        groc.add("prajwal");
//        groc.remove("inchara");

//
//        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,groc);
//        mylistview.setAdapter(arrayAdapter);

//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl("https://my-json-server.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        jsonplaceholder jsonplh=retrofit.create(jsonplaceholder.class);
//        Call<data> call=jsonplh.getData();
//        call.enqueue(new Callback<data>() {
//            @Override
//            public void onResponse(Call<data> call, Response<data> response) {
//               try{
//                   data d= response.body();
//                   Exclusion[][] ex=d.getExclusions();
//                   int v=ex[1][1].getOptions_id();
//                   Exclusion[] m=ex[0];
//
//                   res.setText("success "+m[2].getOptions_id());
//               }
//               catch (Exception exception){
//                   res.setText(exception.getMessage());
//               }
//                   // res.setText(ex[0][1].getOptions_id());
//            }
//
//            @Override
//            public void onFailure(Call<data> call, Throwable t) {
//                    res.setText(t.getMessage());
//            }
//        });
        //Call<List<data>> call= jsonplh.getData();
       // res.setText(call.toString());
//        call.enqueue(new Callback<List<data>>() {
//            @Override
//            public void onResponse(Call<List<data>> call, Response<List<data>> response) {
//               List<data> d=response.body();
//              // String[] f=
//               res.append(d.toString());
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<data>> call, Throwable t) {
//                 //res.setText("once again error:"+t.getMessage());
//                res.append(t.getMessage());
//            }
//        });
        //recycler view
        RecyclerView name=(RecyclerView) findViewById(R.id.rcView);
        name.setLayoutManager(new LinearLayoutManager(this));




        Call<data> call=new Myapi().getres();
        call.enqueue(new Callback<data>() {
            @Override
            public void onResponse(Call<data> call, Response<data> response) {
                name.setAdapter(new Myadapter(response.body(),MainActivity.this));
              //name2.setAdapter(new ItemsAdapter(response.body().getFacilities()));

            }

            @Override
            public void onFailure(Call<data> call, Throwable t) {

            }
        });
      // ch=(CheckBox) findViewById(R.id.itCheckBox);
        //dispMessage(ch.getText().toString());
       // Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
//     name.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View view) {
//             Toast.makeText(MainActivity.this,"hola", Toast.LENGTH_SHORT).show();
//             //dispMessage("hola");
//         }
//     });



       // RecyclerView name=(RecyclerView) findViewById(R.id.rcView);
        //name.setLayoutManager(new LinearLayoutManager(this));
        //String[] arr={"helo","hola","bala"};


    }
    public void dispMessage(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
    void validate(){

    }
}