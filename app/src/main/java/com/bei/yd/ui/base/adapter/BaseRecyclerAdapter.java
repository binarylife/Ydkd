package com.bei.yd.ui.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * recyclerView适配器基类
 * Created by yuanwai on 16/2/19.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 数据集合
     */
    protected List<T> mItems;
    protected Context mContext;

    /**
     * 构造函数
     *
     * @param context
     */
    public BaseRecyclerAdapter(Context context) {
        this.mContext = context;
        mItems = new ArrayList<>();
    }

    /**
     * 返回数据集
     *
     * @return
     */
    public List<T> getList() {
        return mItems;
    }

    /**
     * 添加单条数据
     *
     * @param item
     */
    public void addItem(T item) {
        if (item == null) return;
        mItems.add(mItems.size(), item);
        notifyItemInserted(mItems.size());
    }

    /**
     * 追加数据集合
     *
     * @param items
     */
    public void addItems(List<T> items) {
        if (items == null) return;
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    public boolean containsAll(List<T> items) {
        return mItems.containsAll(items);
    }

    /**
     * 更新指定行数据
     *
     * @param tasks
     * @param position
     */
    public void updateItem(T tasks, int position) {
        if (tasks == null) return;
        mItems.set(position, tasks);
        notifyItemChanged(position);
    }

    /**
     * 更新全部数据
     *
     * @param items
     */
    public void updateItems(List<T> items) {
        if (items == null) return;
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * 移除指定行数据
     *
     * @param index
     */
    public void removeItem(int index) {
        mItems.remove(index);
        notifyItemRemoved(index);
    }

    public void getView(int position, RecyclerView.ViewHolder viewHolder, int type, T item) {
    }

    /**
     * 返回指定行数据
     *
     * @param location
     * @return
     */
    public T getItem(int location) {
//        java.lang.IndexOutOfBoundsException: Invalid index 0, size is 0
//        at java.util.ArrayList.throwIndexOutOfBoundsException(ArrayList.java:255)
//        at java.util.ArrayList.get(ArrayList.java:308)
//        at com.baidai.baidaitravel.ui.base.adapter.BaseRecyclerAdapter.getItem(BaseRecyclerAdapter.java:103)
        if (mItems == null || mItems.isEmpty()) {
            return null;
        } else {
            return mItems.get(location);
        }
    }

    /**
     * 返回数据集合总数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    /**
     * 清除全部数据
     */
    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }
}
