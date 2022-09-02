package com.example.evableindia.response;

import com.example.evableindia.layout.RegfisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface api

{   @FormUrlEncoded
    @POST("registers.php")
Call<RegfisterResponse> registers
        (  @Field("name") String name,
           @Field("email") String email,
           @Field("pass") String pass


        );


}
