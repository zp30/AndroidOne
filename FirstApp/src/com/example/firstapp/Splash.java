package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;

public class Splash extends Activity {

	MediaPlayer splashSound;
	
	@Override
	protected void onCreate(Bundle firstState) {
		// TODO Auto-generated method stub
		super.onCreate(firstState);
		setContentView(R.layout.splash);
		
		splashSound = MediaPlayer.create(Splash.this, R.raw.intro_evrywhrigo);
		splashSound.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(12800);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMain = new Intent("android.intent.action.MENU");
					startActivity(openMain);
				}
			}
			
		};
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashSound.release();
		finish();
	}
	
	

}
