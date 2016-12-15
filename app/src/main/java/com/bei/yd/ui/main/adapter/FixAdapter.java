package com.bei.yd.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bei.yd.R;
import com.bei.yd.ui.base.adapter.BaseRecyclerAdapter;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.utils.MyUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import java.lang.ref.WeakReference;

/**
 * 精彩景点RecyclerView Adapter,
 *
 * @author: yujin on 16/4/26.
 */
public class FixAdapter extends BaseRecyclerAdapter<MainItemNewOrderBean>
    implements View.OnClickListener {

  /**
   * context引用
   */
  private WeakReference<Context> mContext;
  //  item点击事件的回调
  private OnItemListener listener;

  public FixAdapter(Context context) {
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
          MyUtils.getBackgroundByType(wonderScenicBean.getStatus()));
      viewHolder.tvScenicName.setText(MyUtils.getTextByType(wonderScenicBean.getStatus()));
      viewHolder.tvAddress.setText(
          wonderScenicBean.getArea() + "/" + wonderScenicBean.getAddress());
      viewHolder.tvCreateTime.setText(wonderScenicBean.getAccount());//  工单的状态
      viewHolder.tvPhone.setText(wonderScenicBean.getPhone() + "");//  工单的状态
      showYuJinggButton(viewHolder.tvyujing, wonderScenicBean);
      //viewHolder.tvyujing.setText(showYuJinggButton());//  工单的状态
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
      case "A"://   一级派单员
        if (statusValue == 7) {
          //  派单预警
          textView.setText(bean.getDispatchWarning()+"");
          MyUtils.showYuJinggButtonBG(textView,bean.getDispatchWarning());
        }else{
          textView.setVisibility(View.GONE);
        }
        break;
      case "B":// 二级派单员
        if (statusValue == 1) {
          //  派单预警
          if (bean.getDispatchWarning1() != 0) {
            textView.setText(bean.getDispatchWarning1() + "");
            MyUtils.showYuJinggButtonBG(textView,bean.getDispatchWarning1());
          } else {
            textView.setVisibility(View.GONE);
          }
          if (statusValue == 3) {
            //   二级二次排队呢预警
            if (bean.getDispatchWarning2() != 0) {
              textView.setText(bean.getDispatchWarning2() + "");
              MyUtils.showYuJinggButtonBG(textView,bean.getDispatchWarning2());
            } else {
              textView.setVisibility(View.GONE);
            }
          }
          if (statusValue == 7) {
            //  派单预警
            if (bean.getDispatchWarning()!=0) {
              textView.setText(bean.getDispatchWarning() + "");
              MyUtils.showYuJinggButtonBG(textView, bean.getDispatchWarning());
            }else
            {
              textView.setVisibility(View.GONE);
            }
          }
        }
        if (statusValue == 5) {
          // 回访中
          if (bean.getVisitWarning() != 0) {
            textView.setText(bean.getVisitWarning() + "");
            MyUtils.showYuJinggButtonBG(textView,bean.getVisitWarning());
          } else {
            textView.setVisibility(View.GONE);
          }
        }
        break;
      case "C":
        if (statusValue == 2) {
          //  接口人 派单预警
          if (bean.getDispatchWarning()!=0) {
            textView.setText(bean.getDispatchWarning() + "");
            MyUtils.showYuJinggButtonBG(textView,bean.getDispatchWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        }
        break;
      case "D":
        //  装机人
        if (statusValue == 4) {
          //  装机预警
          if (bean.getInstallWarning()!=0) {
            textView.setText(bean.getInstallWarning() + "");
            MyUtils.showYuJinggButtonBG(textView,bean.getInstallWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        }
        break;

      case "CD":
        if (statusValue == 2) {
          //  接口人 派单预警
          if (bean.getDispatchWarning()!=0) {
            textView.setText(bean.getDispatchWarning() + "");
            MyUtils.showYuJinggButtonBG(textView,bean.getDispatchWarning());
          }else{
            textView.setVisibility(View.GONE);
          }
        }
        if (statusValue == 4) {
          //  装机预警
          if (bean.getInstallWarning()!=0) {
            textView.setText(bean.getInstallWarning() + "");
            MyUtils.showYuJinggButtonBG(textView,bean.getInstallWarning());
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
