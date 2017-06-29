package com.example.administrator.artisan;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.shop.ShopingSouSuoActivity;
import com.example.administrator.artisan.utils.ActivityUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/6/5.
 */
public class ShopingFrame extends Fragment {
    @BindView(R.id.sseditText)
    EditText edittext;
    @BindView(R.id.supplier_list_title_tv)
    TextView mSupplierListTitleTv;
    @BindView(R.id.supplier_list_product_tv)
    TextView mProductTv;
    @BindView(R.id.jiantou1)
    ImageView iv1;
    @BindView(R.id.supplier_list_product)
    LinearLayout mProduct;
    @BindView(R.id.supplier_list_sort_tv)
    TextView mSortTv;
    @BindView(R.id.jiantou2)
    ImageView iv2;
    @BindView(R.id.supplier_list_sort)
    LinearLayout mSort;
    @BindView(R.id.supplier_list_activity_tv)
    TextView mCategoryTv;
    @BindView(R.id.jiantou3)
    ImageView iv3;
    @BindView(R.id.supplier_list_activity)
    LinearLayout mCategory;
    @BindView(R.id.supplier_list_activity_tvjl)
    TextView supplier_list_activity_tvjl;
    @BindView(R.id.jiantou4)
    ImageView iv4;
    @BindView(R.id.supplier_list_activity_jl)
    LinearLayout supplier_list_activity_jl;
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
    String titles4 = "离我最近";

    private ActivityUtils activityUtils;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoping_frame, null);
        bind = ButterKnife.bind(this, view);
        initData();
        initPopMenu();
        activityUtils = new ActivityUtils(this);
        edittext.setInputType(InputType.TYPE_NULL);
        mProductTv.setText(titles1);
        mSortTv.setText(titles2);
        mCategoryTv.setText(titles3);
        supplier_list_activity_tvjl.setText(titles4);
        setOnClicks();
        return view;
    }

    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void setOnClicks() {
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityUtils.startActivity(ShopingSouSuoActivity.class);
            }
        });
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
        View popView = LayoutInflater.from(getActivity()).inflate(R.layout.popwin_supplier_list, null);
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
                mProductTv.setTextColor(Color.parseColor("#333333"));
                mSortTv.setTextColor(Color.parseColor("#333333"));
                mCategoryTv.setTextColor(Color.parseColor("#333333"));
                supplier_list_activity_tvjl.setTextColor(Color.parseColor("#333333"));
            }
        });

        popView.findViewById(R.id.popwin_supplier_list_bottom)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupMenu.dismiss();
                    }
                });

        mMenuAdapter1 = new SimpleAdapter(getActivity(), mMenuData1, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter2 = new SimpleAdapter(getActivity(), mMenuData2, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter3 = new SimpleAdapter(getActivity(), mMenuData3, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mMenuAdapter4 = new SimpleAdapter(getActivity(), mMenuData4, R.layout.item_listview_popwin,
                new String[]{"name"}, new int[]{R.id.listview_popwind_tv});

        mPopListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupMenu.dismiss();
                switch (menuIndex) {
                    case 0:
                        String currentProduct = mMenuData1.get(i).get("name");
                        mSupplierListTitleTv.setText(currentProduct);
                        mProductTv.setText(currentProduct);
                        break;
                    case 1:
                        String currentSort = mMenuData2.get(i).get("name");
                        mSupplierListTitleTv.setText(currentSort);
                        mSortTv.setText(currentSort);
                        break;
                    case 2:
                        String currentAct = mMenuData3.get(i).get("name");
                        mSupplierListTitleTv.setText(currentAct);
                        mCategoryTv.setText(currentAct);
                        break;
                    case 3:
                        String currentActs = mMenuData4.get(i).get("name");
                        mSupplierListTitleTv.setText(currentActs);
                        supplier_list_activity_tvjl.setText(currentActs);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.supplier_list_product, R.id.supplier_list_activity_jl, R.id.supplier_list_sort,
            R.id.supplier_list_activity, R.id.my_concern_fh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.supplier_list_product:
                mProductTv.setTextColor(Color.parseColor("#ea1010"));
                iv1.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter1);
                popupMenu.showAsDropDown(mProduct, 0, 2);
                menuIndex = 0;
                break;
            case R.id.supplier_list_sort:
                mSortTv.setTextColor(Color.parseColor("#ea1010"));
                iv2.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter2);
                popupMenu.showAsDropDown(mSort, 0, 2);
                menuIndex = 1;
                break;
            case R.id.supplier_list_activity:
                mCategoryTv.setTextColor(Color.parseColor("#ea1010"));
                iv3.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter3);
                popupMenu.showAsDropDown(mCategory, 0, 2);
                menuIndex = 2;
                break;
            case R.id.supplier_list_activity_jl:
                supplier_list_activity_tvjl.setTextColor(Color.parseColor("#ea1010"));
                iv4.setImageResource(R.drawable.icon_up);
                mPopListview.setAdapter(mMenuAdapter4);
                popupMenu.showAsDropDown(supplier_list_activity_jl, 0, 2);
                menuIndex = 3;
                break;
            case R.id.my_concern_fh:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    public static ShopingFrame newInstance() {
        return new ShopingFrame();
    }

}