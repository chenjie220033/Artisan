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
 * 订座订单   待付款
 */

public class MyDZDFKFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dzdfk_fragment,null);
        return view;
    }

    public static MyDZDFKFragment newInstance() {
        return new MyDZDFKFragment();
    }
}
