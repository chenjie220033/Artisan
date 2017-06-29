package com.example.administrator.artisan.mys.myyouhuoquan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.FragmentDaiFu;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/20.
 *
 * 我的   我的优惠券   全部
 */
public class MyYouHuiQBFragment extends Fragment{

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_jifen_quanbu, null);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    public static MyYouHuiQBFragment newInstance() {
        return new MyYouHuiQBFragment();
    }
}
