package com.example.administrator.artisan.mys.myshenghuo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/***
 * chen
 *  我的生活信息
 */

public class MyShenghuoActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shenghuo);
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

    @OnClick({R.id.my_shenghuoxx_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_shenghuoxx_fh:
                finish();
                break;
        }
    }
}
