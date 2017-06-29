package com.example.administrator.artisan.mys.wdjf.wojf;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.myqg.TitleDownAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 * 我的  我的积分商城
 * */
public class MyJiFenActivity extends AppCompatActivity {

    private Unbinder bind;
    @BindView(R.id.id_jifenshangchenglayout)
    TabLayout id_jifenshangchenglayout;
    @BindView(R.id.id_jifenviewpager)
    ViewPager id_jifenviewpager;
    private FragmentManager fragmentManager;
    private MyReMenJiFenFragment myReMenJiFenFragment;
    private MyTuiJianJiFenFragment myTuiJianJiFenFragment;
    private MyQuanBuJiFenFragment myQuanBuJiFenFragment;
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ji_fen);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mTitles.add("热门");
        mTitles.add("推荐");
        mTitles.add("全部");

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        myReMenJiFenFragment = MyReMenJiFenFragment.newInstance();
        myTuiJianJiFenFragment = MyTuiJianJiFenFragment.newInstance();
        myQuanBuJiFenFragment = MyQuanBuJiFenFragment.newInstance();
        fragmentsList.add(myReMenJiFenFragment);
        fragmentsList.add(myTuiJianJiFenFragment);
        fragmentsList.add(myQuanBuJiFenFragment);

        TitleDownAdapter myPagerAdapter = new TitleDownAdapter(getSupportFragmentManager(), fragmentsList, mTitles);
        id_jifenshangchenglayout.setSelected(true);
        id_jifenshangchenglayout.setTabsFromPagerAdapter(myPagerAdapter);
        id_jifenviewpager.setAdapter(myPagerAdapter);
        id_jifenshangchenglayout.setupWithViewPager(id_jifenviewpager);


        id_jifenshangchenglayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                id_jifenviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_jifenshangcheng_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_jifenshangcheng_fh:
                finish();
                break;
        }
    }
}
