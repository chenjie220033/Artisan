package com.example.administrator.artisan.nongjiale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;

/**
 * Created by Administrator on 2017/6/12.
 */
public class JiangHuPingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.jianghu_ping_fragment,null);
        return view;
    }

    public static JiangHuPingFragment newInstance() {
        return new JiangHuPingFragment();
    }
}
