package com.bei.yd.ui.base.view;

/**
 * 界面操作接口基类
 * Created by HETI on 2016/3/1.
 */
public interface IBaseView {

    /**
     * 显示进度条
     */
    void showProgress();
    /**
     * 隐藏进度条
     */
    void hideProgress();
    /**
     * 显示错误界面
     */
    void showLoadFailMsg(String msg);
}
