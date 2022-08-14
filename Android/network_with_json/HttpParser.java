package com.skt.network_with_json;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpParser {
    String address;

    public HttpParser(String address){
        this.address = address;
    }

    public String JsonParser(){
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode() == 200){
                String line = "";
                BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                while (true){
                    line = buffer.readLine();
                    if(line==null) break;
                    stringBuilder.append(line+'\n');
                }
                buffer.close();
                conn.disconnect();
            }
            else{
                Log.d("log", "접속 실패!");
            }
        }
        catch (Exception e){
            Log.d("log", "네트워크 오류!");
        }
        return stringBuilder.toString();
    }
}
