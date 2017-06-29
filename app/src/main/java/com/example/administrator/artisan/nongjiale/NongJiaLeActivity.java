package com.example.administrator.artisan.nongjiale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.banners.BannerAdapter;
import com.example.administrator.artisan.banners.BannerLayout;
import com.example.administrator.artisan.banners.LocalBanner;
import com.example.administrator.artisan.utils.ActivityUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/10.
 */

public class NongJiaLeActivity extends AppCompatActivity {
    @BindView(R.id.layout_banner)
    BannerLayout layoutBanner;
    private ActivityUtils activityUtils;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nongjiale);
        unbinder = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initBanner();
    }

    // 轮播图
    private void initBanner() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {
            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(NongJiaLeActivity.this).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        layoutBanner.setAdapter(bannerAdapter);

        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        bannerAdapter.reset(localBanners);

    }

    @Override
    protected void onDestroy() {
        if (this.unbinder != null) {
            this.unbinder.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.layout_huiyi, R.id.layout_caizhai, R.id.layout_chuidiao,
            R.id.layout_shaokao, R.id.layout_dengshan, R.id.layout_wenquan,
            R.id.layout_shanghua, R.id.layout_gengduo, R.id.nongjiale_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nongjiale_fh:
                finish();
                break;
            case R.id.layout_huiyi:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_caizhai:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_chuidiao:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_shaokao:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_dengshan:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_wenquan:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_shanghua:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
            case R.id.layout_gengduo:
                activityUtils.startActivity(JiangHuActivity.class);
                break;
        }
    }
}
