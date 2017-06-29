package com.example.administrator.artisan.mores.tieba.huodong;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mores.tieba.gouwu.HuoDongBaoMingActivity;
import com.example.administrator.artisan.mores.tieba.gouwu.HuoDongXiangQingActivity;
import com.example.administrator.artisan.utils.ActivityUtils;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * Created by chen on 2017/6/22.
 * 活动界面
 */
public class HuoDongActivity extends AppCompatActivity {

    @BindView(R.id.supplier_list_title_tv)
    TextView supplierListTitleTv;
    @BindView(R.id.supplier_list_cart_iv)
    ImageView supplierListCartIv;
    @BindView(R.id.titlebar_layout)
    FrameLayout titlebarLayout;
    @BindView(R.id.huodong_fenlei_tv)
    TextView huodongFenleiTv;
    @BindView(R.id.jiantou1)
    ImageView jiantou1;
    @BindView(R.id.huodong_fenlei)
    PercentLinearLayout huodongFenlei;
    @BindView(R.id.huodong_shijian_tv)
    TextView huodongShijianTv;
    @BindView(R.id.jiantou2)
    ImageView jiantou2;
    @BindView(R.id.huodong_shijian)
    LinearLayout huodongShijian;
    @BindView(R.id.test)
    TextView test;
    private ArrayList<Map<String, String>> mMenuData1;
    private ArrayList<Map<String, String>> mMenuData2;
    private ListView mPopListview;
    private PopupWindow popupMenu;
    private SimpleAdapter mMenuAdapter1;
    private SimpleAdapter mMenuAdapter2;
    private int menuIndex = 0;
    String titles1 = "分类";
    String titles2 = "时间";
    private Unbinder bind;
    private ActivityUtils activityUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_dong);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        test.setAlpha(0.6f);
        initData();
        initPopMenu();
        activityUtils = new ActivityUtils(this);
        huodongFenleiTv.setText(titles1);
        huodongShijianTv.setText(titles2);
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void initData() {
        mMenuData1 = new ArrayList<>();
        String[] menuStr1 = new String[]{"全部", "旅游", "房地产", "美食", "休闲娱乐", "酒店", "购物",
                "生活服务", "丽人", "水果", "电影/在线选座"};
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
    }

    private void initPopMenu() {
        View popView = LayoutInflater.from(this).inflate(R.layout.popwin_supplier_list, null);
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
                jiantou1.setImageResource(R.drawable.icon_down);
                jiantou2.setImageResource(R.drawable.icon_down);
                huodongFenleiTv.setTextColor(Color.parseColor("#333333"));
                huodongShijianTv.setTextColor(Color.parseColor("#333333"));
            }
        });
        popView.findViewById(R.id.popwin_supplier_list_bottom)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupMenu.dismiss();
                    }
                });

        mMenuAdapter1 = new SimpleAdapter(this, mMenuData1, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter2 = new SimpleAdapter(this, mMenuData2, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});
        mPopListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupMenu.dismiss();
                switch (menuIndex) {
                    case 0:
                        String currentProduct = mMenuData1.get(i).get("name");
                        supplierListTitleTv.setText(currentProduct);
                        huodongFenleiTv.setText(currentProduct);
                        break;
                    case 1:
                        String currentSort = mMenuData2.get(i).get("name");
                        supplierListTitleTv.setText(currentSort);
                        huodongShijianTv.setText(currentSort);
                        break;
                }
            }
        });

    }

    @OnClick({R.id.huodong_fenlei, R.id.huodong_shijian, R.id.mores_huodong_fh,
            R.id.huodong_xiangqing,R.id.huodong_lijicanjia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huodong_lijicanjia:
                activityUtils.startActivity(HuoDongBaoMingActivity.class);
                break;
            case R.id.huodong_xiangqing:
                activityUtils.startActivity(HuoDongXiangQingActivity.class);
                break;
            case R.id.mores_huodong_fh:
                finish();
                break;
            case R.id.huodong_fenlei:
                huodongFenleiTv.setTextColor(Color.parseColor("#ea1010"));
                jiantou1.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter1);
                popupMenu.showAsDropDown(huodongFenlei, 0, 2);
                menuIndex = 0;
                break;
            case R.id.huodong_shijian:
                huodongShijianTv.setTextColor(Color.parseColor("#ea1010"));
                jiantou2.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter2);
                popupMenu.showAsDropDown(huodongShijian, 0, 2);
                menuIndex = 1;
                break;
        }
    }
}
