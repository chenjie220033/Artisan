package com.example.administrator.artisan.mys.myye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;

/**
 * Created by chen on 2017/6/8.
 * 我的  我的余额   代金券充值
 */
public class MyDaiJinChongzhiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_daijin_chongzhi_fragment, null);
        return view;
    }

    public static MyDaiJinChongzhiFragment newInstance() {
        return new MyDaiJinChongzhiFragment();
    }
}