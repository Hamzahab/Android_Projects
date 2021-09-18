package com.example.hamzah_medbook;

public class Medicine {
    private String dateStarted;
    private String name;
    private int doseAmount;
    private String doseUnit;
    private int dailyFreq;

    public Medicine(String dateStarted, String name, int doseAmount, String doseUnit, int dailyFreq) {
        this.dateStarted = dateStarted;
        this.name = name;
        this.doseAmount = doseAmount;
        this.doseUnit = doseUnit;
        this.dailyFreq = dailyFreq;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoseAmount() {
        return doseAmount;
    }

    public void setDoseAmount(int doseAmount) {
        this.doseAmount = doseAmount;
    }

    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit;
    }

    public int getDailyFreq() {
        return dailyFreq;
    }

    public void setDailyFreq(int dailyFreq) {
        this.dailyFreq = dailyFreq;
    }
}
