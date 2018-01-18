package com.bawei.jiaosheng0108.model;

import com.bawei.jiaosheng0108.MyApp;
import com.bawei.jiaosheng0108.bean.XiangBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/8.
 */

public class XiangModel{
    public void getData(final ModelCallBack callBack){
        Map<String, String> map = new HashMap<>();
        map.put("source","android");
        map.put("uid","4729");
        map.put("pid","71");
        MyApp.inters.getXiang(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangBean>() {
                    @Override
                    public void accept(XiangBean bean) throws Exception {
                         callBack.success(bean);
                    }
                });
    }

    public interface ModelCallBack {
       public void success(XiangBean bean);
    }
}
