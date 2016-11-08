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
import java.lang.ref.WeakReference;

/**
 * 精彩景点RecyclerView Adapter,
 *
 * @author: yujin on 16/4/26.
 */
public class MainAdapter extends BaseRecyclerAdapter<MainItemNewOrderBean> implements View.OnClickListener{

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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WonderScenicItemViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new WonderScenicItemViewHolder(
                    LayoutInflater.from(mContext.get()).inflate(R.layout.item_main_frg_info, null));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainItemNewOrderBean  wonderScenicBean= getItem(position);
        if (holder instanceof WonderScenicItemViewHolder) {
            WonderScenicItemViewHolder viewHolder = (WonderScenicItemViewHolder) holder;
            viewHolder.tvScenicName.setText(wonderScenicBean.getAddress());
            viewHolder.itemView.setTag(wonderScenicBean);
            viewHolder.itemView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
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
        @Bind(R.id.rl_scenery_item)
        View itemView;
        @Bind(R.id.tv_scenic_name)
        TextView tvScenicName;
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
         * @param view     被点击的View
         * @param position 第几个
         */
        void onItemClick(View view, int position);
    }
}
