package com.example.administrator.artisan.mys.myyouhuoquan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.myqg.TitleDownAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 *
 * 我的   我的优惠券
 * */
public class MyYHQActivity extends AppCompatActivity {
    private Unbinder bind;
    @BindView(R.id.id_youhuiquanlayout)
    TabLayout id_youhuiquanlayout;
    @BindView(R.id.id_youhuiquanviewpager)
    ViewPager id_youhuiquanviewpager;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private MyYouHuiQBFragment myYouHuiQBFragment;
    private MyYouHuiWSYFragment myYouHuiWSYFragment;
    private MyYouHuiYSYFragment myYouHuiYSYFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_yhq);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mTitles.add("全部");
        mTitles.add("未使用");
        mTitles.add("已使用");

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        myYouHuiQBFragment = MyYouHuiQBFragment.newInstance();
        myYouHuiWSYFragment = MyYouHuiWSYFragment.newInstance();
        myYouHuiYSYFragment = MyYouHuiYSYFragment.newInstance();
        fragmentsList.add(myYouHuiQBFragment);
        fragmentsList.add(myYouHuiWSYFragment);
        fragmentsList.add(myYouHuiYSYFragment);

        TitleDownAdapter myPagerAdapter = new TitleDownAdapter(getSupportFragmentManager(), fragmentsList, mTitles);
        id_youhuiquanlayout.setSelected(true);
        id_youhuiquanlayout.setTabsFromPagerAdapter(myPagerAdapter);
        id_youhuiquanviewpager.setAdapter(myPagerAdapter);
        id_youhuiquanlayout.setupWithViewPager(id_youhuiquanviewpager);


        id_youhuiquanlayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                id_youhuiquanviewpager.setCurrentItem(tab.getPosition());
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

    @OnClick(R.id.my_youhuiquan_fh)
    public void onViewClicked() {
        finish();
    }
}
