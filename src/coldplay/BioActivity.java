package coldplay;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import app.ColdplayApp.R;


public class BioActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bio_text);

	TextView txt = (TextView) findViewById(R.id.textView1);
	
	txt.setText(readText());
	}
	
	private String readText() {
		InputStream inputStream = getResources().openRawResource(
				R.raw.what);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		int i;
		try{
			i = inputStream.read();
			while(i != -1){
				byteArrayOutputStream.write(i);
				i = inputStream.read();
			}
			
			inputStream.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  byteArrayOutputStream.toString();
	}
	
	@Override
	public void onBackPressed() {
	    // do nothing.
	}
	

}
