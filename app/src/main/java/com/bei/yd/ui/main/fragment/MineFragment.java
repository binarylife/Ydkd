package com.bei.yd.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bei.yd.R;
import com.bei.yd.ui.main.adapter.MainPagerAdapter;

/**
 * Created by wangchunlei on 3/28/16.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
  private Context context;

  private MainPagerAdapter adapter;

  private TabLayout tabLayout;

  private OnViewPagerCreated mOnViewPagerCreated;


  @Override
  public void onAttach(Context context) {
    this.context = context;
    mOnViewPagerCreated = (OnViewPagerCreated) context;
    super.onAttach(context);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);

    initViews(view);

    // 当tab layout位置为果壳精选时，隐藏fab
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        //if (tab.getPosition() == 1) {
        //  fab.hide();
        //} else {
        //  fab.show();
        //}

      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }

    });

    mOnViewPagerCreated.viewPagerCreated();
    return view;
  }


  private void initViews(View view) {
    tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
    ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
    viewPager.setOffscreenPageLimit(3);
    adapter = new MainPagerAdapter(getChildFragmentManager(), context);
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
  }

  @Override public void onClick(View v) {

  }

  public interface OnViewPagerCreated {
    void viewPagerCreated();
  }
}
