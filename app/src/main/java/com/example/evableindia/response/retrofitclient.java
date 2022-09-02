package com.example.evableindia.response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclient
{
    private static  String BASE_URL="hhtp://192.168.4.242 /usersapi/";
    private static retrofitclient client;
    private static Retrofit retrofit;


    private retrofitclient()
    {
        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static  synchronized retrofitclient getInstance()
    {
        if (client== null)
        {
            client= new retrofitclient();
        }
        return client;
    }
     public api getapi()

     {
         return   retrofit.create(api.class);
     }


}
