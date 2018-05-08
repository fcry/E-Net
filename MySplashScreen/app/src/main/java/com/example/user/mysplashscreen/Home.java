package com.example.user.mysplashscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    private HashMap<String,String> map;
    private ArrayList<HashMap<String,String>> mylist;
    private SimpleAdapter adapter;

    private ListView listview;
    private String[] img,txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listview =(ListView)findViewById(R.id.listView);
        txt = new String[] {"text1","text2","text3","text4"};
        img = new String[] {Integer.toString(R.mipmap.ic_launcher),
                Integer.toString(R.mipmap.ic_launcher),
                Integer.toString(R.mipmap.ic_launcher),
                Integer.toString(R.mipmap.ic_launcher)};

        mylist =new ArrayList<HashMap<String, String>>();
        for (int i=0; i<txt.length; i++){
            map = new HashMap<String, String>();
            map.put("txt", txt[i]);
            map.put("img", img[1]);
            mylist.add(map);
        }
        adapter =new SimpleAdapter(this,mylist,R.layout.home_list_view,
               new String[] {"txt", "img"}, new int[]{R.id.txt_1v, R.id.img_1v} );

        listview.setAdapter(adapter);
    }
}