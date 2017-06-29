package com.example.administrator.artisan.mys.wdjf.wojf;

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

import com.example.administrator.artisan.Homes.HomeGridViewAdapter;
import com.example.administrator.artisan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class MyReMenJiFenAdapter extends BaseAdapter {
    private Context context;
    private List<String> list = new ArrayList<String>();

    public MyReMenJiFenAdapter(Context context, List<String> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.my_myjf_jfsc_remen_item, null);

            viewHoder.tv1 = (TextView) view.findViewById(R.id.titles);
            viewHoder.tv2 = (TextView) view.findViewById(R.id.jifen_remen_duihuan);
            view.setTag(viewHoder);
        } else {
            viewHoder = (ViewHoder) view.getTag();
        }
        viewHoder.tv1.setText(list.get(i).toString());
        viewHoder.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,JiFenDuiHuanActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }

    class ViewHoder {
        TextView tv1,tv2;
    }
}
