package com.example.administrator.artisan;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.artisan.mores.tieba.TieBaActivity;
import com.example.administrator.artisan.mores.tieba.gouwu.GouWuActivity;
import com.example.administrator.artisan.mores.tieba.huodong.HuoDongActivity;
import com.example.administrator.artisan.mores.tieba.jiazheng.JiaZhengActivity;
import com.example.administrator.artisan.mores.tieba.jiudian.JiuDianActivity;
import com.example.administrator.artisan.mores.tieba.shangjiafuwu.SJFWActivity;
import com.example.administrator.artisan.mys.myyouhuoquan.MyYHQActivity;
import com.example.administrator.artisan.mys.wdjf.wojf.MyJiFenActivity;
import com.example.administrator.artisan.nongjiale.NongJiaLeActivity;
import com.example.administrator.artisan.utils.ActivityUtils;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/5.
 */
public class MoreFrame extends Fragment {
    private Unbinder unbinder;
    private ActivityUtils activityUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_frame, null);
        unbinder = ButterKnife.bind(this, view);
        activityUtils = new ActivityUtils(this);
        return view;
    }

    public static MoreFrame newInstance() {
        return new MoreFrame();
    }


    @OnClick({R.id.my_more_fh, R.id.more_shangjia, R.id.more_nongjiale, R.id.more_tieba,
            R.id.more_jifen, R.id.more_youhui, R.id.more_gouwu, R.id.more_jiudian,
            R.id.more_qianggou, R.id.more_jiazheng, R.id.more_dingzuo, R.id.more_huodong, R.id.more_shenghuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_more_fh:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.more_shangjia:
                activityUtils.startActivity(SJFWActivity.class);
                break;
            case R.id.more_nongjiale:
                activityUtils.startActivity(NongJiaLeActivity.class);
                break;
            case R.id.more_tieba:
                activityUtils.startActivity(TieBaActivity.class);
                break;
            case R.id.more_jifen:
                activityUtils.startActivity(MyJiFenActivity.class);
                break;
            case R.id.more_youhui:
                activityUtils.startActivity(MyYHQActivity.class);
                break;
            case R.id.more_gouwu:
                activityUtils.startActivity(GouWuActivity.class);
                break;
            case R.id.more_jiudian:
                activityUtils.startActivity(JiuDianActivity.class);
                break;
            case R.id.more_qianggou:
                break;
            case R.id.more_jiazheng:
                activityUtils.startActivity(JiaZhengActivity.class);
                break;
            case R.id.more_dingzuo:
                break;
            case R.id.more_huodong:
                activityUtils.startActivity(HuoDongActivity.class);
                break;
            case R.id.more_shenghuo:
                break;
        }
    }

    @Override
    public void onDestroy() {
        if (this.unbinder != null) {
            this.unbinder.unbind();
        }
        super.onDestroy();

    }

}