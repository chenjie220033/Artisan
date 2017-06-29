package com.example.administrator.artisan.mores.tieba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/25.
 * 贴吧 发帖子
 */
public class FaTieZiActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_tie_zi);
        bind = ButterKnife.bind(this);
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

    @OnClick(R.id.my_mores_tieba_ftz_fh)
    public void onViewClicked() {
        finish();
    }
}
