package com.example.administrator.artisan.mys.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;

/**
 * Created by chen on 2017/6/6.
 * 购物  已付款
 */
public class FragmentYiFu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yifu, null);

        return view;
    }
    public static FragmentYiFu newInstance() {
        return new FragmentYiFu();
    }
}
