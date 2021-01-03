package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class editAlarm extends AppCompatActivity {
    private TimePicker mTimePicker;
    private EditText mLabel, mMed, mRec;
    private CheckBox mMon, mTues, mWed, mThurs, mFri, mSat, mSun;
    private int selectHour, currentHour;
    private int selectMinute, currentMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        Button btSave = findViewById(R.id.btnSave);
        Button btCancel = findViewById(R.id.btnCancel);
        final Calendar now = Calendar.getInstance();
        final Intent intent = new Intent(this, MainActivity.class);
        final Bundle b = new Bundle();

        //private TimePickerDialog.OnTimeSetListener

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = mTimePicker.getHour();
                    minute = mTimePicker.getMinute();
                }
                else{
                    hour = mTimePicker.getCurrentHour();
                    minute = mTimePicker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }

                b.putString("name", mLabel.getText().toString());
                b.putString("med", mMed.getText().toString());
                b.putString("recom",mRec.getText().toString());
                intent.putExtra("alarm",b);
                //b.putString("ampm",hour);

            }
        });



    }



    public static void setTimePickerTime(TimePicker picker, long time) {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);

        final int minutes = c.get(Calendar.MINUTE);
        final int hours = c.get(Calendar.HOUR_OF_DAY);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            picker.setMinute(minutes);
            picker.setHour(hours);
        } else {
            picker.setCurrentMinute(minutes);
            picker.setCurrentHour(hours);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static int getTimePickerMinute(TimePicker picker) {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                ? picker.getMinute()
                : picker.getCurrentMinute();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static int getTimePickerHour(TimePicker picker) {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                ? picker.getHour()
                : picker.getCurrentHour();
    }



}
