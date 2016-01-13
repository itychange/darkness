package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.darkness.AppController;
import com.itychange.darkness.R;

import java.util.List;

import util.data;

public class adapterphotoanimater extends BaseAdapter {
    public Context mContext;
    private LayoutInflater inflater;
    private List<data> movieItems;
    private boolean shouldBlur = false;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public adapterphotoanimater(Context mContext, List<data> movieItems) {
        this.mContext = mContext;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {

         if(movieItems.size()==0){
             return 0;
         }else{
             return movieItems.size();
         }
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
            convertView = inflater.inflate(R.layout.item_photo_animater, null);

        NetworkImageView image=(NetworkImageView)convertView.findViewById(R.id.images);
        Log.i(null,"urrl:"+movieItems.get(position).getUrl());

        image.setImageUrl(movieItems.get(position).getUrl(), imageLoader);



        return convertView;
    }


}