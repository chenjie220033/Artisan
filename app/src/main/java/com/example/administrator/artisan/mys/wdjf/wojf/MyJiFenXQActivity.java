package com.example.administrator.artisan.mys.wdjf.wojf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyJiFenXQActivity extends AppCompatActivity {

    @BindView(R.id.jifen_xiangqing_gridview)
    MyGridView jifenXiangqingGridview;
    @BindView(R.id.jifenxiangqing_beijingse)
    TextView jifenxiangqingBeijingse;
    private Unbinder bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ji_fen_xq);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        jifenxiangqingBeijingse.setAlpha(0.6f);
        initGridView();
    }

    private void initGridView() {
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            list1.add("美的赛克斯");
        }
        JiFenXQAdapter jiFenXQAdapter = new JiFenXQAdapter(this, list1);
        jifenXiangqingGridview.setAdapter(jiFenXQAdapter);
        jifenXiangqingGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MyJiFenXQActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_jifen_xiangqing_fh, R.id.jifen_btn_lijiduihuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_jifen_xiangqing_fh:
                finish();
                break;
            case R.id.jifen_btn_lijiduihuan:
                Intent intent = new Intent(getApplicationContext(),JiFenDuiHuanActivity.class);
                startActivity(intent);
                break;
        }
    }
}
