package com.example.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.Calendar;


public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = MyReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive - Intent Action: " + intent.getAction());
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
           // new timeHttpGet(context).execute();
        }
    }

   /* public static class timeHttpGet extends AsyncTask<String, Void, String > {
        private WeakReference<Context> myReceiverWeakReference;
        timeHttpGet(Context context) {
            myReceiverWeakReference = new WeakReference<>(context);
        }
        @Override
     //   protected String doInBackground(String... parameters) {
     //       OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://classroom.pitchayakit.com/alarm/alarm_time.php")
                    .build();
     //       try {
       //         Response response = client.newCall(request).execute();
                Log.d(TAG, "timeHttpGet result : " + response.toString());
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "timeHttpGet error : " + e);
            }
            return null;
        }*/


}
