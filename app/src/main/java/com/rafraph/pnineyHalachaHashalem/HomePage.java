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
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
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
    public void onBackPressed() {
        finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        downBack dd=new downBack();

        context = this;
        mPrefs = getSharedPreferences(PREFS_NAME, 0);
        shPrefEditor = mPrefs.edit();
        //shPrefEditor.putBoolean("try",true);
        MyLanguage = mPrefs.getInt("MyLanguage", -1);
        TextView dayliyLimud=findViewById(R.id.daily_limud);
        TextView theBooks=findViewById(R.id.the_books);
        TextView theMarks=findViewById(R.id.the_marks);
        TextView theSearch=findViewById(R.id.the_search);
        TextView theSettings=findViewById(R.id.the_settings);
        TextView theLast=findViewById(R.id.the_last);
        TextView theQuiz=findViewById(R.id.the_quiz);
        TextView theAsk=findViewById(R.id.the_ask);
        TextView bePartner=findViewById(R.id.be_partner);
        TextView buyBooks=findViewById(R.id.buy_books);
        ImageView toMain= (ImageView) findViewById(R.id.to_main);
        ImageView askTheRav= (ImageView) findViewById(R.id.ask_the_rav);
        ImageView donate= (ImageView) findViewById(R.id.donation);
        ImageView quiz= (ImageView) findViewById(R.id.take_quiz);
        ImageView cart= (ImageView) findViewById(R.id.go_shop);
        if(MyLanguage==ENGLISH){
            toMain.setImageResource(R.drawable.to_main_e);
            dayliyLimud.setText("Daily Study");
            theBooks.setText("Books");
            theMarks.setText("Bookmarks");
            theSearch.setText("Search");
            theSettings.setText("Settings");
            theLast.setText("Last location");
            theQuiz.setText("hebrew testing");
            theAsk.setText("Ask the Rabbi");
            bePartner.setText("Donations");
            buyBooks.setText("Purchasing books");
        }
        if(MyLanguage==RUSSIAN)
        {
            toMain.setImageResource(R.drawable.to_main_r);
            dayliyLimud.setText("Ежедневное изучение");
            theBooks.setText("Книги");
            theMarks.setText("Закладки");
            theSearch.setText("Поиск");
            theSettings.setText("Настройки");
            theLast.setText("Последние место чтения");
            theQuiz.setText("hebrew testing ");
            theAsk.setText("Спросить равина");
            askTheRav.setPadding(65,0,0,0);
            askTheRav.setScaleY(1f);
            askTheRav.setScaleX(1f);
            donate.setPadding(65,0,0,0);
            donate.setScaleY(0.6f);
            donate.setScaleX(0.6f);
            quiz.setPadding(0,0,45,0);
            quiz.setScaleY(1f);
            quiz.setScaleX(1f);
            bePartner.setText("Пожертвования");
            buyBooks.setText("Список книг");
        }
        if(MyLanguage==SPANISH)
        {
            toMain.setImageResource(R.drawable.to_main_s);
            dayliyLimud.setText("Estudio diario");
            theBooks.setText("Libros");
            theMarks.setText("Signets");
            theSearch.setText("Búsqueda");
            theSettings.setText("Definiciones");
            theLast.setText("Última ubicación");
            theQuiz.setText("hebrew testing ");
            theAsk.setText("pregúntale al rabino");
            askTheRav.setPadding(75,0,0,0);
            askTheRav.setScaleY(1f);
            askTheRav.setScaleX(1f);
            quiz.setPadding(0,0,55,0);
            quiz.setScaleY(1f);
            quiz.setScaleX(1f);
            bePartner.setText("Donaciones");
            buyBooks.setText("compra de libros");
        }
        if(MyLanguage==FRENCH)
        {
            toMain.setImageResource(R.drawable.to_main_f);
            dayliyLimud.setText("étude quotidienne");
            theBooks.setText("livres");
            theMarks.setText("Marcadores");
            theSearch.setText("Recherche");
            theSettings.setText("Réglages");
            theLast.setText("Dernier emplacement");
            theQuiz.setText("hebrew testing ");
            theAsk.setText("Demander au rav");
            bePartner.setText("Devenez partenaires");
            buyBooks.setText("Achat de livres");
            buyBooks.setPadding(0,0,0,0);
            askTheRav.setPadding(65,0,0,0);
            askTheRav.setScaleY(1f);
            askTheRav.setScaleX(1f);
            donate.setPadding(115,0,0,0);
            donate.setScaleY(0.9f);
            donate.setScaleX(0.9f);
            quiz.setPadding(0,0,55,0);
            quiz.setScaleY(1f);
            quiz.setScaleX(1f);
            cart.setPadding(0,0,25,0);
            cart.setScaleY(0.7f);
            cart.setScaleX(0.7f);
        }
        Bundle extras = getIntent().getExtras();


        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ImageView too_books= (ImageView) findViewById(R.id.too_main);
        ImageView too_py= (ImageView) findViewById(R.id.to_py);
        ImageView settings= (ImageView) findViewById(R.id.settings);
        ImageView searchAll= (ImageView) findViewById(R.id.searchAll);
        ImageView mymarks= (ImageView) findViewById(R.id.my_marks);
        ImageView myLastLoc= (ImageView) findViewById(R.id.my_last_loc);
        ImageView goShop= (ImageView) findViewById(R.id.go_shop);


        ImageView takeQuiz= (ImageView) findViewById(R.id.take_quiz);

        LinearLayout main=(LinearLayout) findViewById(R.id.main);
        LinearLayout main2=(LinearLayout) findViewById(R.id.lnrOption2);
        LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption7);
        LinearLayout main4=(LinearLayout) findViewById(R.id.lnrOption9);
        LinearLayout main5=(LinearLayout) findViewById(R.id.lnrOption10);
        LinearLayout main6=(LinearLayout) findViewById(R.id.lnrOption11);

        if (mPrefs.getInt("BlackBackground", 0)==1)
        {
            main.setBackgroundColor(Color.BLACK);
            main2.setBackgroundColor(Color.BLACK);
            main3.setBackgroundColor(Color.BLACK);
            main4.setBackgroundColor(Color.BLACK);
            main5.setBackgroundColor(Color.BLACK);
            main6.setBackgroundColor(Color.BLACK);
            if(MyLanguage==ENGLISH)
                toMain.setImageResource(R.drawable.to_main_b_e);
            if(MyLanguage==RUSSIAN)
                toMain.setImageResource(R.drawable.to_main_b_r);
            if(MyLanguage==SPANISH)
                toMain.setImageResource(R.drawable.to_main_b_s);
            if(MyLanguage==FRENCH)
                toMain.setImageResource(R.drawable.to_main_b_f);
            if(MyLanguage==HEBREW)
                toMain.setImageResource(R.drawable.to_main_b);
            main=(LinearLayout) findViewById(R.id.lnrOption3);
            ImageView menu= (ImageView) findViewById(R.id.menu);
            menu.setImageResource(R.drawable.ic_action_congif_b);
            main.setBackgroundColor(Color.rgb(120,1,1));
        }
        ImageView menu= (ImageView) findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextThemeWrapper ctw = new ContextThemeWrapper(HomePage.this, R.style.CustomPopupTheme);
                PopupMenu popupMenu = new PopupMenu(ctw, v);
                //popupMenu.

                if(MyLanguage == ENGLISH) {

                    popupMenu.getMenu().add(0,0,0,"Settings");
                    popupMenu.getMenu().add(0,1,0,"Books");
                    popupMenu.getMenu().add(0,2,0,"Daily Study");
                    popupMenu.getMenu().add(0,3,0,"Search");

                    popupMenu.getMenu().add(0,5,0,"Contact Us");
                    popupMenu.getMenu().add(0,6,0,"Purchasing books");
                    popupMenu.getMenu().add(0,7,0,"Ask the Rabbi");
                    //booksDownload configHeaders[6] = "ספרים להורדה";
                    popupMenu.getMenu().add(0,8,0,"About the series");
                    popupMenu.getMenu().add(0,9,0,"About");
                }
                else if(MyLanguage == RUSSIAN) {

                    popupMenu.getMenu().add(0,0,0,"Настройки");
                    popupMenu.getMenu().add(0,1,0,"Книги");
                    popupMenu.getMenu().add(0,2,0,"Ежедневное изучение");
                    popupMenu.getMenu().add(0,3,0,"Поиск");
                    popupMenu.getMenu().add(0,5,0,"Отзыв");
                    popupMenu.getMenu().add(0,6,0,"Список книг");
                    popupMenu.getMenu().add(0,7,0,"Спросить равина");
                    //booksDownload configHeaders[6] = "ספרים להורדה";
                    popupMenu.getMenu().add(0,8,0,"О серии книг");
                    popupMenu.getMenu().add(0,9,0,"О приложении");
                }
                else if(MyLanguage == SPANISH) {
                    toMain.setImageResource(R.drawable.to_main_s);
                    popupMenu.getMenu().add(0,0,0,"Definiciones");
                    popupMenu.getMenu().add(0,1,0,"Libros");
                    popupMenu.getMenu().add(0,2,0,"Estudio diario");
                    popupMenu.getMenu().add(0,3,0,"Búsqueda");

                    popupMenu.getMenu().add(0,5,0,"retroalimentación");
                    popupMenu.getMenu().add(0,6,0,"compra de libros");
                    popupMenu.getMenu().add(0,7,0,"pregúntale al rabino");
                    //booksDownload configHeaders[6] = "ספרים להורדה";
                    popupMenu.getMenu().add(0,8,0,"en la serie");
                    popupMenu.getMenu().add(0,9,0,"sobre");
                }
                else if(MyLanguage == FRENCH) {

                    popupMenu.getMenu().add(0,0,0,"Réglages");
                    popupMenu.getMenu().add(0,1,0,"livres");
                    popupMenu.getMenu().add(0,2,0,"étude quotidienne");
                    popupMenu.getMenu().add(0,3,0,"Recherche");
                    popupMenu.getMenu().add(0,5,0,"Contact Us");
                    popupMenu.getMenu().add(0,6,0,"Achat de livres");
                    popupMenu.getMenu().add(0,7,0,"Demander au rav");
                    //booksDownload configHeaders[6] = "ספרים להורדה";
                    popupMenu.getMenu().add(0,8,0,"Sur la collection");
                    popupMenu.getMenu().add(0,9,0,"À propos");
                }
                else {/*this is the default*/
                    popupMenu.getMenu().add(0,0,0,"הגדרות");
                    popupMenu.getMenu().add(0,1,0,"ספרים");
                    popupMenu.getMenu().add(0,2,0,"הלימוד היומי");
                    popupMenu.getMenu().add(0,3,0,"חיפוש");
                    popupMenu.getMenu().add(0,4,0,"ראשי תיבות");
                    popupMenu.getMenu().add(0,5,0,"משוב");
                    popupMenu.getMenu().add(0,6,0,"רכישת ספרים");
                    popupMenu.getMenu().add(0,7,0,"שאל את הרב");
                    //booksDownload configHeaders[6] = "ספרים להורדה";
                    popupMenu.getMenu().add(0,8,0,"על הסדרה");
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

                            case 1:/*to books*/
                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                ourIntent.putExtra("homePage", false);
                                startActivity(ourIntent);
                                break;

                            case 2:/*pninaYomit*/
                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.pninaYomit");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                startActivity(ourIntent);
                                break;

                            case 3:/*search in all books*/
                                try {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ourIntent = new Intent(HomePage.this, ourClass);
                                startActivity(ourIntent);

                                break;

                            case 4:/*acronyms*/
                                acronymsDecode();
                                break;

                            case 5:/*feedback*/
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
                            case 6:/*buy books*/
                                intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://shop.yhb.org.il/"));
                                startActivity(intent);
                                break;

                            case 7:/*ask the rav*/
                                intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://yhb.org.il/שאל-את-הרב-2/"));
                                startActivity(intent);
                                break;
                            case 8:/*about pninei*/
                                try
                                {
                                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.About_p");
                                    ourIntent = new Intent(HomePage.this, ourClass);
                                    startActivity(ourIntent);
                                }
                                catch (ClassNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                            //case 8:/*hascamot*/
                             //   hascamotDialog();
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
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class ourClass = null;
                try {
                    ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent ourIntent = new Intent(HomePage.this, ourClass);
                ourIntent.putExtra("homePage", true);
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
        if(mPrefs.getString("Version", "").equals("4.1.7") == false)
        {

            String version = null;
            try {
                version = packageManager.getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            newVersion = true;
            shPrefEditor.putString("Version", version);
            shPrefEditor.commit();
            newVersionDialog = new Dialog(context);
            newVersionDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            newVersionDialog.setContentView(R.layout.new_version);
            newVersionDialog.setTitle("גרסה " + version);
            newVersionDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            TextView title=newVersionDialog.findViewById(R.id.title);
            TextView txt1=newVersionDialog.findViewById(R.id.txt1);

            TextView txt3=newVersionDialog.findViewById(R.id.txt3);
            TextView txt4=newVersionDialog.findViewById(R.id.txt4);
            TextView txt5=newVersionDialog.findViewById(R.id.txt5);
            TextView txt6=newVersionDialog.findViewById(R.id.txt6);
            TextView txt7=newVersionDialog.findViewById(R.id.txt7);
            TextView txt8=newVersionDialog.findViewById(R.id.txt8);
            if(MyLanguage==ENGLISH){
                title.setText("We have renewed!");
                txt1.setText("We are pleased to present you with the “Peninei  Halakha” app in an improved design, which includes:");
                txt3.setText("2. Completion of all “Peninei Halakha” books in languages");
                txt4.setText("3. Improving search engine results including auto-completion");
                txt5.setText("4. Daily halakha and the possibility of scheduling a reminder");
                txt6.setText("5. Troubleshooting");
                txt7.setText("Enjoy your study!");
                txt8.setText("App team \"Peninei Halakha\"");
            }
            if(MyLanguage==RUSSIAN)
            {
                title.setText("Обновление!");
                txt1.setText("Рады представить Вам приложение \"Жемчужины Галахи\" в обновленном дизайне, который включает в себя:");

                txt3.setText("2. Дополнение книгами на иностранных языках");
                txt4.setText("3. Улучшение поиска, включая автозаполнение");
                txt5.setText("4. Программа \"Ежедневная жемчужина\" и возможность установить напоминание об обучении");
                txt6.setText("5. Устранены баги");
                txt7.setText("Наслаждайтесь Вашей учебой");
                txt8.setText("Коллектив приложения Жемчужины Галахи");
            }
            if(MyLanguage==SPANISH)
            {
                title.setText("¡Hemos renovado!");
                txt1.setText("Nos complace presentarle la aplicación Pninei Halaja con un diseño mejorado, que incluye:");
                txt3.setText("2. Finalización de todos los libros de referencia en idiomas.");
                txt4.setText("3. Mejorar los resultados del motor de búsqueda, incluida la finalización automática");
                txt5.setText("4. Halajá diaria y la posibilidad de programar un recordatorio.");
                txt6.setText("5. Resolución de problemas.");
                txt7.setText("¡Aprendizaje divertido!");
                txt8.setText("personal de la aplicación Pninei de Halajá");
            }
            if(MyLanguage==FRENCH)
            {
                title.setText("Nous avons renouvelé !");
                txt1.setText("Nous sommes heureux de vous présenter la version améliorée de notre application, au sommaire :");
                txt3.setText("2. La mise à jour du contenu avec désormais la collection complète du receuil 'PNINÉ HALAKHA'' en langues étrangères");
                txt4.setText("3. Un nouveau moteur de recherche intuitif");
                txt5.setText("4. L'étude d'une loi quotidienne avec la possibilité de programmer un rappel automatique sur votre téléphone");
                txt6.setText("5. La correction de bugs");
                txt7.setText("Bonne étude !");
                txt8.setText("L'équipe de l'appli PNINÉ HALAKHA");
            }




            ImageView dialogExit = (ImageView) newVersionDialog.findViewById(R.id.dialogButtonExit);
            // if button is clicked
            dialogExit.setOnClickListener(new View.OnClickListener()
            {
                @SuppressLint("NewApi")
                @Override
                public void onClick(View v)
                {
                    Class ourClass = null;
                    try {
                        ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Intent ourIntent = new Intent(HomePage.this, ourClass);

                    ourIntent.putExtra("homePage", false);
                    ourIntent.putExtra("newV", true);
                    startActivity(ourIntent);
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
                    ourIntent.putExtra("newV", true);
                    startActivity(ourIntent);

                }
            });
            newVersionDialog.show();
        }
        goShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://shop.yhb.org.il/"));
                if(MyLanguage==ENGLISH)
                intent.setData(Uri.parse("https://shop.yhb.org.il/en/"));
                if(MyLanguage==FRENCH)
                    intent.setData(Uri.parse("https://shop.yhb.org.il/fr/"));
                if(MyLanguage==RUSSIAN)
                    intent.setData(Uri.parse("https://shop.yhb.org.il/ru/"));
                if(MyLanguage==SPANISH)
                    intent.setData(Uri.parse("https://shop.yhb.org.il/es/"));
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
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://test.yhb.org.il/#/login"));
                startActivity(intent);
            }
        });
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if(MyLanguage==HEBREW)
                intent.setData(Uri.parse("https://yhb.org.il/support-us/"));
                else
                    intent.setData(Uri.parse("https://en.yhb.org.il/donations/"));
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
