package com.example.administrator.artisan.Homes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mores.tieba.gouwu.GouWuAdapter1;
import com.example.administrator.artisan.mores.tieba.gouwu.GouWuXiangQingActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class HomeGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> list = new ArrayList<String>();

    public HomeGridViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
       ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new ViewHoder();
            view = LayoutInflater.from(context).inflate(R.layout.home_gridview_item, null);
            viewHoder.tv1 = (TextView) view.findViewById(R.id.home_gridview_title);
            viewHoder.tv2 = (TextView) view.findViewById(R.id.home_gridview_yishou);
            viewHoder.imageView = (ImageView) view.findViewById(R.id.home_gridview_tupian);
            view.setTag(viewHoder);
        } else {
            viewHoder = (ViewHoder) view.getTag();
        }
        viewHoder.tv1.setText(list.get(i).toString());
        //字体加横线
        viewHoder.tv2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        return view;
    }

    class ViewHoder {
        TextView tv1,tv2;
        ImageView imageView;
    }
}
