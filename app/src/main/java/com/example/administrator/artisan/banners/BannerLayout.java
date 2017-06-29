package com.example.administrator.artisan.banners;

import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.example.administrator.artisan.R;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Administrator on 2017/4/19.
 */

//自定义的轮播图控件
public class BannerLayout extends RelativeLayout {
    @BindView(R.id.pager_banner)
    ViewPager mPagerBanner;
    @BindView(R.id.indicator)
    CircleIndicator mIndicator;
    private static final long duration = 4000;
    private CyclingHandler mCyclingHandler;
    private Timer mCycleTimer;
    private TimerTask mCycleTask;
    private long mResumecycleTime;

    public BannerLayout(Context context) {
        super(context);
        init(context);
    }

    public BannerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BannerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    //    布局的填充和初始化
    private void init(Context context) {
//        merge标签一定要设置ViewGroup和attachToRoot为true
        LayoutInflater.from(context).inflate(R.layout.widget_banner_layout, this, true);
        ButterKnife.bind(this);
        mCyclingHandler = new CyclingHandler(this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        在视图显示出来的时候
//        计时器
        mCycleTimer = new Timer();
        //                定时的发送一些事件:使用Handler来发送并且处理
        mCycleTask = new TimerTask() {
            @Override
            public void run() {
//                定时的发送一些事件:使用Handler来发送并且处理
                mCyclingHandler.sendEmptyMessage(0);

            }
        };
//        执行(事件，延时时间，循环时间)
        mCycleTimer.schedule(mCycleTask, duration, duration);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
//        取消我们开启的计时任务
        mCycleTimer.cancel();
        mCycleTask.cancel();
        mCycleTimer = null;
        mCycleTask = null;
    }

    //首先获取触摸的时间
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mResumecycleTime = System.currentTimeMillis() + duration;

        return super.dispatchTouchEvent(ev);
    }

    //    切换到下一页的方法
    public void moveToNextPosition() {
//        看有没有适配器
        if (mPagerBanner.getAdapter() == null) {
            throw new IllegalStateException("you need set a banner adapter");

        }
//        看适配器是不是有数据
        int count = mPagerBanner.getAdapter().getCount();
        if (count == 0) return;
//        看是不是展示的最后一条
        if (mPagerBanner.getCurrentItem() == count - 1) {
//      切换到0,不设置平滑滚动
            mPagerBanner.setCurrentItem(0, false);
        } else {
            mPagerBanner.setCurrentItem(mPagerBanner.getCurrentItem() + 1, true);
        }

    }

    //    设置适配器
    public void setAdapter(BannerAdapter adapter) {
        mPagerBanner.setAdapter(adapter);
        mIndicator.setViewPager(mPagerBanner);
        adapter.registerDataSetObserver(mIndicator.getDataSetObserver());


    }

    //    为了防止内部类持有外部类的引用而造成内存泄漏，所以用静态内部类和弱引用
    private static class CyclingHandler extends android.os.Handler {
        private WeakReference<BannerLayout> mBannerReference;

        public CyclingHandler(BannerLayout banner) {
            mBannerReference = new WeakReference<BannerLayout>(banner);
        }


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            接收到消息，处理轮播图切换到下一页
            if (mBannerReference == null)
                return;
            BannerLayout bannerLayout = mBannerReference.get();
            if (bannerLayout == null) return;
//            触摸之后时间没过4秒，不去轮播
            if (System.currentTimeMillis() < bannerLayout.mResumecycleTime) {
                return;
            }
//            切换到下一页
            bannerLayout.moveToNextPosition();
        }
    }

}