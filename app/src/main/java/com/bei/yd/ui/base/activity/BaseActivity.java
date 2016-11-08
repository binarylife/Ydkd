package com.bei.yd.ui.base.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bei.yd.R;
import com.umeng.analytics.MobclickAgent;

/**
 * Acitvity基类
 * Created by yuanwai on 16/2/19.
 */
public abstract class BaseActivity extends AppCompatActivity {
  //Toolbar自定义布局时，左边有空白：http://stackoverflow.com/questions/32086148/when-add-a-custom-view-in-android-toolbar-there-will-be-a-marginleft
  //StatusBar的颜色通过Activity的Theme来定义自动适应，Toolbar也可以
  /**
   *
   */
  @Nullable @Bind(R.id.toolbar) protected Toolbar toobar;
  /**
   * 无数据时显示的View
   */
  //    @Nullable
  //    @Bind(android.R.id.empty)
  protected View mEmptyView;
  /**
   * 无数据显示的信息TV
   */
  //    @Nullable
  //    @Bind(R.id.empty_text)
  TextView mEmptyText;
  //    /**
  //     * 无数据的Layout
  //     */
  //    @Nullable
  //    @Bind(R.id.empty_load)
  //    View mEmptyLoad;
  /**
   * 无数据的Button
   */
  //    @Nullable
  //    @Bind(R.id.empty_button)
  TextView mEmptyButton;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
    mEmptyView = findViewById(android.R.id.empty);
    mEmptyText = (TextView) findViewById(R.id.empty_text);
    mEmptyButton = (TextView) findViewById(R.id.empty_button);
    //        showStatusBar(false);
  }


  public void onResume() {
    super.onResume();
    //使用集成测试服务
    //        MobclickAgent.setDebugMode(true);
  }

  public void onPause() {
    super.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
    //BaiDaiApp.getRefWatcher(this).watch(this);
  }

}