package com.skt.network_with_json;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImage {

    public Bitmap bitmap(String src){
        Bitmap myBitmap = null;
        HttpURLConnection conn = null;
        try{
            java.net.URL url = new URL(src);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            myBitmap = BitmapFactory.decodeStream(inputStream);
        }
        catch (Exception e){
            Log.d("log", "네트워크 오류!");
        }
        return myBitmap;
    }
}
