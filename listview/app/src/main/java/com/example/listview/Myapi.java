package com.example.listview;
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


      //  call.enqueue(new Callback<data>() {
            //@Override
//            public void onResponse(Call<data> call, Response<data> response) {
//                res=response;
////               try{
////                   data d= response.body();
////                   Exclusion[][] ex=d.getExclusions();
////                   int v=ex[1][1].getOptions_id();
////                   Exclusion[] m=ex[0];
////
////                   res.setText("success "+m[2].getOptions_id());
//            }
//
//            // res.setText(ex[0][1].getOptions_id());
//
//
//            @Override
//            public void onFailure(Call<data> call, Throwable t) {
//
//            }
//        });
       // return res;


