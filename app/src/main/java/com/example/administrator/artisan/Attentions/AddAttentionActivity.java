package com.example.administrator.artisan.Attentions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/8.
 * AddAttention添加关注界面
 */

public class AddAttentionActivity extends AppCompatActivity {


    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atten_add);
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

    @OnClick({R.id.atten_add_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.atten_add_fh:
                finish();
                break;
        }
    }
}
