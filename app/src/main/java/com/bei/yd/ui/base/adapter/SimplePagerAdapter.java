package com.bei.yd.ui.base.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager Adapter基类
 * Created by yuanwai on 2016/3/15.
 */
public class SimplePagerAdapter<T> extends PagerAdapter {

    /**
     * 数据集
     */
    private List<T> list = new ArrayList<T>();

    /**
     * 无参构造函数
     */
    public SimplePagerAdapter() {
    }

    /**
     * 有参构造函数，传入数据集
     * @param list
     */
    public SimplePagerAdapter(List<T> list) {
        setList(list);
    }

    /**
     * 返回数据集
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 为Adapter设置数据集
     * @param list
     */
    public void setList(List<T> list) {
        if (list == null) return;
        this.list = list;
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
        return arg0 == arg1;
    }

    /**
     * 返回数据总数
     *
     * @return 数量
     */
    @Override
    public int getCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        } else {
            return 0;
        }
    }

    /**
     * 移除ItemView
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    /**
     * 把Item加入到ViewPager中
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = getItemView(container, position);
        container.addView(view);
        return view;
    }

    /**
     *
     * @param container
     * @param position
     * @return
     */
    public View getItemView(ViewGroup container, int position) {

        return new View(container.getContext());
    }

    /**
     * 返回索引项的数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        return list.get(position);
    }

    /**
     * 返回索引页的标题
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
