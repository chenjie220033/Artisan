package com.example.administrator.artisan.mys.wdjf.wojf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.artisan.R;
import com.example.administrator.artisan.zhifu.SmoothCheckBox;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class JiFenDuiHuanActivity extends AppCompatActivity {

    private Unbinder bind;
    @BindView(R.id.jifen_duihuan_list)
    ListView myListView;
    @BindView(R.id.jifen_duihuan_qrdh)
    Button button;
    private MyAdapter myAdapter;
    private ArrayList<Boolean> checkList = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_fen_dui_huan);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        setListViewHeightBasedOnChildren(myListView);
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    public void checkPosition(final int position) {
        for (int i = 0; i < checkList.size(); i++) {
            if (position == i) {
                checkList.set(i, true);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(JiFenDuiHuanActivity.this, myAdapter.getItem(position) + "", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                checkList.set(i, false);
            }
        }
        myAdapter.notifyDataSetChanged();
    }


    private void initView() {
        final ArrayList list = new ArrayList();
        for (int i = 1; i < 11; i++) {
            list.add("修改地址" + i);
            checkList.add(false);
        }
        myAdapter = new MyAdapter(getApplicationContext(), list);
        myListView.setAdapter(myAdapter);

    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        ArrayList<String> myList;

        public MyAdapter(Context context, ArrayList<String> myList) {
            this.inflater = LayoutInflater.from(context);
            this.myList = myList;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return myList.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return myList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Log.i("aaa", "getview");
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.shouhuo_dizhi_item, null);
                holder = new ViewHolder();
                holder.txt = (TextView) convertView.findViewById(R.id.shouhuo_dizhi_xgdz);
                holder.checkBox = (SmoothCheckBox) convertView
                        .findViewById(R.id.shouhuo_dizhi_box);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.txt.setText(myList.get(position).toString());
            holder.txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(JiFenDuiHuanActivity.this, "修改地址" + position, Toast.LENGTH_SHORT).show();
                }
            });
            holder.checkBox.setChecked(checkList.get(position));
            holder.checkBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                    if (isChecked) {
                        checkPosition(position);
                    } else {
                        checkList.set(position, false);
                    }
                }
            });

            convertView.setOnClickListener(new View.OnClickListener() {//item�������е�ѡ����

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    checkPosition(position);
                }
            });


            return convertView;
        }

        final class ViewHolder {
            TextView txt;
            SmoothCheckBox checkBox;
        }
    }

    @Override
    protected void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
