package com.example.administrator.artisan.mys.wdjf.wojf;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.artisan.Homes.HomeGridViewAdapter;
import com.example.administrator.artisan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chen on 2017/6/20.
 * 我的  我的积分商城   热门
 */
public class MyReMenJiFenFragment extends Fragment {

    @BindView(R.id.my_jifenshangcheng_remen)
    ListView myJifenshangchengRemen;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jifen_remen, null);
        bind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        List<String> list1 = new ArrayList<String>();
        for (int i = 1; i < 11; i++) {
            list1.add("花生油");
        }
        MyReMenJiFenAdapter myReMenJiFenAdapter = new MyReMenJiFenAdapter(getActivity(), list1);
        myJifenshangchengRemen.setAdapter(myReMenJiFenAdapter);
        myJifenshangchengRemen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),MyJiFenXQActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        if (this.bind != null) {
            this.bind.unbind();
        }
        super.onDestroy();
    }

    public static MyReMenJiFenFragment newInstance() {
        return new MyReMenJiFenFragment();
    }

}
