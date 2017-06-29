package com.example.administrator.artisan.mores.tieba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/25.
 * 贴吧首页
 */
public class TieBaActivity extends AppCompatActivity {
private ActivityUtils activityUtils;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie_ba);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar()!=null){
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

    @OnClick({R.id.my_mores_tieba_fh, R.id.tieba_fatie,R.id.tiezi_layout_1,R.id.tiezi_layout_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tiezi_layout_1:
                activityUtils.startActivity(TieZiXiangQingActivity.class);
                break;
            case R.id.tiezi_layout_2:
                activityUtils.startActivity(TieZiXiangQingActivity.class);
                break;
            case R.id.my_mores_tieba_fh:
                finish();
                break;
            case R.id.tieba_fatie:
                activityUtils.startActivity(FaTieZiActivity.class);
                break;
        }
    }
}
