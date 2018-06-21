package com.xy.blog.rest;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RespHandler implements Callback<JsonObject> {

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        System.out.println(response.body());
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable throwable) {
        System.out.println(throwable.getMessage());
    }
}
