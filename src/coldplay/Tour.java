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

public class Tour extends Activity  {
	
	
	WebView ourBrow;
	EditText url;
	Button home;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tourlayout);
		
		ourBrow = (WebView) findViewById(R.id.fbView);
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		
		
		
		
		ourBrow.setWebViewClient(new ourViewClient());
		try{
		
		
		
		ourBrow.loadUrl("http://m.coldplay.com/live.php");
		} catch (Exception e){
			e.printStackTrace();
		}
	
	
		
		
		
		
		
	}
		
		
	}
	
	