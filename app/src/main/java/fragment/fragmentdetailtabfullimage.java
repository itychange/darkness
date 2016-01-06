package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.darkness.AppController;
import com.itychange.darkness.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentdetailtabfullimage extends Fragment {

    private String url;
    public fragmentdetailtabfullimage(String url) {
        // Required empty public constructor
        this.url=url;
    }
    private NetworkImageView mimg_full;
    ImageLoader imageLoader=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmenttabfullimage, container, false);
        mimg_full= (NetworkImageView) view.findViewById(R.id.full_img);
        imageLoader= AppController.getInstance().getImageLoader();
        mimg_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mimg_full.setImageUrl(url,imageLoader);

    }

}
