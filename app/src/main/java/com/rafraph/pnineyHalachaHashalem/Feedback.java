package com.rafraph.pnineyHalachaHashalem;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Feedback extends Activity implements View.OnClickListener
{
	TextView sendEmail;
	EditText EmailHeader, EmailContent;
	static SharedPreferences mPrefs;
	SharedPreferences.Editor shPrefEditor;
	public static final String PREFS_NAME = "MyPrefsFile";
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
		EmailHeader = (EditText) findViewById(R.id.name);
		EmailContent = (EditText) findViewById(R.id.etContent);

		sendEmail = (TextView) findViewById(R.id.bSendEmail);
		sendEmail.setOnClickListener(this);
		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		TextView gotProblem=(TextView) findViewById(R.id.newV);
		EditText edName=(EditText) findViewById(R.id.name);
		EditText edTitle=(EditText) findViewById(R.id.title);
		EditText etcontact=(EditText) findViewById(R.id.etContent);
		TextView txt3=(TextView) findViewById(R.id.textView3);
		TextView txt4=(TextView) findViewById(R.id.textView4);
		//LinearLayout main=(LinearLayout) findViewById(R.id.lnrOption2);
		//	LinearLayout main3=(LinearLayout) findViewById(R.id.lnrOption3);
		//	LinearLayout main4=(LinearLayout) findViewById(R.id.lnrOption7);
		//	LinearLayout main5=(LinearLayout) findViewById(R.id.lnrOption8);
		LinearLayout main=(LinearLayout) findViewById(R.id.main);
		if (mPrefs.getInt("BlackBackground", 0)==1)
		{
			gotProblem.setTextColor(Color.WHITE);
			edName.setTextColor(Color.WHITE);
			edName.setBackgroundColor(Color.rgb(13,13,12));
			edTitle.setTextColor(Color.WHITE);
			edTitle.setBackgroundColor(Color.rgb(13,13,12));
			etcontact.setTextColor(Color.WHITE);
			etcontact.setBackgroundColor(Color.rgb(13,13,12));

			//main.setBackgroundColor(Color.BLACK);
			main.setBackgroundColor(Color.BLACK);
			//main3.setBackgroundColor(Color.BLACK);
			//main4.setBackgroundColor(Color.BLACK);
			//main5.setBackgroundColor(Color.BLACK);


		}
		Button linkForFix = (Button) findViewById(R.id.bContentFix);
		linkForFix.setOnClickListener(this);
		findViewById(R.id.b_chap).setOnClickListener(new View.OnClickListener() {
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
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bSendEmail:
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
