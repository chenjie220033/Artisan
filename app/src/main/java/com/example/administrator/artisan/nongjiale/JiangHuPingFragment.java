package com.example.administrator.artisan.nongjiale;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mores.tieba.shangjiafuwu.ShangjiaXXPingJiaFragment;
import com.example.administrator.artisan.utils.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/12.
 */
public class JiangHuPingFragment extends Fragment {

    private Unbinder bind;
@BindView(R.id.jianghu_pingjia_listview)
    MyListView pingjialistview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.jianghu_ping_fragment,null);
        bind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }

    private void initView() {
        List list = new ArrayList();
        for (int i = 0; i <5 ; i++) {
            list.add("测试者");
        }
        PingjiaAdapter pingJiaAdapter = new PingjiaAdapter(getActivity(),list);
        pingjialistview.setAdapter(pingJiaAdapter);
    }
    private class PingjiaAdapter extends BaseAdapter {
        private List list = new ArrayList();
        private Context context;
        public PingjiaAdapter(Activity activity, List list) {
            this.list = list;
            this.context = activity;
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
            ViewHoder viewHoder = null;
            if (view==null){
                viewHoder = new ViewHoder();
                view = LayoutInflater.from(context).inflate(R.layout.home_dingzuo_xq_item1,null);
                viewHoder.tv1 = (TextView) view.findViewById(R.id.home_dingzuo_xq_nicheng);

                view.setTag(viewHoder);
            }else {
                viewHoder = (ViewHoder) view.getTag();
            }
            viewHoder.tv1.setText(list.get(i).toString());

            return view;
        }
        private class ViewHoder{
            TextView tv1;
        }
    }

    public static JiangHuPingFragment newInstance() {
        return new JiangHuPingFragment();
    }
}
