package com.rafraph.pnineyHalachaHashalem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class About_p extends Activity
{
	Button link;
	public int MyLanguage;
	static SharedPreferences mPrefs;
	SharedPreferences.Editor shPrefEditor;
	public static final String PREFS_NAME = "MyPrefsFile";
	private static final int HEBREW	 = 0;
	private static final int ENGLISH = 1;
	private static final int RUSSIAN = 2;
	private static final int SPANISH = 3;
	private static final int FRENCH = 4;
	public Dialog acronymsDialog;
	public EditText TextToDecode;
	String acronymsText;
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
	@Override
	public void onBackPressed() {
		try
		{
			Class ourClass = null;
			Intent ourIntent;
			ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
			ourIntent = new Intent(About_p.this, ourClass);
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
		setContentView(R.layout.about_pninei);
		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		MyLanguage = mPrefs.getInt("MyLanguage", -1);
		ImageView toMain= (ImageView) findViewById(R.id.to_main);
		if(MyLanguage==ENGLISH)
			toMain.setImageResource(R.drawable.to_main_e);
		if(MyLanguage==RUSSIAN)
			toMain.setImageResource(R.drawable.to_main_r);
		if(MyLanguage==SPANISH)
			toMain.setImageResource(R.drawable.to_main_s);
		if(MyLanguage==FRENCH)
			toMain.setImageResource(R.drawable.to_main_f);
		TextView txt1=(TextView) findViewById(R.id.include);
		TextView txt2=(TextView) findViewById(R.id.headr);
		TextView txt3=(TextView) findViewById(R.id.textView3);
		TextView txt4=(TextView) findViewById(R.id.textView4);
		switch (MyLanguage)
		{
			case ENGLISH:
				txt1.setText("About the series");
				txt2.setText("The series of books, “Peninei Halakha” is the work of Rabbi Eliezer Melamed shlita, Rosh Yeshiva and Rabbi of the community Har Bracha");
				txt3.setText("Rabbi Eliezer Melamed");
				txt4.setText("Rosh Yeshivat Har Bracha and Rabbi of the community, author of the “Peninei Halakha” series, and author of the weekly column “Revivim” in the “Besheva” newspaper");
				break;
			case RUSSIAN:
				txt1.setText("О серии книг");
				txt2.setText("Серия книг \"Жемчужины Галахи\" написана равином Элиэзером Меламедом, главой ешивы и поселения Хар-Браха");
				txt3.setText("Равин Элиэзер Меламед");
				txt4.setText("Глава ешивы Хар-Браха и равин поселения, автор книг \"Жемчужины Галахи\" и еженедельной колонки \"Ревивим\"");
				break;
			case FRENCH:
				txt1.setText("Sur la collection");
				txt2.setText("La série de livre Pninei Halakha a été écrit par le rabbin Eliezer Melamed chlit'a, roch yéchiva et rabbin de Har Braha");
				txt3.setText("Le rabbin Eliezer Melamed");
				txt4.setText("Roch yéchiva et rabbin de de Har Braha, auteur de la série de livre Pninei Halkha, auteur de la colonne hebdomadaire \"revivim\" dans le journal \"béchéva\"");
				break;
			case SPANISH:
				txt1.setText("en la serie");
				txt2.setText("La serie de libros, Pninei Halaja es obra del rabino Eliezer Melamed Shlita, Rosh Yeshiva y el rabino Har Beraja.");
				txt3.setText("El rabino Eliezer enseña");
				txt4.setText("Rosh Yeshiva Har Beraja y rabino del Yishuv, autor de la serie Pninei Halaja y autor de la columna Revivim en el periódico Besheva");
				break;
			case HEBREW:
				break;
		}
		//LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption2);
	//	LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption3);
	//	LinearLayout main4=(LinearLayout) findViewById(R.id.lnrOption7);
	//	LinearLayout main5=(LinearLayout) findViewById(R.id.lnrOption8);
		RelativeLayout main2=(RelativeLayout) findViewById(R.id.layout_root);
		if (mPrefs.getInt("BlackBackground", 0)==1)
		{
			txt1.setTextColor(Color.WHITE);
			txt2.setTextColor(Color.WHITE);
			txt3.setTextColor(Color.WHITE);
			txt4.setTextColor(Color.WHITE);
			//main.setBackgroundColor(Color.BLACK);
			main2.setBackgroundColor(Color.BLACK);
			//main3.setBackgroundColor(Color.BLACK);
			//main4.setBackgroundColor(Color.BLACK);
			//main5.setBackgroundColor(Color.BLACK);


		}
		toMain.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try
				{
					Class ourClass = null;
					Intent ourIntent;
					ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
					ourIntent = new Intent(About_p.this, ourClass);
					startActivity(ourIntent);
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		});
		ImageView menu= (ImageView) findViewById(R.id.menu);
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ContextThemeWrapper ctw = new ContextThemeWrapper(About_p.this, R.style.CustomPopupTheme);
				PopupMenu popupMenu = new PopupMenu(ctw, v);
				//popupMenu.

				if(MyLanguage == ENGLISH) {
					popupMenu.getMenu().add(0,0,0,"Settings");
					popupMenu.getMenu().add(0,1,0,"Books");
					popupMenu.getMenu().add(0,2,0,"Daily Study");
					popupMenu.getMenu().add(0,3,0,"Search");
					popupMenu.getMenu().add(0,4,0,"Abbreviations");
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
					popupMenu.getMenu().add(0,4,0,"Сокращения");
					popupMenu.getMenu().add(0,5,0,"Отзыв");
					popupMenu.getMenu().add(0,6,0,"Список книг");
					popupMenu.getMenu().add(0,7,0,"Спросить равина");
					//booksDownload configHeaders[6] = "ספרים להורדה";
					popupMenu.getMenu().add(0,8,0,"О серии книг");
					popupMenu.getMenu().add(0,9,0,"О приложении");
				}
				else if(MyLanguage == SPANISH) {
					popupMenu.getMenu().add(0,0,0,"Definiciones");
					popupMenu.getMenu().add(0,1,0,"Libros");
					popupMenu.getMenu().add(0,2,0,"Estudio diario");
					popupMenu.getMenu().add(0,3,0,"Búsqueda");
					popupMenu.getMenu().add(0,4,0,"Acrónimos");
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
					popupMenu.getMenu().add(0,4,0,"Initiales");
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
					popupMenu.getMenu().add(0,2,0,"לימוד יומי");
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
								ourIntent = new Intent(About_p.this, ourClass);
								ourIntent.putExtra("homePage", true);
								startActivity(ourIntent);
								break;

							case 1:/*to books*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About_p.this, ourClass);
								ourIntent.putExtra("homePage", false);
								startActivity(ourIntent);
								break;

							case 2:/*pninaYomit*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.pninaYomit");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About_p.this, ourClass);
								startActivity(ourIntent);
								break;

							case 3:/*search in all books*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(About_p.this, ourClass);
								startActivity(ourIntent);

								break;

							case 4:/*acronyms*/
								acronymsDecode();
								break;

							case 5:/*feedback*/
								try
								{
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.Feedback");
									ourIntent = new Intent(About_p.this, ourClass);
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
									ourIntent = new Intent(About_p.this, ourClass);
									startActivity(ourIntent);
								}
								catch (ClassNotFoundException e)
								{
									e.printStackTrace();
								}
								//case 8:/*hascamot*/
								//   hascamotDialog();
								//  break;
							case 9:/*about*/
								try
								{
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.About");
									ourIntent = new Intent(About_p.this, ourClass);
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
	}


}
