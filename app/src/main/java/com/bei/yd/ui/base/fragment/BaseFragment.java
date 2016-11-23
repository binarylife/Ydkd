package com.bei.yd.ui.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Fragment基类
 * Created by yuanwai on 16/2/18.
 */
public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

//    @Nullable
//    @Bind(R.id.swipe)
//    SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentResouceId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        dealLogicBeforeInitView();
        super.onViewCreated(view, savedInstanceState);
        dealLogicAfterInitView(view);
    }

    //返回布局id
    public abstract int getContentResouceId();

    //界面初始化之前调用
    public abstract void dealLogicBeforeInitView();

    //界面初始化之后调用
    public abstract void dealLogicAfterInitView(View view);

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        //内存检测工具释放
    }
}
