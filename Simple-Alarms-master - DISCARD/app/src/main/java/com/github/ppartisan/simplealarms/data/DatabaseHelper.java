package com.github.ppartisan.simplealarms.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.github.ppartisan.simplealarms.model.Alarm;
import com.github.ppartisan.simplealarms.util.AlarmUtils;

import java.util.List;

public final class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alarms.db";
    private static final int SCHEMA = 1;

    private static final String TABLE_NAME = "alarms";
    private static final String TABLE_NAME2 ="temp_alarms";
    private static final String TABLE_NEW = "alarms_new";

    public static final String _ID = "_id";
    public static final String COL_TIME = "time";
    public static final String COL_LABEL = "label";
    public static final String COL_MON = "mon";
    public static final String COL_TUES = "tues";
    public static final String COL_WED = "wed";
    public static final String COL_THURS = "thurs";
    public static final String COL_FRI = "fri";
    public static final String COL_SAT = "sat";
    public static final String COL_SUN = "sun";
    public static final String COL_IS_ENABLED = "is_enabled";
    public static final String COL_MED = "med";
    public static final String COL_REC = "rec";

    private static DatabaseHelper sInstance = null;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Log.i(getClass().getSimpleName(), "Creating database...");
        Log.d ("DBHELPER", "creating DB");
        final String CREATE_ALARMS_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TIME + " INTEGER NOT NULL, " +
                COL_LABEL + " TEXT, " +
                COL_MON + " INTEGER NOT NULL, " +
                COL_TUES + " INTEGER NOT NULL, " +
                COL_WED + " INTEGER NOT NULL, " +
                COL_THURS + " INTEGER NOT NULL, " +
                COL_FRI + " INTEGER NOT NULL, " +
                COL_SAT + " INTEGER NOT NULL, " +
                COL_SUN + " INTEGER NOT NULL, " +
                COL_IS_ENABLED + " INTEGER NOT NULL, " +
                COL_MED +" TEXT, " +
                COL_REC + "TEXT " +
                ");";

       // sqLiteDatabase.execSQL(CREATE_ALARMS_TABLE);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME);

        String CREATE_ALARMS_TABLE = "CREATE TABLE " + TABLE_NEW + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TIME + " INTEGER NOT NULL, " +
                COL_LABEL + " TEXT, " +
                COL_MON + " INTEGER NOT NULL, " +
                COL_TUES + " INTEGER NOT NULL, " +
                COL_WED + " INTEGER NOT NULL, " +
                COL_THURS + " INTEGER NOT NULL, " +
                COL_FRI + " INTEGER NOT NULL, " +
                COL_SAT + " INTEGER NOT NULL, " +
                COL_SUN + " INTEGER NOT NULL, " +
                COL_IS_ENABLED + " INTEGER NOT NULL, " +
                COL_MED + "TEXT, " +
                COL_REC + "TEXT "+
                ");";

        sqLiteDatabase.execSQL(CREATE_ALARMS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        Log.d("DBHELPER", "temptable");
        String Temp_CREATE_ALARMS_TABLE =  "CREATE TABLE " + TABLE_NAME2 + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TIME + " INTEGER NOT NULL, " +
                COL_LABEL + " TEXT, " +
                COL_MON + " INTEGER NOT NULL, " +
                COL_TUES + " INTEGER NOT NULL, " +
                COL_WED + " INTEGER NOT NULL, " +
                COL_THURS + " INTEGER NOT NULL, " +
                COL_FRI + " INTEGER NOT NULL, " +
                COL_SAT + " INTEGER NOT NULL, " +
                COL_SUN + " INTEGER NOT NULL, " +
                COL_IS_ENABLED + " INTEGER NOT NULL" +
                ");";

        sqLiteDatabase.execSQL(Temp_CREATE_ALARMS_TABLE);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME);

        Log.d("DBHELPER", "newtable");
       String CREATE_ALARMS_TABLE = "CREATE TABLE " + TABLE_NEW + " (" +
               _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               COL_TIME + " INTEGER NOT NULL, " +
               COL_LABEL + " TEXT, " +
               COL_MON + " INTEGER NOT NULL, " +
               COL_TUES + " INTEGER NOT NULL, " +
               COL_WED + " INTEGER NOT NULL, " +
               COL_THURS + " INTEGER NOT NULL, " +
               COL_FRI + " INTEGER NOT NULL, " +
               COL_SAT + " INTEGER NOT NULL, " +
               COL_SUN + " INTEGER NOT NULL, " +
               COL_IS_ENABLED + " INTEGER NOT NULL, " +
               COL_MED + "TEXT, " +
               COL_REC + "TEXT "+
               ");";

        sqLiteDatabase.execSQL(CREATE_ALARMS_TABLE);

       sqLiteDatabase.execSQL("INSERT INTO " + TABLE_NAME + " SELECT " +
               _ID + "," +COL_TIME + "," + COL_LABEL + "," + COL_MON + "," + COL_TUES + "," + COL_WED + "," +  COL_THURS +
               "," + COL_FRI + "," + COL_SAT + "," + COL_SUN + "," + COL_IS_ENABLED + "FROM" + TABLE_NAME2 );

       sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME2);
      // onCreate(sqLiteDatabase);
    }
    /*public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new UnsupportedOperationException("This shouldn't happen yet!");
    }*/

    /*public boolean insertAlarm(int _ID, int COL_TIME, String COL_MED, String COL_REC,
                               int COL_MON, int COL_TUES, int COL_WED, int COL_THURS, int COL_FRI,
                               int COL_SAT, int COL_SUN, int COL_IS_ENABLED){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_ID", 0);
        contentValues.put("COL_TIME", 12);
        contentValues.put("COL_MED", "ABC");
        contentValues.put("COL_REC", "123");
        contentValues.put("COL_MON", 0);
        contentValues.put("COL_TUES", 0);
        contentValues.put("COL_WED", 0);
        contentValues.put("COL_THURS", 0);
        contentValues.put("COL_FRI", 0);
        contentValues.put("COL_SAT", 0);
        contentValues.put("COL_SUN", 1);
        db.insert("alarms",null,contentValues);
        return true;

    }*/

    public long addAlarm() {
        return addAlarm(new Alarm());
    }

    long addAlarm(Alarm alarm) {
        return getWritableDatabase().insert(TABLE_NAME, null, AlarmUtils.toContentValues(alarm));
    }

    public int updateAlarm(Alarm alarm) {
        final String where = _ID + "=?";
        final String[] whereArgs = new String[] { Long.toString(alarm.getId()) };
        return getWritableDatabase()
                .update(TABLE_NAME, AlarmUtils.toContentValues(alarm), where, whereArgs);
    }

    public int deleteAlarm(Alarm alarm) {
        return deleteAlarm(alarm.getId());
    }

    int deleteAlarm(long id) {
        final String where = _ID + "=?";
        final String[] whereArgs = new String[] { Long.toString(id) };
        return getWritableDatabase().delete(TABLE_NAME, where, whereArgs);
    }

    public List<Alarm> getAlarms() {

        Cursor c = null;

        try{
            c = getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null);
            return AlarmUtils.buildAlarmList(c);
        } finally {
            if (c != null && !c.isClosed()) c.close();
        }

    }

}
