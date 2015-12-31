package fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.itychange.darkness.R;

import java.util.ArrayList;

import adapter.adapterhome;
import network.network;
import util.data;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentgiftabcute extends Fragment {

    private GridView mGridView;
    private ArrayList<data> mArrayList;
    private adapterhome mAdapterhome;
    private String username="get_all_products.php";
    private String username_01="drawnew";
    private String username_02="id_tacgia";
    public fragmentgiftabcute() {
        // Required empty public constructor
    }
    private OnFragmentClickListener_tabcute mListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmentgiftabcute, container, false);
        mGridView= (GridView) view.findViewById(R.id.mlist_cute);
        mArrayList=new ArrayList<>();

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentClickListener_tabcute) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentClickListener");
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new network(getActivity(),mGridView,mArrayList, mAdapterhome,username,username_01,username_02,true).execute();
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentClick(mArrayList.get(position).getUrl(), mArrayList.get(position).getTitlte());
            }
        });
    }
    public interface OnFragmentClickListener_tabcute {
        void onFragmentClick(String url,String information);
    }

}
