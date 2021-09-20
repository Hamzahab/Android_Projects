package com.example.hamzah_medbook;

import java.util.ArrayList;
import java.util.List;

/*
    Stores all medicine added by user, keeping track of total doses daily
 */
public class MedicineBook extends ArrayList<Medicine>{
    private List<Medicine> medicineList;
    private static int totalMedDose;

    MedicineBook() {
        super();
    }

    public List<Medicine> getMedicineList() {
        return this;
    }

    public void addMedicine(Medicine m) {
        add(m);

        //increment totalMedDose
        totalMedDose+=m.getDoseAmount();
    }

    public void removeMedicine(Medicine m) {
        remove(m);

        //decrement totalMedDose
        totalMedDose-=m.getDoseAmount();
    }

    public int getTotalMedDose(){
        return totalMedDose;
    }


}
