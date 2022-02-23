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
import android.widget.Toast;

import java.util.Calendar;

public class pninaYomit extends Activity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnina_yomit);
        webview = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = webview.getSettings();
        webSettings.setDefaultTextEncodingName("utf-8");
        webview.requestFocusFromTouch();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webview.loadUrl("https://ph.yhb.org.il/pninayomit/");
        webview.scrollTo(0,680);
        webSettings.setDomStorageEnabled(true);
        createNotiChannel();
        refresh(300);
        findViewById(R.id.setNotifcation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calnder=Calendar.getInstance();
                calnder.set(Calendar.HOUR_OF_DAY,18);
                calnder.set(Calendar.MINUTE,57);

                Intent notiReciv=new Intent(getApplicationContext(), Notification_reciver.class);
                PendingIntent penNotu=PendingIntent.getBroadcast(getApplicationContext(),100,notiReciv,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarm=(AlarmManager) getSystemService(ALARM_SERVICE);
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,calnder.getTimeInMillis(),AlarmManager.INTERVAL_DAY,penNotu);
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
            Toast.makeText(getApplicationContext(), "עודכן בהצלחה", Toast.LENGTH_LONG).show();
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
        if(webview.getScrollY()<680)
            webview.setScrollY(680);
        refresh(300);
    }


}