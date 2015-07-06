package coldplay;



import android.app.Activity;
import android.os.Bundle;
import app.ColdplayApp.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class HomeActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);  
        
       AdView adView = (AdView) this.findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       adView.loadAd(adRequest);
        
        
    }
}