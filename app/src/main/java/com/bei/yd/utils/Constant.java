package com.bei.yd.utils;

import android.os.Environment;
import com.bei.yd.api.IApiConfig;

/**
 * 各个页面需要使用的常量
 * Created by fb on 5/7/16.
 */
public class Constant implements IApiConfig {
  /**
   * bundle key 1
   */
  public static final String BUNDLE_KEY_1 = "Bundle_key_1";
  /**
   * bundle key 2
   */
  public static final String BUNDLE_KEY_2 = "Bundle_key_2";
  /**
   * bundle key 3
   */
  public static final String BUNDLE_KEY_3 = "Bundle_key_3";
  /**
   * bundle key 4
   */
  public static final String BUNDLE_KEY_4 = "Bundle_key_4";
  /**
   * bundle key 5
   */
  public static final String BUNDLE_KEY_5 = "Bundle_key_5";
  /**
   * bundle key 6
   */
  public static final String BUNDLE_KEY_6 = "Bundle_key_6";
  /**
   * 判断是否显示收藏、评论、首页布局
   */
  public static final String BUNDLE_KEY_7 = "isShowContainer";
  /**
   * bundle key 10
   */
  public static final String BUNDLE_KEY_10 = "Bundle_key_10";

  /**
   * APP首页进入搜索(搜索接口)
   */
  public static final int ASKTYPE_APP_MAIN_SEARCH = 1;
  /**
   * 目的地首页进入搜索(搜索接口)
   */
  public static final int ASKTYPE_DESTINATION_MAIN_SEARCH = 2;
  /**
   * 列表页面进入的搜索(搜索接口)
   */
  public static final int ASKTYPE_ARTICLE_LIST_SEARCH = 3;
  /**
   * 列表请求列表数据接口（文章列表接口）
   */
  public static final int ASKTYPE_ARTICLE_LIST = 4;
  /**
   * 文章详情标签点击的列表请求type
   */
  public static final int ASKTYPE_ARTICLE_DETAIL_TAG = 5;
  /**
   * 列表界面的筛选功能
   */
  public static final int ASKTYPE_ARTICLE_LIST_TAG = 6;
  /**
   * 工单列表页面的id
   * 接收类型 int
   */
  public static final String ORDER_ID = BUNDLE_KEY_1;
  /**
   * 工单创建者
   */
  public static final String ORDER_CREATER = BUNDLE_KEY_2;
  /**
   * 工单接受者
   */
  public static final String ORDER_RECIVIER = BUNDLE_KEY_3;
  /**
   * 景点列表页面跳转到详情页面直接启动播放器
   * <p/>
   * boolean标识
   */
  public static final String SCENERYDIZ_ACTIVITY_ISPLAY = BUNDLE_KEY_4;
  /**
   * 搜索页面的BundleKEY_asktype
   *
   * @see #ASKTYPE_APP_MAIN_SEARCH 首页所搜索进入时传入的值
   * @see #ASKTYPE_ARTICLE_LIST_SEARCH 列表页面进入时传入的值
   * @see #ASKTYPE_DESTINATION_MAIN_SEARCH 目的地首页进入搜索页面传入的值
   */
  public static final String SEARCH_ACTIVITY_BUNDLE_KEY_ASKTYPE = BUNDLE_KEY_1;
  /**
   * 搜索页面的BundleKEY_product
   * 如果是列表页面进入的搜索页面，需要传入product参数
   *
   * @see #PRODUCT_SCENIC 景点列表页进入时要传入的参数
   */
  public static final String SEARCH_ACTIVITY_BUNDLE_KEY_PRODUCT = BUNDLE_KEY_2;
  /**
   * 门票页面的BundleKEY_productid
   */
  public static final String TICKET_ACTIVITY_BUNDLE_KEY_PRODUCTID = BUNDLE_KEY_1;
  /**
   * 门票页面的BundleKEY_productTYPE
   */
  public static final String TICKET_ACTIVITY_BUNDLE_KEY_PRODUCTTYPE = BUNDLE_KEY_2;
}
