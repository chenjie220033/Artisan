package com.example.administrator.artisan.mys.myqg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.wodohuodong.MyHDWFBDActivity;

/**
 * Created by chen on 2017/6/21.
 * 我的   抢购待付款
 */

public class MyQGouFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_qgou_fragment,null);
        return view;
    }

    public static MyQGouFragment newInstance() {
        return new MyQGouFragment();
    }
}
