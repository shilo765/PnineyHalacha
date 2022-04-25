package com.rafraph.pnineyHalachaHashalem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomePage extends Activity {
    public boolean newVersion = false;
    public Dialog  newVersionDialog;
    public Context context;
    static SharedPreferences mPrefs;
    SharedPreferences.Editor shPrefEditor;
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        context = this;
        mPrefs = getSharedPreferences(PREFS_NAME, 0);
        shPrefEditor = mPrefs.edit();
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String version;
        try
        {
            version = packageManager.getPackageInfo(packageName, 0).versionName;

            if(mPrefs.getString("Version", "").equals("4") == false)
            {
                newVersion = true;
                shPrefEditor.putString("Version", version);
                shPrefEditor.commit();
                newVersionDialog = new Dialog(context);
                newVersionDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                newVersionDialog.setContentView(R.layout.new_version);
                newVersionDialog.setTitle("גרסה " + version);

                Button dialogButtonExit = (Button) newVersionDialog.findViewById(R.id.dialogButtonExit);
                // if button is clicked
                dialogButtonExit.setOnClickListener(new View.OnClickListener()
                {
                    @SuppressLint("NewApi")
                    @Override
                    public void onClick(View v)
                    {
                        newVersionDialog.dismiss();
                    }
                });
                newVersionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                            Class ourClass = null;
                            try {
                                ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            Intent ourIntent = new Intent(HomePage.this, ourClass);
                            startActivity(ourIntent);

                    }
                });
                newVersionDialog.show();
            }
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ImageView too_books= (ImageView) findViewById(R.id.too_books);
        ImageView too_py= (ImageView) findViewById(R.id.too_py);
        ImageView about_ph= (ImageView) findViewById(R.id.about_p);
        ImageView searchAll= (ImageView) findViewById(R.id.searchAll);
        ImageView mymarks= (ImageView) findViewById(R.id.my_marks);
        ImageView myLastLoc= (ImageView) findViewById(R.id.my_last_loc);
        ImageView goShop= (ImageView) findViewById(R.id.go_shop);
        ImageView askTheRav= (ImageView) findViewById(R.id.ask_the_rav);
        ImageView donate= (ImageView) findViewById(R.id.donation);
        too_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMainActivity = new Intent("com.rafraph.ph_beta.MAINACTIVITY");
                startActivity(openMainActivity);
            }
        });
        too_py.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class ourClass = null;
                try {
                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.pninaYomit");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent ourIntent = new Intent(HomePage.this, ourClass);
                startActivity(ourIntent);
            }
        });
        about_ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class ourClass = null;
                try {
                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.About_p");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent ourIntent = new Intent(HomePage.this, ourClass);
                startActivity(ourIntent);
            }
        });
        searchAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class ourClass = null;
                try {
                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent ourIntent = new Intent(HomePage.this, ourClass);
                startActivity(ourIntent);
            }
        });
        mymarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Class ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.BookmarkActivity");
                    Intent ourIntent = new Intent(HomePage.this, ourClass);
                    startActivity(ourIntent);
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        });
        myLastLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Class ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.textMain");
                    Intent ourIntent = new Intent(HomePage.this, ourClass);
                    int[] book_chapter = new int[2];
                    book_chapter[0] = 0xFFFF;
                    book_chapter[1] = 0xFFFF;
                    ourIntent.putExtra("book_chapter", book_chapter);
                    startActivity(ourIntent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        goShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://shop.yhb.org.il/"));
                startActivity(intent);
            }
        });
        askTheRav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://yhb.org.il/שאל-את-הרב-2/"));
                startActivity(intent);
            }
        });
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("https://yhb.org.il/support-us/"));
                startActivity(intent);
            }
        });
        //ImageView Sep=(ImageView) findViewById(R.id.my_marks);
        //Sep.setVisibility(View.VISIBLE);


    }
}
