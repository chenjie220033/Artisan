package com.example.administrator.artisan.mys.mydz;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mys.myyhxx.MyZhangHuXXActivity;
import com.example.administrator.artisan.mys.myyhxx.pupwindows.RxDialogWheelYearMonthDay;
import com.example.administrator.artisan.zhifu.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.my_zhanghu_jbsz_n;

/**
 * Created by chen on 2017/6/9.
 * 在线订座
 */

public class MyZaiXianDingZuoActivity extends AppCompatActivity {
    @BindView(R.id.checkBox_nan)
    SmoothCheckBox checkBoxNan;
    @BindView(R.id.checkBox_nv)
    SmoothCheckBox checkBoxNv;
    @BindView(R.id.my_zaixian_dz_dbj)
    TextView myZaixianDzDbj;
    @BindView(R.id.checkBox_dbj)
    SmoothCheckBox checkBoxDbj;
    @BindView(R.id.my_zaixian_dz_ddt)
    TextView myZaixianDzDdt;
    @BindView(R.id.checkBox_ddt)
    SmoothCheckBox checkBoxDdt;
    @BindView(R.id.home_zaixiandingzuo_renshu)
    EditText editTextrenshu;
    @BindView(R.id.home_zaixiandingzuo_shijian)
    EditText editTextshijian;
    private Unbinder bind;
    private RxDialogWheelYearMonthDay mRxDialogWheelYearMonthDay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_zaixian_dingzuo);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //点击不弹出键盘
        editTextshijian.setInputType(InputType.TYPE_NULL);
        editTextrenshu.setInputType(InputType.TYPE_NULL);
        //默认不弹出小键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
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
                            editTextshijian.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "年"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "月"
                                            + mRxDialogWheelYearMonthDay.getSelectorDay() + "日");
                        } else {
                            editTextshijian.setText(
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


    @OnClick({R.id.my_zaixian_dz_ddt, R.id.my_zaixian_dz_dbj, R.id.checkBox_nan, R.id.checkBox_nv
            , R.id.home_zaixiandingzuo_fh,R.id.home_zaixiandingzuo_renshu,R.id.home_zaixiandingzuo_shijian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_zaixiandingzuo_shijian:
                if (mRxDialogWheelYearMonthDay == null) {
                    initWheelYearMonthDayDialog();
                }
                mRxDialogWheelYearMonthDay.show();
                break;
            case R.id.home_zaixiandingzuo_renshu:
                break;
            case R.id.home_zaixiandingzuo_fh:
                finish();
                break;
            case R.id.my_zaixian_dz_ddt:
                checkBoxDdt.setVisibility(View.VISIBLE);
                checkBoxDdt.setChecked(true);
                checkBoxDbj.setVisibility(View.GONE);
                checkBoxDbj.setChecked(false);
                break;
            case R.id.my_zaixian_dz_dbj:
                checkBoxDbj.setVisibility(View.VISIBLE);
                checkBoxDbj.setChecked(true);
                checkBoxDdt.setVisibility(View.GONE);
                checkBoxDdt.setChecked(false);
                break;
            case R.id.checkBox_nan:
                checkBoxNan.setChecked(true);
                checkBoxNv.setChecked(false);
                break;
            case R.id.checkBox_nv:
                checkBoxNan.setChecked(false);
                checkBoxNv.setChecked(true);
                break;
        }
    }
}
