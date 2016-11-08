package com.bei.yd.ui.base.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.bei.yd.widget.DialogBuilder;
import com.bei.yd.widget.LoadingDialog;

/**
 * Created by yuanwai on 16/2/19.
 */
public abstract class BackBaseActivity extends BaseActivity {
  /**
   * 标题栏的标题
   */
  //@Nullable @Bind(R.id.toolbar_title_TV) TextView toobarTitleTV;
  /**
   *
   */
  private LoadingDialog loadingDialog;
  /**
   * 弹出的Dialog
   */
  DialogBuilder.Builder builder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //注册监听处理网络事件
    //if (!EventBus.getDefault().isRegistered(this)) {
    //  EventBus.getDefault().register(this);
    //}
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    //if (EventBus.getDefault().isRegistered(this)) {
    //  EventBus.getDefault().unregister(this);
    //}
    if (loadingDialog != null && loadingDialog.isShowing()) {
      loadingDialog.dismiss();
    }
    //if (builder != null && !builder.isDismiss()) {
    //  builder.setDismiss(true);
    //}
  }

  /**
   * 设置标题栏的标题
   */
  public void setToolbarTitle(String title) {
    //if (toobarTitleTV != null) {
    //  toobarTitleTV.setText(title);
    //}
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      this.onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }

  protected void addFragment(Class<? extends Fragment> cls, int layoutId, boolean isToback) {
    try {
      Fragment fragment = cls.newInstance();
      addFragment(fragment, cls.getName(), layoutId, isToback);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void addFragment(Class<? extends Fragment> cls, int layoutId, boolean isToback,
      Bundle bundle) {
    try {
      Fragment fragment = cls.newInstance();
      fragment.setArguments(bundle);
      addFragment(fragment, cls.getName(), layoutId, isToback);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void addFragment(Fragment frg, String tag, int layoutId, boolean isToback) {
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    Fragment fragment = getFragmentManager().findFragmentByTag(tag);
    if (fragment == null) {
      ft.replace(layoutId, frg, tag);
    } else {
      ft.replace(layoutId, fragment, tag);
    }

    if (isToback) {
      ft.addToBackStack(frg.getClass().getName());
    }
    ft.commitAllowingStateLoss();
  }

  public void goBack() {
    if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
      getSupportFragmentManager().popBackStackImmediate();
    } else {
      finish();
    }
  }

  protected abstract void onLoadData();

  protected void stopRefresh() {
    //        if (mSwipeRefreshLayout != null) {
    //            mSwipeRefreshLayout.setRefreshing(false);//停止刷新
    //        }
  }

  protected void showLoad() {
    if (this == null) return;
    showLoad("加载中...");
  }

  protected void showLoad(String str) {
    if (this == null) return;
    if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
    //        if (mEmptyLoad != null) mEmptyLoad.setVisibility(View.VISIBLE);
    //        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.VISIBLE);
    if (mEmptyText != null) mEmptyText.setText("");
    if (mEmptyButton != null) mEmptyButton.setVisibility(View.GONE);
  }

  protected void showConnectionFail() {
    if (this == null) return;
    showConnectionFail("加载失败");
  }

  protected void showConnectionFail(String str) {
    showConnectionRetry();
  }

  protected void showConnectionRetry() {
    if (this == null) return;
    showConnectionRetry("重新连接");
  }

  protected void showConnectionRetry(String str) {
    if (this == null) return;
    if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
    if (mEmptyButton != null) {
      mEmptyButton.setVisibility(View.VISIBLE);
      mEmptyButton.setOnClickListener(mOnClickListener);
    }
  }

  /**
   * 显示加载进度Dialog
   */
  public void showProgressDialog(Context context) {
    showProgressDialog(context, true);
  }

  /**
   * 显示加载进度Dialog
   *
   * @param cancel 是否可以取消，true 可取消，false不可取消
   */
  public void showProgressDialog(Context context, boolean cancel) {
    if (loadingDialog == null) {
      loadingDialog = new LoadingDialog(context, false);
    }
    if (!loadingDialog.isShowing()) {
      loadingDialog.show();
    }
  }

  /**
   * 延迟时间, 隐藏加载进度Dialog
   */
  public void dismissProgressDialog(long delayMillis) {
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        dismissProgressDialog();
      }
    }, delayMillis);
  }

  /**
   * 隐藏加载进度Dialog
   */
  public void dismissProgressDialog() {
    if (loadingDialog != null && loadingDialog.isShowing()) {
      loadingDialog.dismiss();
      loadingDialog = null;
    }
  }

  protected void hideEmptyView() {
    if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
  }

  protected View.OnClickListener mOnClickListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      onLoadData();
    }
  };

  /**
   * 确定取消 对话框
   */
  public void showMutiDialog(String content, DialogBuilder.ClickCallbak callbak) {
    if (builder == null) {
      builder = new DialogBuilder.Builder(this);
    }
    builder.setMutilBtn("确定", "取消", callbak);
    builder.setDialogContent(content);
    builder.create().show();
  }

  /**
   * 确定取消 对话框 自定义标题
   */
  public void showMutiDialog(String content, String title, DialogBuilder.ClickCallbak callbak) {
    if (builder == null) {
      builder = new DialogBuilder.Builder(this);
    }
    builder.setMutilBtn("确定","取消", callbak);
    builder.setDialogContent(content);
    builder.setDialogTitle(title);
    builder.create().show();
  }

  /**
   * 确定取消 对话框 自定义标题
   */
  //public void showMutiDialogCallphone(String content, String title,
  //    DialogBuilder.ClickCallbak callbak) {
  //  if (builder == null) {
  //    builder = new DialogBuilder.Builder(this);
  //  }
  //  builder.setMutilBtn(getString(R.string.ok_callphone), getString(R.string.comment_cancel),
  //      callbak);
  //  builder.setDialogContent(content);
  //  builder.setDialogTitle(title);
  //  builder.create().show();
  //}

  /**
   * 确定取消 对话框 自定义标题
   */
  public void showMutiDialog(String content, String title, String submitName, String cacelName,
      DialogBuilder.ClickCallbak callbak) {
    if (builder == null) {
      builder = new DialogBuilder.Builder(this);
    }
    if (TextUtils.isEmpty(cacelName)) {
      builder.setCancle(false);
      builder.setDismiss(false);
    }
    builder.setMutilBtn(submitName, cacelName, callbak);
    builder.setDialogContent(content);
    builder.setDialogTitle(title);
    builder.create().show();
  }
}
