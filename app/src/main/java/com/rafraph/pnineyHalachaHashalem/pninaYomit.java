package com.rafraph.pnineyHalachaHashalem;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class pninaYomit extends Activity {
    public static final String PREFS_NAME = "MyPrefsFile";
    static SharedPreferences mPrefs;
    SharedPreferences.Editor shPrefEditor;
    WebView webview;
    private static final int HEBREW	 = 0;
    private static final int ENGLISH = 1;
    private static final int RUSSIAN = 2;
    private static final int SPANISH = 3;
    private static final int FRENCH = 4;
    private NumberPicker etH,etM;
    public static AlarmManager alarm=null;
    public static PendingIntent penNotu=null;
    private String[] pickerValsH,pickerValsM;
    public boolean notPress=false;
    public static int scrool=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnina_yomit);
       // webview.clearView();

        webview = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = webview.getSettings();
        webSettings.setDefaultTextEncodingName("utf-8");
        webview.requestFocusFromTouch();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webview.setWebChromeClient(new WebChromeClient());
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        mPrefs = getSharedPreferences(PREFS_NAME, 0);
        shPrefEditor = mPrefs.edit();
        int MyLanguage = mPrefs.getInt("MyLanguage", 0);
        switch (MyLanguage)
        {
            case ENGLISH:
                webview.loadUrl("https://ph.yhb.org.il/pninayomit-en/#page-text");
                break;
            case RUSSIAN:
                webview.loadUrl("https://ph.yhb.org.il/pninayomit-ru/#page-text");
                break;
            case FRENCH:
                webview.loadUrl("https://ph.yhb.org.il/pninayomit-fr/#page-text");
                break;
            case SPANISH:
                webview.loadUrl("https://ph.yhb.org.il/pninayomit-es/#page-text");
                break;
            case HEBREW:
                webview.loadUrl("https://ph.yhb.org.il/pninayomit/#page-text");
                break;
        }


        scrool=webview.getScrollY();

        createNotiChannel();
        refresh(10);
        TextView img=(TextView) findViewById(R.id.bSendEmail);
        ImageView deleteR=(ImageView) findViewById(R.id.deleteReminder);
        etH=(NumberPicker) findViewById(R.id.etH);
        etM=(NumberPicker) findViewById(R.id.etM);
        ImageButton Sep=(ImageButton) findViewById(R.id.sep);
        etH.setVisibility(View.INVISIBLE);
        Sep.setVisibility(View.INVISIBLE);
        etM.setVisibility(View.INVISIBLE);
        LinearLayout l=(LinearLayout) findViewById(R.id.lnrOptions);
        //String[] values = {"Public", "Shared", "Private"};
        etH.setMaxValue(23);
        etH.setMinValue(0);
        //etH.def
        etH.setWrapSelectorWheel(true);
        etM.setMaxValue(59);
        etM.setMinValue(0);
        //etH.def
        etM.setWrapSelectorWheel(true);
        //etH.setDisplayedValues(values);
        pickerValsM = new String[] {"00", "01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
        pickerValsH = new String[] {"00", "01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};

        etH.setDisplayedValues(pickerValsH);
        etM.setDisplayedValues(pickerValsM);
        etH.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int valuePicker1 = etH.getValue();
                Log.d("picker value", pickerValsH[valuePicker1] + "");

            }
        });
        etM.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int valuePicker1 = etM.getValue();
                Log.d("picker value", pickerValsM[valuePicker1] + "");
            }
        });
        l.setBackgroundColor(Color.parseColor("#fefef2"));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!notPress) {
                   // img.setBackgroundResource(R.drawable.h_set_remainder);
                    img.setPadding(0,0,150,0);
                    img.setText("קבע");
                    l.setBackgroundColor(Color.parseColor("#970606"));
                    etH.setVisibility(View.VISIBLE);
                    Sep.setVisibility(View.VISIBLE);
                    etM.setVisibility(View.VISIBLE);
                    notPress=true;
                }
                else
                {
                    int hour=0,mins=0;
                    try {
                         hour = ((NumberPicker) findViewById(R.id.etH)).getValue();
                         mins = ((NumberPicker) findViewById(R.id.etM)).getValue();
                    Calendar calnder = Calendar.getInstance();
                    calnder.set(Calendar.HOUR_OF_DAY, hour);
                    calnder.set(Calendar.MINUTE, mins);

                    Intent notiReciv = new Intent(getApplicationContext(), Notification_reciver.class);
                    penNotu = PendingIntent.getBroadcast(getApplicationContext(), 100, notiReciv, PendingIntent.FLAG_UPDATE_CURRENT);
                    alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarm.setRepeating(AlarmManager.RTC_WAKEUP, calnder.getTimeInMillis(), AlarmManager.INTERVAL_DAY, penNotu);
                    Toast.makeText(getApplicationContext(), "התראה הוגדרה בהצלחה!", Toast.LENGTH_SHORT).show();
                    String setH="",setM="";
                    if(((NumberPicker) findViewById(R.id.etH)).getValue()<10)
                        setH+="0";
                    if(((NumberPicker) findViewById(R.id.etM)).getValue()<10)
                        setM+="0";
                    img.setText(setH+((NumberPicker) findViewById(R.id.etH)).getValue()+" : "+setM+((NumberPicker) findViewById(R.id.etM)).getValue());


                    etH.setVisibility(View.INVISIBLE);
                    Sep.setVisibility(View.INVISIBLE);
                    img.setPadding(50,0,0,0);
                    etM.setVisibility(View.INVISIBLE);
                    l.setBackgroundColor(Color.parseColor("#fefef2"));
                    //img.setBackgroundResource(R.drawable.h_set_remainder);
                    notPress=false;
//
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "נא למלא את השעה", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        deleteR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm.cancel(penNotu);
                Toast.makeText(getApplicationContext(), "ההתראה בוטלה", Toast.LENGTH_SHORT).show();
                etH.setVisibility(View.INVISIBLE);
                Sep.setVisibility(View.INVISIBLE);
                img.setPadding(50,0,0,0);
                etM.setVisibility(View.INVISIBLE);
                l.setBackgroundColor(Color.parseColor("#fefef2"));
                //img.setBackgroundResource(R.drawable.h_set_remainder);
                notPress=false;
            }
        });
        findViewById(R.id.tooApp).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Class ourClass = null;
               try {
                   ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
               Intent ourIntent = new Intent(pninaYomit.this, ourClass);
               startActivity(ourIntent);
            }
        });
    }

    private void createNotiChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name="hi";
            String des="hiAgain";
            int imp= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notifyLemubit",name,imp);
            channel.setDescription(des);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    private void refresh(int millisec) {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
        handler.postDelayed(runnable, millisec);
    }
    public void content()
    {

        refresh(10);
    }


}