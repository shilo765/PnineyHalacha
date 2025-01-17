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
import android.support.v7.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Feedback extends Activity implements View.OnClickListener
{
	TextView sendEmail;
	EditText EmailHeader, EmailContent;
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
	@Override
	public void onBackPressed() {
		try
		{
			Class ourClass = null;
			Intent ourIntent;
			ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
			ourIntent = new Intent(Feedback.this, ourClass);
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
		setContentView(R.layout.activity_feedback);
		EmailHeader = (EditText) findViewById(R.id.last_search);
		EmailContent = (EditText) findViewById(R.id.etContent);

		sendEmail = (TextView) findViewById(R.id.send_feedback);
		//sendEmail.setOnClickListener(this);
		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		TextView gotProblem=(TextView) findViewById(R.id.headr);
		EditText edName=(EditText) findViewById(R.id.last_search);
		EditText edTitle=(EditText) findViewById(R.id.title);
		EditText etcontact=(EditText) findViewById(R.id.etContent);
		TextView sendFeed=(TextView) findViewById(R.id.send_feedback);
		sendFeed.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String emailaddress[] = { "shilob@yhb.org.il" };
				String header;
				String message;

				header = EmailHeader.getText().toString();
				header = "לגבי \"פניני הלכה\": " + EmailHeader.getText().toString();
				message = EmailContent.getText().toString();

				Intent emailIntent = new Intent (android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, header);
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
			}
		});
		TextView contactFix=(TextView) findViewById(R.id.bContentFix);
		//LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption2);
		//	LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption3);
		//	LinearLayout main4=(LinearLayout) findViewById(R.id.lnrOption7);
		//	LinearLayout main5=(LinearLayout) findViewById(R.id.lnrOption8);
		LinearLayout main=(LinearLayout) findViewById(R.id.main);
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
		toMain.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try
				{
					Class ourClass = null;
					Intent ourIntent;
					ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
					ourIntent = new Intent(Feedback.this, ourClass);
					ourIntent.putExtra("goLast",false);
					startActivity(ourIntent);
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		});
		switch (MyLanguage)
		{
			case ENGLISH:
				gotProblem.setText("have a problem with the app? We'll help!");
				edName.setHint("Name");
				edName.setPadding(30,10,0,0);
				edTitle.setHint("Title");
				edTitle.setPadding(30,10,0,0);
				etcontact.setHint("Referral content");
				etcontact.setPadding(30,10,0,0);
				sendFeed.setText("Send feedback");
				sendFeed.setPadding(5,0,0,0);
				contactFix.setText("For a suggested correction in the content of the books - click here");
				break;
			case RUSSIAN:
				gotProblem.setText("У Вас есть проблема с приложением? Мы поможем");
				edName.setHint("Имя");
				edName.setPadding(30,10,0,0);
				edTitle.setHint("Заголовок");
				edTitle.setPadding(30,10,0,0);
				etcontact.setHint("Текст");
				etcontact.setPadding(30,10,0,0);
				sendFeed.setText("Отзыв");
				sendFeed.setPadding(5,0,0,0);
				contactFix.setText("Для предложений изменений в тексте книг - нажмите здесь");
				break;
			case FRENCH:
				gotProblem.setText("Vous avez un problème avec l'application ? Nous sommes là pour vous aider");
				edName.setHint("Nom");
				edName.setPadding(30,10,0,0);
				edTitle.setHint("Titre");
				edTitle.setPadding(30,10,0,0);
				etcontact.setHint("Contenu de votre message");
				etcontact.setPadding(30,10,0,0);
				sendFeed.setText("Envoyez un commentaire");
				sendFeed.setPadding(5,0,0,0);
				contactFix.setText("Pour nous suggerer une correction sur le contenu du livre - appuyez ici");
				break;
			case SPANISH:
				gotProblem.setText("¿Tienes algún problema con la aplicación?, ¡te ayudaremos!");
				edName.setHint("Nombre");
				edName.setPadding(30,10,0,0);;
				edTitle.setHint("Título");
				edTitle.setPadding(30,10,0,0);
				etcontact.setHint("Contenido de la referencia");
				etcontact.setPadding(30,10,0,0);
				sendFeed.setText("Enviar comentarios");
				sendFeed.setPadding(5,0,0,0);
				contactFix.setText("Para una corrección sugerida en el contenido de los libros - haga clic aquí");
				break;
			case HEBREW:
				break;
		}
		if (mPrefs.getInt("BlackBackground", 0)==1)
		{
			gotProblem.setTextColor(Color.WHITE);
			edName.setTextColor(Color.WHITE);
			edName.setBackgroundResource(R.drawable.dark_rec);
			edTitle.setTextColor(Color.WHITE);
			edTitle.setBackgroundResource(R.drawable.dark_rec);
			etcontact.setTextColor(Color.WHITE);
			etcontact.setBackgroundResource(R.drawable.dark_big_rec);


			//main.setBackgroundColor(Color.BLACK);
			main.setBackgroundColor(Color.BLACK);
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
			//main3.setBackgroundColor(Color.BLACK);
			//main4.setBackgroundColor(Color.BLACK);
			//main5.setBackgroundColor(Color.BLACK);


		}
		ImageView menu= (ImageView) findViewById(R.id.menu);
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ContextThemeWrapper ctw = new ContextThemeWrapper(Feedback.this, R.style.CustomPopupTheme);
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
									ourIntent = new Intent(Feedback.this, ourClass);
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
								ourIntent = new Intent(Feedback.this, ourClass);
								ourIntent.putExtra("homePage", true);
								shPrefEditor.putString("where", "Feedback");
								shPrefEditor.commit();
								startActivity(ourIntent);
								break;

							case 1:/*to books*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.MainActivity");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(Feedback.this, ourClass);
								ourIntent.putExtra("homePage", false);
								startActivity(ourIntent);
								break;

							case 2:/*pninaYomit*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.pninaYomit");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(Feedback.this, ourClass);
								startActivity(ourIntent);
								break;

							case 3:/*search in all books*/
								try {
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.SearchHelp");
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								ourIntent = new Intent(Feedback.this, ourClass);
								startActivity(ourIntent);

								break;

							case 4:/*acronyms*/
								acronymsDecode();
								break;

							case 5:/*feedback*/
								try
								{
									ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.Feedback");
									ourIntent = new Intent(Feedback.this, ourClass);
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
									ourIntent = new Intent(Feedback.this, ourClass);
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
									ourIntent = new Intent(Feedback.this, ourClass);
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
		Button linkForFix = (Button) findViewById(R.id.bContentFix);
		linkForFix.setOnClickListener(this);
		findViewById(R.id.to_main).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openMainActivity = new Intent("com.rafraph.ph_beta.MAINACTIVITY");
				startActivity(openMainActivity);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.

		return true;
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
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.send_feedback:
			//String emailaddress[] = { "janer.solutions@gmail.com" };
			String emailaddress[] = { "shilob@yhb.org.il" };
			String header;
			String message;

			header = EmailHeader.getText().toString();
			header = "לגבי \"פניני הלכה\": " + EmailHeader.getText().toString();
			message = EmailContent.getText().toString();

			Intent emailIntent = new Intent (android.content.Intent.ACTION_SEND);
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, header);
			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
			startActivity(emailIntent);
			break;
			
		case R.id.bContentFix:
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			intent.addCategory(Intent.CATEGORY_BROWSABLE);
			intent.setData(Uri.parse("http://yhb.org.il/?page_id=1194"));
			startActivity(intent);
			break;

		}
	}

}
