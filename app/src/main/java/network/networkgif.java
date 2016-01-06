package network;


import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.adaptergif;
import util.data;


public class networkgif extends AsyncTask<Void, Void, List<data>> {


    // Get your own user name at http://www.geonames.org/login

    AndroidHttpClient mClient = AndroidHttpClient.newInstance("");
    private GridView girlview;
    private adaptergif mAdaptergif;
    private ArrayList<data> mList;
    private String username;
    private String username_01;
    private String username_02;
    private static final String URL = "http://themylifes.com/android_connect_drawness/";

    Context mContext;
    private boolean check = false;

    public networkgif(Context mContext, GridView girlview, ArrayList<data> mDatas, adaptergif mAdaptergif, String username, String username_01, String username_02, boolean check) {
        this.mContext = mContext;
        this.girlview = girlview;
        this.mAdaptergif = mAdaptergif;
        this.mList = mDatas;
        this.username = username;
        this.username_01 = username_01;
        this.username_02 = username_02;
        this.check = check;
        Toast.makeText(mContext, "show data:" + check, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected List<data> doInBackground(Void... params) {
        HttpGet request = new HttpGet(URL + username);
        JSONResponseHandler responseHandler = new JSONResponseHandler();
        try {
            return mClient.execute(request, responseHandler);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(List<data> result) {
        if (null != mClient)
            mClient.close();

        mAdaptergif =new adaptergif(mContext,result);
                girlview.setAdapter(mAdaptergif);


    }

    private class JSONResponseHandler implements ResponseHandler<List<data>> {


        private static final String LONGITUDE_TAG = "id";
        private static final String MAGNITUDE_TAG = "url";



        @Override
        public List<data> handleResponse(HttpResponse response)
                throws ClientProtocolException, IOException {
            String JSONResponse = new BasicResponseHandler()
                    .handleResponse(response);
            try {


                // Get top-level JSON Object - a Map
                JSONObject responseObject = (JSONObject) new JSONTokener(
                        JSONResponse).nextValue();


                // Extract value of "earthquakes" key -- a List
                JSONArray earthquakes = responseObject
                        .getJSONArray(username_01);


                // Iterate over earthquakes list
                for (int idx = 0; idx < earthquakes.length(); idx++) {


                    // Get single earthquake data - a Map
                    JSONObject earthquake = (JSONObject) earthquakes.get(idx);


                    // Summarize earthquake data as a string and add it to
                    // result
                    data mData=new data();
                    mData.setId(""+earthquake.get(LONGITUDE_TAG));
                    mData.setUrl("" + earthquake.get(MAGNITUDE_TAG));
                    mData.setId_tacgia("" + earthquake.get(username_02));
                    mList.add(mData);
                    Log.i(null,"showw:"+earthquake.get(MAGNITUDE_TAG));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }
    }

}