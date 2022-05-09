package com.rafraph.pnineyHalachaHashalem;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


public class Splash extends Activity{
	static SharedPreferences mPrefs;
	SharedPreferences.Editor shPrefEditor;
	public static final String PREFS_NAME = "MyPrefsFile";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
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

		} else {
			setContentView(R.layout.splash);
			Thread timer = new Thread() {
				public void run() {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
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
			};
			timer.start();
		}
	}
	
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
