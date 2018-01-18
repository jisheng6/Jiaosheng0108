package com.bawei.jiaosheng0108.view;

import com.bawei.jiaosheng0108.bean.ShopBean;

/**
 * Created by Adminjs on 2017/12/19.
 */

public interface MainViewListener {
    public void success(ShopBean bean);
    public void failure(Exception e);
}
