package com.example.administrator.artisan.Homes.dingzuo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.artisan.R;
import com.example.administrator.artisan.mores.tieba.gouwu.GouWuXiangQingActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/6/28.
 * 订座列表适配器
 */

public class HomeYouHuiLBAdapter extends BaseAdapter {
    private List list = new ArrayList();
    private Context context;
    public HomeYouHuiLBAdapter(Activity activity, List list) {
        this.context = activity;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHorder viewHorder = null;
        if (view==null){
            viewHorder = new ViewHorder();
            view = LayoutInflater.from(context).inflate(R.layout.youhui_liebiao_item,null);
            viewHorder.tv1 = (TextView) view.findViewById(R.id.youhui_liebiao_ljxz);
            view.setTag(viewHorder);
        }else {
            viewHorder = (ViewHorder) view.getTag();
        }
        viewHorder.tv1.setText(list.get(i).toString());
        viewHorder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,HomeYouHuiXQActivity.class);
//                intent.putExtra("mingcheng",list.get(i).toString());
                context.startActivity(intent);
            }
        });
        return view;
    }
    class ViewHorder{
      TextView tv1;
    }
}
