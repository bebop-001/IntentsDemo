package com.example.IntentsDemo;
/*
 * Second activity is opened either implicitly or explicitly by the MainAction.
 * Print a bit of activity about what opened us.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends Activity {
	// The view that started this activity...
	Intent intent;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.second_activity);
		Log.i("SecondActivity:", "onCreate");
		// and our intent is...
		intent = this.getIntent();
		// this action's text view...
		textView = (TextView) findViewById(R.id.secondActivityText);
		
		// the 'action' that started the intent
		String intentAction = intent.getAction();
		textView.setText("intent.getAction() = \"" 
			+ ((intentAction == null) ? "NULL" : intentAction) + "\"");
		super.onCreate(savedInstanceState);
	}
}
