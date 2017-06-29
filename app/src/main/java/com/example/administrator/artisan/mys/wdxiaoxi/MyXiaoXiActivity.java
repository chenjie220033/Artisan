package com.example.administrator.artisan.mys.wdxiaoxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 * 我的  消息中心和我的消息一个界面
 * */
public class MyXiaoXiActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_xiao_xi);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
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

    @OnClick(R.id.my_xiaoxi_fh)
    public void onViewClicked() {
        finish();
    }
}
