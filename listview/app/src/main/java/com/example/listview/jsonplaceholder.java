package com.example.listview;

import com.example.listview.model.data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonplaceholder {

    @GET("ricky1550/pariksha/db")
 Call <data> getData();
}
