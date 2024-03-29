package com.example.forever.pid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DoctorDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Pid";
    public static final int DATABASE_VERSION = 1;

    public static final String DOCTOR_INFO_TABLE = "doctor_table";
    public static final String DOC_ID = "doc_id";
    public static final String DOC_NAME = "doc_name";
    public static final String DOC_DETAILS = "doc_details";
    //public static final String DOC_APNMT_TIME_START = "apnmt_time_start";
    //public static final String DOC_APNMT_TIME_END = "apnmt_time_end";
    public static final String DOC_APNMT_DATE = "apnmt_date";
    public static final String DOC_PHONE = "phone";
    public static final String DOC_EMAIL= "email";
    public static final String CREATE_DOCTOR_TABLE = "create table " +DOCTOR_INFO_TABLE+"("+
            DOC_ID+" integer primary key, "+
            DOC_NAME+" text, "+
            DOC_DETAILS+" text, "+
            DOC_APNMT_DATE+" text, "+
            DOC_PHONE+" text, "+
            DOC_EMAIL+" text);";

    public static final String MEDICAL_HISTORY_TABLE = "history_table";
    public static final String MH_ID = "mh_id";
    public static final String DOC_MH_ID = "mh_doc_id";
    public static final String MH_IMAGE_NAME = "image_name";
    public static final String MH_DATE = "mh_apnmt_date";
    public static final String CREATE_HISTORY_TABLE = "create table " +MEDICAL_HISTORY_TABLE+"("+
            MH_ID+" integer primary key, "+
            DOC_MH_ID+" integer, "+
            MH_IMAGE_NAME+" text, "+
            MH_DATE+" text);";

    public DoctorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME,  null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOCTOR_TABLE);
        db.execSQL(CREATE_HISTORY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exits"+DOCTOR_INFO_TABLE);
        db.execSQL("drop table if exits"+MEDICAL_HISTORY_TABLE);
        onCreate(db);

    }
    public void clearDatabase(){

        SQLiteDatabase db = this.getWritableDatabase(); //get database
        //db.execSQL("DELETE FROM "+ DOCTOR_INFO_TABLE+""); //delete all rows in a table
        //db.execSQL("drop table if exits"+DOCTOR_INFO_TABLE);
        //db.execSQL("drop table if exits"+MEDICAL_HISTORY_TABLE);
        db.delete(DOCTOR_INFO_TABLE,null,null);
        db.delete(MEDICAL_HISTORY_TABLE,null,null);
        db.close();
    }
}
