package com.example.administrator.artisan.mys.mydc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/8.
 * 订单详情
 */

public class DingWeiYiXiaoFeiActivity extends AppCompatActivity {
    private Unbinder bind;
    //    @BindView(R.id.flowview_1_1)
//    TextView flowview11;
//    @BindView(R.id.flowview_1_2)
//    TextView flowview12;
//    @BindView(R.id.flowview_2_1)
//    TextView flowview21;
//    @BindView(R.id.flowview_2_2)
//    TextView flowview22;
//    @BindView(R.id.jindutiao)
//    FlowView flowView;
//    @BindView(R.id.button_jia)
//    Button button_jia;
//    @BindView(R.id.button_jian)
//    Button button_jian;
//    private List list = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dingzuo_yxf);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
//        initView();
    }
//    private void initView() {
///**
// *    FlowView进度条
// * */
////        list.add("提交成功 05-10 09:22");
////        list.add("订单完成 05-10 09:23");
////        flowView.setLabels(list);
//
//        button_jia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flowView.getmDoneNums() < 2) {
//                    flowView.setmDoneNums(flowView.getmDoneNums() + 1);
//                }
//            }
//        });
//        button_jian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flowView.getmDoneNums() > 0) {
//                    flowView.setmDoneNums(flowView.getmDoneNums() - 1);
//                }
//            }
//        });
//
//    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
