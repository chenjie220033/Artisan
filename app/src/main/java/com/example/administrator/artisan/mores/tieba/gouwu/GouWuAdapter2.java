package com.example.administrator.artisan.mores.tieba.gouwu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/6/21.
 * 购物  适配器
 */

public class GouWuAdapter2 extends BaseAdapter {
    private Context context;
    private List<String> list = new ArrayList<String>();

    public GouWuAdapter2(Context context, List<String> list) {
        this.context = context;
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
        ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new ViewHoder();
            view = LayoutInflater.from(context).inflate(R.layout.gouwu_listview_item, null);
            viewHoder.tv1 = (TextView) view.findViewById(R.id.gouwu_list_text);
            view.setTag(viewHoder);
        } else {
            viewHoder = (ViewHoder) view.getTag();
        }
        viewHoder.tv1.setText(list.get(i).toString());
        return view;
    }

    class ViewHoder {
        TextView tv1;
    }
}
