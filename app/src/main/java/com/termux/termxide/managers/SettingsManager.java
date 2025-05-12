package com.termux.termxide.managers;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class SettingsManager {

	private static final String KEY_IS_FIRST = "is first";
	private static final String  KEY_HOME_PATH = "home path";
	SharedPreferences preferences;

	public SettingsManager(Context context){
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}
	public boolean getIsFirst() {
		return preferences.getBoolean(KEY_IS_FIRST,true);
	}

	public String getHomePath(){
		return preferences.getString(KEY_HOME_PATH,"");
	}
}
