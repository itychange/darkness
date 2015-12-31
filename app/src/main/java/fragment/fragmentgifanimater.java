package fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itychange.darkness.R;

import adapter.adaptergifdetail;
import view.SlidingTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentgifanimater extends Fragment {

    SlidingTabLayout tabs;
    adaptergifdetail mAdaptergifdetail;
    CharSequence Titles[] = {"Robot", "Cute"};
    private FragmentActivity myContext;
    private ViewPager viewPager;
    private String url, information;

    public fragmentgifanimater() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentgifanimater, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.container);
        tabs = (SlidingTabLayout)view.findViewById(R.id.tabs);

        // Setting the ViewPager For the SlidingTabsLayout
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fragManager = myContext.getSupportFragmentManager(); //If using fragments from support v4


        mAdaptergifdetail = new adaptergifdetail(fragManager, Titles, 2);
        viewPager.setAdapter(mAdaptergifdetail);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);
    }

}