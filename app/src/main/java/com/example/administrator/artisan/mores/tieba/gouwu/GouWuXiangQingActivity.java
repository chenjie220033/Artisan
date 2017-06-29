package com.example.administrator.artisan.mores.tieba.gouwu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/21.
 * 购物详情
 */
public class GouWuXiangQingActivity extends AppCompatActivity {
    @BindView(R.id.text_beijingse)
    TextView textBeijingse;
    private Unbinder bind;
    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_xiang_qing);

        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        activityUtils = new ActivityUtils(this);
        textBeijingse.setAlpha(0.5f);
//        Intent intents = getIntent();
//        test.setText(intents.getStringExtra("mingcheng"));
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_gouwuxiangqing_fh, R.id.houwuxiangqing_gwc_image,R.id.gouwu_xiangqing_ljgm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gouwu_xiangqing_ljgm:
                activityUtils.startActivity(GouWuCheZhiFuActivity.class);
                break;
            case R.id.my_gouwuxiangqing_fh:
                finish();
                break;
            case R.id.houwuxiangqing_gwc_image:
                activityUtils.startActivity(GouWuCheActivity.class);
                break;
        }
    }
}
