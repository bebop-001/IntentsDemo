package com.example.IntentsDemo;
/*
 *  This demo code implements the TwistedEquation Android 4.0 Intents demos 
 *  numbers 63, 64, 64, 66 and 67 (parts 1 through 5)
 *  63: Start a second activity explicitly.
 *  64: Start a second activity implicitly.
 *  65: Start a second app to view a web page.  Set the AndroidManifest.xml
 *      file so it will respond to the request.
 *  66: Start a second activity with an intent to "share text."  Set the code up so it
 *      explicitly starts a 'chooser' and modify the AndroidManifest.xml so this app will
 *      respond to the request.
 *  67: Modify the second activity so it indicates the activity that started it.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String ourUrl = "http://kana-tutor.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void startSecondActivity(View view) {
		// changed intent and additional "intent filter" in manifest
		// file to activate the second activity as before except
		// as a custom activity.
		Toast.makeText(
				MainActivity.this, getString(R.string.second_activity), Toast.LENGTH_SHORT
				).show();
		// Explicit setup for starting SecondActivity java.
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		startActivity(intent);
	}
	public void startImplicitSecondActivity(View view) {
		// changed intent and additional "intent filter" in manifest
		// file to activate the second activity as before except
		// as a custom activity.
		Toast.makeText(
				MainActivity.this, getString(R.string.start_implicit_second_activity), Toast.LENGTH_SHORT
				).show();
		// Explicit setup for starting SecondActivity java.
		Intent intent = new Intent();
		intent.setAction("StartSecondActivity");
		startActivity(intent);
	}
	public void viewWebpage(View view) {
		// start an http request to browse kana-tutor.com.
		// intent filter in AndroidManifest.xml intercepts http request to
		// kana-tutor and allows you to start the 'second activity' or
		// select a web browser.
		Toast.makeText(
				MainActivity.this, getString(R.string.view_webpage), Toast.LENGTH_SHORT
				).show();
		// NOTE:  http is necessary to tell system to look for an html browser.
		Uri uri = Uri.parse(ourUrl);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
	public void shareText(View view) {
		// Share a string of text with another application.  Use a 'chooser' to select
		// the app.
		Toast.makeText(
				MainActivity.this, getString(R.string.share_text), Toast.LENGTH_SHORT
				).show();
		Intent intent = new Intent()
			.setAction(Intent.ACTION_SEND)
			.putExtra(Intent.EXTRA_TEXT, ourUrl)
			.setType("text/plain");
		// This broadcasts to the system and anything that handles plain text 
		// can respond.  If more than one app responds you will get the chooser.
		// startActivity(intent);
		
		// by using Intent.createChooser we can customize the name of the chooser.
		startActivity(Intent.createChooser(intent, getString(R.string.share_text)));
	}
}
