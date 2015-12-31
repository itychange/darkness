package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.fragmentgiftabcute;
import fragment.fragmentgiftabrobot;

/**
 * Created by hp1 on 21-01-2015.
 */
public class adaptergifdetail extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public adaptergifdetail(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            fragmentgiftabrobot mFragmentgiftabrobot = new fragmentgiftabrobot();
            return mFragmentgiftabrobot;
        }else {
            fragmentgiftabcute mFragmentgittabcute = new fragmentgiftabcute();
            return mFragmentgittabcute;

        }


    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }


    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}