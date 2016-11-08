package com.bei.yd.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bei.yd.R;

/**
 * 进度条的Dialog
 * Created by xmren on 9/10/2015.
 */
public class LoadingDialog extends Dialog {
  /**
   * layoutParam
   */
  private WindowManager.LayoutParams layoutParams;
  /**
   * 加载的文字
   */
  private TextView loadtext;
  /**
   * 图片
   */
  private ImageView pb_loding;

  /**
   * Dialog
   */
  public LoadingDialog(Context context) {
    super(context, R.style.Dialog);
    init(true);
  }

  /**
   * 初始化Dialog
   *
   * @param outside 点击外边是否关闭
   */
  public LoadingDialog(Context context, boolean outside) {
    super(context, R.style.Dialog);
    init(outside);

    //		//设置返回键和触摸不取消
    //		OnKeyListener onKeyListener = new DialogInterface.OnKeyListener(){
    //			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
    //				if (keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0){
    //					return true;
    //				} else {
    //					return false;
    //				}
    //			}
    //		};
    //		this.setOnKeyListener(onKeyListener);
    //		this.setCanceledOnTouchOutside(false);
  }

  /**
   * 设置属性
   */
  private void init(boolean outside) {
    setCanceledOnTouchOutside(outside);
    this.setContentView(R.layout.custom_dialog);
    layoutParams = this.getWindow().getAttributes();
    layoutParams.gravity = Gravity.CENTER;
    layoutParams.dimAmount = 0; // 去背景遮盖
    layoutParams.alpha = 1.0f;
    this.getWindow().setAttributes(layoutParams);
    loadtext = (TextView) this.findViewById(R.id.tv_msg);
    pb_loding = (ImageView) this.findViewById(R.id.pb_loding);
    //pb_loding.setBackgroundResource(R.drawable.net_loading);
  }

  @Override public void show() {
    super.show();
    if (pb_loding != null) {
      AnimationDrawable animationDrawable = (AnimationDrawable) pb_loding.getBackground();
      //			animationDrawable.isRunning()
      animationDrawable.start();
    }
  }

  @Override public void onWindowFocusChanged(boolean hasFocus) {
    if (!hasFocus) {
      dismiss();
    }
  }

  public void setLoadText(String content) {
    loadtext.setText(content);
  }

  public void setLoadText(int titleResid) {
    loadtext.setText(titleResid);
  }

  /**
   * 设置文字颜色
   */
  public void setLoadTextColor(int color) {
    loadtext.setTextColor(color);
  }

  /**
   * 设置背景变暗的程度,默认透明
   * 1.0表示完全不透明，0.0表示没有变暗。
   */
  public void setDimAmount(float dimAmount) {
    layoutParams = this.getWindow().getAttributes();
    layoutParams.dimAmount = dimAmount;
    this.getWindow().setAttributes(layoutParams);
  }
}