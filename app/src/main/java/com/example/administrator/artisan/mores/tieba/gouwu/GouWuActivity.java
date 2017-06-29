package com.example.administrator.artisan.mores.tieba.gouwu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/***
 * Created by chen on 2017/6/21.
 * home购物
 */
public class GouWuActivity extends AppCompatActivity {

    @BindView(R.id.gridView1)
    GridView gridView1;
    @BindView(R.id.gridView2)
    GridView gridView2;
    @BindView(R.id.gouwu_list)
    ListView listView;
    private Unbinder bind;
    private ActivityUtils activityUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        activityUtils = new ActivityUtils(this);
        initGridView();
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void initGridView() {
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            list1.add("美的赛克斯");
        }
        GouWuAdapter1 gouwuadapter1 = new GouWuAdapter1(this, list1);
        gridView1.setAdapter(gouwuadapter1);
        gridView2.setAdapter(gouwuadapter1);

        List<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list2.add("西门子冰箱");
        }
        GouWuAdapter2 gouwuadapter2 = new GouWuAdapter2(this, list2);
        listView.setAdapter(gouwuadapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                activityUtils.startActivity(GouWuXiangQingActivity.class);
            }
        });
    }

    @OnClick({R.id.home_gouwu_gengduo1, R.id.home_gouwu_gengduo2, R.id.home_gouwu_gengduo3,
            R.id.my_gouwu_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_gouwu_fh:
                finish();
                break;
            case R.id.home_gouwu_gengduo1:
                activityUtils.startActivity(HomeShangPinActivity.class);
                break;
            case R.id.home_gouwu_gengduo2:
                activityUtils.startActivity(HomeShangPinActivity.class);
                break;
            case R.id.home_gouwu_gengduo3:
                activityUtils.startActivity(HomeShangPinActivity.class);
                break;
        }
    }
}
