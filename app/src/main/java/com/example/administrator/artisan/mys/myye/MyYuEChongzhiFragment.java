package com.example.administrator.artisan.mys.myye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.zhifu.SmoothCheckBox;
import com.example.administrator.artisan.zhifu.ZhiFu2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/8.
 * 我的  我的余额   余额充值
 */
public class MyYuEChongzhiFragment extends Fragment {
    @BindView(R.id.smoothCheckBox1)
    SmoothCheckBox smoothCheckBox1;
    @BindView(R.id.smoothCheckBox2)
    SmoothCheckBox smoothCheckBox2;
    @BindView(R.id.my_chongzhi_hint)
    TextView my_chongzhi_hint;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_yue_chongzhi_fragment, null);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    public static MyYuEChongzhiFragment newInstance() {
        return new MyYuEChongzhiFragment();
    }

    @Override
    public void onDestroyView() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroyView();
    }

    @OnClick({R.id.my_yue_zhifubao, R.id.my_yue_weixin,R.id.my_yue_ljcz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_yue_zhifubao:
                smoothCheckBox2.setChecked(false);
                smoothCheckBox2.setVisibility(View.GONE);
                if (smoothCheckBox1.isChecked()) {
                    smoothCheckBox1.setChecked(false);
                    smoothCheckBox1.setVisibility(View.GONE);
                } else {
                    smoothCheckBox1.setChecked(true);
                    smoothCheckBox1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.my_yue_weixin:
                smoothCheckBox1.setChecked(false);
                smoothCheckBox1.setVisibility(View.GONE);
                if (smoothCheckBox2.isChecked()){
                    smoothCheckBox2.setChecked(false);
                    smoothCheckBox2.setVisibility(View.GONE);
                }else {
                    smoothCheckBox2.setChecked(true);
                    smoothCheckBox2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.my_yue_ljcz:
                if (smoothCheckBox1.isChecked()==true){
                    Toast.makeText(getContext(), "使用支付宝支付", Toast.LENGTH_SHORT).show();
                }else if (smoothCheckBox2.isChecked()==true){
                    Toast.makeText(getContext(), "使用微信支付", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
