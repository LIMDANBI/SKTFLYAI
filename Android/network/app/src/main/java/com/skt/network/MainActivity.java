package com.skt.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String urlStr = "http://172.23.244.218:5000/";
    Button sendBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    public void run(){
                        try{ // 통신할 때는 try - catch 문 항상 사용
                            URL url = new URL(urlStr);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setDoInput(true);
                            conn.setDoOutput(true);
                            conn.setConnectTimeout(10000);

                            int resCode = conn.getResponseCode(); // 응답 결과 값
                            if(resCode == 200){
                                BufferedReader buffer = new BufferedReader(
                                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                                StringBuilder strBuilder = new StringBuilder();
                                String line = null;
                                while (true){
                                    line = buffer.readLine();
                                    if(line==null) break;
                                    strBuilder.append(line+"\n");
                                }

                                buffer.close();
                                conn.disconnect();

                                String result = strBuilder.toString();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(result);
                                    }
                                });

                            } else{
                                Log.d("log", "접속 실패!");
                            }

                        } catch (Exception e){
                            Log.d("log", "네트워크 오류!");
                        }
                    }
                }.start();
            }
        });
    }
}