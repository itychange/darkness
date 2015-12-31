package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.felipecsl.gifimageview.library.GifImageView;
import com.itychange.darkness.R;

import java.util.List;

import util.data;

public class adapterhome extends BaseAdapter {
    public Context mContext;
    private LayoutInflater inflater;
    private List<data> movieItems;
    private boolean shouldBlur = false;
    public adapterhome(Context mContext, List<data> movieItems) {
        this.mContext = mContext;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {

        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView
            , ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_main, null);

        final GifImageView mGifImageView = (GifImageView) convertView.findViewById(R.id.img_home);
        final Blur blur = Blur.newInstance(mContext);
        Log.i(null,"================>"+movieItems.get(position).getUrl());

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
        }.execute(movieItems.get(position).getUrl());
        return convertView;
    }


}