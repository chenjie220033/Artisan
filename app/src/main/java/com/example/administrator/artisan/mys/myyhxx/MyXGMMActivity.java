package com.example.administrator.artisan.mys.myyhxx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.artisan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * chen
 * 我的   账户信息    修改密码
 * */
public class MyXGMMActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_xgmm);
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

    @OnClick({R.id.my_yonghuxx_xgmm_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_yonghuxx_xgmm_fh:
                finish();
                break;

        }
    }
}
