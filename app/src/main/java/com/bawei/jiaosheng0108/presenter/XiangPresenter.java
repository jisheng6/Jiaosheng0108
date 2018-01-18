package com.bawei.jiaosheng0108.presenter;

import com.bawei.jiaosheng0108.bean.XiangBean;
import com.bawei.jiaosheng0108.model.XiangModel;
import com.bawei.jiaosheng0108.view.XiangView;

/**
 * Created by Adminjs on 2018/1/8.
 */

public class XiangPresenter {
    private XiangModel model;
    private XiangView view;

    public XiangPresenter(XiangView view) {
        this.view = view;
        this.model = new XiangModel();
    }
    public void get(){
        model.getData(new XiangModel.ModelCallBack() {
            @Override
            public void success(XiangBean bean) {
                if (view != null){
                    view.success(bean);
                }
            }
        });
    }
    public void detach(){
        view = null;
    }
}
