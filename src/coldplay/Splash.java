package coldplay;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import app.ColdplayApp.R;


public class Splash extends Activity{
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle OhYeah) {
		// TODO Auto-generated method stub
		super.onCreate(OhYeah);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
		setContentView(R.layout.splash_main);
	    
	    
	
	    
		Thread timer = new Thread(){
			public void run(){ 
				try{
					sleep(5000);
					
				} catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					 Intent i = new Intent(Splash.this, TheTabActivity.class);
		                startActivity(i);
				}
			}
			
		};
		timer.start();
        
	}
	
	
	@Override
	public void onBackPressed() {
	    // do nothing.
	}


	

}