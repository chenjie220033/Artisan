package com.example.administrator.artisan.mys.myyhxx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.my_xgh_nicheng;

/**
 * Created by chen on 2017/6/17.
 * 我的  账户信息  设置昵称
 */
public class MyXiuGaiNCActivity extends AppCompatActivity {
    @BindView(R.id.my_shezhi_nicheng)
    EditText my_shezhi_nicheng;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_xiugai_nc);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //默认不弹出小键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //传回来的数据
//        init();
    }
//    private void init() {
//        final Intent intents = getIntent();
//        my_shezhi_nicheng.setHint(intents.getStringExtra("nicheng"));
//    }


    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_yonghu_sznc_fh, R.id.my_qrbc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_yonghu_sznc_fh:
                finish();
                break;
            case R.id.my_qrbc:
//                String nicheng = my_shezhi_nicheng.getText().toString();
//                Intent intent = new Intent(this, MyZhangHuXXActivity.class);
//                intent.putExtra("nicheng",nicheng);
//                startActivity(intent);
                finish();
                break;
        }
    }
}
