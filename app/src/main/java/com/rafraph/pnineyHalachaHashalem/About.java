package com.rafraph.pnineyHalachaHashalem;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class About extends Activity implements View.OnClickListener
{
	private static final int HEBREW	 = 0;
	private static final int ENGLISH = 1;
	private static final int RUSSIAN = 2;
	private static final int SPANISH = 3;
	private static final int FRENCH = 4;
	Button link;
	static SharedPreferences mPrefs;
	SharedPreferences.Editor shPrefEditor;
	public static final String PREFS_NAME = "MyPrefsFile";
	public Dialog acronymsDialog;
	public EditText TextToDecode;
	String acronymsText;
	void acronymsDecode()
	{
		final Context context = this;
		//shilo
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
	@Override
	public void onBackPressed() {
		try
		{
			Class ourClass = null;
			Intent ourIntent;
			ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
			ourIntent = new Intent(About.this, ourClass);
			startActivity(ourIntent);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();

		TextView appName=(TextView) findViewById(R.id.appName);
		TextView include=(TextView) findViewById(R.id.include);
		TextView newV=(TextView) findViewById(R.id.headr);
		TextView newD=(TextView) findViewById(R.id.newD);
		TextView editText=(TextView) findViewById(R.id.editText);
		ImageView img=findViewById(R.id.to_main);
		int MyLanguage = mPrefs.getInt("MyLanguage", 0);

		ImageView toMain = (ImageView) findViewById(R.id.to_main);
		if(MyLanguage==ENGLISH)
			toMain.setImageResource(R.drawable.to_main_e);
		if(MyLanguage==RUSSIAN)
			toMain.setImageResource(R.drawable.to_main_r);
		if(MyLanguage==SPANISH)
			toMain.setImageResource(R.drawable.to_main_s);
		if(MyLanguage==FRENCH)
			toMain.setImageResource(R.drawable.to_main_f);
		ImageView menu= (ImageView) findViewById(R.id.menu);
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ContextThemeWrapper ctw = new ContextThemeWrapper(About.this, R.style.CustomPopupTheme);
				PopupMenu popupMenu = new PopupMenu(ctw, v);
				//popupMenu.

				if(MyLanguage == ENGLISH) {
					popupMenu.getMenu().add(0,-1,0,"Homepage");
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
					popupMenu.getMenu().add(0,-1,0,"домашняя страница");
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
					popupMenu.getMenu().add(0,-1,0,"Página principal");
					popupMenu.getMenu().add(0,0,0,"Definiciones");
					popupMenu.getMenu().add(0,1,0,"Libros");
					popupMenu.getMenu().add(0,2,0,"Estudio diario");
					popupMenu.getMenu().add(0,3,0,"Búsqueda");
					popupMenu.getMenu().add(0,5,0,"Retroalimentación");
					popupMenu.getMenu().add(0,6,0,"Compra de libros");
					popupMenu.getMenu().add(0,7,0,"Pregúntale al rabino");
					//booksDownload configHeaders[6] = "ספרים להורדה";
					popupMenu.getMenu().add(0,8,0,"En la serie");
					popupMenu.getMenu().add(0,9,0,"Sobre");
				}
				else if(MyLanguage == FRENCH) {
					popupMenu.getMenu().add(0,-1,0,"Page d'accueil");
					popupMenu.getMenu().add(0,0,0,"Réglages");
					popupMenu.getMenu().add(0,1,0,"Livres");
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
					popupMenu.getMenu().add(0,-1,0,"דף הבית");
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
							case -1:/*Home page*/

								try
								{
									ourClass = null;

									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
									ourIntent = new Intent(About.this, ourClass);
									startActivity(ourIntent);
								}
								catch (ClassNotFoundException e)
								{
									e.printStackTrace();
								}
								break;
							case 0:/*settings*/

								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About.this, ourClass);
								ourIntent.putExtra("homePage", true);
								shPrefEditor.putString("where", "About");
								shPrefEditor.commit();

								startActivity(ourIntent);
								break;

							case 1:/*to books*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About.this, ourClass);
								ourIntent.putExtra("homePage", false);
								startActivity(ourIntent);
								break;

							case 2:/*pninaYomit*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.pninaYomit");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About.this, ourClass);
								startActivity(ourIntent);
								break;

							case 3:/*search in all books*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About.this, ourClass);
								startActivity(ourIntent);

								break;

							case 4:/*acronyms*/
								acronymsDecode();
								break;

							case 5:/*feedback*/
								try
								{
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.Feedback");
									ourIntent = new Intent(About.this, ourClass);
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

								if(MyLanguage==FRENCH)
									intent.setData(Uri.parse("https://shop.yhb.org.il/fr/"));
								if(MyLanguage==RUSSIAN)
									intent.setData(Uri.parse("https://shop.yhb.org.il/ru/"));
								if(MyLanguage==SPANISH)
									intent.setData(Uri.parse("https://shop.yhb.org.il/es/"));
								if(MyLanguage==ENGLISH)
									intent.setData(Uri.parse("https://shop.yhb.org.il/en/"));
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
									ourIntent = new Intent(About.this, ourClass);
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
									ourIntent = new Intent(About.this, ourClass);
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
		switch (MyLanguage)
		{
			case ENGLISH:
				appName.setText("Peninei Halakha App");
				include.setText("Includes all “Peninei Halakha” books (including Harchavot) in Hebrew, English, Russian and French");
				newV.setText("Updated version of Shilo Ben Natan");
				newD.setText("Application design Anya Sara Borochov");
				editText.setText("Editing the text for the application Elisha Haneshka and Shilo Ben Natan");
				break;
			case RUSSIAN:

				appName.setText("Приложение \"Жемчужины Галахи\"");
				include.setText("Содержит все книги \"Жемчужины Галахи\" (включая дополнения) на иврите, английском, русском и французском");
				newV.setText("Обновление версии Шило бен Натан");
				newD.setText("Дизайн приложения Аня Сара Борохов");
				editText.setText("Редактирование текста для приложения Элиша Хеншкен и Шило бен Натан");
				break;
			case FRENCH:

				appName.setText("Application Pninei Halakha");
				include.setText("Inclus tous les livres de Pninei Halakha (incluant les approfondissements) en hébreu, anglais, russe et français");
				newV.setText("Version mise à jour par Chilo Ben Nathan");
				newD.setText("Design de l'application par Ania Sarah Borokhov");
				editText.setText("Texte de l'application édité par Elicha Anchaka et Chilo Ben Nathan");
				break;
			case SPANISH:

				appName.setText("Aplicación Pninei Halaja");
				include.setText("Incluye todos los libros de Pninei Halajá (incluidas las extensiones) en hebreo, inglés, ruso y francés");
				newV.setText("Versión actualizada de Sheila Ben Natan");
				newD.setText("Diseño de aplicaciones Anya Sara Borochov");
				editText.setText("Edición del texto para la aplicación Elisha Haneshka y Sheila Ben Natan");
				break;
			case HEBREW:
				break;
		}
		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try
				{
					Class ourClass = null;
					Intent ourIntent;
					ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
					ourIntent = new Intent(About.this, ourClass);
					startActivity(ourIntent);
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		});

		//LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption2);
		//	LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption3);
		//	LinearLayout main4=(LinearLayout) findViewById(R.id.lnrOption7);
		//	LinearLayout main5=(LinearLayout) findViewById(R.id.lnrOption8);

		RelativeLayout main2=(RelativeLayout) findViewById(R.id.layout_root);
		if (mPrefs.getInt("BlackBackground", 0)==1)
		{

			appName.setTextColor(Color.WHITE);
			include.setTextColor(Color.WHITE);
			newV.setTextColor(Color.WHITE);
			newD.setTextColor(Color.WHITE);
			editText.setTextColor(Color.WHITE);
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
			LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption3);
			menu.setImageResource(R.drawable.ic_action_congif_b);
			main.setBackgroundColor(Color.rgb(120,1,1));




			//main.setBackgroundColor(Color.BLACK);

			main2.setBackgroundColor(Color.BLACK);
			//main3.setBackgroundColor(Color.BLACK);
			//main4.setBackgroundColor(Color.BLACK);
			//main5.setBackgroundColor(Color.BLACK);


		}

	}
	private  void speak()
	{
		Intent intd=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intd.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intd.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		intd.putExtra(RecognizerIntent.EXTRA_PROMPT, "do somthing");
		try {
			Toast.makeText(getApplicationContext(), "result.get(0)", Toast.LENGTH_LONG).show();
			startActivityForResult(intd,1000);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Toast.makeText(getApplicationContext(), "result.get(0)", Toast.LENGTH_LONG).show();
		switch (requestCode){
			case 1000:{
				if(resultCode==RESULT_OK&&null!=data)
				{
					ArrayList<String> result =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					TextView include=(TextView) findViewById(R.id.include);
					include.setText(result.get(0));
					Toast.makeText(getApplicationContext(), "result.get(0)", Toast.LENGTH_LONG).show();
				}
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		return true;
	}
	
	public void onClick(View v)
	{
		// TODO Auto-generated method stub

		Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://shop.yhb.org.il/"));
        startActivity(intent);
	}
}
