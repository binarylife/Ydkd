package com.bei.yd.ui.main.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bei.yd.R;
import com.bei.yd.ui.base.adapter.BaseRecyclerAdapter;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.utils.MyUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import java.lang.ref.WeakReference;

/**
 * 精彩景点RecyclerView Adapter,
 *
 * @author: yujin on 16/4/26.
 */
public class MainAdapter extends BaseRecyclerAdapter<MainItemNewOrderBean>
    implements View.OnClickListener {

  /**
   * context引用
   */
  private WeakReference<Context> mContext;
  //  item点击事件的回调
  private OnItemListener listener;

  public MainAdapter(Context context) {
    super(context);
    mContext = new WeakReference<>(context);
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    WonderScenicItemViewHolder viewHolder = null;
    if (viewHolder == null) {
      viewHolder = new WonderScenicItemViewHolder(
          LayoutInflater.from(mContext.get()).inflate(R.layout.item_order_detail, null));
    }
    return viewHolder;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    MainItemNewOrderBean wonderScenicBean = getItem(position);
    if (holder instanceof WonderScenicItemViewHolder) {
      WonderScenicItemViewHolder viewHolder = (WonderScenicItemViewHolder) holder;
      viewHolder.itemtopView.setBackgroundResource(
          MyUtils.getNorBackgroundByType(wonderScenicBean.getStatus()));
      viewHolder.tvScenicName.setText(MyUtils.getNorTextByType(wonderScenicBean.getStatus()));
      viewHolder.tvAddress.setText(
          wonderScenicBean.getArea() + "/" + wonderScenicBean.getAddress());
      viewHolder.tvCreateTime.setText(wonderScenicBean.getPhone());//  工单的状态
      viewHolder.tvPhone.setText(wonderScenicBean.getStatus() + "");//  工单的状态
      showYuJinggButton(viewHolder.tvyujing, wonderScenicBean);
      viewHolder.itemView.setTag(wonderScenicBean);
      viewHolder.itemView.setOnClickListener(this);
    }
  }

  @Override public void onClick(View v) {
    if (listener != null) {
      switch (v.getId()) {
        case R.id.rl_scenery_item:
          listener.onItemClick(v, mItems.indexOf(v.getTag()));
          return;
      }
    }
  }

  /**
   * 精彩景点列表ViewHolder
   */
  class WonderScenicItemViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.rl_scenery_item) View itemView;
    @Bind(R.id.item_consumer_detail_top_layout) View itemtopView;
    @Bind(R.id.item_consumer_detail_money) TextView tvScenicName;//工单编号
    @Bind(R.id.item_consumer_detail_tag) TextView tvAddress;//工单地址
    @Bind(R.id.item_consumer_detail_time) TextView tvCreateTime;//工单创建时间
    @Bind(R.id.item_consumer_detail_notes) TextView tvPhone;//工单联系电话

    @Bind(R.id.tv_yujing) TextView tvyujing;//预警级别

    public WonderScenicItemViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }

  /**
   * 设置Item点击事件
   *
   * @param listener Item点击回调
   */
  public void setOnItemClickListener(OnItemListener listener) {
    this.listener = listener;
  }

  /**
   * Item的回调事件
   */
  public interface OnItemListener {
    /**
     * 点击回调方法
     *
     * @param view 被点击的View
     * @param position 第几个
     */
    void onItemClick(View view, int position);
  }

  /**
   * 展示预警buttom上的文字
   */
  private void showYuJinggButton(TextView textView, MainItemNewOrderBean bean) {
    int statusValue = bean.getStatus();
    switch (SharedPreferenceHelper.getUserRole()) {
      //  判断用户的角色
      //case "A":
      //  break;
      case "B":// 区县派单员
        if (statusValue == 1) {
          //  派单预警
          if(bean.getDispatchWarning()!=0) {
            textView.setText(bean.getDispatchWarning() + "");
            MyUtils.showYuJinggButtonBG(textView, bean.getDispatchWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        } else if (statusValue == 4) {
          // 回访中
          if(bean.getVisitWarning()!=0) {
            textView.setText(bean.getVisitWarning() + "");
            MyUtils.showYuJinggButtonBG(textView, bean.getVisitWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        }
        break;
      case "C":
        if (statusValue == 2) {
          //  派单预警
          if (bean.getDispatchWarning()!=0) {
            textView.setText(bean.getDispatchWarning() + "");
            MyUtils.showYuJinggButtonBG(textView, bean.getDispatchWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        }
        break;
      case "D":
        //  装机人
        if (statusValue == 3) {
          //  装机预警
          if (bean.getInstallWarning()!=0) {
            textView.setText(bean.getInstallWarning() + "");
            MyUtils.showYuJinggButtonBG(textView, bean.getInstallWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        }
        break;
      default:
        textView.setVisibility(View.GONE);
    }
  }
}
