package com.bei.yd.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bei.yd.R;

/**
 * @author renxiaomin
 */
public class DialogBuilder extends Dialog {

  public DialogBuilder(Context context) {
    super(context);
  }

  public DialogBuilder(Context context, int theme) {
    super(context, theme);
  }

  /**
   * Helper class for creating a custom dialog
   */
  public static class Builder {

    private Context context;
    private String positiveButtonText;
    private View.OnClickListener positiveButtonClickListener;
    private String cancelButtonText;
    private View.OnClickListener cancelButtonClickListener;
    private String content;
    private String title;
    private ClickCallbak clickCallbak;
    private boolean isCancle = true;
    /**
     * 是否取消dialog
     */
    private boolean dismiss = true;

    public boolean isDismiss() {
      return dismiss;
    }

    public void setDismiss(boolean dismiss) {
      this.dismiss = dismiss;
    }

    public void setCancle(boolean isCancle) {
      this.isCancle = isCancle;
    }

    public Builder(Context context) {
      this.context = context;
    }

    /**
     * Set the positive button text and it's listener
     */
    public Builder setPositiveButton(String positiveButtonText, View.OnClickListener listener) {
      this.positiveButtonText = positiveButtonText;
      this.positiveButtonClickListener = listener;
      return this;
    }

    public Builder setCancelButton(String cancelButtonText, View.OnClickListener listener) {
      this.cancelButtonText = cancelButtonText;
      this.cancelButtonClickListener = listener;
      return this;
    }

    public Builder setMutilBtn(String positiveButtonText, String cancelButtonText,
        ClickCallbak clickCallbak) {
      this.clickCallbak = clickCallbak;
      this.positiveButtonText = positiveButtonText;
      this.cancelButtonText = cancelButtonText;
      return this;
    }

    public Builder setDialogContent(String content) {
      this.content = content;
      return this;
    }

    public Builder setDialogTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setDialogTitle(String title, String content) {
      this.title = title;
      this.content = content;
      return this;
    }

    /**
     * Create the custom dialog
     */
    public DialogBuilder create() {
      final DialogBuilder dialog = new DialogBuilder(context, R.style.Dialog);
      View layout = LayoutInflater.from(context).inflate(R.layout.common_dialog_layout, null);
      Button cancelButton = (Button) layout.findViewById(R.id.btn_cancel);
      Button positiveButton = (Button) layout.findViewById(R.id.btn_confirm);
      TextView tv_dialog_content = (TextView) layout.findViewById(R.id.tv_dialog_content);
      TextView tv_dialog_title = (TextView) layout.findViewById(R.id.tv_dialog_title);
      if (!TextUtils.isEmpty(title)) {
        tv_dialog_title.setText(title);
      }
      if (!TextUtils.isEmpty(content)) {
        tv_dialog_content.setText(content);
      }
      if (!TextUtils.isEmpty(positiveButtonText)) {
        positiveButton.setText(positiveButtonText);
        positiveButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
            if (dismiss) {
              dialog.dismiss();
            }
            if (positiveButtonClickListener != null) {
              positiveButtonClickListener.onClick(v);
            }
            if (clickCallbak != null) {
              clickCallbak.onConfirm();
            }
          }
        });
      } else {
        positiveButton.setVisibility(View.GONE);
      }
      if (!TextUtils.isEmpty(cancelButtonText)) {
        cancelButton.setText(cancelButtonText);
        cancelButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
            dialog.dismiss();
            if (cancelButtonClickListener != null) {
              cancelButtonClickListener.onClick(v);
            }
            if (clickCallbak != null) {
              clickCallbak.onCancle();
            }
          }
        });
      } else {
        cancelButton.setVisibility(View.GONE);
      }
      dialog.setCancelable(isCancle);
      dialog.setContentView(layout);
      return dialog;
    }
  }

  public interface ClickCallbak {
    public void onConfirm();

    public void onCancle();
  }
}
