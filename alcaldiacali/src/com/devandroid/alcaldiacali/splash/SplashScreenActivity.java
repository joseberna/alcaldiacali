package com.devandroid.alcaldiacali.splash;

import java.util.Timer;
import java.util.TimerTask;
import com.devandroid.alcaldiacali.MainActivity;
import com.devandroid.alcaldiacali.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class SplashScreenActivity extends Activity {
	private static final long SPLASH_SCREEN_DELAY = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash_screen);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Intent mainIntent = new Intent().setClass(
						SplashScreenActivity.this, MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		};
		// Simulate a long loading process on application startup.
		Timer timer = new Timer();
		timer.schedule(task, SPLASH_SCREEN_DELAY);
	}
}
