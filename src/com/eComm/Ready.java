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

public class Ready extends Activity {
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ready);
        
        
        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(lExit);
        
    }
	private OnClickListener lExit = new OnClickListener() {
	    public void onClick(View v) {
	    	finish();
	    }
	};
	
	public void onPause() {
		super.onPause();
		try {
			Thread.sleep(23000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Get reference to notification manager
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
		
		int icon = R.drawable.icon;
		CharSequence tickerText = "Player(s) Found!";
		long when = System.currentTimeMillis();
		Notification notification = new Notification(icon, tickerText, when);
		
		Context context = getApplicationContext();
		CharSequence contentTitle = "Beakin";
		CharSequence contentText = "Found 1 player(s) with: Call of Duty";
		Intent notificationIntent = new Intent(this, Result.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		//default sound/light/vibrate
		//notification.defaults = Notification.DEFAULT_ALL;
		//clear notification when clicked
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		
		final int HELLO_ID = 1;
		mNotificationManager.notify(HELLO_ID, notification);
	}
}








