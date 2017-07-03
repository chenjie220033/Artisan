package com.example.administrator.artisan.mores.tieba.jiazheng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/7/1.
 */
public class JiaZhengActivity extends AppCompatActivity {

    @BindView(R.id.jiazheng_baojie_text)
    TextView jiazhengBaojieText;
    @BindView(R.id.jiazheng_xiyixixie_text)
    TextView jiazhengXiyixixieText;
    @BindView(R.id.jiazheng_caboli_text)
    TextView jiazhengCaboliText;
    @BindView(R.id.jiazheng_youyanji_text)
    TextView jiazhengYouyanjiText;
    @BindView(R.id.jiazheng_chufang_text)
    TextView jiazhengChufangText;
    @BindView(R.id.jiazheng_xinju_text)
    TextView jiazhengXinjuText;
    @BindView(R.id.jiazheng_dala_text)
    TextView jiazhengDalaText;
    private Unbinder bind;
    private Intent intent;
    private String titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jia_zheng);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_mores_jiazhengfuwu_fh, R.id.jiazheng_baojie, R.id.jiazheng_caboli,
            R.id.jiazheng_chufang, R.id.jiazheng_dala, R.id.jiazheng_gengduo, R.id.jiazheng_xiyixixie,
            R.id.jiazheng_youyanji, R.id.jiazheng_xinju})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_mores_jiazhengfuwu_fh:
                finish();
                break;
            case R.id.jiazheng_gengduo:
                intent = new Intent(JiaZhengActivity.this, QuanBuFuWuActivity.class);
                startActivity(intent);
                break;
            case R.id.jiazheng_baojie:
                titles = jiazhengBaojieText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
            case R.id.jiazheng_xiyixixie:
                titles = jiazhengXiyixixieText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
            case R.id.jiazheng_caboli:
                titles = jiazhengCaboliText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
            case R.id.jiazheng_youyanji:
                titles = jiazhengYouyanjiText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
            case R.id.jiazheng_chufang:
                titles = jiazhengChufangText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
            case R.id.jiazheng_xinju:
                titles = jiazhengXinjuText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
            case R.id.jiazheng_dala:
                titles = jiazhengDalaText.getText().toString();
                intent = new Intent(JiaZhengActivity.this, YuYueFuWuActivity.class);
                intent.putExtra("titles", titles);
                startActivity(intent);
                break;
        }
    }
}
