package com.example.administrator.artisan.mys.myqg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;

/**
 * Created by chen on 2017/5/15.
 * 点餐  已完成
 */

public class FragmentComplete extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complete, null);

        return view;
    }

    public static FragmentComplete newInstance() {
        return new FragmentComplete();
    }

}
