package com.xy.blog.rest;

import com.google.gson.JsonObject;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface ApiService {

    @POST("cgi-bin/menu/create")
    Call<JsonObject> createMenu(@Body RequestBody body);

    @POST("cgi-bin/message/template/send")
    Call<JsonObject> sendTemplateMessage(@Body RequestBody body);

    @GET("sns/oauth2/access_token")
    Call<JsonObject> getOpenId(@QueryMap Map<String,String> param);
}
