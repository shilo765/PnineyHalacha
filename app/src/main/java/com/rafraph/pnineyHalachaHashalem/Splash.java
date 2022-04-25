package com.rafraph.pnineyHalachaHashalem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Class ourClass = null;
					try {
						ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.HomePage");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					Intent ourIntent = new Intent(Splash.this, ourClass);
					startActivity(ourIntent);
				}
			}
		};
		timer.start();
	}
	
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
