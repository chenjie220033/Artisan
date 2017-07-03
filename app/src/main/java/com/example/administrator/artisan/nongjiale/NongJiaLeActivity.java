package com.example.administrator.artisan.nongjiale;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.banners.BannerAdapter;
import com.example.administrator.artisan.banners.BannerLayout;
import com.example.administrator.artisan.banners.LocalBanner;
import com.example.administrator.artisan.shop.ShopingSouSuoActivity;
import com.example.administrator.artisan.utils.ActivityUtils;
import com.example.administrator.artisan.utils.MyGridView;
import com.example.administrator.artisan.utils.MyListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/10.
 */

public class NongJiaLeActivity extends AppCompatActivity {
    @BindView(R.id.layout_banner)
    BannerLayout layoutBanner;
    @BindView(R.id.nongjiele_gridview)
    MyGridView nongjiele_gridview;
    @BindView(R.id.nongjiele_listview)
    MyListView nongjieleListview;
    private ActivityUtils activityUtils;
    private Unbinder unbinder;
    @BindView(R.id.nongjiele_toolbar_editText)
    EditText nongjielete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nongjiale);
        unbinder = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        nongjielete.setInputType(InputType.TYPE_NULL);
        initBanner();
        initView();
    }

    private void initView() {
        List list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            list.add("江湖酒家");
        }
        NongJiaLeGridViewAdapter nongJiaLeGridViewAdapter = new NongJiaLeGridViewAdapter(list);
        nongjiele_gridview.setAdapter(nongJiaLeGridViewAdapter);
        nongjiele_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                activityUtils.startActivity(JiangHuActivity.class);
            }
        });
        List  glist = new ArrayList();
        for (int i = 0; i < 4; i++) {
            glist.add("锦江大酒店");
        }
        NongJiaLeListViewAdapter nongJiaLeListViewAdapter = new  NongJiaLeListViewAdapter(glist);
        nongjieleListview.setAdapter(nongJiaLeListViewAdapter);
        nongjieleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                activityUtils.startActivity(JiangHuActivity.class);
            }
        });
    }
    private class NongJiaLeListViewAdapter extends BaseAdapter {
        private List list = new ArrayList();

        public NongJiaLeListViewAdapter( List list) {
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
                view = LayoutInflater.from(getApplication()).inflate(R.layout.home_dingzuo_item, null);
                viewHorder.tv = (TextView) view.findViewById(R.id.text_titles);
                viewHorder.tv1 = (TextView) view.findViewById(R.id.text_juli);
                view.setTag(viewHorder);
            } else {
                viewHorder = (ViewHorder) view.getTag();
            }
            viewHorder.tv.setText(list.get(i).toString());
            viewHorder.tv1.setVisibility(View.GONE);


            return view;
        }

        class ViewHorder {
            TextView tv,tv1;
        }
    }
    private class NongJiaLeGridViewAdapter extends BaseAdapter{
        private List list = new ArrayList();

        public NongJiaLeGridViewAdapter( List list) {
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
                view = LayoutInflater.from(getApplication()).inflate(R.layout.nongjiale_gridview_item, null);
                viewHorder.tv = (TextView) view.findViewById(R.id.nongjiele_gridview_item_title);
                viewHorder.tv1 = (TextView) view.findViewById(R.id.nongjiele_gridview_item_beijing);
                view.setTag(viewHorder);
            } else {
                viewHorder = (ViewHorder) view.getTag();
            }
            viewHorder.tv.setText(list.get(i).toString());
            viewHorder.tv1.setAlpha(0.6f);

            return view;
        }

        class ViewHorder {
            TextView tv,tv1;
        }

    }
    // 轮播图
    private void initBanner() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {
            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(NongJiaLeActivity.this).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        layoutBanner.setAdapter(bannerAdapter);

        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        bannerAdapter.reset(localBanners);

    }

    @Override
    protected void onDestroy() {
        if (this.unbinder != null) {
            this.unbinder.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.layout_huiyi, R.id.layout_caizhai, R.id.layout_chuidiao,
            R.id.layout_shaokao, R.id.layout_dengshan, R.id.layout_wenquan,
            R.id.layout_shanghua, R.id.layout_gengduo, R.id.nongjiale_fh,
            R.id.nongjiele_jingqu, R.id.nongjiele_gonglue, R.id.nongjiele_lvyou,
            R.id.nongjiele_shanghu, R.id.nongjiele_toolbar_editText,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nongjiele_lvyou:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.nongjiele_shanghu:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.nongjiele_jingqu:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.nongjiele_toolbar_editText:
                activityUtils.startActivity(ShopingSouSuoActivity.class);
                break;
            case R.id.nongjiale_fh:
                finish();
                break;
            case R.id.layout_huiyi:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_caizhai:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_chuidiao:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_shaokao:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_dengshan:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_wenquan:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_shanghua:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
            case R.id.layout_gengduo:
                activityUtils.startActivity(NongJiaLeLBActivity.class);
                break;
        }
    }
}
