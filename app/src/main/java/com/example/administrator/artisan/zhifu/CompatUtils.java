package com.example.administrator.artisan.zhifu;

import android.content.Context;

/**
 * chen
 * 自定义CheckBox   动画效果
 * 描述 : 工具类
 */
public class CompatUtils {
    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}