package com.example.administrator.artisan.mys.myjifensc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.artisan.R;
/***
 * chen
 * 我的       积分商城
 */

public class MyJiFenSCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ji_fen_sc);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }
}
