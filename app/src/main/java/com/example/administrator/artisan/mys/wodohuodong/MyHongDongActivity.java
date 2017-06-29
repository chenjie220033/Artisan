package com.example.administrator.artisan.mys.wodohuodong;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.mydz.MyDZDFKFragment;
import com.example.administrator.artisan.mys.mydz.MyDZYFKFragment;
import com.example.administrator.artisan.mys.mydz.MyDZYTKFragment;
import com.example.administrator.artisan.mys.mydz.MyDZYXFFragment;
import com.example.administrator.artisan.nongjiale.JiangHuYYXZFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 *
 * 我的  我的活动
 * */
public class MyHongDongActivity extends AppCompatActivity {
    private Unbinder bind;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hong_dong);
        bind = ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        fragment = getSupportFragmentManager().findFragmentById(R.id.my_wdhd_frame);
        if (fragment == null) {
            fragment = MyHDWFBDActivity.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.my_wdhd_frame, MyHDWFBDActivity.newInstance()).commit();
        }
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.my_wdhd_radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.my_wdhd_wfbd: {
                        fragment = MyHDWFBDActivity.newInstance();
                    }
                    break;
                    case R.id.my_wdhd_wcjd: {
                        fragment = MyHDWCJDAcativity.newInstance();
                    }
                }
                if(fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_wdhd_frame, fragment).commit();
                }
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

    @OnClick(R.id.my_huodong_fh)
    public void onViewClicked() {
        finish();
    }
}
