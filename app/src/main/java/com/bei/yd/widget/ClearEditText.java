package com.bei.yd.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.bei.yd.R;
import com.bei.yd.utils.DeviceUtils;

/**
 * 带一键清除功能的editText
 * Created by fengbei on 2016/7/12.
 */

public class ClearEditText extends EditText
    implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {
  private Drawable mClearTextIcon;
  private OnFocusChangeListener mOnFocusChangeListener;
  private OnTouchListener mOnTouchListener;


  public ClearEditText(final Context context) {
    super(context);
    init(context);
  }

  public ClearEditText(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public ClearEditText(final Context context, final AttributeSet attrs,
      final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  /**
   * 创建drawable，并为其加入Touch、Focus事件处理
   * 加入TextChangedListener，监听EditText内容变化
   */
  private void init(final Context context) {
    final Drawable drawable =
        ContextCompat.getDrawable(context, R.drawable.search_close_ico);
    final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
    //DrawableCompat.setTint(wrappedDrawable, getCurrentHintTextColor());
    mClearTextIcon = wrappedDrawable;
    mClearTextIcon.setBounds(0, 0, DeviceUtils.dip2px(context,18),
        DeviceUtils.dip2px(context,18));
    setClearIconVisible(false);
    super.setOnTouchListener(this);
    super.setOnFocusChangeListener(this);
    addTextChangedListener(this);
  }

  /**
   * 隐藏清除按钮
   * @param visible
   */
  private void setClearIconVisible(final boolean visible) {
    mClearTextIcon.setVisible(visible, false);
    final Drawable[] compoundDrawables = getCompoundDrawables();
    setCompoundDrawables(compoundDrawables[0], compoundDrawables[1],
        visible ? mClearTextIcon : null, compoundDrawables[3]);
  }

  @Override
  public void setOnFocusChangeListener(final OnFocusChangeListener onFocusChangeListener) {
    mOnFocusChangeListener = onFocusChangeListener;
  }

  @Override
  public void setOnTouchListener(final OnTouchListener onTouchListener) {
    mOnTouchListener = onTouchListener;
  }

  @Override
  public void onFocusChange(final View view, final boolean hasFocus) {
    if (hasFocus) {
      //在获取焦点时，判断输入框中内容是否大于0，有内容则显示清除按钮。
      setClearIconVisible(getText().length() > 0);
    } else {
      setClearIconVisible(false);
    }
    if (mOnFocusChangeListener != null) {
      mOnFocusChangeListener.onFocusChange(view, hasFocus);
    }
  }

  @Override
  public boolean onTouch(final View view, final MotionEvent motionEvent) {
    final int x = (int) motionEvent.getX();
    if (mClearTextIcon.isVisible() && x > getWidth() - getPaddingRight() - mClearTextIcon.getIntrinsicWidth()) {
      if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
        setText("");
      }
      return true;
    }
    return mOnTouchListener != null && mOnTouchListener.onTouch(view, motionEvent);
  }

  /**
   * 内容变化监听
   * @param s
   * @param start
   * @param before
   * @param count
   */
  @Override
  public final void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
    if (isFocused()) {
      setClearIconVisible(s.length() > 0);
    }
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
  }

  @Override
  public void afterTextChanged(Editable s) {
  }
}