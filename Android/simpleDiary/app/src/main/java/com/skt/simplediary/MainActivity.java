package com.skt.simplediary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단한 일기장");

        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editDiary);
        btnWrite = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cyear = cal.get(Calendar.YEAR);
        int cmonth = cal.get(Calendar.MONTH);
        int cday = cal.get(Calendar.DATE);

        datePicker.init(cyear, cmonth, cday, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                fileName = year+"_"+(month+1)+"_"+day+".txt";
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String diaryContent = editText.getText().toString();
                    outFs.write(diaryContent.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName+"이 저장되었습니다.", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    Toast.makeText(getApplicationContext(), "오류가 발생했습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}