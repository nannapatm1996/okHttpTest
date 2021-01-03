package com.github.ppartisan.simplealarms.model;

import android.support.annotation.IntDef;
import android.util.SparseBooleanArray;

public class Firebase_Alarm {
    public Long id;
    public Long time;
    public String label;
    public String med;
    public String rec;
    public SparseBooleanArray allDays;
    public int is_enable;
    /*public int mon;
    public int tues;
    public int wed;
    public int thurs;
    public int fri;
    public int sat;
    public int sun;*/



    public Firebase_Alarm() {

    }

    private static SparseBooleanArray buildBaseDaysArray() {

        final int numDays = 7;

        final SparseBooleanArray array = new SparseBooleanArray(numDays);

        array.put(MON, false);
        array.put(TUES, false);
        array.put(WED, false);
        array.put(THURS, false);
        array.put(FRI, false);
        array.put(SAT, false);
        array.put(SUN, false);

        return array;

    }

    @IntDef({MON,TUES,WED,THURS,FRI,SAT,SUN})
    @interface Days{}
    public static final int MON = 1;
    public static final int TUES = 2;
    public static final int WED = 3;
    public static final int THURS = 4;
    public static final int FRI = 5;
    public static final int SAT = 6;
    public static final int SUN = 7;


    public Firebase_Alarm(long id, long time, String label, String med, String rec @Alarm.Days int... days) {
        this.id = id;
        this.time = time;
        this.label = label;
        //this.allDays = buildDaysArray(days);
        this.med = med;
        this.rec = rec;

    }


}


