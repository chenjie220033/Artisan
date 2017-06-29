package com.example.administrator.artisan.mores.tieba.gouwu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/6/21.
 * 购物  适配器
 */

public class GouWuAdapter1 extends BaseAdapter {
    private Context context;
    private List<String> list = new ArrayList<String>();

    public GouWuAdapter1(Context context, List<String> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.gouwu_gridview_item, null);
            viewHoder.tv1 = (TextView) view.findViewById(R.id.home_gouwu_shangpinmingcheng);
            viewHoder.tv2 = (TextView) view.findViewById(R.id.home_gouwu_shangpinjiage);
            viewHoder.imageView = (ImageView) view.findViewById(R.id.home_gouwu_shangpintupian);
            viewHoder.tv3 = (TextView) view.findViewById(R.id.gouwu_btn_lijigoumai);
            view.setTag(viewHoder);
        } else {
            viewHoder = (ViewHoder) view.getTag();
        }
        viewHoder.tv1.setText(list.get(i).toString());
        viewHoder.tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,GouWuXiangQingActivity.class);
                intent.putExtra("mingcheng",list.get(i).toString());
                context.startActivity(intent);
//
            }
        });
        return view;
    }

    class ViewHoder {
        TextView tv1,tv2,tv3;
        ImageView imageView;
    }
}
