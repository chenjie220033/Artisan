package com.example.administrator.artisan.mys.myyhxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.administrator.artisan.R;
/**
 * chen
 * 我的  我的设置   修改头像  已删除
 * */
public class MyXGTXActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_xgtx);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
     TextView textView = (TextView) findViewById(R.id.my_xgtx_beijingyanse);
        textView.setAlpha(0.5f);
    }
}
