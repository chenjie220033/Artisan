package com.example.administrator.artisan.mys.myyhxx;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.artisan.MainActivity;
import com.example.administrator.artisan.MyFrame;
import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.my_shezhi_nicheng;
/**
 * chen
 *
 * 我的   账户信息
 * */
public class MyZhangHuXXActivity extends AppCompatActivity {
    @BindView(R.id.zhanghxx_sjh)
    TextView zhanghxxSjh;
    @BindView(R.id.my_zhzx_bdsjh)
    RelativeLayout my_zhzx_bdsjh;
    @BindView(R.id.my_xgh_nicheng)
    TextView my_xgh_nicheng;
    private String pNumber = "13921564654";
    private ActivityUtils activityUtils;
    private PopupWindow mPopWindow;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_zhang_hu_xx);
        bind = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //手机号中间显示***
        Phonenumber();
        //传回来的数据
        init();
        my_zhzx_bdsjh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void init() {
        final Intent intents = getIntent();
        my_xgh_nicheng.setText(intents.getStringExtra("nicheng"));
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(MyZhangHuXXActivity.this).inflate(R.layout.popupwindow, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //弹出，界面外面的背景色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示PopupWindow
        View rootview = LayoutInflater.from(MyZhangHuXXActivity.this).inflate(R.layout.activity_my_zhang_hu_xx, null);
        mPopWindow.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        //退出颜色变回1.0f
        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }

    private void Phonenumber() {
        //指定位置显示***手机号
        if (!TextUtils.isEmpty(pNumber) && pNumber.length() > 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pNumber.length(); i++) {
                char c = pNumber.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }

            zhanghxxSjh.setText(sb.toString());
        }


    }

    @OnClick({R.id.my_yonghuxx_fh, R.id.my_zhanghu_yhnc, R.id.my_jfsz, R.id.my_zhzx_wdshdz,
            R.id.my_zhanghu_xgtx, R.id.my_zhzx_xgwdmm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_zhzx_xgwdmm:
                activityUtils.startActivity(MyXGMMActivity.class);
                break;
            case R.id.my_zhanghu_xgtx:
//                activityUtils.startActivity(MyXGTXActivity.class);
                break;
            case R.id.my_zhzx_wdshdz:
                activityUtils.startActivity(MySHDZActivity.class);
                break;
            case R.id.my_jfsz:
                activityUtils.startActivity(MyJiBenSheZhiActivity.class);
                break;
            case R.id.my_yonghuxx_fh:
                finish();
                break;
            case R.id.my_zhanghu_yhnc:
//                String nicheng = my_xgh_nicheng.getText().toString();
                Intent intent = new Intent(this, MyXiuGaiNCActivity.class);
//                intent.putExtra("nicheng",nicheng);
                startActivity(intent);
//                finish();
                break;
        }
    }
}
