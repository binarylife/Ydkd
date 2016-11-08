package com.bei.yd.ui.base.adapter;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * 简单的ViewPagerAdapter，输入View，挨个显示
 */
public class SimpleViewPagerAdapter extends PagerAdapter {
    /**
     * 界面列表
     */
    private List<View> views;

    /**
     * viewPage的简单的Adapter，传入Views,再挨个显示
     *
     * @param views
     */
    public SimpleViewPagerAdapter(List<View> views) {

        this.views = views;

    }

    /**
     * 获得当前界面数
     *
     * @return 数量
     */
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    /**
     * 判断是否由对象生成界面
     *
     * @param arg0
     * @param arg1
     * @return 是否是同一个对象
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    /**
     * 异常销毁再重建的方法
     *
     * @param arg0
     * @param arg1
     */
    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    /**
     * 异常销毁时的存储方法
     *
     * @return
     */
    @Override
    public Parcelable saveState() {
        return null;
    }

    /**
     * 把Item加入到ViewPager中
     *
     * @param container viewPager
     * @param position  position
     * @return ItemView
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View current = views.get(position);
        container.addView(current);
        return current;

    }

    /**
     * 销毁ItemView
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    /**
     * 返回列表中的数据
     *
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /**
     * 返回某一页的标题
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return views.get(position).toString();
    }
}
