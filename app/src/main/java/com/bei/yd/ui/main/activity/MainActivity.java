package com.bei.yd.ui.main.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import butterknife.Bind;
import cn.hugeterry.updatefun.UpdateFunGO;
import cn.hugeterry.updatefun.config.UpdateKey;
import com.bei.yd.R;
import com.bei.yd.app.AppConstant;
import com.bei.yd.bean.TabEntity;
import com.bei.yd.ui.base.activity.BackBaseActivity;
import com.bei.yd.ui.main.fragment.MineFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.baseapp.AppConfig;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.daynightmodeutils.ChangeModeController;
import java.util.ArrayList;
import rx.functions.Action1;
/**
 * des:主界面
 * Created by xsf
 * on 2016.09.15:32
 */
public class MainActivity extends BackBaseActivity {

    @Bind(R.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"首页", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal,R.mipmap.ic_care_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected,R.mipmap.ic_care_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private MineFragment newsMainFragment;
    //private PhotosMainFragment photosMainFragment;
    //private VideoMainFragment videoMainFragment;
    private MineFragment careMainFragment;
    private static int tabLayoutHeight;

    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(com.jaydenxiao.common.R.anim.fade_in,
                com.jaydenxiao.common.R.anim.fade_out);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //切换daynight模式要立即变色的页面
        ChangeModeController.getInstance().init(this,R.attr.class);
        super.onCreate(savedInstanceState);
        //初始化frament
        initFragment(savedInstanceState);
        //tabLayout.measure(0,0);
        //tabLayoutHeight=tabLayout.getMeasuredHeight();
        setContentView(R.layout.act_main);
        initTab();
        //监听菜单显示或隐藏
    }
    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
    }
    /**
     * 初始化碎片
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            newsMainFragment = (MineFragment) getFragmentManager().findFragmentByTag("newsMainFragment");
            //photosMainFragment = (PhotosMainFragment) getSupportFragmentManager().findFragmentByTag("photosMainFragment");
            //videoMainFragment = (VideoMainFragment) getSupportFragmentManager().findFragmentByTag("videoMainFragment");
            careMainFragment = (MineFragment) getFragmentManager().findFragmentByTag("careMainFragment");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            newsMainFragment = new MineFragment();
            //photosMainFragment = new PhotosMainFragment();
            //videoMainFragment = new VideoMainFragment();
            careMainFragment = new MineFragment();
            transaction.add(R.id.fl_body, newsMainFragment, "newsMainFragment");
            //transaction.add(R.id.fl_body, photosMainFragment, "photosMainFragment");
            //transaction.add(R.id.fl_body, videoMainFragment, "videoMainFragment");
            transaction.add(R.id.fl_body, careMainFragment, "careMainFragment");
        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        //tabLayout.setCurrentTab(currentTabPosition);
    }

    /**
     * 切换
     */
    private void SwitchTo(int position) {
        LogUtils.logd("主页菜单position" + position);
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:
                //transaction.hide(photosMainFragment);
                //transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(newsMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //美女
            case 1:
                transaction.hide(newsMainFragment);
                //transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                //transaction.show(photosMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //视频
            case 2:
                transaction.hide(newsMainFragment);
                //transaction.hide(photosMainFragment);
                transaction.hide(careMainFragment);
                //transaction.show(videoMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //关注
            case 3:
                transaction.hide(newsMainFragment);
                //transaction.hide(photosMainFragment);
                //transaction.hide(videoMainFragment);
                transaction.show(careMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }

    /**
     * 菜单显示隐藏动画
     * @param showOrHide
     */
    //private void startAnimation(boolean showOrHide){
    //    final ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
    //    ValueAnimator valueAnimator;
    //    ObjectAnimator alpha;
    //    if(!showOrHide){
    //         valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
    //        alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 1, 0);
    //    }else{
    //         valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
    //        alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 0, 1);
    //    }
    //    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    //        @Override
    //        public void onAnimationUpdate(ValueAnimator valueAnimator) {
    //            layoutParams.height= (int) valueAnimator.getAnimatedValue();
    //            tabLayout.setLayoutParams(layoutParams);
    //        }
    //    });
    //    AnimatorSet animatorSet=new AnimatorSet();
    //    animatorSet.setDuration(500);
    //    animatorSet.playTogether(valueAnimator,alpha);
    //    animatorSet.start();
    //}

    /**
     * 监听全屏视频时返回键
     */
    @Override
    public void onBackPressed() {
        //if (JCVideoPlayer.backPress()) {
        //    return;
        //}
        super.onBackPressed();
    }
    /**
     * 监听返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //奔溃前保存位置
        LogUtils.loge("onSaveInstanceState进来了1");
        //if (tabLayout != null) {
        //    LogUtils.loge("onSaveInstanceState进来了2");
        //    outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, tabLayout.getCurrentTab());
        //}
    }

    @Override
    protected void onStop() {
        super.onStop();
        UpdateFunGO.onStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ChangeModeController.onDestory();
    }

    @Override protected void onLoadData() {

    }

    /**
     * 切换fragment 并能返回上一个fragment
     *
     * @param currentFg 当前的fragment
     * @param newFg 要显示的新的fragment
     * @param canBack 是否返回上一个
     * @param isRefresh 是否销毁当前的fragment 以达到返回后刷新界面数据效果 true 销毁 false 不销毁
     */
    //public void changeFragment(Fragment currentFg, Fragment newFg, boolean canBack,
    //    boolean isRefresh) {
    //    FragmentManager fm = getFragmentManager();
    //    android.app.FragmentTransaction transaction = fm.beginTransaction();
    //    if (isRefresh) {
    //        transaction.replace(R.id.activity_main_content, newFg);
    //    } else {
    //        if (currentFg != null) {
    //            transaction.hide(currentFg);
    //        }
    //        if (!newFg.isAdded()) {
    //            transaction.add(R.id.activity_main_content, newFg);
    //        } else {
    //            transaction.show(newFg);
    //        }
    //    }
    //    if (canBack) {
    //        transaction.addToBackStack(null);
    //    }
    //    transaction.commitAllowingStateLoss();
    //    if (newFg instanceof DestinationFragment) {//目前的首页
    //        UmengUtils.onMainBottomTap(this, getResources().getString(R.string.ui_app_frist));
    //    } else if (newFg instanceof ChooseDestinationFragment) {//目的地
    //        UmengUtils.onMainBottomTap(this, getResources().getString(R.string.ui_md_frist));
    //    } else if (newFg instanceof ShoppingCarFragment) {
    //        UmengUtils.onMainBottomTap(this, getResources().getString(R.string.ui_app_shopcar));
    //    } else if (newFg instanceof NewMineFragment) {
    //        UmengUtils.onMainBottomTap(this, getResources().getString(R.string.ui_app_userceter));
    //    }
    //}

}
