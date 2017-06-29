package com.example.administrator.artisan.mys.wodohuodong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.mydz.MyDZYTKFragment;

/**
 * Created by chen on 2017/6/20.
 * 我的  我的活动  我发布的
 */

public class MyHDWFBDActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_hd_wfbd_fragment,null);
        return view;
    }

    public static MyHDWFBDActivity newInstance() {
        return new MyHDWFBDActivity();
    }
}
