package com.eComm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class main extends Activity {
    
	private String listItems[] = {"Texas Hold'Em", "Pong", "Hangman", "Call of Duty", "Need for Speed", "Archetype", "Backgammon", "Minecraft", "Angry Birds"};
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //handles to objects
        ListView lv = (ListView) findViewById(R.id.ActivityList);
        
        //Listeners
        Button btnCont = (Button) findViewById(R.id.btnContinue);
        btnCont.setOnClickListener(lContinue);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(lCancel);
        
        //set-up
        lv.setAdapter(new ArrayAdapter(this, R.layout.listitem, R.id.activityItem, listItems));
        lv.setTextFilterEnabled(true); //allows you to type for search
    }
    
	// Create an anonymous implementation of OnClickListener
	private OnClickListener lContinue = new OnClickListener() {
	    public void onClick(View v) {
	    	Intent myIntent = new Intent(main.this, Ready.class);
	    	startActivity(myIntent);
	    }
	};
	private OnClickListener lCancel = new OnClickListener() {
	    public void onClick(View v) {
	    	finish();
	    }
	};
	
	public void onPause() {
		super.onPause();
		finish();
	}
}





