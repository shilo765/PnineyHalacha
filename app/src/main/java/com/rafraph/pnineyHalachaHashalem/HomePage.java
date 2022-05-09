package com.rafraph.pnineyHalachaHashalem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class HomePage extends Activity {
    public boolean newVersion = false;
    public int MyLanguage;
    public Dialog  newVersionDialog;
    public Context context;
    static SharedPreferences mPrefs;
    SharedPreferences.Editor shPrefEditor;
    public static final String PREFS_NAME = "MyPrefsFile";
    private static final int HEBREW	 = 0;
    private static final int ENGLISH = 1;
    private static final int RUSSIAN = 2;
    private static final int SPANISH = 3;
    private static final int FRENCH = 4;
    public EditText TextToDecode;
    public Dialog acronymsDialog;
    String acronymsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        context = this;
        mPrefs = getSharedPreferences(PREFS_NAME, 0);
        shPrefEditor = mPrefs.edit();
        MyLanguage = mPrefs.getInt("MyLanguage", -1);
        Bundle extras = getIntent().getExtras();


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
                            ourIntent.putExtra("homePage", false);
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
        ImageView menu= (ImageView) findViewById(R.id.menu);
        LinearLayout main=(LinearLayout) findViewById(R.id.main);
        LinearLayout main2=(LinearLayout) findViewById(R.id.lnrOption2);
        LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption7);
        if (mPrefs.getInt("BlackBackground", 0)==1)
        {
            main.setBackgroundColor(Color.BLACK);
            main2.setBackgroundColor(Color.BLACK);
            main3.setBackgroundColor(Color.BLACK);
        }
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(HomePage.this, v);
                //popupMenu.

                if(MyLanguage == ENGLISH) {

                    popupMenu.getMenu().add(0,0,0,"Settings");
                    popupMenu.getMenu().add(0,1,0,"About");
                    popupMenu.getMenu().add(0,2,0,"Feedback");
                    popupMenu.getMenu().add(0,3,0,"Explanation of search results");
                    popupMenu.getMenu().add(0,4,0,"Acronyms");
                    popupMenu.getMenu().add(0,5,0,"Approbations");
                    popupMenu.getMenu().add(0,6,0,"Language / שפה");
                }
                else if(MyLanguage == RUSSIAN) {
                    popupMenu.getMenu().add(0,0,0,"Настройки");
                    popupMenu.getMenu().add(0,1,0,"Около");
                    popupMenu.getMenu().add(0,2,0,"Обратная связь");
                    popupMenu.getMenu().add(0,3,0,"Объяснение результатов поиска");
                    popupMenu.getMenu().add(0,4,0,"Абревиатуры");
                    popupMenu.getMenu().add(0,5,0,"Апробации");
                    popupMenu.getMenu().add(0,6,0,"ЯЗЫК / שפה");
                }
                else if(MyLanguage == SPANISH) {
                    popupMenu.getMenu().add(0,0,0,"Ajustes");
                    popupMenu.getMenu().add(0,1,0,"Acerca de");
                    popupMenu.getMenu().add(0,2,0,"Comentarios");
                    popupMenu.getMenu().add(0,3,0,"Explicacion del resultado de la busqueda");
                    popupMenu.getMenu().add(0,4,0,"Acronimos");
                    popupMenu.getMenu().add(0,5,0,"Aprovaciones");
                    popupMenu.getMenu().add(0,6,0,"Idioma / שפה");
                }
                else if(MyLanguage == FRENCH) {
                    popupMenu.getMenu().add(0,0,0,"Definitions");
                    popupMenu.getMenu().add(0,1,0,"A Propos de…");
                    popupMenu.getMenu().add(0,2,0,"Commentaires");
                    popupMenu.getMenu().add(0,3,0,"Explication de la recherche");
                    popupMenu.getMenu().add(0,4,0,"Acronymes");
                    popupMenu.getMenu().add(0,5,0,"Approbations");
                    popupMenu.getMenu().add(0,6,0,"Langue / שפה");
                }
                else {/*this is the default*/
                    popupMenu.getMenu().add(0,0,0,"הגדרות");
                    popupMenu.getMenu().add(0,1,0,"חיפוש");
                    popupMenu.getMenu().add(0,2,0,"ספרים");
                    popupMenu.getMenu().add(0,3,0,"לימוד יומי");
                    popupMenu.getMenu().add(0,4,0,"משוב");
                    popupMenu.getMenu().add(0,5,0,"רכישת ספרים");
                    popupMenu.getMenu().add(0,6,0,"שאל את הרב");
                    popupMenu.getMenu().add(0,7,0,"ראשי תיבות");
                    popupMenu.getMenu().add(0,8,0,"הסכמות");
                    //booksDownload configHeaders[6] = "ספרים להורדה";
                    popupMenu.getMenu().add(0,9,0,"אודות");
                }
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {

                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        Class ourClass = null;
                        Intent ourIntent;
                        Intent intent;
                    switch (item.getItemId())
                        {
                            case 0:/*settings*/

                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                ourIntent.putExtra("homePage", true);
                                startActivity(ourIntent);
                                break;

                            case 1:/*search in all books*/
                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                startActivity(ourIntent);

                                break;
                            case 2:/*to books*/
                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                ourIntent.putExtra("homePage", false);
                                startActivity(ourIntent);
                                break;

                            case 3:/*pninaYomit*/
                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.pninaYomit");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                startActivity(ourIntent);
                                break;
                            case 4:/*feedback*/
                                try
                                {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.Feedback");
                                    ourIntent = new Intent(HomePage.this, ourClass);
                                    startActivity(ourIntent);
                                }
                                catch (ClassNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:/*buy books*/
                                intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://shop.yhb.org.il/"));
                                startActivity(intent);
                                break;

                            case 6:/*ask the rav*/
                                intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://yhb.org.il/שאל-את-הרב-2/"));
                                startActivity(intent);
                                break;
                            case 7:/*acronyms*/
                                acronymsDecode();
                            break;
                            case 8:/*hascamot*/
                                hascamotDialog();
                                break;
                            case 9:/*about*/
                                try
                                {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.About");
                                    ourIntent = new Intent(HomePage.this, ourClass);
                                    startActivity(ourIntent);
                                }
                                catch (ClassNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                break;


                        default:
                            break;
                    }
				return true;
                }
                });

                popupMenu.show();
            }
        });
        too_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMainActivity = new Intent("com.rafraph.ph_beta.MAINACTIVITY");
                openMainActivity.putExtra("homePage", false);
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
    void acronymsDecode()
    {
        final Context context = this;

        // custom dialog
        acronymsDialog = new Dialog(context);
        acronymsDialog.setContentView(R.layout.acronyms);
        acronymsDialog.setTitle("פענוח ראשי תיבות");

        Button dialogButtonExit = (Button) acronymsDialog.findViewById(R.id.dialogButtonExit);
        Button dialogButtonDecode = (Button) acronymsDialog.findViewById(R.id.dialogButtonDecode);
        final TextView decodedText = (TextView) acronymsDialog.findViewById(R.id.textViewDecodedText);
        //final byte[] buffer;
        //final int size;

        TextToDecode = (EditText) acronymsDialog.findViewById(R.id.editTextAcronyms );

        // if button is clicked
        dialogButtonExit.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v)
            {
                acronymsDialog.dismiss();
            }
        });

        dialogButtonDecode.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v)
            {
                acronymsText = "\r\n" + /*"י\"א" */TextToDecode.getText().toString() + " - ";
                acronymsText = acronymsText.replace("\"", "");
                acronymsText = acronymsText.replace("'", "");
                InputStream is;
                String r="לא נמצאו תוצאות";
                int index=0, index_end=0, first=1;
                try
                {
                    is = getAssets().open("acronyms.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    String strText  = new String(buffer);

                    while (strText.indexOf(acronymsText, index_end) != -1)
                    {
                        index = strText.indexOf(acronymsText, index);
                        index = strText.indexOf("-", index+1) + 2;
                        index_end = strText.indexOf("\r\n", index);
                        if(first==1)
                        {
                            r = strText.substring (index, index_end);
                            first=0;
                        }
                        else
                            r += ", " + strText.substring (index, index_end);
                    }
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                decodedText.setText(TextToDecode.getText().toString() + " - " + r);

            }
        });
        acronymsDialog.show();
    }
    @SuppressLint("SetJavaScriptEnabled")
    void hascamotDialog()
    {
        final Context context = this;
        final Dialog dialog = new Dialog(context);
        int fontSize;
        WebView webviewHascmot;
        WebSettings webSettingsHascamot;

        dialog.setContentView(R.layout.note);

        dialog.setTitle(" הסכמות ");

        webviewHascmot = (WebView) dialog.findViewById(R.id.webViewNote1);
        webSettingsHascamot = webviewHascmot.getSettings();
        webSettingsHascamot.setJavaScriptEnabled(true);
        webSettingsHascamot.setDefaultTextEncodingName("utf-8");
        webviewHascmot.requestFocusFromTouch();
        //	if(API < 19)
        //	webSettingsNote.setBuiltInZoomControls(true);

        fontSize = mPrefs.getInt("fontSize", 20);
        webSettingsHascamot.setDefaultFontSize(fontSize);
        int backgroundColor = mPrefs.getInt("BlackBackground", 0);
        webviewHascmot.setBackgroundColor(backgroundColor);
        if(backgroundColor==1)
            webviewHascmot.loadUrl("file:///android_asset/hascamot_white.html");
        else
        {
            webviewHascmot.loadUrl("file:///android_asset/hascamot.html");
            webviewHascmot.setBackgroundColor(Color.WHITE);
        }

        dialog.show();
    }
}
