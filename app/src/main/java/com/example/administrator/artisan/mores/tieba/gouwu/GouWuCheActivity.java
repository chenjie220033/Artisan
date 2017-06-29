package com.example.administrator.artisan.mores.tieba.gouwu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/21.
 * 购物车
 */
public class GouWuCheActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che);
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

    @OnClick({R.id.my_gouwuche_fh, R.id.gouwuche_jiesuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_gouwuche_fh:
                finish();
                break;
            case R.id.gouwuche_jiesuan:
                Intent intent = new Intent(GouWuCheActivity.this,GouWuCheZhiFuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
