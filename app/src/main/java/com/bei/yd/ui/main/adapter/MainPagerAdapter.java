package com.bei.yd.ui.main.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.bei.yd.ui.main.fragment.NorOrderFragment;
/**
 * Created by fb on 2016/8/10.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private final Context context;
    private NorOrderFragment norFragment;
    private NorOrderFragment fixFragment;

    public NorOrderFragment getGuokrFragment() {
        return norFragment;
    }

    public NorOrderFragment getZhihuFragment() {
        return fixFragment;
    }


    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        titles =new String[] {"普通工单","维修工单"};
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1){
            norFragment = NorOrderFragment.newInstance();
            return norFragment;
        } else{
            norFragment = NorOrderFragment.newInstance();
            return norFragment;
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
