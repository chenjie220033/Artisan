package com.example.administrator.artisan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.artisan.Homes.GalleryAdapter1;
import com.example.administrator.artisan.Homes.GalleryAdapter2;
import com.example.administrator.artisan.Homes.HomeGridViewAdapter;
import com.example.administrator.artisan.Homes.daojishi.CountdownView;
import com.example.administrator.artisan.Homes.dingzuo.HomeDingZuoActivity;
import com.example.administrator.artisan.banners.BannerAdapter;
import com.example.administrator.artisan.banners.BannerLayout;
import com.example.administrator.artisan.banners.LocalBanner;
import com.example.administrator.artisan.mores.tieba.TieBaActivity;
import com.example.administrator.artisan.mores.tieba.gouwu.GouWuActivity;
import com.example.administrator.artisan.mores.tieba.gouwu.GouWuAdapter1;
import com.example.administrator.artisan.mores.tieba.huodong.HuoDongActivity;
import com.example.administrator.artisan.mores.tieba.jiazheng.JiaZhengActivity;
import com.example.administrator.artisan.mores.tieba.jiudian.JiuDianActivity;
import com.example.administrator.artisan.mores.tieba.shangjiafuwu.SJFWActivity;
import com.example.administrator.artisan.mys.myyouhuoquan.MyYHQActivity;
import com.example.administrator.artisan.mys.wdjf.wojf.MyJiFenActivity;
import com.example.administrator.artisan.nongjiale.NongJiaLeActivity;
import com.example.administrator.artisan.utils.ActivityUtils;
import com.example.administrator.artisan.utils.MyGridView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.gridView1;

/**
 * Created by Administrator on 2017/6/5.
 */
public class HomeFrame extends Fragment {
    @BindView(R.id.layout_banner1)
    BannerLayout layoutBanner1;
    @BindView(R.id.layout_banner2)
    BannerLayout layoutBanner2;
    Unbinder unbinder;
    @BindView(R.id.cv_countdownViewTest1)
    CountdownView countdownView;
    @BindView(R.id.id_recyclerview_horizontal)
    RecyclerView idRecyclerviewHorizontal;
    @BindView(R.id.id_recyclerview_horizontal2)
    RecyclerView idRecyclerviewHorizontal2;
    @BindView(R.id.home_gridview)
    MyGridView myGridView;
    private ActivityUtils activityUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frame, null);
        unbinder = ButterKnife.bind(this, view);
        initBanner1();
        initBanner2();
        activityUtils = new ActivityUtils(this);
        countdownView.setTag("test1");
        long time1 = (long) 5 * 60 * 60 * 1000;
        countdownView.start(time1);
        initRecyclerView();
        initGridView();
        return view;
    }

    private void initGridView() {
        List<String> list1 = new ArrayList<String>();
        for (int i = 1; i < 11; i++) {
            list1.add("景江大酒店");
        }
        HomeGridViewAdapter homeadapter = new HomeGridViewAdapter(getActivity(), list1);
        myGridView.setAdapter(homeadapter);
    }

    private void initRecyclerView() {
        //第一个横向滑动
        //添加图片
        List<Integer> mDatas1 = new ArrayList<Integer>(Arrays.asList(R.drawable.home_h,
                R.drawable.home_h, R.drawable.home_h, R.drawable.home_h
                , R.drawable.home_h, R.drawable.home_h, R.drawable.home_h
                , R.drawable.home_h, R.drawable.home_h));
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        idRecyclerviewHorizontal.setLayoutManager(linearLayoutManager);
        //设置适配器
        GalleryAdapter1 mAdapter = new GalleryAdapter1(getActivity(), mDatas1);
        mAdapter.setOnItemClickLitener(new GalleryAdapter1.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        idRecyclerviewHorizontal.setAdapter(mAdapter);
        //第二个横向滑动
        List<Integer> mDatas2 = new ArrayList<Integer>(Arrays.asList(R.drawable.home_h,
                R.drawable.home_h, R.drawable.home_h, R.drawable.home_h
                , R.drawable.home_h, R.drawable.home_h, R.drawable.home_h
                , R.drawable.home_h, R.drawable.home_h));
        //设置布局管理器
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        idRecyclerviewHorizontal2.setLayoutManager(linearLayoutManager2);
        //设置适配器
        GalleryAdapter2 mAdapter2 = new GalleryAdapter2(getActivity(), mDatas2);
        mAdapter.setOnItemClickLitener(new GalleryAdapter1.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        idRecyclerviewHorizontal2.setAdapter(mAdapter2);
    }


    // 轮播图
    private void initBanner1() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {
            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(getActivity()).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        layoutBanner1.setAdapter(bannerAdapter);
        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        bannerAdapter.reset(localBanners);
    }

    // 轮播图
    private void initBanner2() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {
            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(getActivity()).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        layoutBanner2.setAdapter(bannerAdapter);
        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        bannerAdapter.reset(localBanners);
    }

    public static HomeFrame newInstance() {
        return new HomeFrame();
    }

    @Override
    public void onDestroyView() {
        if (this.unbinder != null) {
            this.unbinder.unbind();
        }
        super.onDestroyView();
    }

    @OnClick({R.id.home_nongjiale2, R.id.home_nongjiele, R.id.home_jiudian, R.id.home_gouwu,
            R.id.home_dingzou, R.id.home_youhui, R.id.home_shangjia, R.id.home_shenghuo,
            R.id.home_jiazheng, R.id.home_jifen, R.id.home_huodong, R.id.home_tieba,
            R.id.home_huodong_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_huodong_layout:
                activityUtils.startActivity(HuoDongActivity.class);
                break;
            case R.id.home_tieba:
                activityUtils.startActivity(TieBaActivity.class);
                break;
            case R.id.home_nongjiale2:
                activityUtils.startActivity(NongJiaLeActivity.class);
                break;
            case R.id.home_nongjiele:
                activityUtils.startActivity(NongJiaLeActivity.class);
                break;
            case R.id.home_jiudian:
                activityUtils.startActivity(JiuDianActivity.class);
                break;
            case R.id.home_gouwu:
                activityUtils.startActivity(GouWuActivity.class);
                break;
            case R.id.home_dingzou:
                activityUtils.startActivity(HomeDingZuoActivity.class);
                break;
            case R.id.home_youhui:
                activityUtils.startActivity(MyYHQActivity.class);
                break;
            case R.id.home_shangjia:
                activityUtils.startActivity(SJFWActivity.class);
                break;
            case R.id.home_shenghuo:
                break;
            case R.id.home_jiazheng:
                activityUtils.startActivity(JiaZhengActivity.class);
                break;
            case R.id.home_jifen:
                activityUtils.startActivity(MyJiFenActivity.class);
                break;
            case R.id.home_huodong:
                activityUtils.startActivity(HuoDongActivity.class);
                break;
        }
    }
}
