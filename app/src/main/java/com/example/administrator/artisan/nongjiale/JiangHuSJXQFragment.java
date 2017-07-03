package com.example.administrator.artisan.nongjiale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/12.
 */
public class JiangHuSJXQFragment extends Fragment{

    private Unbinder bind;
    @BindView(R.id.jianghu_yyxz_sjjj)
    TextView textshangjiajj;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jianghu_sjxq_fragment,null);
        bind = ButterKnife.bind(this, view);
        textshangjiajj.setText("\u3000\u3000"+"反思反思过巴斯公报私改把四个白色不该苏北盖博怪兽被盖上杯盖刚把uis八嘎随便改搜嘎碎骨白色本该是八嘎虽本该是八嘎随便给");
        return view;
    }

    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    public static JiangHuSJXQFragment newInstance() {
        return new JiangHuSJXQFragment();
    }
}
