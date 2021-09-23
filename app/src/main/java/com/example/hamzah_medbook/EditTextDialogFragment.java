package com.example.hamzah_medbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class EditTextDialogFragment extends DialogFragment {
    private EditText eDate;
    private EditText eName;
    private EditText eDose;
    private EditText eUnit;
    private EditText eFreq;
    private AddMedicineDialogListener listener;

    interface AddMedicineDialogListener{
        void updateMedBook(Medicine m);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (AddMedicineDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_add_text,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setView(view).setTitle("Add Medicine")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //get textviews
                        eDate = view.findViewById(R.id.editTextDate);
                        eName = view.findViewById(R.id.editTextName);
                        eDose = view.findViewById(R.id.editTextDose);
                        eUnit = view.findViewById(R.id.editTextUnit);
                        eFreq = view.findViewById(R.id.editTextFreq);

                        //create med
                        Medicine newMed = new Medicine(eDate.getText().toString(),
                                eName.getText().toString(),
                                Integer.parseInt(eDose.getText().toString()),
                                eUnit.getText().toString(),
                                Integer.parseInt(eFreq.getText().toString()));


                        listener.updateMedBook(newMed);
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
    }
}
