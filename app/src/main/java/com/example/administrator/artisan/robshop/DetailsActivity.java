package com.example.administrator.artisan.robshop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;
import com.example.administrator.artisan.zhifu.ZhiFuActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.view2;
import static com.example.administrator.artisan.R.id.view3;

/**
 * Created by chen on 2017/5/11.
 *
 * 农家乐  抢购详情
 */

public class DetailsActivity extends AppCompatActivity {
    private Activity basecontext;
    @BindView(R.id.scroll_view)
    PullToZoomScrollViewEx scrollView;
    private ActivityUtils activityUtils;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        bind = ButterKnife.bind(this);
         activityUtils= new ActivityUtils(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        basecontext = this;
        View headview = LayoutInflater.from(basecontext).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(basecontext).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(basecontext).inflate(R.layout.profile_content_view, null, false);
        scrollView.setHeaderView(headview);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
        TextView textView = (TextView) scrollView.getPullRootView().findViewById(R.id.details_yuanjia);
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Button button = (Button) scrollView.getPullRootView().findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this, ZhiFuActivity.class));
            }
        });
        RatingBarView ratingBarView = (RatingBarView) scrollView.getPullRootView().findViewById(R.id.starView);
        //设置星星可以点击来变化星值
        ratingBarView.setmClickable(true);
        //设置选中的值
        ratingBarView.setStar(3);
        //监听ratingBarView的变化
        ratingBarView.setOnRatingListener(new RatingBarView.OnRatingListener() {
            @Override
            public void onRating(Object bindObject, int RatingScore) {
                if (RatingScore>0&&RatingScore<3){
                    Toast.makeText(basecontext, "差评"+RatingScore+"分", Toast.LENGTH_SHORT).show();
                }else if (RatingScore>=3&&RatingScore<=5){
                    Toast.makeText(basecontext, "好评"+RatingScore+"分", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @OnClick({R.id.qianggou_fh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qianggou_fh:
                finish();
                break;
//            case R.id.qianggou_daozheli:
//                activityUtils.startActivity(LocationDemo.class);
//                break;


        }
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
