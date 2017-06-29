package com.example.administrator.artisan.Homes.dingzuo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.mydz.MyZaiXianDingZuoActivity;
import com.example.administrator.artisan.robshop.PullToZoomScrollViewEx;
import com.example.administrator.artisan.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.include;
import static com.example.administrator.artisan.R.id.view;
/***
 * Created by chen on 2017/6/14.
 * 订座详情
 */

public class HomeDingZuoXQActivity extends AppCompatActivity {
    private Activity basecontext;
    private Unbinder bind;
    private ActivityUtils activityUtils;
    @BindView(R.id.home_dingzuo_xq_gridview)
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ding_zuo_xq);
        bind = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        basecontext = this;
        initView();
    }

    private void initView() {
        List list = new ArrayList();
        for (int i = 1; i < 9; i++) {
            list.add("红烧肉");
        }
        gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.home_dingzuo_xq_fh,R.id.home_youhui_xiangqing,R.id.home_dingzuo_zaixiandingzuo
             ,R.id.home_dingzuoxq_ckqbpt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_dingzuoxq_ckqbpt:
                activityUtils.startActivity(ShangJiaDianPingActivity.class);
                break;
            case R.id.home_dingzuo_zaixiandingzuo:
                activityUtils.startActivity(MyZaiXianDingZuoActivity.class);
                break;
            case R.id.home_youhui_xiangqing:
                activityUtils.startActivity(HomeYouHuiLBActivity.class);
//                activityUtils.startActivity(HomeYouHuiXQActivity.class);
                break;
            case R.id.home_dingzuo_xq_fh:
                finish();
                break;
        }
    }
}
