package com.rafraph.pnineyHalachaHashalem;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_pninei);
		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		MyLanguage = mPrefs.getInt("MyLanguage", -1);
		ImageView toMain= (ImageView) findViewById(R.id.b_chap);
		TextView txt1=(TextView) findViewById(R.id.include);
		TextView txt2=(TextView) findViewById(R.id.newV);
		TextView txt3=(TextView) findViewById(R.id.textView3);
		TextView txt4=(TextView) findViewById(R.id.textView4);
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
				PopupMenu popupMenu = new PopupMenu(About_p.this, v);
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
					popupMenu.getMenu().add(0,1,0,"אודות");
					popupMenu.getMenu().add(0,2,0,"משוב");
					popupMenu.getMenu().add(0,3,0,"הסבר על החיפוש");
					popupMenu.getMenu().add(0,4,0,"ראשי תיבות");
					popupMenu.getMenu().add(0,5,0,"הסכמות");
					//booksDownload configHeaders[6] = "ספרים להורדה";
					popupMenu.getMenu().add(0,6,0,"Language / שפה");
				}
				popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
				{

					@Override
					public boolean onMenuItemClick(MenuItem item)
					{
						Class ourClass = null;
						Intent ourIntent;
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

							case 1:/*about*/
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
							case 2:/*Feedback*/
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
							case 3:/*Explanation for Search*/
								try
								{
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
									ourIntent = new Intent(About_p.this, ourClass);
									startActivity(ourIntent);
								}
								catch (ClassNotFoundException e)
								{
									e.printStackTrace();
								}
								break;
							case 4:/*acronyms*/


								break;

							case 5:/*hascamot*/

								break;
							case 6:/*language*/
								;
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
