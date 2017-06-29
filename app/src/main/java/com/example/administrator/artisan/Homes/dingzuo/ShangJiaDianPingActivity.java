package com.example.administrator.artisan.Homes.dingzuo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/***
 * Created by chen on 2017/6/27.
 * 订座 商家商品
 */
public class ShangJiaDianPingActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shang_jia_dian_ping);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick(R.id.home_dingzuo_xq_sjdp_fh)
    public void onViewClicked() {
        finish();
    }
}
