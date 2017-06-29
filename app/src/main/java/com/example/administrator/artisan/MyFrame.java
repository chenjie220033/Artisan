package com.example.administrator.artisan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.artisan.mys.MyQiangGouActivity;
import com.example.administrator.artisan.mys.mydc.MyDingCanActivity;
import com.example.administrator.artisan.mys.mydz.MyDingZuoActivity;
import com.example.administrator.artisan.mys.mydz.diancai.MyDingZuoDianCaiActivity;
import com.example.administrator.artisan.mys.myjiudian.MyJiuDianYuYueActivity;
import com.example.administrator.artisan.mys.myshenghuo.MyShenghuoActivity;
import com.example.administrator.artisan.mys.myye.MyYuEActivity;
import com.example.administrator.artisan.mys.myyhxx.MyZhangHuXXActivity;
import com.example.administrator.artisan.mys.myyouhuoquan.MyYHQActivity;
import com.example.administrator.artisan.mys.qmjjr.QuanMinJJRActivity;
import com.example.administrator.artisan.mys.shop.MyShop;
import com.example.administrator.artisan.mys.wdjf.MyIntegralActivity;
import com.example.administrator.artisan.mys.wdjf.wojf.MyJiFenActivity;
import com.example.administrator.artisan.mys.wdxiaoxi.MyXiaoXiActivity;
import com.example.administrator.artisan.mys.wodohuodong.MyHongDongActivity;
import com.example.administrator.artisan.nongjiale.NongJiaLeActivity;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.R.attr.id;
import static android.R.attr.longClickable;

/**
 * Created by Administrator on 2017/6/5.
 */

public class MyFrame extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.my_black_text)
    TextView myBlackText;
    private ActivityUtils activityUtils;
    MainActivity activity = (MainActivity) getActivity();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_frame, null);
        unbinder = ButterKnife.bind(this, view);
        activityUtils = new ActivityUtils(this);
        myBlackText.setAlpha(0.3f);
        return view;
    }

    @Override
    public void onDestroy() {
        if (this.unbinder!=null){
        this.unbinder.unbind();
        }
        super.onDestroy();
    }

    public static MyFrame newInstance() {
        return new MyFrame();
    }


    @OnClick({R.id.my_wdqg_layout, R.id.my_wdgw_layout, R.id.my_wdhd_layout,
            R.id.my_wddz_layout, R.id.my_wdqd_layout, R.id.my_wdjdyy_layout,
            R.id.my_layout_jifenduihuan, R.id.my_wdye_yue_text,R.id.my_wdye_jifen_text,
            R.id.my_layout_quanminjinjiren,R.id.my_yhmd_layout,R.id.my_relative_dl,
            R.id.my_wdyhj_layout,R.id.my_wdshxx_layout,R.id.my_wdsc_layout,R.id.my_chongzhi_layout
            ,R.id.my_xiaoxizhongxin_layout,R.id.my_xiaoxi_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_xiaoxi_layout:
                activityUtils.startActivity(MyXiaoXiActivity.class);
                break;
            case R.id.my_xiaoxizhongxin_layout:
                activityUtils.startActivity(MyXiaoXiActivity.class);
                break;
            case R.id.my_chongzhi_layout:
                activityUtils.startActivity(MyYuEActivity.class);
                break;
            case R.id.my_wdsc_layout:
//                FragmentManager fm = getActivity().getSupportFragmentManager();
//                fm.beginTransaction().replace(R.id.main_framelayout,new ShopingFrame())
//                        .addToBackStack(null).commit();
                break;
            case R.id.my_wdshxx_layout:
                activityUtils.startActivity(MyShenghuoActivity.class);
                break;
            case R.id.my_wdyhj_layout:
                activityUtils.startActivity(MyYHQActivity.class);
                break;
            case R.id.my_wdye_jifen_text:
                activityUtils.startActivity(MyJiFenActivity.class);
                break;
            case R.id.my_relative_dl:
                  activityUtils.startActivity(MyZhangHuXXActivity.class);
                break;
            case R.id.my_yhmd_layout:
                //没有改
                activityUtils.startActivity(MyDingZuoDianCaiActivity.class);
                break;
            case R.id.my_wdqg_layout:
                activityUtils.startActivity(MyQiangGouActivity.class);
                break;
            case R.id.my_wdgw_layout:
                activityUtils.startActivity(MyShop.class);
                break;
            case R.id.my_wdhd_layout:
                activityUtils.startActivity(MyHongDongActivity.class);
                break;
            case R.id.my_wddz_layout:
                activityUtils.startActivity(MyDingZuoActivity.class);
                break;
            case R.id.my_wdjdyy_layout:
                activityUtils.startActivity(MyJiuDianYuYueActivity.class);
                break;
            case R.id.my_layout_jifenduihuan:
                activityUtils.startActivity(MyIntegralActivity.class);
                break;
            case R.id.my_layout_quanminjinjiren:
                activityUtils.startActivity(QuanMinJJRActivity.class);
                break;
            case R.id.my_wdye_yue_text:
                activityUtils.startActivity(MyYuEActivity.class);
                break;
            case R.id.my_wdqd_layout:
                break;
        }
    }
}
