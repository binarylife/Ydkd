package com.bei.yd.ui.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.bei.yd.R;
import com.bei.yd.widget.DialogBuilder;
import com.bei.yd.widget.LoadingDialog;

/**
 * fragment数据加载处理基类
 * Created by yuanwai on 2016/2/24.
 */
public abstract class BaseLoadFragment extends BaseFragment
    implements SwipeRefreshLayout.OnRefreshListener {

  protected boolean isLoading;
  private DialogBuilder.Builder builder;
  //    @Nullable
  //    @Bind(R.id.swipe)             SwipeRefreshLayout mSwipeRefreshLayout;
  /**
   * 主界面
   */
  @Nullable @Bind(android.R.id.empty) View mEmptyView;
  /**
   * 重试的文字提示
   */
  @Nullable @Bind(R.id.empty_text) TextView mEmptyText;
  /**
   * 重试按钮
   */
  @Nullable @Bind(R.id.empty_button) TextView mEmptyButton;

  private LoadingDialog loadingDialog;
  /**
   * 重试按钮监听
   */
  private View.OnClickListener reTryListener;

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onLoadData();
    reTryListener = new View.OnClickListener() {
      @Override public void onClick(View v) {
        onLoadData();
      }
    };
    //        if(mSwipeRefreshLayout!=null) mSwipeRefreshLayout.setOnRefreshListener(this);
  }

  @Override public void onRefresh() {//刷新数据
    onLoadData();
  }

  protected abstract void onLoadData();

  protected void stopRefresh() {
    //        if (mSwipeRefreshLayout != null) {
    //            mSwipeRefreshLayout.setRefreshing(false);//停止刷新
    //        }
  }

  //    protected void showLoad() {
  //        if (getActivity() == null) return;
  //        showLoad(getString(R.string.string_loading));
  //    }

  //    protected void showLoad(String str) {
  //        if (getActivity() == null) {
  //            return;
  //        }
  //        if (mEmptyView != null) {
  //            mEmptyView.setVisibility(View.VISIBLE);
  //        }
  //        if (mEmptyText != null) {
  //            mEmptyText.setText(R.string.string_loading);
  //        }
  //        if (mEmptyButton != null) {
  //            mEmptyButton.setVisibility(View.GONE);
  //        }
  //    }

  protected void showConnectionFail(String str) {
    if (mEmptyView != null) {
      mEmptyView.setVisibility(View.VISIBLE);
    }
    if (mEmptyButton != null) {
      mEmptyButton.setVisibility(View.VISIBLE);
      mEmptyButton.setOnClickListener(reTryListener);
    }
    if (mEmptyText != null && !TextUtils.isEmpty(str)) {
      mEmptyText.setText(str);
    }
  }

  /**
   * 显示加载进度Dialog
   */
  public void showProgressDialog(Context context) {
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
   * 确定取消 对话框 自定义标题
   */
  public void showMutiDialog(String content, String title, DialogBuilder.ClickCallbak callbak) {
    if (builder == null) {
      builder = new DialogBuilder.Builder(getActivity());
    }
    builder.setMutilBtn("确定", "取消", callbak);
    builder.setDialogContent(content);
    builder.setDialogTitle(title);
    builder.create().show();
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

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    if (loadingDialog != null && loadingDialog.isShowing()) {
      loadingDialog.dismiss();
    }
  }
}
