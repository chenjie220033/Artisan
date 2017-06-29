package com.example.administrator.artisan.nongjiale;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.robshop.PullToZoomScrollViewEx;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/10.
 */

public class JiangHuActivity extends AppCompatActivity {
    private Activity basecontext;
    @BindView(R.id.scroll_views)
    PullToZoomScrollViewEx scrollView;
    private List<String> titles = new ArrayList<String>();
    private List<Fragment> fragmentlist = new ArrayList<Fragment>();
    private FragmentManager fragmentManager;
    private JiangHuYYXZFragment jiangHuYYXZFragment;
    private JiangHuSJXQFragment jiangHuSJXQFragment;
    private JiangHuPingFragment jiangHuPingFragment;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    private Fragment fragment;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nongjiale_jianghu);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        basecontext = this;

        initView();
    }

    private void initView() {
        View zoomView = LayoutInflater.from(basecontext).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(basecontext).inflate(R.layout.nongjiale_jiujia, null, false);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
        fragment = getSupportFragmentManager().findFragmentById(R.id.nongjiale_jiujia_fraament);
        if (fragment == null) {
            fragment = JiangHuYYXZFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.nongjiale_jiujia_fraament, jiangHuYYXZFragment.newInstance()).commit();
        }
        RadioGroup radioGroup = (RadioGroup) scrollView.getPullRootView().findViewById(R.id.nongjiale_radiogroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.nongjiale_yyxz: {
                        fragment = JiangHuYYXZFragment.newInstance();
                    }
                    break;
                    case R.id.nongjiale_sjxq: {
                        fragment = JiangHuSJXQFragment.newInstance();
                    }
                    break;
                    case R.id.nongjiale_ping: {
                        fragment = JiangHuPingFragment.newInstance();
                    }
                    break;

                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nongjiale_jiujia_fraament, fragment).commit();
                }
            }
        });

    }

    @OnClick(R.id.nongjiale_fh)
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
