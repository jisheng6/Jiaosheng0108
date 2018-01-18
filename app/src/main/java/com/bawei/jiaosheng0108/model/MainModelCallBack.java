package com.bawei.jiaosheng0108.model;


import com.bawei.jiaosheng0108.bean.ShopBean;

/**
 * Created by Adminjs on 2017/12/19.
 */

public interface MainModelCallBack {

    public void success(ShopBean bean);
    public void failure(Exception e);
}
