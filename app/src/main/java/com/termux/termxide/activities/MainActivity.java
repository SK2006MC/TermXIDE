package com.termux.termxide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.termux.databinding.ActivityMainBinding;
import com.termux.termxide.managers.SettingsManager;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private SettingsManager settingsManager;
	private ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		settingsManager = new SettingsManager(this);

		if (settingsManager.getIsFirst()) {
			startMyActivity(FirstActivity.class);
			finish();
		}

		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		initializeUI();
//		initNavView();

		initOnBackPressed();
	}

	private void initializeUI() {
	}

//	private void initNavView() {
//		binding.myNav.setNavigationItemSelectedListener(item -> {
//			int id = item.getItemId();
//			if (id == R.id.nav_settings) {
//				startMyActivity(SettingsActivity.class);
//			} else if (id == R.id.nav_about) {
//				startMyActivity(AboutActivity.class);
//			} else if (id == R.id.nav_logs) {
//				startMyActivity(LogActivity.class);
//			} else {
//				return false;
//			}
//			return true;
//		});
//	}

	public void initOnBackPressed() {
		getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
			@Override
			public void handleOnBackPressed() {
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	private void showAlert(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	private void startMyActivity(Class<?> activityClass) {
		startActivity(new Intent(this, activityClass));
	}
}