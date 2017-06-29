package com.example.administrator.artisan.mys.myye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.zhifu.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/8.
 * 我的  我的余额   金块充值
 */
public class MyJinKuaiChongzhiFragment extends Fragment {
    @BindView(R.id.smoothCheckBox1)
    SmoothCheckBox smoothCheckBox1;
    @BindView(R.id.smoothCheckBox2)
    SmoothCheckBox smoothCheckBox2;
    @BindView(R.id.smoothCheckBox3)
    SmoothCheckBox smoothCheckBox3;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_jinkuai_chongzhi_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public static MyJinKuaiChongzhiFragment newInstance() {
        return new MyJinKuaiChongzhiFragment();
    }

    @Override
    public void onDestroyView() {
        if (this.unbinder!=null){
            this.unbinder.unbind();
        }
        super.onDestroyView();
    }

    @OnClick({R.id.my_jinkuai_zhifubao, R.id.my_jinkuai_weixin, R.id.my_jinkuai_yue, R.id.my_daijinquan_ljcz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_jinkuai_zhifubao:
                smoothCheckBox2.setChecked(false);
                smoothCheckBox2.setVisibility(View.GONE);
                smoothCheckBox3.setChecked(false);
                smoothCheckBox3.setVisibility(View.GONE);
                if (smoothCheckBox1.isChecked()){
                    smoothCheckBox1.setChecked(false);
                    smoothCheckBox1.setVisibility(View.GONE);
                } else {
                    smoothCheckBox1.setChecked(true);
                    smoothCheckBox1.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.my_jinkuai_weixin:
                smoothCheckBox1.setChecked(false);
                smoothCheckBox1.setVisibility(View.GONE);
                smoothCheckBox3.setChecked(false);
                smoothCheckBox3.setVisibility(View.GONE);
                if (smoothCheckBox2.isChecked()){
                    smoothCheckBox2.setChecked(false);
                    smoothCheckBox2.setVisibility(View.GONE);
                } else {
                    smoothCheckBox2.setChecked(true);
                    smoothCheckBox2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.my_jinkuai_yue:
                smoothCheckBox2.setChecked(false);
                smoothCheckBox2.setVisibility(View.GONE);
                smoothCheckBox1.setChecked(false);
                smoothCheckBox1.setVisibility(View.GONE);
                if (smoothCheckBox3.isChecked()){
                    smoothCheckBox3.setChecked(false);
                    smoothCheckBox3.setVisibility(View.GONE);
                } else {
                    smoothCheckBox3.setChecked(true);
                    smoothCheckBox3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.my_daijinquan_ljcz:
                if (smoothCheckBox1.isChecked()==true){
                    Toast.makeText(getContext(), "使用支付宝支付", Toast.LENGTH_SHORT).show();
                }else if (smoothCheckBox2.isChecked()==true){
                    Toast.makeText(getContext(), "使用微信支付", Toast.LENGTH_SHORT).show();
                } else if (smoothCheckBox3.isChecked() == true) {
                    Toast.makeText(getContext(), "使用余额支付", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}