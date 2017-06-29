package com.example.administrator.artisan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.artisan.Attentions.AddAttentionActivity;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/5.
 */

public class AttentionFrame extends Fragment {
    private Unbinder unbinder;
    private ActivityUtils activityUtils;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attention_frame, null);
        unbinder = ButterKnife.bind(this, view);
        activityUtils = new ActivityUtils(this);
        return view;
    }

    public static AttentionFrame newInstance() {
        return new AttentionFrame();
    }
    @OnClick({R.id.focus_add, R.id.atten_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.focus_add:
                activityUtils.startActivity(AddAttentionActivity.class);
                break;
            case R.id.atten_sousuo:
                break;
        }
    }

    @Override
    public void onDestroy() {
        if (this.unbinder!=null){
            this.unbinder.unbind();
        }
        super.onDestroy();
    }
}
