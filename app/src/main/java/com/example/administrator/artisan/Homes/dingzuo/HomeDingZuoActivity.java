package com.example.administrator.artisan.Homes.dingzuo;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.banners.BannerAdapter;
import com.example.administrator.artisan.banners.BannerLayout;
import com.example.administrator.artisan.banners.LocalBanner;
import com.example.administrator.artisan.utils.ActivityUtils;
import com.squareup.picasso.Picasso;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.artisan.R.id.supplier_list_activity_jl;
/**
 * Created by Chen on 2017/6/14.
 * home订座界面
 *
 * */
public class HomeDingZuoActivity extends AppCompatActivity {

    @BindView(R.id.home_dingzuo_banner)
    BannerLayout homeDingzuoBanner;
    @BindView(R.id.supplier_list_title_tv)
    TextView supplierListTitleTv;
    @BindView(R.id.home_dingzuo_fenlei_tv)
    TextView homeDingzuoFenleiTv;
    @BindView(R.id.jiantou1)
    ImageView iv1;
    @BindView(R.id.home_dingzuo_fenlei)
    PercentLinearLayout homeDingzuoFenlei;
    @BindView(R.id.home_dingzuo_diqu_tv)
    TextView homeDingzuoDiquTv;
    @BindView(R.id.jiantou2)
    ImageView iv2;
    @BindView(R.id.home_dingzuo_diqu)
    LinearLayout homeDingzuoDiqu;
    @BindView(R.id.home_dingzuo_shangquan_tv)
    TextView homeDingzuoShangquanTv;
    @BindView(R.id.jiantou3)
    ImageView iv3;
    @BindView(R.id.home_dingzuo_shangquan)
    LinearLayout homeDingzuoShangquan;
    @BindView(R.id.home_dingzuo_paixu_tv)
    TextView homeDingzuoPaixuTv;
    @BindView(R.id.jiantou4)
    ImageView iv4;
    @BindView(R.id.home_dingzuo_paixu)
    LinearLayout homeDingzuoPaixu;
    private Unbinder bind;

    private ArrayList<Map<String, String>> mMenuData1;
    private ArrayList<Map<String, String>> mMenuData2;
    private ArrayList<Map<String, String>> mMenuData3;
    private ArrayList<Map<String, String>> mMenuData4;

    private ListView mPopListview;
    private PopupWindow popupMenu;
    private SimpleAdapter mMenuAdapter1;
    private SimpleAdapter mMenuAdapter2;
    private SimpleAdapter mMenuAdapter3;
    private SimpleAdapter mMenuAdapter4;
    private int menuIndex = 0;

    String titles1 = "全部分类";
    String titles2 = "地区";
    String titles3 = "商圈";
    String titles4 = "排序";
    private ActivityUtils activityUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ding_zuo);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        activityUtils = new ActivityUtils(this);
        homeDingzuoFenleiTv.setText(titles1);
        homeDingzuoDiquTv.setText(titles2);
        homeDingzuoShangquanTv.setText(titles3);
        homeDingzuoPaixuTv.setText(titles4);
        initBanner();
        initData();
        initPopMenu();
    }

    private void initData() {
        mMenuData1 = new ArrayList<>();
        String[] menuStr1 = new String[]{"全部", "美食", "休闲娱乐", "酒店", "购物",
                "生活服务", "丽人", "亲子", "结婚", "水果", "旅游", "电影/在线选座"};
        Map<String, String> map1;
        for (int i = 0, len = menuStr1.length; i < len; ++i) {
            map1 = new HashMap<>();
            map1.put("name", menuStr1[i]);
            mMenuData1.add(map1);
        }

        mMenuData2 = new ArrayList<>();
        String[] menuStr2 = new String[]{"城区", "开发区", "泽州县", "陵川县"
                , "阳城县", "沁水县", "高平市"};
        Map<String, String> map2;
        for (int i = 0, len = menuStr2.length; i < len; ++i) {
            map2 = new HashMap<>();
            map2.put("name", menuStr2[i]);
            mMenuData2.add(map2);
        }

        mMenuData3 = new ArrayList<>();
        String[] menuStr3 = new String[]{"泽州路", "黄华街", "新市街",
                "红星街", "太行路", "白水街", "景西路"};
        Map<String, String> map3;
        for (int i = 0, len = menuStr3.length; i < len; ++i) {
            map3 = new HashMap<>();
            map3.put("name", menuStr3[i]);
            mMenuData3.add(map3);
        }

        mMenuData4 = new ArrayList<>();
        String[] menuStr4 = new String[]{"距离优先", "推荐排序"};
        Map<String, String> map4;
        for (int i = 0, len = menuStr4.length; i < len; ++i) {
            map4 = new HashMap<>();
            map4.put("name", menuStr4[i]);
            mMenuData4.add(map4);
        }
    }

    /***
     * 初始化popupwindow
     */
    private void initPopMenu() {
        View popView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popwin_supplier_list, null);
        mPopListview = (ListView) popView.findViewById(R.id.popwin_supplier_list_lv);
        popupMenu = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT);
        popupMenu.setOutsideTouchable(true);
        popupMenu.setBackgroundDrawable(new BitmapDrawable());
        popupMenu.setFocusable(true);
        popupMenu.setAnimationStyle(R.style.popwin_anim_style);
        popupMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                iv1.setImageResource(R.drawable.icon_down);
                iv2.setImageResource(R.drawable.icon_down);
                iv3.setImageResource(R.drawable.icon_down);
                iv4.setImageResource(R.drawable.icon_down);
                homeDingzuoFenleiTv.setTextColor(Color.parseColor("#333333"));
                homeDingzuoDiquTv.setTextColor(Color.parseColor("#333333"));
                homeDingzuoShangquanTv.setTextColor(Color.parseColor("#333333"));
                homeDingzuoPaixuTv.setTextColor(Color.parseColor("#333333"));
            }
        });

        popView.findViewById(R.id.popwin_supplier_list_bottom)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupMenu.dismiss();
                    }
                });

        mMenuAdapter1 = new SimpleAdapter(getApplicationContext(), mMenuData1, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter2 = new SimpleAdapter(getApplicationContext(), mMenuData2, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter3 = new SimpleAdapter(getApplicationContext(), mMenuData3, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter4 = new SimpleAdapter(getApplicationContext(), mMenuData4, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mPopListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupMenu.dismiss();
                switch (menuIndex) {
                    case 0:
                        String currentProduct = mMenuData1.get(i).get("name");
                        supplierListTitleTv.setText(currentProduct);
                        homeDingzuoFenleiTv.setText(currentProduct);
                        break;
                    case 1:
                        String currentSort = mMenuData2.get(i).get("name");
                        supplierListTitleTv.setText(currentSort);
                        homeDingzuoDiquTv.setText(currentSort);
                        break;
                    case 2:
                        String currentAct = mMenuData3.get(i).get("name");
                        supplierListTitleTv.setText(currentAct);
                        homeDingzuoShangquanTv.setText(currentAct);
                        break;
                    case 3:
                        String currentActs = mMenuData4.get(i).get("name");
                        supplierListTitleTv.setText(currentActs);
                        homeDingzuoPaixuTv.setText(currentActs);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.home_dingzuo_fh, R.id.home_dingzuo_fenlei,
            R.id.home_dingzuo_diqu, R.id.home_dingzuo_shangquan,
            R.id.home_dingzuo_paixu,R.id.cheshi1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cheshi1:
                activityUtils.startActivity(HomeDingZuoXQActivity.class);
                break;
            case R.id.home_dingzuo_fh:
                finish();
                break;
            case R.id.home_dingzuo_fenlei:
                homeDingzuoFenleiTv.setTextColor(Color.parseColor("#ea1010"));
                iv1.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter1);
                popupMenu.showAsDropDown(homeDingzuoFenlei, 0, 2);
                menuIndex = 0;
                break;
            case R.id.home_dingzuo_diqu:
                homeDingzuoDiquTv.setTextColor(Color.parseColor("#ea1010"));
                iv2.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter2);
                popupMenu.showAsDropDown(homeDingzuoDiqu, 0, 2);
                menuIndex = 1;
                break;
            case R.id.home_dingzuo_shangquan:
                homeDingzuoShangquanTv.setTextColor(Color.parseColor("#ea1010"));
                iv3.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter3);
                popupMenu.showAsDropDown(homeDingzuoShangquan, 0, 2);
                menuIndex = 2;
                break;
            case R.id.home_dingzuo_paixu:
                homeDingzuoPaixuTv.setTextColor(Color.parseColor("#ea1010"));
                iv4.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter4);
                popupMenu.showAsDropDown(homeDingzuoPaixu, 0, 2);
                menuIndex = 3;
                break;
        }
    }

    // 轮播图
    private void initBanner() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {
            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(getApplicationContext()).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        homeDingzuoBanner.setAdapter(bannerAdapter);
        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        localBanners.add(new LocalBanner(R.drawable.home_banner));
        bannerAdapter.reset(localBanners);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }


}
