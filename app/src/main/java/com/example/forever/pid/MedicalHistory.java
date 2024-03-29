package com.example.forever.pid;



public class MedicalHistory {
    private int mHistoryId;
    private String addDate;
    private String imageName;
    private int doctorId;

    public MedicalHistory() {
    }

    public MedicalHistory(int mHistoryId, String addDate, String imageName, int doctorId) {
        this.mHistoryId = mHistoryId;
        this.addDate = addDate;
        this.imageName = imageName;
        this.doctorId = doctorId;
    }

    public MedicalHistory(String addDate, String imageName, int doctorId) {
        this.addDate = addDate;
        this.imageName = imageName;
        this.doctorId = doctorId;
    }


    public MedicalHistory(int mHistoryId, String addDate, String imageName) {
        this.mHistoryId = mHistoryId;
        this.addDate = addDate;
        this.imageName = imageName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getmHistoryId() {
        return mHistoryId;
    }

    public void setmHistoryId(int mHistoryId) {
        this.mHistoryId = mHistoryId;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}