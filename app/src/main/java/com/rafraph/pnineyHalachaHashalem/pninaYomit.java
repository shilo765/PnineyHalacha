package com.rafraph.pnineyHalachaHashalem;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
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
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

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
        ImageView img=(ImageView) findViewById(R.id.setNotification);
        EditText etH=(EditText) findViewById(R.id.etH);
        EditText etM=(EditText) findViewById(R.id.etM);
        ImageButton Sep=(ImageButton) findViewById(R.id.sep);
        etH.setVisibility(View.INVISIBLE);
        Sep.setVisibility(View.INVISIBLE);
        etM.setVisibility(View.INVISIBLE);
        LinearLayout l=(LinearLayout) findViewById(R.id.lnrOptions);
        l.setBackgroundColor(Color.parseColor("#fefef2"));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!notPress) {
                    img.setImageResource(R.drawable.h_set_remainder);
                    l.setBackgroundColor(Color.parseColor("#970606"));
                    etH.setVisibility(View.VISIBLE);
                    Sep.setVisibility(View.VISIBLE);
                    etM.setVisibility(View.VISIBLE);
                    notPress=true;
                }
                else
                {
                    int hour = Integer.parseInt(((EditText) findViewById(R.id.etH)).getText().toString());
                    int mins = Integer.parseInt(((EditText) findViewById(R.id.etM)).getText().toString());
                    Calendar calnder = Calendar.getInstance();
                    calnder.set(Calendar.HOUR_OF_DAY, hour);
                    calnder.set(Calendar.MINUTE, mins);

                    Intent notiReciv = new Intent(getApplicationContext(), Notification_reciver.class);
                    PendingIntent penNotu = PendingIntent.getBroadcast(getApplicationContext(), 100, notiReciv, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarm.setRepeating(AlarmManager.RTC_WAKEUP, calnder.getTimeInMillis(), AlarmManager.INTERVAL_DAY, penNotu);
                    Toast.makeText(getApplicationContext(), "התראה הוגדרה בהצלחה!", Toast.LENGTH_SHORT).show();
                    etH.setVisibility(View.INVISIBLE);
                    Sep.setVisibility(View.INVISIBLE);

                    etM.setVisibility(View.INVISIBLE);
                    l.setBackgroundColor(Color.parseColor("#fefef2"));
                    img.setImageResource(R.drawable.h_pnina_remainder);
                    notPress=false;
                }
            }
        });
        findViewById(R.id.tooApp).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent openMainActivity = new Intent("com.rafraph.ph_beta.MAINACTIVITY");
               startActivity(openMainActivity);
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