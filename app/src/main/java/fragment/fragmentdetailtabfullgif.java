package fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felipecsl.gifimageview.library.GifImageView;
import com.itychange.darkness.R;

import adapter.Blur;
import adapter.GifDataDownloader;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentdetailtabfullgif extends Fragment {


    private GifImageView mGifImageView;
    private boolean shouldBlur = false;

    private String url;
    public fragmentdetailtabfullgif(String url) {
        // Required empty public constructor
        this.url=url;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmenttabfullgif, container, false);
        mGifImageView= (GifImageView) view.findViewById(R.id.img_gifdetail);
        final Blur blur = Blur.newInstance(getActivity());
        mGifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        mGifImageView.setOnFrameAvailable(new GifImageView.OnFrameAvailable() {
            @Override
            public Bitmap onFrameAvailable(Bitmap bitmap) {
                if (shouldBlur) {
                    return blur.blur(bitmap);
                }
                return bitmap;
            }
        });
        new GifDataDownloader() {
            @Override protected void onPostExecute(final byte[] bytes) {
                mGifImageView.setBytes(bytes);
                mGifImageView.startAnimation();
            }
        }.execute(url);
        return view;
    }


}
