package com.bawei.jiaosheng0108.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jiaosheng0108.R;
import com.bawei.jiaosheng0108.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Adminjs on 2018/1/8.
 */

public class XiangAdapter extends RecyclerView.Adapter<XiangAdapter.IViewholder>{
    private Context context;
    private List<XiangBean.DataBean> list;

    public XiangAdapter(Context context) {
        this.context = context;
    }
    public void addData(XiangBean bean){
        if (list == null){
            list = new ArrayList<>();
        }
        if (bean.getData() == null){
            Toast.makeText(context, "不能为空", Toast.LENGTH_SHORT).show();
        }else{
           list.add(bean.getData());
        }
        notifyDataSetChanged();
    }

    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_layout,null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(IViewholder holder, int position) {
        String[] url = list.get(position).getImages().split("\\|");
        holder.simpleDraweeView.setImageURI(url[0],list.get(position).getImages());
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class IViewholder extends RecyclerView.ViewHolder{

        SimpleDraweeView simpleDraweeView;
        TextView title;
        TextView price;
        public IViewholder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simple);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
