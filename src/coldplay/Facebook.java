package coldplay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.ColdplayApp.R;

public class Facebook extends Activity  {
	
	
	WebView ourBrow;
	EditText url;

	
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facebooklayout);
		
		
		
		
		
		ourBrow = (WebView) findViewById(R.id.fbView);
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		
	
		
		
		
		ourBrow.setWebViewClient(new ourViewClient());
		try{
		
		
		
		ourBrow.loadUrl("https://m.facebook.com/profile.php?id=15253175252");
		} catch (Exception e){
			e.printStackTrace();
		}
	
	
		
		
		
		
		
	}


	


		
		
		
		
		
	}
	
	
	
	