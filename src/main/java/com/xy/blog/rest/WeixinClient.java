package com.xy.blog.rest;

import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class WeixinClient {

    public static final String API_BASE_URL = "https://api.weixin.qq.com/";

    public static <S> S createService(Class<S> serviceClass) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
                //.tlsVersions(TlsVersion.TLS_1_0)
                .cipherSuites(CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA,
                        CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA256).build();

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());

        httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(20, TimeUnit.SECONDS);
        httpClient.connectionSpecs(Collections.singletonList(spec));

        httpClient.addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();

            HttpUrl.Builder urlBuilder = request.url().newBuilder();


            String token = "10_3eJTBtaroN9eTlHpP2gfKSkJqsEFTy6SmnP3hlbaPPyDFBTZJ2-zv_GrNZeXknt281tCIfi0vQZv4gd1RFBstG2iadwVnY_f39PV6lm3PiX6DtJLcAJQOqQwitVwZW_UH84YbLmC4wCkaqkATLQbABABTY";

            urlBuilder.addQueryParameter("access_token", token);
            requestBuilder.url(urlBuilder.build());

            return chain.proceed(requestBuilder.build());
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

}
