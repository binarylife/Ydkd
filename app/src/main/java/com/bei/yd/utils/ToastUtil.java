package com.bei.yd.utils;

import android.content.Context;
import android.widget.Toast;
import com.bei.yd.app.YDApp;

/**
 */
public class ToastUtil {
	public static void showNormalShortToast(Context context,
			CharSequence content) {
		//c
		Toast.makeText(YDApp.mContext, content, Toast.LENGTH_SHORT).show();
	}

	public static void showNormalLongToast(Context context, CharSequence content) {
		Toast.makeText(context, content, Toast.LENGTH_LONG).show();
	}

	public static void showNormalShortToast(Context context, int resid) {
		Toast.makeText(context, resid, Toast.LENGTH_SHORT).show();
	}

	public static void showNormalLongToast(Context context, int resid) {
		Toast.makeText(context, resid, Toast.LENGTH_LONG).show();
	}




	public static void showNormalShortToast(
											CharSequence content) {
		Toast.makeText(YDApp.mContext, content, Toast.LENGTH_SHORT).show();
	}

	public static void showNormalLongToast( CharSequence content) {
		Toast.makeText(YDApp.mContext, content, Toast.LENGTH_LONG).show();
	}

	public static void showNormalShortToast( int resid) {
		Toast.makeText(YDApp.mContext, resid, Toast.LENGTH_SHORT).show();
	}

	public static void showNormalLongToast( int resid) {
		Toast.makeText(YDApp.mContext, resid, Toast.LENGTH_LONG).show();
	}

//	public static void showImgToast(Context context, int background) {
//		showImgToast(context, background, 0, 0);
//	}


	public static void getJavaInfo() {
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getLineNumber()
				+ "-->"
				+ Thread.currentThread().getStackTrace()[1].getFileName());
	}
}
