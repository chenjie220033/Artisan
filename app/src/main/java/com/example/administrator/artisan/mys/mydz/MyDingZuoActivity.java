package com.example.administrator.artisan.mys.mydz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.nongjiale.JiangHuPingFragment;
import com.example.administrator.artisan.nongjiale.JiangHuSJXQFragment;
import com.example.administrator.artisan.nongjiale.JiangHuYYXZFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 *  Created by chen on 2017/6/7.
 *  我的   订座订单
 * */
public class MyDingZuoActivity extends AppCompatActivity {

    private Fragment fragment;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ding_zuo);
        bind = ButterKnife.bind(this);
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
        fragment = getSupportFragmentManager().findFragmentById(R.id.my_dzdd_frame);
        if (fragment == null) {
            fragment = MyDZDFKFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.my_dzdd_frame, MyDZDFKFragment.newInstance()).commit();
        }
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.my_dz_radiogroup);
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {

               switch (i) {
                   case R.id.my_dzdd_dfk: {
                       fragment = MyDZDFKFragment.newInstance();
                   }
                   break;
                   case R.id.my_dzdd_yfk: {
                       fragment = MyDZYFKFragment.newInstance();
                   }
                   break;
                   case R.id.my_dzdd_yxf: {
                       fragment = MyDZYXFFragment.newInstance();
                   }
                   break;
                   case R.id.my_dzdd_ytk: {
                       fragment = MyDZYTKFragment.newInstance();
                   }
                   break;
               }
               if(fragment != null){
                   getSupportFragmentManager().beginTransaction().replace(R.id.my_dzdd_frame, fragment).commit();
               }
           }
       });
    }


    @OnClick({R.id.my_ding_zuo_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_ding_zuo_fh:
                finish();
                break;
        }
    }
}
