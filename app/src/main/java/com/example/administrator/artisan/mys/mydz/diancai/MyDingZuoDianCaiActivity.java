package com.example.administrator.artisan.mys.mydz.diancai;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.artisan.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * chen 2017-06-02
 * 外卖
 */
public class MyDingZuoDianCaiActivity extends AppCompatActivity implements AdapterLeftMenu.onItemSelectedListener, ShopCartInterface, RxDialogShopCart.ShopCartDialogImp {
    private final static String TAG = "MainActivity";
    private RecyclerView leftMenu;//左侧菜单栏
    private RecyclerView rightMenu;//右侧菜单栏
    private TextView headerView;
    private LinearLayout headerLayout;//右侧菜单栏最上面的菜单
    private RelativeLayout bottomLayout;
    private ModelDishMenu headMenu;
    private AdapterLeftMenu leftAdapter;
    private AdapterRightDish rightAdapter;
    private ArrayList<ModelDishMenu> mModelDishMenuList;//数据源
    private boolean leftClickType = false;//左侧菜单点击引发的右侧联动
    private ModelShopCart mModelShopCart;

    private ImageView shoppingCartView;
    private FrameLayout shopingCartLayout;
    private TextView totalPriceTextView;
    private TextView totalPriceNumTextView;
    private LinearLayout mainLayout;
    //    private Button gouwu_jiesuan_button;
    private RxDialogShopCart dialog;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dingz_diancai);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initData();
        initView();
        initAdapter();
    }


    private void initView() {
        mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        leftMenu = (RecyclerView) findViewById(R.id.left_menu);
        rightMenu = (RecyclerView) findViewById(R.id.right_menu);
        headerView = (TextView) findViewById(R.id.right_menu_tv);
        headerLayout = (LinearLayout) findViewById(R.id.right_menu_item);
//        fakeAddImageView = (RxFakeAddImageView)findViewById(R.id.right_dish_fake_add);
        bottomLayout = (RelativeLayout) findViewById(R.id.shopping_cart_bottom);
//        gouwu_jiesuan_button = (Button) findViewById(gouwu_jiesuan_button);
        shoppingCartView = (ImageView) findViewById(R.id.shopping_cart);
        shopingCartLayout = (FrameLayout) findViewById(R.id.shopping_cart_layout);
        totalPriceTextView = (TextView) findViewById(R.id.shopping_cart_total_tv);
        totalPriceNumTextView = (TextView) findViewById(R.id.shopping_cart_total_num);

        leftMenu.setLayoutManager(new LinearLayoutManager(this));
        rightMenu.setLayoutManager(new LinearLayoutManager(this));

        rightMenu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(1) == false) {//无法下滑
                    showHeadView();
                    return;
                }
                View underView = null;
                if (dy > 0)
                    underView = rightMenu.findChildViewUnder(headerLayout.getX(), headerLayout.getMeasuredHeight() + 1);
                else
                    underView = rightMenu.findChildViewUnder(headerLayout.getX(), 0);
                if (underView != null && underView.getContentDescription() != null) {
                    int position = Integer.parseInt(underView.getContentDescription().toString());
                    ModelDishMenu menu = rightAdapter.getMenuOfMenuByPosition(position);

                    if (leftClickType || !menu.getMenuName().equals(headMenu.getMenuName())) {
                        if (dy > 0 && headerLayout.getTranslationY() <= 1 && headerLayout.getTranslationY() >= -1 * headerLayout.getMeasuredHeight() * 4 / 5 && !leftClickType) {// underView.getTop()>9
                            int dealtY = underView.getTop() - headerLayout.getMeasuredHeight();
                            headerLayout.setTranslationY(dealtY);
//                            Log.e(TAG, "onScrolled: "+headerLayout.getTranslationY()+"   "+headerLayout.getBottom()+"  -  "+headerLayout.getMeasuredHeight() );
                        } else if (dy < 0 && headerLayout.getTranslationY() <= 0 && !leftClickType) {
                            headerView.setText(menu.getMenuName());
                            int dealtY = underView.getBottom() - headerLayout.getMeasuredHeight();
                            headerLayout.setTranslationY(dealtY);
//                            Log.e(TAG, "onScrolled: "+headerLayout.getTranslationY()+"   "+headerLayout.getBottom()+"  -  "+headerLayout.getMeasuredHeight() );
                        } else {
                            headerLayout.setTranslationY(0);
                            headMenu = menu;
                            headerView.setText(headMenu.getMenuName());
                            for (int i = 0; i < mModelDishMenuList.size(); i++) {
                                if (mModelDishMenuList.get(i) == headMenu) {
                                    leftAdapter.setSelectedNum(i);
                                    break;
                                }
                            }
                            if (leftClickType) leftClickType = false;
                            Log.e(TAG, "onScrolled: " + menu.getMenuName());
                        }
                    }
                }
            }
        });

        shopingCartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCart(view);
            }
        });
    }

    private void initData() {
        mModelShopCart = new ModelShopCart();
        mModelDishMenuList = new ArrayList<>();
        ArrayList<ModelDish> dishs1 = new ArrayList<>();
        dishs1.add(new ModelDish("面包", 1.0, 10));
        dishs1.add(new ModelDish("蛋挞", 1.0, 10));
        dishs1.add(new ModelDish("牛奶", 1.0, 10));
        dishs1.add(new ModelDish("肠粉", 1.0, 10));
        dishs1.add(new ModelDish("绿茶饼", 1.0, 10));
        dishs1.add(new ModelDish("花卷", 1.0, 10));
        dishs1.add(new ModelDish("包子", 1.0, 10));
        ModelDishMenu breakfast = new ModelDishMenu("早点", dishs1);

        ArrayList<ModelDish> dishs2 = new ArrayList<>();
        dishs2.add(new ModelDish("粥", 1.0, 10));
        dishs2.add(new ModelDish("炒饭", 1.0, 10));
        dishs2.add(new ModelDish("炒米粉", 1.0, 10));
        dishs2.add(new ModelDish("炒粿条", 1.0, 10));
        dishs2.add(new ModelDish("炒牛河", 1.0, 10));
        dishs2.add(new ModelDish("炒菜", 1.0, 10));
        ModelDishMenu launch = new ModelDishMenu("午餐", dishs2);

        ArrayList<ModelDish> dishs3 = new ArrayList<>();
        dishs3.add(new ModelDish("淋菜", 1.0, 10));
        dishs3.add(new ModelDish("川菜", 1.0, 10));
        dishs3.add(new ModelDish("湘菜", 1.0, 10));
        dishs3.add(new ModelDish("粤菜", 1.0, 10));
        dishs3.add(new ModelDish("赣菜", 1.0, 10));
        dishs3.add(new ModelDish("东北菜", 1.0, 10));
        ModelDishMenu evening = new ModelDishMenu("晚餐", dishs3);

        ArrayList<ModelDish> dishs4 = new ArrayList<>();
        dishs4.add(new ModelDish("淋菜", 1.0, 10));
        dishs4.add(new ModelDish("川菜", 1.0, 10));
        dishs4.add(new ModelDish("湘菜", 1.0, 10));
        dishs4.add(new ModelDish("湘菜", 1.0, 10));
        dishs4.add(new ModelDish("湘菜1", 1.0, 10));
        dishs4.add(new ModelDish("湘菜2", 1.0, 10));
        dishs4.add(new ModelDish("湘菜3", 1.0, 10));
        dishs4.add(new ModelDish("湘菜4", 1.0, 10));
        dishs4.add(new ModelDish("湘菜5", 1.0, 10));
        dishs4.add(new ModelDish("湘菜6", 1.0, 10));
        dishs4.add(new ModelDish("湘菜7", 1.0, 10));
        dishs4.add(new ModelDish("湘菜8", 1.0, 10));
        dishs4.add(new ModelDish("粤菜", 1.0, 10));
        dishs4.add(new ModelDish("赣菜", 1.0, 10));
        dishs4.add(new ModelDish("东北菜", 1.0, 10));
        ModelDishMenu menu1 = new ModelDishMenu("夜宵", dishs4);

        mModelDishMenuList.add(breakfast);
        mModelDishMenuList.add(launch);
        mModelDishMenuList.add(evening);
        mModelDishMenuList.add(menu1);
    }

    private void initAdapter() {
        leftAdapter = new AdapterLeftMenu(this, mModelDishMenuList);
        rightAdapter = new AdapterRightDish(this, mModelDishMenuList, mModelShopCart);
        rightMenu.setAdapter(rightAdapter);
        leftMenu.setAdapter(leftAdapter);
        leftAdapter.addItemSelectedListener(this);
        rightAdapter.setShopCartInterface(this);
        initHeadView();
    }

    private void initHeadView() {
        headMenu = rightAdapter.getMenuOfMenuByPosition(0);
        headerLayout.setContentDescription("0");
        headerView.setText(headMenu.getMenuName());
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
        leftAdapter.removeItemSelectedListener(this);

    }

    private void showHeadView() {
        headerLayout.setTranslationY(0);
        View underView = rightMenu.findChildViewUnder(headerView.getX(), 0);
        if (underView != null && underView.getContentDescription() != null) {
            int position = Integer.parseInt(underView.getContentDescription().toString());
            ModelDishMenu menu = rightAdapter.getMenuOfMenuByPosition(position + 1);
            headMenu = menu;
            headerView.setText(headMenu.getMenuName());
            for (int i = 0; i < mModelDishMenuList.size(); i++) {
                if (mModelDishMenuList.get(i) == headMenu) {
                    leftAdapter.setSelectedNum(i);
                    break;
                }
            }
        }
    }

    @Override
    public void onLeftItemSelected(int position, ModelDishMenu menu) {
        int sum = 0;
        for (int i = 0; i < position; i++) {
            sum += mModelDishMenuList.get(i).getModelDishList().size() + 1;
        }
        LinearLayoutManager layoutManager = (LinearLayoutManager) rightMenu.getLayoutManager();
        layoutManager.scrollToPositionWithOffset(sum, 0);
        leftClickType = true;
    }

    @Override
    public void add(View view, int position) {
        int[] addLocation = new int[2];
        int[] cartLocation = new int[2];
        int[] recycleLocation = new int[2];
        view.getLocationInWindow(addLocation);
        shoppingCartView.getLocationInWindow(cartLocation);
        rightMenu.getLocationInWindow(recycleLocation);

        PointF startP = new PointF();
        PointF endP = new PointF();
        PointF controlP = new PointF();

        startP.x = addLocation[0];
        startP.y = addLocation[1] - recycleLocation[1];
        endP.x = cartLocation[0];
        endP.y = cartLocation[1] - recycleLocation[1];
        controlP.x = endP.x;
        controlP.y = startP.y;

        final RxFakeAddImageView rxFakeAddImageView = new RxFakeAddImageView(this);
        mainLayout.addView(rxFakeAddImageView);
        rxFakeAddImageView.setImageResource(R.drawable.gouwuche_2);
        rxFakeAddImageView.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.item_dish_circle_size);
        rxFakeAddImageView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.item_dish_circle_size);
        rxFakeAddImageView.setVisibility(View.VISIBLE);
        ObjectAnimator addAnimator = ObjectAnimator.ofObject(rxFakeAddImageView, "mPointF",
                new RxPointFTypeEvaluator(controlP), startP, endP);
        addAnimator.setInterpolator(new AccelerateInterpolator());
        addAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                rxFakeAddImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                rxFakeAddImageView.setVisibility(View.GONE);
                mainLayout.removeView(rxFakeAddImageView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ObjectAnimator scaleAnimatorX = new ObjectAnimator().ofFloat(shoppingCartView, "scaleX", 0.6f, 1.0f);
        ObjectAnimator scaleAnimatorY = new ObjectAnimator().ofFloat(shoppingCartView, "scaleY", 0.6f, 1.0f);
        scaleAnimatorX.setInterpolator(new AccelerateInterpolator());
        scaleAnimatorY.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleAnimatorX).with(scaleAnimatorY).after(addAnimator);
        animatorSet.setDuration(800);
        animatorSet.start();

        showTotalPrice();
    }

    @Override
    public void remove(View view, int position) {
        showTotalPrice();
    }

    private void showTotalPrice() {
        if (mModelShopCart != null && mModelShopCart.getShoppingTotalPrice() > 0) {
            totalPriceTextView.setVisibility(View.VISIBLE);
            totalPriceTextView.setText("¥ " + mModelShopCart.getShoppingTotalPrice());
            totalPriceNumTextView.setVisibility(View.VISIBLE);
            totalPriceNumTextView.setText("" + mModelShopCart.getShoppingAccount());

        } else {
            totalPriceTextView.setVisibility(View.GONE);
            totalPriceNumTextView.setVisibility(View.GONE);
        }
    }

    private void showCart(View view) {
        if (mModelShopCart != null && mModelShopCart.getShoppingAccount() > 0) {
            dialog = new RxDialogShopCart(this, mModelShopCart, R.style.cartdialog);
            Window window = dialog.getWindow();
            dialog.setShopCartDialogImp(this);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);
            dialog.show();
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.BOTTOM;
            params.dimAmount = 0.5f;
            window.setAttributes(params);

        }
    }

    @Override
    public void dialogDismiss() {
        showTotalPrice();
        rightAdapter.notifyDataSetChanged();
    }


    @OnClick(R.id.my_youhuimaidan_fh)
    public void onViewClicked() {
        finish();
    }
}
