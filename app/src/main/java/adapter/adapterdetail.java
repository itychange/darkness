package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.fragmentdetailtabfullgif;
import fragment.fragmentdetailtabfullimage;
import fragment.fragmentdetailtabinformation;

/**
 * Created by hp1 on 21-01-2015.
 */
public class adapterdetail extends FragmentStatePagerAdapter {

    private CharSequence Titles[];
    private int NumbOfTabs;
    private String url, infor;
    private boolean check=false;

    public adapterdetail(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb,String url,String infor,boolean check) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.url=url;
        this.infor=infor;
        this.check=check;

    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            if(check==false){
                fragmentdetailtabfullimage mFragmentdetailtabfullimage = new fragmentdetailtabfullimage(url);
                return mFragmentdetailtabfullimage;
            }else{
                fragmentdetailtabfullgif mFragmentdetailtabfullgif=new fragmentdetailtabfullgif(url);
                return  mFragmentdetailtabfullgif;
            }
        }else {
            fragmentdetailtabinformation mFragmentdetailtabinformation = new fragmentdetailtabinformation(infor);
            return mFragmentdetailtabinformation;
        }


    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}