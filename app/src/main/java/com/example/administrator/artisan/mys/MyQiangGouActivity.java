package com.example.administrator.artisan.mys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.myqg.FragmentComplete;
import com.example.administrator.artisan.mys.myqg.MyQGouFragment;
import com.example.administrator.artisan.mys.myqg.MyQGouFragment1;
import com.example.administrator.artisan.mys.myqg.TitleDownAdapter;
import com.example.administrator.artisan.mys.wodohuodong.MyHDWCJDAcativity;
import com.example.administrator.artisan.mys.wodohuodong.MyHDWFBDActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.R.attr.fragment;

/**
 * Created by chen on 2017/6/6.
 * 我的  我的抢购
 */
public class MyQiangGouActivity extends AppCompatActivity {

    private Fragment fragment;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qiang_gou);
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
        fragment = getSupportFragmentManager().findFragmentById(R.id.my_wdhd_frame);
        if (fragment == null) {
            fragment = MyHDWFBDActivity.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.my_wdhd_frame, MyQGouFragment.newInstance()).commit();
        }
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.my_wdhd_radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.my_wdhd_wfbd: {
                        fragment = MyQGouFragment.newInstance();
                    }
                    break;
                    case R.id.my_wdhd_wcjd: {
                        fragment = MyQGouFragment1.newInstance();
                    }
                }
                if(fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_wdhd_frame, fragment).commit();
                }
            }
        });
    }
    @OnClick({R.id.drawer_wodeshoucang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.drawer_wodeshoucang:
                finish();
                break;

        }
    }
}
