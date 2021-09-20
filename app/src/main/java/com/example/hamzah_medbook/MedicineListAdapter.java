package com.example.hamzah_medbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MedicineListAdapter extends ArrayAdapter<Medicine> {
    private Context mContext;
    private int mResource;

    public MedicineListAdapter(Context context, int resource,  List<Medicine> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String dateStarted = getItem(position).getDateStarted();
        String dose = getItem(position).getDoseAmount() + " " + getItem(position).getDoseUnit();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        //create textview objects
        TextView mName = (TextView) convertView.findViewById(R.id.text1);
        TextView mDate = (TextView) convertView.findViewById(R.id.text2);
        TextView mDose = (TextView) convertView.findViewById(R.id.text3);

        mName.setText(name);
        mDate.setText(dateStarted);
        mDose.setText(dose);

        return convertView;

    }
}
