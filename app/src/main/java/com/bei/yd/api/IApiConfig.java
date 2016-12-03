package com.bei.yd.api;


/**
 * 应用Api配置文件
 * Created by yuanwai on 2016/3/7.
 */
public interface IApiConfig {

  /**
   * 无差别标签
   */
  String MARKER = 17 + "";

  /**
   * API地址
   */
  String BASE_URL = "http://www.ordos-edu.com/yd/" ;
  //String BASE_URL = "http://192.168.1.109/yd/" ;
  /**
   * H5地址
   */
  //String H5_BASE_URL = BaiDaiApp.mContext.getString(R.string.H5_URL);
  /**
   * 每页需要加载的个数
   */
  int PAGESIZE = 10;

  /*
   * 景点:scenicSpot
    * 酒店:hotel
	 * 购物:shop
	 * 餐饮:dish
	 * 娱乐:leisure
	 * 线路:travelLine
	 * 活动:activity
	 * 玩乐:play
	 * 火车票:Trains
	 * 机票:FlightDomestic
	 */
  /**
   * 新景点
   */
  String PRODUCT_SCENIC = "scenicSpot";
  /**
   * 酒店
   */
  String PRODUCT_HOTEL = "hotel";
  /**
   * 携程的 国际酒店
   */
  String PRODUCT_HOTELINTERNATE = "HotelInternate";
  /**
   * 携程的 国内酒店
   */
  String PRODUCT_HOTELDOMESTIC = "HotelDomestic";
  /**
   * 购物
   */
  String PRODUCT_SHOP = "shop";
  /**
   * 餐饮
   */
  String PRODUCT_DISH = "dish";
  /**
   * 娱乐
   */
  String PRODUCT_LEISURE = "leisure";
  /**
   * 线路
   */
  String PRODUCT_TRAVELLINE = "travelLine";

  /**
   * 活动
   */
  String PRODUCT_ACTIVITY = "activity";
  /**
   * 玩乐
   */
  String PRODUCT_PLAY = "play";
  /**
   * 火车票
   */
  String PRODUCT_TRAINS = "Trains";

  /**
   * 国际火车票
   */
  String PRODUCT_TRAININTERNAT = "TrainInternat";

  /**
   * 国内机票
   */
  String PRODUCT_FLIGHTDOMESTIC = "FlightDomestic";
  /**
   * 国际机票
   */

  String PRODUCT_FLIGHTINTERNATE = "FlightInternate";

  /**
   * 支付宝回调接口
   */
  String ALI_PAY_NOTIFY_URL = BASE_URL + "tradeApi/alipayBack.htm";
  /**
   * 交通
   */
  String PRODUCT_TRAFFIC = "traffic";
  /**
   * 加入购物车接口
   */
  String ADD_SHOPPING_CART = "shoppingCartApi/addShoppingCart.htm";
  /**
   * 购物车列表接口
   */
  String SHOPPING_CART_LIST = "shoppingCartApi/shoppingCartList.htm";

  /**
   * 填写订单接口
   */
  String SHOPPING_FILLIN_ORDER = "shoppingCartApi/getShoppingCartsByCartId.htm";
  /**
   * 删除购物车中的商品
   */
  String DELETE_SHOPPING_GOODS = "shoppingCartApi/delShoppingCart.htm";
  /**
   * 提交订单2.0
   */
  String SUMIT_ORDER_2 = "orderApi/createOrder.htm";
  /**
   * 购物车中的商品数量的变化
   */
  String SHOPPING_GOODS_CHANGENUM = "shoppingCartApi/addShoppingCart.htm";
  /**
   * 立即支付到填写订单的接口
   */
  String NOWPAY_TOBO_FILLINORDWER = "shoppingCartApi/getShoppingCartsByGoods.htm";
  /**
   * 商品详情获取购物车商品总数接口
   */
  String SHOPPING_CAR_GOODS_COUNT = "shoppingCartApi/getShoppingCartsGoodsCount.htm";
  /**
   * 景点-评论列表
   */
  String COMMENTAPI_COMMENTLIST = "commentApi/commentList.htm";
  /**
   * 景点-评论详情
   */
  String COMMENTAPI_COMMENTDETAIL = "commentApi/commentDetail.htm";
  /**
   * 景点-撰写评论
   */
  String COMMENTAPI_WRITECOMMENT = "commentApi/writeComment.htm";
  /**
   * 景点-回复评论
   */
  String COMMENTAPI_REPLYCOMMENT = "commentApi/replyComment.htm";

  /**
   * 获取默认地址
   */
  String RECEIVEADDRESSAPI_GETDEFAULTADDRESS = "receiveAddressApi/getDefaultAddress.htm";
  /**
   * 美食、玩乐、购物商家详情
   */
  String PRICEAPI_MERCHANTDETAIL = "priceApi/merchantDetail.htm";
  /**
   * 百代优选列表
   */
  String PRICEAPI_OPTIMALLIST = "priceApi/optimalList.htm";
  /**
   * 商品详情接口api
   */
  String PRICEAPI_OPTIMALDETAIL = "priceApi/optimalDetail.htm";
  /**
   * 获取美食、购物、娱乐的分类筛选条件的API
   */
  String FILTERAPI_FOODCLASS = "filterApi/foodClass.htm";
  /**
   * 获取活动的分类筛选条件
   */
  String FILTERAPI_ACTIVITYTYPE = "filterApi/activityType.htm";
  /**
   * 酒店详情
   */
  String PRICEAPI_HOTELDETAIL = "priceApi/hotelDetail.htm";
  /**
   * 酒店星级筛选数据接口
   */
  String FILTERAPI_HOTELSTAR = "filterApi/hotelStar.htm";
  /**
   * 用户注册
   */
  String MEMBER_REGISTER = "member/register.htm";
  /**
   * 普通登录
   */
  String MEMBER_LOGIN = "member/login.htm";
  /**
   * 三方登录
   */
  String MEMBER_OAUTH2 = "member/oauth2.htm";
  /**
   * 完善用户信息
   */
  String MEMBER_UPDATEBASEINFO = "member/updateBaseInfo.htm";
  /**
   * 发送验证码
   */
  String MEMBER_SENDVERIFICATIONCODE = "member/sendVerificationCode.htm";
  /**
   * 设置密码
   */
  String MEMBER_RESETPASSWORD = "member/resetPassword.htm";
  /**
   * 找回密码验证码校验
   */
  String MEMBER_CHECKVERIFICATIONCODE = "member/checkVerificationCode.htm";
  /**
   * 根据客户端授权的code获取token和openID
   */
  String MEMBER_WXTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
  /**
   * 根据token和OpenID获取用户基本信息
   */
  String MEMBER_WXUID = "https://api.weixin.qq.com/sns/userinfo";
  /**
   * 获取新浪的用户信息
   */
  String MEMBER_SINAUSERINFO = "https://api.weibo.com/2/users/show.json";
  /**
   * 获取新浪的用户信息
   */
  String MEMBER_GETMEMBERTAG = "member/getMemberTag.htm";
  /**
   * 修改兴趣标签
   */
  String MEMBER_UPDATETAG = "member/updateTag.htm";
  /**
   * 目的地城市列表接口
   */
  String ADVERTAPI_DESTINDEX = "advertApi/destIndex.htm";
  /**
   * 获取首页城市列表
   */
  String COUNTRYAPI_CITYLIST = "countryApi/cityList.htm";
  /**
   * 通过天气网获取天气数据
   */
  String WEATHERJSON = "http://open.weather.com.cn/data/";
  /**
   * 获取首页详情数据
   */
  String ADVERTAPI_ADVERTINDEX = "advertApi/advertIndex.htm";
  /**
   * 添加联系人收货地址
   */
  String RECEIVEADDRESSAPI_ADDADDRESS = "receiveAddressApi/addAddress.htm";
  /**
   * 根据地址id删除地址
   */
  String RECEIVEADDRESSAPI_DELADDRESS = "receiveAddressApi/delAddress.htm";
  /**
   * 根据token 获取地址列表
   */
  String RECEIVEADDRESSAPI_ADDRESSLIST = "receiveAddressApi/addressList.htm";
  /**
   * 添加联系人收货地址
   */
  String RECEIVEADDRESSAPI_MODIFYADDRESS = "receiveAddressApi/modifyAddress.htm";
  /**
   * 根据地址id设置默认地址
   */
  String RECEIVEADDRESSAPI_SETDEFAULTADDRESS = "receiveAddressApi/setDefaultAddress.htm";
  /**
   * 上传本地图片(申请退款)
   */
  String UPLOADAPI_UPLOAD = "uploadApi/upload.htm";
  /**
   * 获取退货订单数据
   */
  String RETURNORDERAPI_ENTITYRETURNINFO = "returnOrderApi/entityReturnInfo.htm";
  /**
   * 提交退货订单数据
   */
  String RETURNORDERAPI_RETURNENTITY = "returnOrderApi/returnEntity.htm";
  /**
   * 获取退货订单数据(虚拟订单)
   */
  String RETURNORDERAPI_DUMMYRETURNINFO = "returnOrderApi/dummyReturnInfo.htm";
  /**
   * 虚拟退款(虚拟订单)
   */
  String RETURNORDERAPI_RETURNDUMMY = "returnOrderApi/returnDummy.htm";
  /**
   * 拒绝退款后重新获取退单信息
   */
  String RETURNORDERAPI_GETRETURNENTITY = "returnOrderApi/getReturnEntity.htm";
  /**
   * 拒绝退款后重新提交退货信息
   */
  String RETURNORDERAPI_RERETURNENTITY = "returnOrderApi/reReturnEntity.htm";
  /**
   * 获取个人信息
   */
  String MEMBER_PERSONALDATA = "member/personalData.htm";
  /**
   * 更新头像
   */
  String MEMBER_UPDATEICON = "member/updateIcon.htm";
  /**
   * 获取省,市,县
   */
  String COUNTRYAPI_GETALL = "countryApi/getAll.htm";

  /**
   * 获取省,直辖市市级标签
   */
  String COUNTRYAPI_GETPROVINCE = "countryApi/getProvince.htm";
  /**
   * 获取县区级标签
   */
  String COUNTRYAPI_GETCHILDREN = "countryApi/getChildren.htm";

  /**
   * 查询退款进度接口
   */
  String RETURNORDERAPI_SELECTRETURNLOG = "returnOrderApi/selectReturnLog.htm";
  /**
   * 修改用户绑定手机
   */
  String MEMBER_UPDATEMOBILE = "member/updateMobile.htm";
  /**
   * 验证用户绑定手机
   */
  String MEMBER_CHECKCODEBINDMOBILE = "member/checkCodeBindMobile.htm";
  /**
   * 修改密码
   */
  String MEMBER_MODIFYPASSWORD = "member/modifyPassword.htm";
  /**
   * 用户提交建议
   */
  String MEMBER_PUBLISHOPINION = "member/publishOpinion.htm";
  /**
   * 提交物流退单信息
   */
  String RETURNORDERAPI_SAVELOGIS = "returnOrderApi/savelogis.htm";
  /**
   * 选择物流公司
   */
  String RETURNORDERAPI_GETLOGISTICCOMPANY = "returnOrderApi/getLogisticCompany.htm";
  /**
   * 详情页面接入地图
   */
  String MAPAPI_MAPDETAIL = "mapApi/mapDetail.htm";
  /**
   * 地图列表页进入请求接口
   */
  String MAPAPI_MAPLIST = "mapApi/mapList.htm";
  /**
   * 取消退款
   */
  String RETURNORDERAPI_CANCLERETURNENTITY = "returnOrderApi/cancleReturnEntity.htm";
  /**
   * 取消订单
   */
  String ORDERITEMAPI_CANCELORDER = "orderItemApi/cancelOrder.htm";
  /**
   * 商家核验
   */
  String ORDERITEMAPI_CHECKCOUPON = "orderItemApi/checkCoupon.htm";
  /**
   * 确认收货
   */
  String ORDERITEMAPI_COMPLETEORDER = "orderItemApi/completeOrder.htm";
  /**
   * 获取达人详情
   */
  String EXPERTAPI_EXPERTHOMEPAGE = "expertApi/expertHomePage.htm";
  /**
   * 我的足迹请求接口
   */
  String BEENPLACEAPI_BEENPLACELIST = "beenPlaceApi/beenPlaceList.htm";
  /**
   * 获取好友列表
   */
  String FOLLOWAPI_FOLLOWLIST = "followApi/followList.htm";
  /**
   * 删除关注达人
   */
  String FOLLOWAPI_CANCELFOLLOW = "followApi/cancelFollow.htm";
  /**
   * 查看收藏列表
   */
  String ARTICLEFAVAPI_ARTICLEFAVLIST = "articleFavApi/articleFavList.htm";
  /**
   * 取消收藏
   */
  String ARTICLEFAVAPI_CANCELARTICLEFAV = "articleFavApi/cancelArticleFav.htm";
  /**
   * 关注达人
   */
  String FOLLOWAPI_FOLLOW = "followApi/follow.htm";
  /**
   * 获取订单详情
   */
  String ORDERITEMAPI_ORDERDETAIL = "orderItemApi/orderDetail.htm";

  /**
   * 获取订单列表
   */
  String ORDERITEMAPI_LISTORDER = "orderItemApi/listOrder.htm";
  /**
   * 加载附近推荐
   */
  String ARTICLEAPI_NEARBYRECOMMEND = "articleApi/nearByRecommend.htm";
  /**
   * 跳转永乐页面需要城市首字母，需要先调接口查询
   * 根据城市名称，查询城市首字母
   */
  String THIRDORDERAPI_CHANGECITY = "thirdOrderApi/changeCity.htm";
  /**
   * 收藏文章
   */
  String ARTICLEFAVAPI_ARTICLEFAV = "articleFavApi/articleFav.htm";
  /**
   * 获取景区标签
   */
  String ARTICLEAPI_SCENICCONDITION = "articleApi/scenicCondition.htm";
  /**
   * 获取商圈TAG
   */
  String COUNTRYAPI_AREALIST = "countryApi/areaList.htm";
  /**
   * 获取文章详情
   */
  String ARTICLEAPI_ARTICLEDETAIL = "articleApi/articleDetail.htm";
  /**
   * 相关景点
   */
  String ARTICLEAPI_SUBPRODUCTSLIST = "articleApi/subProductsList.htm";
  /**
   * 文章详情页面点击去过
   */
  String BEENPLACEAPI_BEENPLACE = "beenPlaceApi/beenPlace.htm";
  /**
   * 门票详情页面
   */
  String PRICEAPI_PRICEDETAIL = "priceApi/priceDetail.htm";
  /**
   * APP首页搜索
   */
  String ARTICLEAPI_ARTICLELIST = "articleApi/articleList.htm";
  /**
   * 获取商户商品列表
   */
  String PRICEAPI_GOODSLIST = "priceApi/goodsList.htm";
  /**
   * 专题详情
   */
  String ADVERTAPI_THEMEDETAIL = "advertApi/themeDetail.htm";
  /**
   * 专题详情-往期回顾
   */
  String ADVERTAPI_THEMELIST = "advertApi/themeList.htm";
  /**
   * 专题详情-new
   */
  String ADVERTAPI_THEMEDETAILNEW = "advertApi/themeDetailNew.htm";
  /**
   * 行程推荐
   */
  String TRAVELLINEAPI_TRAVELLINELIST = "travelLineApi/travelLineList.htm";
  /**
   * 行程详情
   */
  String TRAVELLINEAPI_TRAVELLINEDETAIL = "travelLineApi/travelLineDetail.htm";
  /**
   * 检查更新的接口
   */
  String APPVERSIONAPI_GETVERSION = "appVersionApi/getVersion.htm";
  /**
   * 新订单详情接口
   */
  String ORDERAPI_ORDERDETAIL = "orderApi/orderDetail.htm";
  /**
   * 新订单列表接口
   */
  String ORDERAPI_ORDERLIST = "orderApi/orderList.htm";
  /**
   * 订单付款接口
   */
  String ORDERAPI_ORDERPAY = "orderApi/createPayBatch.htm";
  /**
   * 订单取消接口
   */
  String ORDERAPI_ORDERCANCEL = "orderApi/cancelOrder.htm";
  /**
   * 订单确认收货接口
   */
  String ORDERAPI_ORDERCONFIRMRECEIVE = "orderApi/completeOrder.htm";
  /**
   * 获取签名时间
   */
  String GET_SIGN_TIME = "tripOrder/getSignTime.htm";
  /**
   * 推送上传城市标签
   */
  String DEVICETOKEN = "appVersionApi/deviceToken.htm";
  /**
   * 用于签到接口
   */
  String SIGN_IN = "member/memberSign.htm";
  /**
   * 新版活动列表页
   */
  String ACTIVITY_ACTIVITYLIST = "activityApi/activityList.htm";
  /**
   * 新版活动详情
   */
  String ACTIVITY_ACTIVITYDETAIL = "activityApi/activityDetail.htm";

  /**
   * 新版景点详情
   */
  String ACTIVITY_NEWSCNERYDETAIL = "spotsArticleApi/spotsArticleDetail.htm";

  /**
   * 文章详情延展数据
   */
  String ARTICLE_EXTENSION = "spotsArticleApi/storeDetail.htm";
  /**
   * 用于校验是否签到接口
   */
  String CHECK_SIGN_IN = "member/getMemberSign.htm";
  /**
   * 社区中话题详情
   */
  String COMMUNITY_TOPIC_DETAIL = "communityApi/getTalkDetail.htm";
  /**
   * 社区中话题详情最新,最热
   */
  String COMMUNITY_TOPIC_STYLE = "communityApi/getLatestDy.htm";
  /**
   * 社区中活动详情(1投票活动,2报名活动)
   */
  String COMMUNITY_ACTIVITY_TOTAL = "communityApi/getActivityDetail.htm";
  /**
   * 社区中长文详情
   */
  String COMMUNITY_LONGARTICLEDETAIL = "communityApi/getStrategyDetail.htm";
  /**
   * 社区中投票活动
   */
  String COMMUNITY_ACTIVITY_VOTE = "communityApi/activityVote.htm";
  /**
   * 社区中报名活动
   */
  String COMMUNITY_ACTIVITY_REGISATION = "communityApi/activityRegistration.htm";

  /**
   * 社区点赞
   */
  String COMMUNITY_PRAISE = "communityApi/praise.htm";
  /**
   * 社区关注用户
   */
  String COMMUNITY_FOCUSUSER = "communityApi/attentionExpert.htm";
  /**
   * 社区发布短文
   */
  String COMMUNITYAPI_RELEASEBRIEF = "communityApi/releaseBrief.htm";
  /**
   * 社区发布短文-搜索话题信息
   */
  String COMMUNITYAPI_GETHOTTESTTALK = "communityApi/getHottestTalk.htm";

  /**
   * 社区首页话题列表
   *
   * 最新、攻略、视频
   */
  String COMMUNITY_TOPIC_LIST = "communityApi/getLatestDy.htm";

  /**
   * 社区首页活动列表
   */
  String COMMUNITY_ACTIVITY_LIST = "communityApi/getActivityAndTalkList.htm";

  /**
   * 查询我的统计数据（积分值、收藏量、关注量、粉丝量、话题量、 足迹量）
   */
  String MEMBER_GETCOUNTSTA = "communityApi/getCountSta.htm";

  /**
   * 文件路径
   */
  String KEY_VIDEO_PATH = "videopath";
  /**
   * 应用默认临时文件文件夹名
   */
  String TEMP_PATH_NAME = "temp";
  /**
   * 默认文件夹名
   */
  String APP_PATH_NAME = "BaiDaiTirp";

  String VIDEO_PATH_NAME = "newvideo";

  String VIDEO_FIRST_IMAGE = "image";

  /**
   * 社区首页推荐信息
   */
  String COMMUNITY_RECOMMEND_INFO = "communityApi/getTopCon.htm";
  /**
   * 社区发布视频
   */
  String COMMUNITYAPI_RELEASEVIDEO = "communityApi/releaseVideo.htm";

  /**
   * 社区推荐达人列表
   */
  String COMMUNITY_RECOMMEND_MASTER = "communityApi/getRecommendExpertList.htm";
  /**
   * 专题列表
   */
  String ACTIVITY_TOPICLIST = "advertApi/topicAdvertisementList.htm";

  /**
   * 查询我的足迹
   */
  String GETFOOTPRINTLIST = "communityApi/getFootprintList.htm";

  /**
   * 查询我的足迹  获取省市
   */
  String GETFOOTPRINT = "communityApi/getFootPrint.htm";

  /**
   * 我的关注用户列表
   */
  String GETATTENTIONEXPERTLIST = "communityApi/getAttentionExpertList.htm";
  /**
   * 关注用户
   */
  String ATTENTIONEXPERT = "communityApi/attentionExpert.htm";

  /**
   * 查询我的粉丝
   */
  String GETMYFANSLIST = "communityApi/getMyFansList.htm";
  /**
   * 查询话题
   */
  String GETTALKLIST = "communityApi/getTalkList.htm";
  /**
   * 我的关注话题列表
   */
  String GETATTENTIONTALKLIST = "communityApi/getAttentionTalkList.htm";

  /**
   * 关注话题
   */
  String ATTENTIONTALK = "communityApi/attentionTalk.htm";

  /**
   * 社区轻分享详情
   */
  String COMMUNITY_SHARE_DETAIL = "communityApi/getBriefDetail.htm";

  /**
   * 首页广告
   */
  String HOME_PAGE_ADS = "advertApi/homepageAds.htm";

  /**
   * 社区评论列表接口
   */
  String COMMUNITY_COMMENT_LIST = "communityApi/getCommentList.htm";
  /**
   * 同步通讯录联系人
   */
  String SYNC_CONTACTOR = "syncApi/syncContactor.htm";

  /**
   * 社区发布评论接口
   */
  String COMMUNITY_COMMENT_SEND = "communityApi/comment.htm";

  /**
   * 社区评论提醒列表接口
   */
  String COMMUNITY_COMMENT_REMIND_LIST = "communityApi/getCommentListByMemberId.htm";
  /**
   * 发送邀请接口
   */
  String SEND_SMS = "communityApi/sendSms.htm";

  /**
   * 社区首页视频列表
   */
  String COMMUNITY_RAIDERS_LIST = "communityApi/getStrategyList.htm";

  /**
   * 社区首页视频列表
   */
  String COMMUNITY_VIDEO_LIST = "communityApi/getVideoList.htm";
  /**
   * 我的  推荐列表
   */
  String GETRECOMMENDEXPERTLIST = "communityApi/getRecommendExpertList.htm";

  /**
   * 获取阿里云配置数据
   */
  String GETOSSPARAM = "communityApi/getOssParam.htm";

  /**
   * APP搜索--新街口
   */
  String SEARCH_NEW = "elasticApi/search.htm";

  /**
   * 社区推荐视频列表
   */
  String COMMUNITY_RECOMMEND_VIDEO = "communityApi/getRecommendVideoList.htm";

  /**
   * 社区推荐攻略列表
   */
  String COMMUNITY_RECOMMEND_RAIDERS = "communityApi/getRecommendStrategyList.htm";
  /**
   * 我的 文章  删除 文章接口
   */
  String REMOVEARTICLE = "communityApi/removeArticle.htm";
  /**
   * 获取商圈TAG
   */
  String SCENICSPOTHOMEADS = "advertApi/scenicSpotHomeAds.htm";
  /**
   * 社区收藏
   */
  String COMMUNITY_KEEP = "communityApi/fav.htm";
}
