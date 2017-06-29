package com.example.administrator.artisan.Homes.dingzuo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.robshop.PullToZoomScrollViewEx;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/***
 * Created by chen on 2017/6/14.
 * 订座 优惠券详情
 */
public class HomeYouHuiXQActivity extends AppCompatActivity {
    private Unbinder bind;
    @BindView(R.id.youhui_iv)
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_you_hui_xq);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        imageView.setImageResource(R.drawable.gouwu_remen);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.home_dingzuo_xq_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_dingzuo_xq_fh:
                finish();
                break;
        }
    }
}
