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

import adapter.adapterphotoanimater;
import network.network;
import util.data;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentmain extends Fragment {

    private OnFragmentClickListener mListener;

    public fragmentmain() {
        // Required empty public constructor
    }
    private String username="getallnarutal.php";
    private String username_01="anhdongvat";
    private String username_02="thongtin";
    public GridView mGridView;
    private ArrayList<data> mList=null;
    private adapterphotoanimater mAdapterphotoanimater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmentmain, container, false);
        mGridView= (GridView) view.findViewById(R.id.mlist);
        mList=new ArrayList<>();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentClickListener");
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new network(getActivity(),mGridView,mList, mAdapterphotoanimater,username,username_01,username_02,false).execute();
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentClick(mList.get(position).getUrl(),mList.get(position).getTitlte(),false);
            }
        });
    }
    public interface OnFragmentClickListener {
        void onFragmentClick(String url,String information,boolean check);
    }
}
