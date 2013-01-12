package com.snehal.activity;

import com.snehal.utility.PersistanceStore;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class MainApp extends Application{

	public PersistanceStore settings;
	private Context context;
	
	public MainApp(Context c) {
		this.context = c;
		settings = new PersistanceStore(c);
	}
	
	public PersistanceStore getSettings(){
		return settings;
	}
	
	public void alert(String message){
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
}
