package com.example.administrator.artisan.mys.myqg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;

/**
 * Created by chen on 2017/6/21.
 * 我的   抢购已付款
 */

public class MyQGouFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_qgou1_fragment,null);
        return view;
    }

    public static MyQGouFragment1 newInstance() {
        return new MyQGouFragment1();
    }
}
