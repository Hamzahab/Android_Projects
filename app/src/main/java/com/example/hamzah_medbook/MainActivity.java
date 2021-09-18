package com.example.hamzah_medbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<ArrayList<String>> aAdapter;
//    ArrayAdapter<String> aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create medicine book
        MedicineBook mb = new MedicineBook();

        //create medicine
        Medicine med1 = new Medicine("2021-09-25" ,"cetirizine hydrochloride", 5, "mg", 1);

        Medicine med2 = new Medicine("2021-09-25" ,"ha", 5, "mg", 1);
        Medicine med3 = new Medicine("2021-09-25" ,"haha", 5, "mg", 1);

        mb.addMedicine(med1);
        mb.addMedicine(med2);
        mb.addMedicine(med3);

        //creating list view for main activity
        lv = findViewById(R.id.main_listview);

        String[] test = {"1", "2", "3"};
        //adapt to o/p
//        aAdapter = new ArrayAdapter<>(this,
//               R.layout.list_row_view
//                , mb.getMedicineList());
        aAdapter = new ArrayAdapter<ArrayList<String>>(this,
                R.layout.list_row_view,
                R.id.text1,
                mb.getParams());
        //set
        lv.setAdapter(aAdapter);

        Button mainButton = findViewById(R.id.button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_add_medicine);
            }
        });

    }

}