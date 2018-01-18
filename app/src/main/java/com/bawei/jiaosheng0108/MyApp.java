package com.bawei.jiaosheng0108;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adminjs on 2018/1/8.
 */

public class MyApp extends Application {

    public static Inters inters;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        inters = retrofit.create(Inters.class);
    }
}
