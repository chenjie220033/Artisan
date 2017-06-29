package com.example.administrator.artisan.mys.myjiudian;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/7.
 * 我的     酒店付款
 */

public class MyJiuDianFuKuanActivity extends AppCompatActivity {
    @BindView(R.id.my_jiudian_zaixian)
    RadioButton zaixianfu;
    @BindView(R.id.my_jiudian_daodian)
    RadioButton daodianfu;
    private Unbinder bind;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiudian_fukuan);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

}
