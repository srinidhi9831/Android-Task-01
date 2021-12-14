package com.example.listview.RetrofitApi;
import com.example.listview.jsonplaceholder;
import com.example.listview.model.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Myapi {

    public Call<data> getres() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonplaceholder jsonplh = retrofit.create(jsonplaceholder.class);
        Call<data> call = jsonplh.getData();
        return call;
    }
}



