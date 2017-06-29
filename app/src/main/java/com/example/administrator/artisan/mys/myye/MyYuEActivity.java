package com.example.administrator.artisan.mys.myye;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.myqg.TitleDownAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/8.
 * 我的余额
 */

public class MyYuEActivity extends AppCompatActivity {

    @BindView(R.id.my_yu_e_layout)
    TabLayout myYuELayout;
    @BindView(R.id.my_yu_e_viewpager)
    ViewPager myYuEViewpager;
    private List<String> titles = new ArrayList<String>();
    private List<Fragment> fragmentlist = new ArrayList<Fragment>();
    private FragmentManager fragmentManager;
    private MyYuEChongzhiFragment myYuEChongzhiFragment;
    private MyDaiJinChongzhiFragment myDaiJinChongzhiFragment;
    private MyJinKuaiChongzhiFragment myJinKuaiChongzhiFragment;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_yue);
        bind = ButterKnife.bind(this);
        //默认不弹出小键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();

    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void initView() {
        titles.add("余额充值");
        titles.add("代金券充值");
        titles.add("金块充值");

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        myYuEChongzhiFragment = MyYuEChongzhiFragment.newInstance();
        myDaiJinChongzhiFragment = MyDaiJinChongzhiFragment.newInstance();
        myJinKuaiChongzhiFragment = MyJinKuaiChongzhiFragment.newInstance();

        fragmentlist.add(myYuEChongzhiFragment);
        fragmentlist.add(myDaiJinChongzhiFragment);
        fragmentlist.add(myJinKuaiChongzhiFragment);

        TitleDownAdapter myPagerAdapter = new TitleDownAdapter(getSupportFragmentManager(), fragmentlist, titles);
        myYuELayout.setSelected(true);
        myYuELayout.setTabsFromPagerAdapter(myPagerAdapter);
        myYuEViewpager.setAdapter(myPagerAdapter);
        myYuELayout.setupWithViewPager(myYuEViewpager);

        myYuELayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myYuEViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick({R.id.my_yuechongzhi_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_yuechongzhi_fh:
                finish();
                break;

        }
    }
}
