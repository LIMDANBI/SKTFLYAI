package com.skt.network_with_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String jsonUrl = "http://172.23.244.218:5000/";
    String imgUrl = "http://172.23.244.218:5000/static/";
    ArrayList<RawData> arrayList;

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        HttpParser httpParser = new HttpParser(jsonUrl);
        String str = httpParser.JsonParser();
//        Log.d("log", str);

        try{
            JSONObject jsonObject = new JSONObject(str);
            JSONArray movieArray = jsonObject.getJSONArray("movies");

            for(int i=0; i<movieArray.length(); i++){
                JSONObject movieObject = movieArray.getJSONObject(i);
                String img = movieObject.getString("img");
                String subject = movieObject.getString("title");
                Double rating = movieObject.getDouble("rating");
//                Log.d("log", "img:"+img);
                arrayList.add(new RawData(img, subject, rating));
            }
            listView = findViewById(R.id.listView);
            listView.setAdapter(new Adapter());
        }
        catch (JSONException e){
            Log.d("log", "json 파싱 오류");
        }
//        btn = findViewById(R.id.btnOk);
    }

    class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = View.inflate(MainActivity.this, R.layout.listview_item, null);
                TextView subject = (TextView) view.findViewById(R.id.movieTitle);
                RatingBar ratingBar = (RatingBar) view.findViewById(R.id.movieRating);
                subject.setText(arrayList.get(i).getSubject());
                ratingBar.setRating(arrayList.get(i).getRating().floatValue());
            }
            return view;
        }
    }
}