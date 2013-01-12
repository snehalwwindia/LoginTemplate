package com.snehal.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PersistanceStore {
	
	private SharedPreferences preferences;
	private final String NAME="user_name";
	private final String PASSWORD="password";
	private final String FLAG_SAVE_PASSWORD="flag_save_password";
	private final String DEFAULT="";
	private final String LOGIN_STATUS="login_status";
	
	public PersistanceStore(Context context) {
		// TODO Auto-generated constructor stub
		if(null==context)
			throw new NullPointerException("Context should not be null");
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public final void setUserName(String uname) {
		Editor editor = preferences.edit();
		editor.putString(NAME, uname);
		editor.commit();
	}

	public final String getUserName() {
		return preferences.getString(NAME,DEFAULT);
	}
	
	public final void setPassword(String password) {
		Editor editor = preferences.edit();
		editor.putString(PASSWORD, password);
		editor.commit();
	}

	public final String getPassword() {
		return preferences.getString(PASSWORD,DEFAULT);
	}
	
	public final void setFlagSavePassword(boolean flag) {
		Editor editor = preferences.edit();
		editor.putBoolean(FLAG_SAVE_PASSWORD, flag);
		editor.commit();
	}

	public final boolean getFlagSavePassword() {
		return preferences.getBoolean(FLAG_SAVE_PASSWORD,false);
	}
	
	public boolean getLoginStatus() {
		return preferences.getBoolean(LOGIN_STATUS, false);
	}
	
	public void setLoginStatus(boolean status)
	{
		Editor editor = preferences.edit();
		editor.putBoolean(LOGIN_STATUS,status);
		editor.commit();
	}
}
