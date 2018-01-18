package com.bawei.jiaosheng0108;

import com.bawei.jiaosheng0108.bean.DeleteBean;
import com.bawei.jiaosheng0108.bean.XiangBean;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Adminjs on 2018/1/8.
 */

public interface Inters{
    @GET("/product/getProductDetail")
    Observable<XiangBean> getXiang(@QueryMap Map<String,String> map);
    @GET("/product/deleteCart")
    Call<DeleteBean> deleteCart(@QueryMap Map<String,String> map);
}
