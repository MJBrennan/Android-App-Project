package coldplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import app.ColdplayApp.R;

public class Twitter extends Activity {
	
	
	WebView ourBrow;
	EditText url;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twitterlayout);
		
		ourBrow = (WebView) findViewById(R.id.fbView);
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		
		
		
		
		ourBrow.setWebViewClient(new ourViewClient());
		try{
		
		
		
		ourBrow.loadUrl("https://mobile.twitter.com/coldplay");
		} catch (Exception e){
			e.printStackTrace();
		}
	
	
		
		
		
		
		
	}





		
		
		
		
		
	}
	
	
	