package coldplay;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import app.ColdplayApp.R;



@SuppressWarnings("deprecation")
public class TheTabActivity extends TabActivity {
	TabHost tabHost;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tabHost = getTabHost();
		setTabs();
	}
	private void setTabs()
	{
		addTab("News", R.drawable.homeicon1, android.rss.RssMain.class);
		addTab("Videos", R.drawable.videoicon1, app.video.YoutubeTabPlayer.class);
		addTab("Gallery", R.drawable.galleryicon1, PhotoActivity2.class);
		addTab("Bio", R.drawable.bioicon1, BioActivity.class);
		addTab("More", R.drawable.moreicon1, Menu.class);
	}
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
	
	
	
	@Override
	public void onBackPressed() {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}