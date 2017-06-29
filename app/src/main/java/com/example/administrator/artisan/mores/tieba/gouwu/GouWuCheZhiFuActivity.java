package com.example.administrator.artisan.mores.tieba.gouwu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.example.administrator.artisan.R;
import com.example.administrator.artisan.zhifu.SmoothCheckBox;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/21.
 * 购物车  支付
 */
public class GouWuCheZhiFuActivity extends AppCompatActivity {

    @BindView(R.id.smoothCheckBox1)
    SmoothCheckBox smoothCheckBox1;
    @BindView(R.id.smoothCheckBox2)
    SmoothCheckBox smoothCheckBox2;
    @BindView(R.id.smoothCheckBox3)
    SmoothCheckBox smoothCheckBox3;
    @BindView(R.id.smoothCheckBox4)
    SmoothCheckBox smoothCheckBox4;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che_zhi_fu);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        smoothCheckBox1.setClickable(false);
        smoothCheckBox2.setClickable(false);
        smoothCheckBox3.setClickable(false);
        smoothCheckBox4.setClickable(false);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_gouwuche_zhifu_fh, R.id.gouwuche_zhifu_zhifubao, R.id.gouwuche_zhifu_yue, R.id.gouwuche_zhifu_weixin, R.id.gouwuche_zhifu_hdfkuan, R.id.gouwuche_zhifu_querzf})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_gouwuche_zhifu_fh:
                finish();
                break;
            case R.id.gouwuche_zhifu_zhifubao:
                smoothCheckBox2.setChecked(false);
                smoothCheckBox3.setChecked(false);
                smoothCheckBox4.setChecked(false);
                smoothCheckBox2.setVisibility(View.INVISIBLE);
                smoothCheckBox3.setVisibility(View.INVISIBLE);
                smoothCheckBox4.setVisibility(View.INVISIBLE);
                if (smoothCheckBox1.isChecked()) {
                    smoothCheckBox1.setChecked(false);
                    smoothCheckBox1.setVisibility(View.INVISIBLE);
                } else {
                    smoothCheckBox1.setChecked(true);
                    smoothCheckBox1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.gouwuche_zhifu_yue:
                smoothCheckBox1.setChecked(false);
                smoothCheckBox3.setChecked(false);
                smoothCheckBox4.setChecked(false);
                smoothCheckBox1.setVisibility(View.INVISIBLE);
                smoothCheckBox3.setVisibility(View.INVISIBLE);
                smoothCheckBox4.setVisibility(View.INVISIBLE);
                if (smoothCheckBox2.isChecked()) {
                    smoothCheckBox2.setChecked(false);
                    smoothCheckBox2.setVisibility(View.INVISIBLE);
                } else {
                    smoothCheckBox2.setChecked(true);
                    smoothCheckBox2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.gouwuche_zhifu_weixin:
                smoothCheckBox1.setChecked(false);
                smoothCheckBox2.setChecked(false);
                smoothCheckBox4.setChecked(false);
                smoothCheckBox1.setVisibility(View.INVISIBLE);
                smoothCheckBox2.setVisibility(View.INVISIBLE);
                smoothCheckBox4.setVisibility(View.INVISIBLE);
                if (smoothCheckBox3.isChecked()) {
                    smoothCheckBox3.setChecked(false);
                    smoothCheckBox3.setVisibility(View.INVISIBLE);
                } else {
                    smoothCheckBox3.setChecked(true);
                    smoothCheckBox3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.gouwuche_zhifu_hdfkuan:
                smoothCheckBox1.setChecked(false);
                smoothCheckBox2.setChecked(false);
                smoothCheckBox3.setChecked(false);
                smoothCheckBox1.setVisibility(View.INVISIBLE);
                smoothCheckBox2.setVisibility(View.INVISIBLE);
                smoothCheckBox3.setVisibility(View.INVISIBLE);
                if (smoothCheckBox4.isChecked()) {
                    smoothCheckBox4.setChecked(false);
                    smoothCheckBox4.setVisibility(View.INVISIBLE);
                } else {
                    smoothCheckBox4.setChecked(true);
                    smoothCheckBox4.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.gouwuche_zhifu_querzf:
                if (smoothCheckBox1.isChecked()==true){
                    Toast.makeText(GouWuCheZhiFuActivity.this, "使用支付宝支付", Toast.LENGTH_SHORT).show();
                }else if (smoothCheckBox2.isChecked()==true){
                    Toast.makeText(GouWuCheZhiFuActivity.this, "使用余额支付", Toast.LENGTH_SHORT).show();
                }else if (smoothCheckBox3.isChecked()==true){
                    Toast.makeText(GouWuCheZhiFuActivity.this, "使用微信支付", Toast.LENGTH_SHORT).show();
                }else if (smoothCheckBox4.isChecked()==true){
                    Toast.makeText(GouWuCheZhiFuActivity.this, "使用货到付款支付", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
