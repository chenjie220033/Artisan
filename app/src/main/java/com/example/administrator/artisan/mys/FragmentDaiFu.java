package com.example.administrator.artisan.mys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.mydc.DingWeiYiXiaoFeiActivity;
import com.example.administrator.artisan.robshop.DetailsActivity;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/5/15.
 */

public class FragmentDaiFu extends Fragment {
    private ActivityUtils activityUtils;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daifu, null);
        bind = ButterKnife.bind(this, view);
        activityUtils=new ActivityUtils(this);
        return view;
    }

    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    public static FragmentDaiFu newInstance() {
        return new FragmentDaiFu();
    }

    @OnClick({R.id.qianggou_daifu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qianggou_daifu:
                activityUtils.startActivity(DetailsActivity.class);
                break;
        }
    }
}
