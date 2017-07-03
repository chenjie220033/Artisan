package com.example.administrator.artisan.nongjiale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/12.
 */
public class JiangHuYYXZFragment extends Fragment{

    private Unbinder bind;
   @BindView(R.id.jianghu_yyxz_listview)
    MyListView listview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jianghu_yyxz_fragment,null);
        bind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("锦江大酒店");
        }
        JiangHuYYXZAdapter jiangHuYYXZAdapter = new  JiangHuYYXZAdapter(list);
        listview.setAdapter(jiangHuYYXZAdapter);
    }
    private class JiangHuYYXZAdapter extends BaseAdapter {
        private List list = new ArrayList();

        public JiangHuYYXZAdapter( List list) {
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
                view = LayoutInflater.from(getContext()).inflate(R.layout.nongjiele_liebiao_list_item, null);
                viewHorder.tv = (TextView) view.findViewById(R.id.text_titles);
                view.setTag(viewHorder);
            } else {
                viewHorder = (ViewHorder) view.getTag();
            }
            viewHorder.tv.setText(list.get(i).toString());


            return view;
        }

        class ViewHorder {
            TextView tv;
        }
    }
    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    public static JiangHuYYXZFragment newInstance() {
        return new JiangHuYYXZFragment();
    }


}
