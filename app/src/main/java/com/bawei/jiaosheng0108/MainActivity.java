package com.bawei.jiaosheng0108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.jiaosheng0108.adapter.XiangAdapter;
import com.bawei.jiaosheng0108.bean.XiangBean;
import com.bawei.jiaosheng0108.jiagou.AddCartBean;
import com.bawei.jiaosheng0108.jiagou.AddCartModelCallBack;
import com.bawei.jiaosheng0108.jiagou.AddCartPresenter;
import com.bawei.jiaosheng0108.jiagou.AddCartViewCallBack;
import com.bawei.jiaosheng0108.presenter.XiangPresenter;
import com.bawei.jiaosheng0108.view.MainViewListener;
import com.bawei.jiaosheng0108.view.XiangView;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements XiangView,AddCartModelCallBack,AddCartViewCallBack{

    private RecyclerView re;
    private XiangPresenter presenter;
    private XiangAdapter adapter;
    private Button gou;
    private Button li;
    private AddCartPresenter addCartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re = findViewById(R.id.recyclerview);
        presenter = new XiangPresenter(this);
        presenter.get();
        adapter = new XiangAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        re.setLayoutManager(manager);
        re.setAdapter(adapter);
        gou = findViewById(R.id.gou);
        li = findViewById(R.id.li);
        addCartPresenter = new AddCartPresenter(this);

        gou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCartPresenter.getData("71");

            }
        });
        li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "正在购买", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void success(XiangBean bean) {
       adapter.addData(bean);
    }

    @Override
    public void success(AddCartBean addCartBean) {
        Toast.makeText(this,""+addCartBean.getMsg(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, GouActivity.class);
        startActivity(intent);
    }

    @Override
    public void failure() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
