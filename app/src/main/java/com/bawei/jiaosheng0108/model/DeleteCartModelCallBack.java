package com.bawei.jiaosheng0108.model;

import com.bawei.jiaosheng0108.bean.DeleteBean;

/**
 * Created by Menglucywhh on 2017/12/11.
 */

public interface DeleteCartModelCallBack {
    public void success(DeleteBean deleteBean);
    public void failure();
}
