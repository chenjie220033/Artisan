package com.example.administrator.artisan.mys.mydz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;

/**
 * Created by chen on 2017/6/17.
 * 订座订单  已消费
 */
public class MyDZYXFFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dzyxf_fragment,null);
        return view;
    }

    public static MyDZYXFFragment newInstance() {
        return new MyDZYXFFragment();
    }
}
