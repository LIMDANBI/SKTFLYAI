package com.skt.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn_read, btn_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_read = findViewById(R.id.btn_read);
        btn_write = findViewById(R.id.btn_write);

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                }
                catch (IOException e){
                    Toast.makeText(MainActivity.this, "파일이 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str ="안녕하세요";
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(MainActivity.this, "파일 저장 완료", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}