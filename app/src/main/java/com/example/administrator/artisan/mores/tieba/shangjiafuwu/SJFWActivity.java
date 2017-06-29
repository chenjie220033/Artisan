package com.example.administrator.artisan.mores.tieba.shangjiafuwu;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;
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
 * 商家服务
 */
public class SJFWActivity extends AppCompatActivity {


    @BindView(R.id.mores_sjfw_fh)
    ImageView moresSjfwFh;
    @BindView(R.id.mores_sjfw_edit)
    EditText moresSjfwEdit;
    @BindView(R.id.supplier_list_title_tv)
    TextView supplierListTitleTv;
    @BindView(R.id.supplier_list_cart_iv)
    ImageView supplierListCartIv;
    @BindView(R.id.titlebar_layout)
    FrameLayout titlebarLayout;
    @BindView(R.id.shangjia_fenlei_tv)
    TextView shangjiaFenleiTv;
    @BindView(R.id.jiantou1)
    ImageView jiantou1;
    @BindView(R.id.shangjia_fenlei)
    PercentLinearLayout shangjiaFenlei;
    @BindView(R.id.shangjia_diqu_tv)
    TextView shangjiaDiquTv;
    @BindView(R.id.jiantou2)
    ImageView jiantou2;
    @BindView(R.id.shangjia_diqu)
    LinearLayout shangjiaDiqu;
    @BindView(R.id.shangjia_shangquan_tv)
    TextView shangjiaShangquanTv;
    @BindView(R.id.jiantou3)
    ImageView jiantou3;
    @BindView(R.id.shangjia_shangquan)
    LinearLayout shangjiaShangquan;
    @BindView(R.id.shangjia_paixu_tv)
    TextView shangjiaPaixuTv;
    @BindView(R.id.jiantou4)
    ImageView jiantou4;
    @BindView(R.id.shangjia_paixu)
    LinearLayout shangjiaPaixu;
    @BindView(R.id.activity_sjfw)
    LinearLayout activitySjfw;
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

    String titles1 = "分类";
    String titles2 = "地区";
    String titles3 = "商圈";
    String titles4 = "排序";
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjfw);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initData();
        initPopMenu();
        shangjiaFenleiTv.setText(titles1);
        shangjiaDiquTv.setText(titles2);
        shangjiaShangquanTv.setText(titles3);
        shangjiaPaixuTv.setText(titles4);
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
        String[] menuStr1 = new String[]{"全部", "旅游","房地产","美食", "休闲娱乐", "酒店", "购物",
                "生活服务", "丽人", "水果",  "电影/在线选座"};
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
                jiantou3.setImageResource(R.drawable.icon_down);
                jiantou4.setImageResource(R.drawable.icon_down);
                shangjiaFenleiTv.setTextColor(Color.parseColor("#333333"));
                shangjiaDiquTv.setTextColor(Color.parseColor("#333333"));
                shangjiaShangquanTv.setTextColor(Color.parseColor("#333333"));
                shangjiaPaixuTv.setTextColor(Color.parseColor("#333333"));
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

        mMenuAdapter4 = new SimpleAdapter(this, mMenuData4, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});
        mPopListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupMenu.dismiss();
                switch (menuIndex) {
                    case 0:
                        String currentProduct = mMenuData1.get(i).get("name");
                        supplierListTitleTv.setText(currentProduct);
                        shangjiaFenleiTv.setText(currentProduct);
                        break;
                    case 1:
                        String currentSort = mMenuData2.get(i).get("name");
                        supplierListTitleTv.setText(currentSort);
                        shangjiaDiquTv.setText(currentSort);
                        break;
                    case 2:
                        String currentAct = mMenuData3.get(i).get("name");
                        supplierListTitleTv.setText(currentAct);
                        shangjiaShangquanTv.setText(currentAct);
                        break;
                    case 3:
                        String currentActs = mMenuData4.get(i).get("name");
                        supplierListTitleTv.setText(currentActs);
                        shangjiaPaixuTv.setText(currentActs);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.shangjia_fenlei, R.id.shangjia_diqu, R.id.shangjia_shangquan,
            R.id.shangjia_paixu,R.id.mores_sjfw_fh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mores_sjfw_fh:
                finish();
                break;
            case R.id.shangjia_fenlei:
                shangjiaFenleiTv.setTextColor(Color.parseColor("#ea1010"));
                jiantou1.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter1);
                popupMenu.showAsDropDown(shangjiaFenlei, 0, 2);
                menuIndex = 0;
                break;
            case R.id.shangjia_diqu:
                shangjiaDiquTv.setTextColor(Color.parseColor("#ea1010"));
                jiantou2.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter2);
                popupMenu.showAsDropDown(shangjiaDiqu, 0, 2);
                menuIndex = 1;
                break;
            case R.id.shangjia_shangquan:
                shangjiaShangquanTv.setTextColor(Color.parseColor("#ea1010"));
                jiantou3.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter3);
                popupMenu.showAsDropDown(shangjiaShangquan, 0, 2);
                menuIndex = 2;
                break;
            case R.id.shangjia_paixu:
                shangjiaPaixuTv.setTextColor(Color.parseColor("#ea1010"));
                jiantou4.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter4);
                popupMenu.showAsDropDown(shangjiaPaixu, 0, 2);
                menuIndex = 3;
                break;
        }
    }
}
