package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itychange.darkness.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentdetailtabinformation extends Fragment {

    String infor;
    TextView txt_infor;
    public fragmentdetailtabinformation(String infor) {
        // Required empty public constructor
        this.infor=infor;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentdetailtabinformation, container, false);
        txt_infor= (TextView) view.findViewById(R.id.txt_infor);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txt_infor.setText(infor);
    }
}
