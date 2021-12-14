package com.example.listview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonplaceholder {

    @GET("ricky1550/pariksha/db")
 Call <data> getData();
}
