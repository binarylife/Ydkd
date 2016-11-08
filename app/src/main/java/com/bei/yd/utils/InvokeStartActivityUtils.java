package com.bei.yd.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bei.yd.ui.base.activity.BaseActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者: wwd
 * 创建日期:16/5/4
 * 类的功能描述:执行跳转的类
 */
public class InvokeStartActivityUtils {
  public static void startActivity(Context context, Class<?> cls, Bundle bundle, boolean isFinish) {
    startActivity(context, cls, bundle, isFinish, 0);
  }

  public static void startActivity(Context context, Class<?> cls, Bundle bundle, boolean isFinish,
      int flag) {
    Intent intent = new Intent(context, cls);
    if (bundle != null) intent.putExtras(bundle);
    if (flag > 0) {
      intent.setFlags(flag);
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      context.startActivity(intent,
          ActivityOptions.makeSceneTransitionAnimation((BaseActivity) context).toBundle());
    } else {
      context.startActivity(intent);
    }
    if (isFinish) {
      ((BaseActivity) context).finish();
    }
  }

  public static void startActivityForResult(Activity activity, Class<?> cls, Bundle bundle,
      int requestCode) {
    Intent intent = new Intent(activity, cls);
    if (bundle != null) intent.putExtras(bundle);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      activity.startActivityForResult(intent, requestCode,
          ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
    } else {
      activity.startActivityForResult(intent, requestCode);
    }
  }

  /**
   * 拨打电话
   *
   * @param tel 电话号码
   */

  public static void startTel(Context context, String tel) {
    if (TextUtils.isEmpty(tel)) {
      ToastUtil.showNormalShortToast("暂无电话");
    } else {
      context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel)));
    }
  }

  public static <T> Observable<T> applySchedulers(Observable<T> observable) {
    return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }

  public static final Observable.Transformer schedulersTransformer = new Observable.Transformer() {
    @Override public Object call(Object observable) {
      return ((Observable) observable).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread());
    }
  };

  public static <T> Observable.Transformer<T, T> applySchedulers() {
    return (Observable.Transformer<T, T>) schedulersTransformer;
  }

  /**
   * 得到transformer实例
   *
   * @return transformer
   */
  public static Observable.Transformer getTransformer() {
    return applySchedulers();
  }
}
