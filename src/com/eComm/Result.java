package com.eComm;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Result extends Activity {
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        
        
        Button btnExit = (Button) findViewById(R.id.ignore);
        btnExit.setOnClickListener(lExit);
        
        
    }
	private OnClickListener lExit = new OnClickListener() {
	    public void onClick(View v) {
	    	finish();
	    }
	};
}