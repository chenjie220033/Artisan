package com.example.administrator.artisan.mys.mydz.diancai;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 *
 * chen 2017-06-02
 *外卖点餐 相关类
 * */
public class RxFakeAddImageView extends ImageView {
    private PointF mPointF;

    public RxFakeAddImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RxFakeAddImageView(Context context) {
        super(context);
    }

    public RxFakeAddImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RxFakeAddImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setMPointF(PointF pointF) {
        setX(pointF.x);
        setY(pointF.y);
    }

    public PointF getmPointF() {
        return mPointF;
    }

    public void setmPointF(PointF mPointF) {
        setX(mPointF.x);
        setY(mPointF.y);
    }
}
