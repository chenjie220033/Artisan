package com.example.administrator.artisan.mores.tieba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/25.
 * 贴吧  帖子详情
 */
public class TieZiXiangQingActivity extends AppCompatActivity {

    @BindView(R.id.tiezi_xiangqing_huifuneirong)
    LinearLayout tieziXiangqingHuifuneirong;
    @BindView(R.id.tiezi_xiangqing_huifu)
    RelativeLayout tieziXiangqingHuifu;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie_zi_xiang_qing);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        tieziXiangqingHuifu.setClickable(false);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.tieba_xiangqing_fh, R.id.tiezi_xiangqing_huifu, R.id.tiezi_xiangqing_zan})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.tieba_xiangqing_fh:
                finish();
                break;
            case R.id.tiezi_xiangqing_huifu:
                if (tieziXiangqingHuifu.isClickable()==false) {
                    tieziXiangqingHuifu.setClickable(true);
                    tieziXiangqingHuifuneirong.setVisibility(View.VISIBLE);
                }else {
                    tieziXiangqingHuifu.setClickable(false);
                    tieziXiangqingHuifuneirong.setVisibility(View.GONE);
                }
                    break;
            case R.id.tiezi_xiangqing_zan:
                break;
        }
    }
}
