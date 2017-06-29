package com.example.administrator.artisan.mys.myyhxx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.myyhxx.pupwindows.RxDialogWheelYearMonthDay;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 * 我的   账户信息   我的基本设置
 * */
public class MyJiBenSheZhiActivity extends AppCompatActivity {
    @BindView(R.id.my_zhanghu_jbsz_n)
    TextView my_zhanghu_jbsz_n;
    private RxDialogWheelYearMonthDay mRxDialogWheelYearMonthDay;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ji_ben_she_zhi);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //默认不弹出小键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void initWheelYearMonthDayDialog() {
        // ------------------------------------------------------------------选择日期开始
        mRxDialogWheelYearMonthDay = new RxDialogWheelYearMonthDay(this, 1950, 2027);
        mRxDialogWheelYearMonthDay.getTv_sure().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (mRxDialogWheelYearMonthDay.getCheckBox_day().isChecked()) {
                            my_zhanghu_jbsz_n.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "年"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "月"
                                            + mRxDialogWheelYearMonthDay.getSelectorDay() + "日");
                        } else {
                            my_zhanghu_jbsz_n.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "年"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "月");
                        }
                        mRxDialogWheelYearMonthDay.cancel();
                    }
                });
        mRxDialogWheelYearMonthDay.getTv_cancle().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        mRxDialogWheelYearMonthDay.cancel();
                    }
                });
        // ------------------------------------------------------------------选择日期结束
    }


    @OnClick({R.id.my_zhanghu_jbsz_n, R.id.activity_my_ji_ben_she_zhi,R.id.my_yonghu_jbsz_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_zhanghu_jbsz_n:
                if (mRxDialogWheelYearMonthDay == null) {
                        initWheelYearMonthDayDialog();
                }
                mRxDialogWheelYearMonthDay.show();
                break;
            case R.id.activity_my_ji_ben_she_zhi:
                break;
            case R.id.my_yonghu_jbsz_fh:
                finish();
                break;
        }
    }
}
