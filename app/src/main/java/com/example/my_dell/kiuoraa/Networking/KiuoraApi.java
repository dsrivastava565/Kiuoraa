package com.example.my_dell.kiuoraa.Networking;

import android.util.Base64;

import com.example.my_dell.kiuoraa.Application.MyApplication;
import com.example.my_dell.kiuoraa.Utils.AddCookiesInterceptor;
import com.example.my_dell.kiuoraa.Utils.ReceivedCookiesInterceptor;

import butterknife.internal.Utils;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class KiuoraApi {
    // private static String API_BASE_URL = "https://www.kiet.edu/api/hrms/";
//    private static String API_BASE_URL = "http://10.21.66.118:8000/";
    private static String API_BASE_URL="http://10.0.0.12:8000/";




    public static Retrofit getRetrofit(Boolean cache) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(new Cache(MyApplication.context.getCacheDir(), 10 * 1024 * 1024)) // 10 MB
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    if (cache)
                        if (com.example.my_dell.kiuoraa.Utils.Utils.networkAvailable()) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        }
                    return chain.proceed(request).newBuilder().removeHeader("Pragma").build();
                })
                .addInterceptor(new ReceivedCookiesInterceptor())
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
