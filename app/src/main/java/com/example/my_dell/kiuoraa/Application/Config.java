package com.example.my_dell.kiuoraa.Application;



import android.content.Context;

public class Config {
    public static final String DB_NAME = "Kioura";
    public static final String DB_SESSION = "Db.session";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_2 = "dd-MM-yyyy";
    public static final String DB_ATT_LIST_KEY = "dbattlist";
    public static final String DB_PROFILE = "dbprofile";
    public static final String DB_TimeTable = "dptimetable";
    public static final String TT_DATA = "timetable";
    public static final String MARK_ATTENDANCE = "mark_attendancee";
    public static final String OFFLINE_DATA_ATT = "offline_att_data";
    public static final String ACADEMIC_CALENDAR = "academic_calendar";
    public static final String PREVIOUSATTENDANCERESPOCE = "previous_attendance_response";
    public static final String REGISTRATION_COMPLETE="registrationComplete";
    public static final String PUSH_NOTIFICATION="pushNotification";

    public static final String VIEW_ATTENDANCE = "viewAttendance";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static String getPath(Context context) {

        String OFFLINE_ATTENDANCE_PATH= "/storage/emulated/0/KAKSHA/"+DB_NAME+".txt";
        return OFFLINE_ATTENDANCE_PATH;
    }
    public static final String EMP_IMG_PATH = "https://www.kiet.edu/Musterroll/Employee_images/";

}
