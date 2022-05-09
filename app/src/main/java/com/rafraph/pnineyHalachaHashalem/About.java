package com.rafraph.pnineyHalachaHashalem;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class About extends Activity implements View.OnClickListener
{
	Button link;
	static SharedPreferences mPrefs;
	SharedPreferences.Editor shPrefEditor;
	public static final String PREFS_NAME = "MyPrefsFile";
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		TextView about=(TextView) findViewById(R.id.about);
		TextView appName=(TextView) findViewById(R.id.appName);
		TextView include=(TextView) findViewById(R.id.include);
		TextView newV=(TextView) findViewById(R.id.newV);
		TextView newD=(TextView) findViewById(R.id.newD);
		TextView editText=(TextView) findViewById(R.id.editText);

		//LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption2);
		//	LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption3);
		//	LinearLayout main4=(LinearLayout) findViewById(R.id.lnrOption7);
		//	LinearLayout main5=(LinearLayout) findViewById(R.id.lnrOption8);
		LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption3);
		RelativeLayout main2=(RelativeLayout) findViewById(R.id.layout_root);
		if (mPrefs.getInt("BlackBackground", 0)==1)
		{
			about.setTextColor(Color.WHITE);
			appName.setTextColor(Color.WHITE);
			include.setTextColor(Color.WHITE);
			newV.setTextColor(Color.WHITE);
			newD.setTextColor(Color.WHITE);
			editText.setTextColor(Color.WHITE);




			//main.setBackgroundColor(Color.BLACK);
			main.setBackgroundColor(Color.BLACK);
			main2.setBackgroundColor(Color.BLACK);
			//main3.setBackgroundColor(Color.BLACK);
			//main4.setBackgroundColor(Color.BLACK);
			//main5.setBackgroundColor(Color.BLACK);


		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
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
