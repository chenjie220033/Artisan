package com.example.administrator.artisan.mys.myyhxx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 * 我的    账户信息  我的收货地址
 * */
public class MySHDZActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shdz);
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

    @OnClick(R.id.my_yonghuxx_wdshdz_fh)
    public void onViewClicked() {
        finish();
    }
}
