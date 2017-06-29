package com.example.administrator.artisan.mores.tieba.jiazheng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class JiaZhengActivity extends AppCompatActivity {

    private ActivityUtils activityUtils;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jia_zheng);
        bind = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);

        if (getSupportActionBar() != null) {
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

    @OnClick({R.id.my_mores_jiazhengfuwu_fh, R.id.hk_caboli})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_mores_jiazhengfuwu_fh:
                finish();
                break;
            case R.id.hk_caboli:
                break;
        }
    }
}
