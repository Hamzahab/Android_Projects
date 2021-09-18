package com.example.hamzah_medbook;

import java.util.ArrayList;
import java.util.List;

/*
    Stores all medicine added by user, keeping track of total doses daily
 */
public class MedicineBook {
    private List<Medicine> medicineList;
    private static int totalMedDose;

    MedicineBook() {
        this.medicineList = new ArrayList<>();
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void addMedicine(Medicine m) {
        medicineList.add(m);

        //increment totalMedDose
        totalMedDose+=m.getDoseAmount();
    }

    public void removeMedicine(Medicine m) {
        medicineList.remove(m);

        //decrement totalMedDose
        totalMedDose-=m.getDoseAmount();
    }

    public int getTotalMedDose(){
        return totalMedDose;
    }

    public List<ArrayList<String>> getParams(){
        List<ArrayList<String>> params = new ArrayList<>();
        for(Medicine m:getMedicineList()){
            ArrayList<String> test = new ArrayList<>();
            test.add(m.getName());
            test.add(m.getDateStarted());
            test.add(Integer.toString(m.getDoseAmount()));
            params.add(test);
        }
        return params;
    }
}
