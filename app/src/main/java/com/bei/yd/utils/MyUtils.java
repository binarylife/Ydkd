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
import com.bei.yd.R;
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
  public static int getBackgroundByType(int type){
    switch (type){
      case Constant.TYPE_NEW:
        return R.drawable.bg_chartreuse_light;
      case Constant.TYPE_ONE_PAI:
        return R.drawable.bg_blue_light;
      case Constant.TYPE_TWO_PAI:
        return R.drawable.bg_orange_light;
      case Constant.TYPE_TWO_PAI_TWO:
        return R.drawable.bg_saffron_light;
      case Constant.TYPE_CHULIZHONG:
        return R.drawable.bg_pale_red;
      case Constant.TYPE_VISITED:
        return R.drawable.bg_green_light;
      case Constant.TYPE_OVER:
        return R.drawable.bg_purple_light;
      default:
        return R.drawable.bg_main_item;
    }
  }
  public static String getTextByType(int type){
    switch (type){
      case Constant.TYPE_NEW:
        return "新建工单";
      case Constant.TYPE_ONE_PAI:
        return "一级派单";
      case Constant.TYPE_TWO_PAI:
        return "二级派单";
      case Constant.TYPE_TWO_PAI_TWO:
        return "二级二次派单";
      case Constant.TYPE_CHULIZHONG:
        return "处理中";
      case Constant.TYPE_VISITED:
        return "回访中";
      case Constant.TYPE_OVER:
        return "结束";
      default:
        return "工单";
    }
  }
  public static int getNorBackgroundByType(int type){
    switch (type){
      case Constant.TYPE_ONE_PAI://  新建工单
        return R.drawable.bg_blue_light;
      case Constant.TYPE_TWO_PAI:  //  派单
        return R.drawable.bg_orange_light;
      case Constant.TYPE_TWO_PAI_TWO://  处理中
        return R.drawable.bg_saffron_light;
      case Constant.TYPE_CHULIZHONG:
        return R.drawable.bg_pale_red;// 回访中
      case Constant.TYPE_VISITED:// 结束
        return R.drawable.bg_green_light;
      default:
        return R.drawable.bg_main_item;
    }
  }
  public static String getNorTextByType(int type){
    switch (type){
      case Constant.TYPE_ONE_PAI:
        return "新建工单";
      case Constant.TYPE_TWO_PAI:
        return "派单中";
      case Constant.TYPE_TWO_PAI_TWO:
        return "处理中";
      case Constant.TYPE_CHULIZHONG:
        return "回访中";
      case Constant.TYPE_VISITED:
        return "结束";
      default:
        return "未知状态";
    }
  }
}
