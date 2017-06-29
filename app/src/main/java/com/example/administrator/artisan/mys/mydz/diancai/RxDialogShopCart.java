package com.example.administrator.artisan.mys.mydz.diancai;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.administrator.artisan.R;
import com.example.administrator.artisan.utils.ActivityUtils;

/**
 *
 * chen 2017-06-02
 * 外卖 购物车
 * */
public class RxDialogShopCart extends Dialog implements View.OnClickListener,ShopCartInterface {

    private LinearLayout linearLayout,clearLayout;
    private RelativeLayout bottomLayout;
    private FrameLayout shopingcartLayout;
    private ModelShopCart mModelShopCart;
    private TextView totalPriceTextView;
    private TextView totalPriceNumTextView;
    private RecyclerView recyclerView;
    private AdapterPopupDish dishAdapter;
    private ShopCartDialogImp shopCartDialogImp;
    private Button gouwu_jiesuan_button;
    public RxDialogShopCart(Context context, ModelShopCart modelShopCart, int themeResId) {
        super(context,themeResId);
        this.mModelShopCart = modelShopCart;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_popupview);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        clearLayout = (LinearLayout)findViewById(R.id.clear_layout);
        shopingcartLayout = (FrameLayout)findViewById(R.id.shopping_cart_layout);
        bottomLayout = (RelativeLayout)findViewById(R.id.shopping_cart_bottom);
        gouwu_jiesuan_button = (Button)findViewById(R.id.gouwu_jiesuan_button);
        totalPriceTextView = (TextView)findViewById(R.id.shopping_cart_total_tv);
        totalPriceNumTextView = (TextView)findViewById(R.id.shopping_cart_total_num);
        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        shopingcartLayout.setOnClickListener(this);
        bottomLayout.setOnClickListener(this);
        clearLayout.setOnClickListener(this);
        gouwu_jiesuan_button.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dishAdapter = new AdapterPopupDish(getContext(), mModelShopCart);
        recyclerView.setAdapter(dishAdapter);
        dishAdapter.setShopCartInterface(this);
        showTotalPrice();
    }

    @Override
    public void show() {
        super.show();
        animationShow(500);
    }

    @Override
    public void dismiss() {
        animationHide(500);
    }

    private void showTotalPrice(){
        if(mModelShopCart !=null && mModelShopCart.getShoppingTotalPrice()>0){
            totalPriceTextView.setVisibility(View.VISIBLE);
            gouwu_jiesuan_button.setVisibility(View.VISIBLE);
            totalPriceTextView.setText("¥ "+ mModelShopCart.getShoppingTotalPrice());
            totalPriceNumTextView.setVisibility(View.VISIBLE);
            totalPriceNumTextView.setText(""+ mModelShopCart.getShoppingAccount());

        }else {
            totalPriceTextView.setVisibility(View.GONE);
            gouwu_jiesuan_button.setVisibility(View.GONE);
            totalPriceNumTextView.setVisibility(View.GONE);
        }
    }

    private void animationShow(int mDuration) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(linearLayout, "translationY",1000, 0).setDuration(mDuration)
        );
        animatorSet.start();
    }

    private void animationHide(int mDuration) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(linearLayout, "translationY",0,1000).setDuration(mDuration)
        );
        animatorSet.start();

        if(shopCartDialogImp!=null){
            shopCartDialogImp.dialogDismiss();
        }

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                RxDialogShopCart.super.dismiss();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shopping_cart_bottom:
            case R.id.shopping_cart_layout:
                this.dismiss();
                break;
            case R.id.clear_layout:
                clear();
                break;
        }
    }

    @Override
    public void add(View view, int postion) {
        showTotalPrice();
    }

    @Override
    public void remove(View view, int postion) {
        showTotalPrice();
        if(mModelShopCart.getShoppingAccount()==0){
            this.dismiss();
        }
    }

    public ShopCartDialogImp getShopCartDialogImp() {
        return shopCartDialogImp;
    }

    public void setShopCartDialogImp(ShopCartDialogImp shopCartDialogImp) {
        this.shopCartDialogImp = shopCartDialogImp;
    }

    public interface ShopCartDialogImp{
        public void dialogDismiss();
    }

    public void clear(){
        mModelShopCart.clear();
        showTotalPrice();
        if(mModelShopCart.getShoppingAccount()==0){
            this.dismiss();
        }
    }
}
