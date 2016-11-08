/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.bei.yd.utils;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;
import com.bei.yd.app.YDApp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class MyUtils {

  public static void dynamicSetTabLayoutMode(TabLayout tabLayout) {
    int tabWidth = calculateTabWidth(tabLayout);
    int screenWidth = getScreenWith();

    if (tabWidth <= screenWidth) {
      tabLayout.setTabMode(TabLayout.MODE_FIXED);
    } else {
      tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
  }

  private static int calculateTabWidth(TabLayout tabLayout) {
    int tabWidth = 0;
    for (int i = 0; i < tabLayout.getChildCount(); i++) {
      final View view = tabLayout.getChildAt(i);
      view.measure(0, 0); // 通知父view测量，以便于能够保证获取到宽高
      tabWidth += view.getMeasuredWidth();
    }
    return tabWidth;
  }

  public static int getScreenWith() {
    return YDApp.mContext.getResources().getDisplayMetrics().widthPixels;
  }

  public static View getRootView(Activity context) {
    return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
  }

  /**
   * 格式化日期
   */
  public static String getTime(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    return format.format(date);
  }

  /**
   * 将时间戳准换成日期格式
   *
   * @throws ParseException
   */
  String changeToDate(String string) throws ParseException {
    long l = Long.parseLong(string);
    return getTime(new Date(l));
  }
}
