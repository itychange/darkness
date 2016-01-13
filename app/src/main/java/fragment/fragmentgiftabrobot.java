package fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.itychange.darkness.InsertandUpdate;
import com.itychange.darkness.R;

import java.util.ArrayList;

import adapter.adaptergif;
import network.networkgif;
import util.data;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentgiftabrobot extends Fragment {
    private GridView mGridView;
    private ArrayList<data> mArrayList;
    private adaptergif mAdaptergif;
//    private String username="get_all_animater_cute.php";
//    private String username_01="gif_animal_cute";
//    private String username_02="thongtin";
private String username="get_all_products.php";
    private String username_01="drawnew";
    private String username_02="id_tacgia";
    private TextView txt_intentl;
    public fragmentgiftabrobot() {
        // Required empty public constructor
    }
    private OnFragmentClickListener_tabrobot mListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmentgiftabrobot, container, false);
        mGridView= (GridView) view.findViewById(R.id.mlist_robot);
        txt_intentl= (TextView) view.findViewById(R.id.Intent);
        txt_intentl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"gif",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), InsertandUpdate.class);
                intent.putExtra("get_all_animater_cute",InsertandUpdate.getKey);
                startActivity(intent);
            }
        });
        mArrayList=new ArrayList<>();
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentClickListener_tabrobot) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentClickListener");
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ConnectivityManager conMgr = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ) {
            Toast.makeText(getActivity(),"Please check internet",Toast.LENGTH_SHORT).show();
        }
        else if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {

            new networkgif(getActivity(),mGridView,mArrayList, mAdaptergif,username,username_01,username_02,true).execute();
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mListener.onFragmentClickTabRoBot(mArrayList.get(position).getUrl(), mArrayList.get(position).getTitlte());
                }
            });
            //transactionFragment(new fragmentmain());
        }

    }
    public interface OnFragmentClickListener_tabrobot {
        void onFragmentClickTabRoBot(String url,String information);
    }

}
