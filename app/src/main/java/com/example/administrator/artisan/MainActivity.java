package com.example.administrator.artisan;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    @BindView(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;
    private Unbinder bind;
    private HomeFrame homeFrame;
    private ShopingFrame shopingFrame;
    private AttentionFrame attentionFrame;
    private MyFrame myFrame;
//    private MoreFrame moreFrame;
    private Fragment mCurrentFragment;
    private int mBackKeyPressedTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //默认不弹出小键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        initView();
    }

    private void initView() {
//        设置导航选择的监听事件
        bottomBar.setOnTabSelectListener(this);
    }

    private void switchfragment(Fragment target) {
        // add show hide的方式

        if (mCurrentFragment == target) return;
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        if (target.isAdded()) {
            // 如果已经添加到FragmentManager里面，就展示
            transaction.show(target);
        } else {
            // 为了方便找到Fragment，我们是可以设置Tag
            String tag;
            if (target instanceof TextFrame) {
                tag = ((TextFrame) target).getArgumentText();
            } else {

                // 把类名作为tag
                tag = target.getClass().getName();
            }

            // 添加Fragment并设置Tag
            transaction.add(R.id.main_framelayout, target, tag);
        }

        transaction.commit();
        mCurrentFragment = target;
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                if (homeFrame == null) {
                    homeFrame = HomeFrame.newInstance();
                }
                switchfragment(homeFrame);
                break;
            case R.id.tab_shoping:
                if (shopingFrame == null) {
                    shopingFrame = ShopingFrame.newInstance();
                }
                switchfragment(shopingFrame);
                break;
            case R.id.tab_attention:
                if (attentionFrame == null) {
                    attentionFrame = AttentionFrame.newInstance();
                }
                switchfragment(attentionFrame);
                break;
            case R.id.tab_my:
                if (myFrame == null) {
                    myFrame = MyFrame.newInstance();
                }
                switchfragment(myFrame);
                break;
//            case R.id.tab_more:
//                if (moreFrame == null) {
//                    moreFrame = MoreFrame.newInstance();
//                }
//                switchfragment(moreFrame);
//                break;

            default:
                throw new UnsupportedOperationException("unsuppor");

        }

    }

    // 处理返回键
    @Override
    public void onBackPressed() {

        if (mCurrentFragment != homeFrame) {

            // 如果不是在首页，就切换首页上
            bottomBar.selectTabWithId(R.id.tab_home);
            return;
        } else {
            // 是首页，连点关闭关闭，退到后台运行
            if (mBackKeyPressedTimes == 0) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mBackKeyPressedTimes = 1;
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            mBackKeyPressedTimes = 0;
                        }
                    }
                }.start();
                return;
            } else {
                finish();
            }
            return;
        }
    }

    @Override
    protected void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
