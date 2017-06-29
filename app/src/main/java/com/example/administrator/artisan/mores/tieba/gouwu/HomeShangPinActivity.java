package com.example.administrator.artisan.mores.tieba.gouwu;

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
 * Created by chen on 2017/6/21.
 * 购物   商品
 */
public class     HomeShangPinActivity extends AppCompatActivity {
    @BindView(R.id.home_shangpin_fenlei_tv)
    TextView homeShangpinFenleiTv;
    @BindView(R.id.jiantou1)
    ImageView iv1;
    @BindView(R.id.home_shangpin_fenlei)
    PercentLinearLayout homeShangpinFenlei;
    @BindView(R.id.home_shangpin_quancheng_tv)
    TextView homeShangpinQuanchengTv;
    @BindView(R.id.jiantou2)
    ImageView iv2;
    @BindView(R.id.home_shangpin_quancheng)
    LinearLayout homeShangpinQuancheng;
    @BindView(R.id.home_shangpin_paixu_tv)
    TextView homeShangpinPaixuTv;
    @BindView(R.id.jiantou3)
    ImageView iv3;
    @BindView(R.id.home_shangpin_paixu)
    LinearLayout homeShangpinPaixu;
    private ArrayList<Map<String, String>> mMenuData1;
    private ArrayList<Map<String, String>> mMenuData2;
    private ArrayList<Map<String, String>> mMenuData3;
    private ListView mPopListview;
    private PopupWindow popupMenu;
    private SimpleAdapter mMenuAdapter1;
    private SimpleAdapter mMenuAdapter2;
    private SimpleAdapter mMenuAdapter3;
    private int menuIndex = 0;
    String titles1 = "分类";
    String titles2 = "全城";
    String titles3 = "排序";
    private ActivityUtils activityUtils;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_shang_pin);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        activityUtils = new ActivityUtils(this);
        homeShangpinFenleiTv.setText(titles1);
        homeShangpinQuanchengTv.setText(titles2);
        homeShangpinPaixuTv.setText(titles3);
        initData();
        initPopMenu();
    }

    /***
     * 初始化popupwindow数据
     */
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
    }

    /***
     * 初始化popupwindow
     */
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
                iv1.setImageResource(R.drawable.icon_down);
                iv2.setImageResource(R.drawable.icon_down);
                iv3.setImageResource(R.drawable.icon_down);
                homeShangpinFenleiTv.setTextColor(Color.parseColor("#333333"));
                homeShangpinQuanchengTv.setTextColor(Color.parseColor("#333333"));
                homeShangpinPaixuTv.setTextColor(Color.parseColor("#333333"));
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

        mMenuAdapter3 = new SimpleAdapter(this, mMenuData3, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mPopListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupMenu.dismiss();
                switch (menuIndex) {
                    case 0:
                        String currentProduct = mMenuData1.get(i).get("name");
                        homeShangpinFenleiTv.setText(currentProduct);
                        break;
                    case 1:
                        String currentSort = mMenuData2.get(i).get("name");
                        homeShangpinQuanchengTv.setText(currentSort);
                        break;
                    case 2:
                        String currentAct = mMenuData3.get(i).get("name");

                        homeShangpinPaixuTv.setText(currentAct);
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            bind.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.my_gouwu_shangpin_fh, R.id.home_shangpin_fenlei, R.id.home_shangpin_quancheng, R.id.home_shangpin_paixu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_gouwu_shangpin_fh:
                finish();
                break;
            case R.id.home_shangpin_fenlei:
                homeShangpinFenleiTv.setTextColor(Color.parseColor("#ea1010"));
                iv1.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter1);
                popupMenu.showAsDropDown(homeShangpinFenlei, 0, 2);
                menuIndex = 0;
                break;
            case R.id.home_shangpin_quancheng:
                homeShangpinQuanchengTv.setTextColor(Color.parseColor("#ea1010"));
                iv2.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter2);
                popupMenu.showAsDropDown(homeShangpinQuancheng, 0, 2);
                menuIndex = 1;
                break;
            case R.id.home_shangpin_paixu:
                homeShangpinPaixuTv.setTextColor(Color.parseColor("#ea1010"));
                iv3.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter3);
                popupMenu.showAsDropDown(homeShangpinPaixu, 0, 2);
                menuIndex = 2;
                break;
        }
    }
}
