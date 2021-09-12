package com.example.hamzah_medbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating list view for main activity
        ListView lv = (ListView) findViewById(R.id.main_listview);

        //test string
        List<String> testArrayList = new ArrayList<String>();
        testArrayList.add("foo");
        testArrayList.add("bar");
        testArrayList.add("really testing");

        //adapt to o/p
        ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1
                , testArrayList);
        //set
        lv.setAdapter(aAdapter);


    }

}