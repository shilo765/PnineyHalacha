package com.rafraph.pnineyHalachaHashalem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class About_p extends Activity
{
	Button link;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_pninei);
		ImageView too_books= (ImageView) findViewById(R.id.books);
		ImageView too_py= (ImageView) findViewById(R.id.rav);
		findViewById(R.id.too_main).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Class ourClass = null;
				try {
					ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				Intent ourIntent = new Intent(About_p.this, ourClass);
				startActivity(ourIntent);
			}
		});
	}


}
