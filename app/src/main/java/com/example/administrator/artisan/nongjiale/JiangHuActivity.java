package com.example.administrator.artisan.nongjiale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.robshop.PullToZoomScrollViewEx;
import com.example.administrator.artisan.utils.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/10.
 */

public class JiangHuActivity extends AppCompatActivity {
    private Fragment fragment;
    private Unbinder bind;
    @BindView(R.id.list_shangjiatuangou)
    MyListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nongjiale_jianghu);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initView();
        initListView();
    }

    private void initListView() {
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add("[58店通用]国贸影城");
        }
        NongJiaLeAdapter nongJiaLeAdapter = new NongJiaLeAdapter(list);
        listView.setAdapter(nongJiaLeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(this,JiangHuActivity.class);
//                startActivity(intent);
            }
        });
    }

    private class NongJiaLeAdapter extends BaseAdapter {
        private List list = new ArrayList();

        public NongJiaLeAdapter(List list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHorder viewHorder = null;
            if (view == null) {
                viewHorder = new ViewHorder();
                view = LayoutInflater.from(getApplication()).inflate(R.layout.nongjiale_xq_listitem, null);
                viewHorder.tv = (TextView) view.findViewById(R.id.text_titles);
                viewHorder.tv1 = (TextView) view.findViewById(R.id.text_yuanjia);
                view.setTag(viewHorder);
            } else {
                viewHorder = (ViewHorder) view.getTag();
            }
            viewHorder.tv.setText(list.get(i).toString());
            viewHorder.tv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

            return view;
        }

        class ViewHorder {
            TextView tv, tv1;
        }
    }

    private void initView() {

        fragment = getSupportFragmentManager().findFragmentById(R.id.nongjiale_jiujia_fraament);
        if (fragment == null) {
            fragment = JiangHuYYXZFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.nongjiale_jiujia_fraament, JiangHuYYXZFragment.newInstance()).commit();
        }
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.nongjiale_radiogroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.nongjiale_yyxz: {
                        fragment = JiangHuYYXZFragment.newInstance();
                    }
                    break;
                    case R.id.nongjiale_sjxq: {
                        fragment = JiangHuSJXQFragment.newInstance();
                    }
                    break;
                    case R.id.nongjiale_ping: {
                        fragment = JiangHuPingFragment.newInstance();
                    }
                    break;

                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nongjiale_jiujia_fraament, fragment).commit();
                }
            }
        });

    }

    @OnClick({R.id.nongjiale_fh, R.id.button_ljyy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nongjiale_fh:
                finish();
                break;
            case R.id.button_ljyy:
                Intent intent = new Intent(JiangHuActivity.this,NongJiaLeZXYDActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
