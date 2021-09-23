package com.example.hamzah_medbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EditTextDialogFragment.AddMedicineDialogListener {
    private ListView mListView;
    private static MedicineBook medBook = new MedicineBook();
    private Button addMedicine;
    private MedicineListAdapter mAdapter;
    private Button deleteMedicine;
    private TextView totalMedDose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.main_listview);
        totalMedDose = (TextView) findViewById(R.id.textViewTotalMed);
        totalMedDose.setText("Total Dose Count: " + medBook.getTotalMedDose().toString());
        //create custom adapter
        mAdapter = new MedicineListAdapter(this, R.layout.list_row_view, medBook.getMedicineList());

        //set our listview to adapter
        mListView.setAdapter(mAdapter);

        //set up buttons
        addMedicine = findViewById(R.id.button1);
        deleteMedicine = findViewById(R.id.button2);

        //set on click listeners for add med
        addMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EditTextDialogFragment().show(getSupportFragmentManager(), "ADD_MEDICINE");

            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //highlight med
                view.setBackgroundColor(Color.LTGRAY);

                //delete med actually
                deleteMedicine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Medicine listItem = (Medicine) mListView.getItemAtPosition(i);
                        medBook.removeMedicine(listItem);

                        mAdapter.remove(listItem);
                        mAdapter.notifyDataSetChanged();

                        //update total doses
//                        totalMedDose.setText("Total Dose Count: " + medBook.getTotalMedDose().toString());
                    }
                });

            }
        });


    }

    public void updateMedBook(Medicine m){
        medBook.addMedicine(m);
        mListView.setAdapter(mAdapter);
    }
}