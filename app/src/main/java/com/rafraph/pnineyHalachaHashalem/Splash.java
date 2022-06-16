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
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class Splash extends Activity{
	static SharedPreferences mPrefs;
	public boolean newVersion = false;
	public int MyLanguage;
	public Dialog  newVersionDialog;
	public Context context;
	private static final int HEBREW	 = 0;
	private static final int ENGLISH = 1;
	private static final int RUSSIAN = 2;
	private static final int SPANISH = 3;
	private static final int FRENCH = 4;
	SharedPreferences.Editor shPrefEditor;
	public static final String PREFS_NAME = "MyPrefsFile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		context = this;
		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		MyLanguage = mPrefs.getInt("MyLanguage", -1);
		if(MyLanguage==-1) {
			switch (Locale.getDefault().getLanguage()) {
				case "en":
					MyLanguage = ENGLISH;
					break;
				case "es":
					MyLanguage = SPANISH;
					break;
				case "ru":
					MyLanguage = RUSSIAN;
					break;
				case "fr":
					MyLanguage = FRENCH;
					break;
				default:
					MyLanguage = HEBREW;
					break;
			}

		}
		Bundle extras = getIntent().getExtras();

		if (mPrefs.getInt("StartInLastLocation", 1) == 1 && !(mPrefs.getInt("book", 0) == 0 && mPrefs.getInt("chapter", 0) == 0) && (mPrefs.getString("Version", "").equals("4") == true)) {
			try {
				Class ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.textMain");
				Intent ourIntent = new Intent(Splash.this, ourClass);
				int[] book_chapter = new int[2];
				book_chapter[0] = 0xFFFF;
				book_chapter[1] = 0xFFFF;
				ourIntent.putExtra("book_chapter", book_chapter);
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		setContentView(R.layout.splash);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.start();
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
				newVersionDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				TextView title=newVersionDialog.findViewById(R.id.title);
				TextView txt1=newVersionDialog.findViewById(R.id.txt1);
				TextView txt2=newVersionDialog.findViewById(R.id.txt2);
				TextView txt3=newVersionDialog.findViewById(R.id.txt3);
				TextView txt4=newVersionDialog.findViewById(R.id.txt4);
				TextView txt5=newVersionDialog.findViewById(R.id.txt5);
				TextView txt6=newVersionDialog.findViewById(R.id.txt6);
				TextView txt7=newVersionDialog.findViewById(R.id.txt7);
				TextView txt8=newVersionDialog.findViewById(R.id.txt8);
				if(MyLanguage==ENGLISH){
					title.setText("We have renewed!");
					txt1.setText("We are pleased to present you with the “Peninei  Halakha” app in an improved design, which includes:");
					txt2.setText("1. Clean and innovative look");
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
					txt2.setText("1. Современный дизайн");
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
					txt2.setText("1. Mirada limpia e innovadora");
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
					txt2.setText("1. Un design clair et moderne");
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
						Intent ourIntent = new Intent(Splash.this, ourClass);
						ourIntent.putExtra("homePage", false);
						ourIntent.putExtra("newV", true);
						startActivity(ourIntent);

					}
				});
				newVersionDialog.show();
			}
			else
			{
				Thread timer2 = new Thread() {
					public void run() {
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						finally {
							if(!(mPrefs.getInt("StartInLastLocation", 1) == 1 && !(mPrefs.getInt("book", 0) == 0 && mPrefs.getInt("chapter", 0) == 0) && (mPrefs.getString("Version", "").equals("4") == true))){
							Class ourClass = null;
							try {
								ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							Intent ourIntent = new Intent(Splash.this, ourClass);
							ourIntent.putExtra("goLast", true);
							startActivity(ourIntent);
							}
						}
					}
				};
				timer2.start();

			}
		}
		catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
