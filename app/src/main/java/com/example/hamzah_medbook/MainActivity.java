package com.example.hamzah_medbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    MedicineBook medBook = new MedicineBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.main_listview);



        //create medicine
        Medicine med1 = new Medicine("2021-09-25" ,"cetirizine hydrochloride", 5, "mg", 1);
        Medicine med2 = new Medicine("2021-09-25" ,"ha", 5, "mg", 1);
        Medicine med3 = new Medicine("2021-09-25" ,"haha", 5, "mg", 1);

        //add to MB
        medBook.addMedicine(med1);
        medBook.addMedicine(med2);
        medBook.addMedicine(med3);

        //create custom adapter
        MedicineListAdapter mAdapter = new MedicineListAdapter(this, R.layout.list_row_view, medBook.getMedicineList());

        //set our listview to adapter
        mListView.setAdapter(mAdapter);

        Button mainButton = findViewById(R.id.button1);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMedicineActivity.class);

                //abstract into bundle
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("objects", (Serializable) medBook);
//                intent.putExtra("medBundle",bundle);
                startActivity(intent);
            }
        });

    }

}