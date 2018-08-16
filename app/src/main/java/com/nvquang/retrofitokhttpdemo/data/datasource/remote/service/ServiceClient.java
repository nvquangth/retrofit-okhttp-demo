package com.nvquang.retrofitokhttpdemo.data.datasource.remote.service;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by quangnv on 16/08/2018
 */

public class ServiceClient {

    private static final int CONNECTION_TIMEOUT = 60;

    static <T> T createService(Context context, String endPoint, Class<T> serviceClass) {
        return createService(context, endPoint, serviceClass, getGsonConfig(), null);
    }

    static <T> T createService(Context context, String endPoint, Class<T> serviceClass, Gson gson) {
        return createService(context, endPoint, serviceClass, gson, null);
    }

    static <T> T createService(Context context, String endPoint, Class<T> serviceClass, Gson gson,
                               Interceptor interceptor) {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        int cacheSize = 10 * 1024 * 1024;
        httpClientBuilder.cache(new Cache(context.getApplicationContext().getCacheDir(), cacheSize));
        if (interceptor != null) {
            httpClientBuilder.addInterceptor(interceptor);
        }
        httpClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.client(httpClientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }

    static Gson getGsonConfig() {
        BooleanAdapter booleanAdapter = new BooleanAdapter();
        IntegerAdapter integerAdapter = new IntegerAdapter();
        return new GsonBuilder()
                .registerTypeAdapter(Boolean.class, booleanAdapter)
                .registerTypeAdapter(boolean.class, booleanAdapter)
                .registerTypeAdapter(Integer.class, integerAdapter)
                .registerTypeAdapter(int.class, integerAdapter)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
}
