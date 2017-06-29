package com.example.administrator.artisan.mys.myjiudian;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/7.
 * 我的    酒店预约
 */
public class MyJiuDianYuYueActivity extends Activity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jiudianyuyue);
        bind = ButterKnife.bind(this);
    }

    @OnClick(R.id.my_jiudianyuyue_fh)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }
}

