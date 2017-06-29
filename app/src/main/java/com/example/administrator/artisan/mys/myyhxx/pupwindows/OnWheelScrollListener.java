package com.example.administrator.artisan.mys.myyhxx.pupwindows;

/**
 * chen
 * 时间选择器相关
 */
public interface OnWheelScrollListener {
	/**
	 *
	 * @param wheel the wheel view whose state has changed.
	 */
	void onScrollingStarted(WheelView wheel);
	
	/**
	 *
	 * @param wheel the wheel view whose state has changed.
	 */
	void onScrollingFinished(WheelView wheel);
}
