package com.rafraph.pnineyHalachaHashalem;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class BookmarkActivity extends Activity 
{
	static SharedPreferences mPrefs;
//	SharedPreferences.Editor shPrefEditor;
	public ListView bookmarksListView = null;
	public List<String> listBookmarksNames = new ArrayList<String>();
	public String Bookmarks;
	public static final String PREFS_NAME = "MyPrefsFile";
	public static int[] book_chapter = new int[2];
	ArrayAdapter  adapter;
	SharedPreferences.Editor shPrefEditor;
	Button buttonDeleteAll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookmarks);
		bookmarksListView = (ListView) findViewById(R.id.Bookmarkslist);
		buttonDeleteAll = (Button) findViewById(R.id.buttonDeleteAll);
	//	shPrefEditor = mPrefs.edit();
		
		TextView textView = new TextView(this);
		textView.setText("סימניות");
		textView.setTextColor(Color.BLACK);
		textView.setTextSize(30);
		bookmarksListView.addHeaderView(textView);
		mPrefs = getSharedPreferences(PREFS_NAME, 0);
		shPrefEditor = mPrefs.edit();
		Bookmarks = mPrefs.getString("Bookmarks", "");
		LinearLayout main=(LinearLayout) findViewById(R.id.main);
		LinearLayout main2=(LinearLayout) findViewById(R.id.lnrOption3);
		if (mPrefs.getInt("BlackBackground", 0)==1)
		{
;
			//main.setBackgroundColor(Color.BLACK);
			main.setBackgroundColor(Color.BLACK);
			//main2.setBackgroundColor(Color.BLACK);
			//main3.setBackgroundColor(Color.BLACK);
			//main4.setBackgroundColor(Color.BLACK);
			//main5.setBackgroundColor(Color.BLACK);


		}
		fillBookmarksNames();
		showBookmarksList();

		final Context context = this;
		
		bookmarksListView.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (position != 0) {
					try {
						Class ourClass = Class.forName("com.rafraph.pnineyHalachaHashalem.textMain");
						Intent ourIntent = new Intent(BookmarkActivity.this, ourClass);
						int i, index = 1/*to skip the first comma*/, index_end = 0;
						int bookmarkScrollY, fontSize;

						for (i = 0; i < ((position - 1) * 5) + 1; i++)/*skip to the book of the right bookmark*/
							index = Bookmarks.indexOf(",", index) + 1;

						/*book*/
						index_end = Bookmarks.indexOf(",", index);
						book_chapter[0] = Integer.parseInt(Bookmarks.substring(index, index_end));

						/*chapter*/
						index = index_end + 1;
						index_end = Bookmarks.indexOf(",", index);
						book_chapter[1] = Integer.parseInt(Bookmarks.substring(index, index_end));
						ourIntent.putExtra("book_chapter", book_chapter);

						/*scroll*/
						index = index_end + 1;
						index_end = Bookmarks.indexOf(",", index);
						bookmarkScrollY = Integer.parseInt(Bookmarks.substring(index, index_end));
						ourIntent.putExtra("bookmarkScrollY", bookmarkScrollY);

						/*font size*/
						index = index_end + 1;
						index_end = Bookmarks.indexOf(",", index);
						if (index_end == -1)/*last bookmark*/
							index_end = Bookmarks.length();
						fontSize = Integer.parseInt(Bookmarks.substring(index, index_end));
						shPrefEditor.putInt("fontSize", fontSize);
						shPrefEditor.commit();

						ourIntent.putExtra("fromBookmarks", 1);
						startActivity(ourIntent);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
	

	}



	private void fillBookmarksNames()
	{
		int i, index = 0, index_end=0;
		String strBookmark = Bookmarks;
		while((index = Bookmarks.indexOf("," , index)) != -1)
		{
			index++;
			index_end = Bookmarks.indexOf("," , index);
			//listBookmarksNames.add(Bookmarks.substring(index, index_end));
			TextView textView = new TextView(getBaseContext());
			//String sourceString = "<b>" + "[" + chapterCounter + "] " + chaptersNames[i][j] + "</b> " + sections;
			//String sourceString = "<b >"+ chaptersNames[i][j].split("-")[1] + "</b>("+ chaptersNames[i][j].split("-")[0]+","+ sections+")";
			textView.setText(Bookmarks.substring(index, index_end));
			//textView.setText("shilo");
			//textView.setText(" (" + sections+ ")");/*only one item in the list per chapter*/
			if (mPrefs.getInt("BlackBackground", 0)==1)
			{
				textView.setTextColor(Color.WHITE);
				bookmarksListView.setBackgroundColor(Color.BLACK);

			}
			else
				textView.setTextColor(Color.BLACK);
			textView.setTextSize(24);
			bookmarksListView.addFooterView(textView);
			for(i=0;i<4;i++)/*skip all other fields*/
				index = Bookmarks.indexOf("," , index) + 1;
		}
	}
	
	public void showBookmarksList()
	{
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listBookmarksNames);
		bookmarksListView.setAdapter(adapter);
	}	

}
