package com.skt.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰");
        String[] mid = {"사과", "복숭아", "딸기", "파인애플", "바나나", "체리", "포도", "샤인머스캣", "자두", "멜론", "수박", "참외", "귤", "오렌지"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, mid);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, mid[i]+" 선택", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("fruit", mid[i]);
                startActivity(intent);
            }
        });
    }
}