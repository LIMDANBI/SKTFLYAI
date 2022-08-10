package com.skt.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button secondBtn;
    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        age = intent.getIntExtra("age", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondBtn = findViewById(R.id.secondBtn);
        secondBtn.setText("name: "+name+", age: "+age);
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("msg", name+"님의 나이는 "+age+"살 이군요.");
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}