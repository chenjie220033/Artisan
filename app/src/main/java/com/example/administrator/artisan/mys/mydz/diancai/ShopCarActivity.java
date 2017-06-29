package com.example.administrator.artisan.mys.mydz.diancai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.administrator.artisan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 * chen 2017-06-02
 *
 * */
public class ShopCarActivity extends AppCompatActivity {

    @BindView(R.id.shop_car_list)
    ListView shopCarList;
    private Unbinder bind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_car);
        bind = ButterKnife.bind(this);


    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
