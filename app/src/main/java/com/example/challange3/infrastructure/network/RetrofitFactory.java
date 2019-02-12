package com.example.challange3.infrastructure.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class RetrofitFactory {

    private static Retrofit retrofit;

    public static Retrofit initialize(String baseUrl)
    {

        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



    }

    public static Retrofit getInstance() {
        return retrofit;
    }

    public static <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}