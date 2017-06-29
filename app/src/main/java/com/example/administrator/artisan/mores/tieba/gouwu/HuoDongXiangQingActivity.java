package com.example.administrator.artisan.mores.tieba.gouwu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/22.
 * 活动 详情
 */
public class HuoDongXiangQingActivity extends AppCompatActivity {

    private Unbinder bind;
    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_dong_xiang_qing);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        activityUtils = new ActivityUtils(this);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.huodong_xiangqing_fh, R.id.huodong_xiangqing_bmcj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huodong_xiangqing_fh:
                finish();
                break;
            case R.id.huodong_xiangqing_bmcj:
                activityUtils.startActivity(HuoDongBaoMingActivity.class);
                break;
        }
    }
}
