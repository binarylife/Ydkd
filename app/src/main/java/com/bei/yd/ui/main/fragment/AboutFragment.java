package com.bei.yd.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.fragment.BaseLoadFragment;
import com.bei.yd.ui.main.activity.SearchTagWorkFixOrderActivity;
import com.bei.yd.ui.main.activity.SearchTagWorkOrderActivity;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.widget.DialogBuilder;
import com.jaydenxiao.common.commonutils.LogUtils;

/**
 * Created by fb on 3/28/16.
 */
public class AboutFragment extends BaseLoadFragment implements View.OnClickListener {
  private Context context;
  @Bind(R.id.about_nor_order) TextView mNorOrder;
  @Bind(R.id.about_fix_order) TextView mFixOrder;
  @Bind(R.id.about_loginout) TextView mLoginOut;

  @Override public void onAttach(Context context) {
    this.context = context;
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public int getContentResouceId() {
    return R.layout.fragment_about;
  }

  @Override public void dealLogicBeforeInitView() {

  }

  @Override public void dealLogicAfterInitView(View view) {
    initViews(view);
  }

  private void initViews(View view) {
    //tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
    //ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
    //tvTitle.setText(MyUtils.getRoleByType(SharedPreferenceHelper.getUserRole()));
    LogUtils.loge("角色" + SharedPreferenceHelper.getUserRole());
    //if (SharedPreferenceHelper.getUserRole() == "A"
    //    || SharedPreferenceHelper.getUserRole() == "B") {
    //  mbtNewOrder.setVisibility(View.VISIBLE);
    //}else{
    //  mbtNewOrder.setVisibility(View.GONE);
    //}
    //tabLayout.setTabsFromPagerAdapter(adapter);
    //tabLayout.setti
  }

  @OnClick({
      R.id.about_nor_order, R.id.about_fix_order, R.id.about_loginout
  }) public void onClick(View v) {
    switch (v.getId()) {
      case R.id.about_nor_order:
        //跳转到工单条件筛选页面
        Bundle bundle1 = new Bundle();
        //bundle.putParcelable(Constant.ORDER_DETAIL, mainItemNewOrderBean);
        //bundle.putBoolean(Constant.isNewOreder, isNorOrder);
        InvokeStartActivityUtils.startActivity(context, SearchTagWorkOrderActivity.class, bundle1,
            false);
        break;
      case R.id.about_fix_order:
        //跳转到工单条件筛选页面
        Bundle bundle2 = new Bundle();
        //bundle.putParcelable(Constant.ORDER_DETAIL, mainItemNewOrderBean);
        //bundle.putBoolean(Constant.isNewOreder, isNorOrder);
        InvokeStartActivityUtils.startActivity(context, SearchTagWorkFixOrderActivity.class,
            bundle2, false);
        break;
      case R.id.about_loginout:
        showMutiDialog("确定退出登录？", "温馨提示", new DialogBuilder.ClickCallbak() {
          @Override public void onConfirm() {
            SharedPreferenceHelper.setRememberAccout(false);
          }

          @Override public void onCancle() {

          }
        });

        break;
    }
  }

  @Override protected void onLoadData() {

  }

  public interface OnViewPagerCreated {
    void viewPagerCreated();
  }
}
