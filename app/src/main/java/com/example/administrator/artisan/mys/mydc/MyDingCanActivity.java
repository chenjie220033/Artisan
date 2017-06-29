package com.example.administrator.artisan.mys.mydc;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.FragmentDaiFu;
import com.example.administrator.artisan.mys.myqg.FragmentComplete;
import com.example.administrator.artisan.mys.myqg.TitleDownAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyDingCanActivity extends AppCompatActivity {

    @BindView(R.id.id_playlayout)
    TabLayout idPlaylayout;
    @BindView(R.id.id_playviewpager)
    ViewPager idPlayviewpager;

    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private FragmentManager fragmentManager;
    private FragmentDaiFu fragmentDaiFu;
    private FragmentJInXing fragmentJInXing;
    private FragmentComplete fragmentComplete;
    private Unbinder bind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ding_can);
        bind = ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void initView() {
        mTitles.add("待付款");
        mTitles.add("进行中");
        mTitles.add("已完成");

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentDaiFu = FragmentDaiFu.newInstance();
        fragmentJInXing = FragmentJInXing.newInstance();
        fragmentComplete = FragmentComplete.newInstance();

        fragmentsList.add(fragmentDaiFu);
        fragmentsList.add(fragmentJInXing);
        fragmentsList.add(fragmentComplete);


        TitleDownAdapter myPagerAdapter = new TitleDownAdapter(getSupportFragmentManager(), fragmentsList, mTitles);
        idPlaylayout.setSelected(true);
        idPlaylayout.setTabsFromPagerAdapter(myPagerAdapter);
        idPlayviewpager.setAdapter(myPagerAdapter);
        idPlaylayout.setupWithViewPager(idPlayviewpager);


        idPlaylayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                idPlayviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick({R.id.drawer_wodedingcan, R.id.id_playlayout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_wodedingcan:
                finish();
                break;
        }
    }

    @OnClick(R.id.my_ding_can_fh)
    public void onViewClicked() {
        finish();
    }
}
