package android.rss;



import java.net.URL;


import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.rss.RSSItem;
import android.rss.RSSParser;



import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import app.ColdplayApp.R;

public class RssMain extends ListActivity {
    private ArrayList<RSSItem> itemlist = null;
    private RSSListAdaptor rssadaptor = null;
    
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main12);

    
    
    
	ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
	NetworkInfo ninfo = cManager.getActiveNetworkInfo();
	if(ninfo!=null && ninfo.isConnected()) {
	
	} else {
		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Sorry There is no internet please check your connection!");
        builder1.setCancelable(true);
        builder1.setPositiveButton("I Will!",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        

        AlertDialog alert11 = builder1.create();
        alert11.show();
		
	}
    
    
    
    
    
    itemlist = new ArrayList<RSSItem>();
    
    new RetrieveRSSFeeds().execute();
}

@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            
            RSSItem data = itemlist.get(position);
            
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(data.link));
            
            startActivity(intent);
    }

    private void retrieveRSSFeed(String urlToRssFeed,ArrayList<RSSItem> list)
{
    try
    {
       URL url = new URL(urlToRssFeed);
       SAXParserFactory factory = SAXParserFactory.newInstance();
       SAXParser parser = factory.newSAXParser();
       XMLReader xmlreader = parser.getXMLReader();
       RSSParser theRssHandler = new RSSParser(list);

       xmlreader.setContentHandler(theRssHandler);

       InputSource is = new InputSource(url.openStream());

       xmlreader.parse(is);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

private class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void>
{
    private ProgressDialog progress = null;
    
            @Override
            protected Void doInBackground(Void... params) {
                    retrieveRSSFeed("http://www.coldplaying.com/feed/",itemlist);
                    
                    rssadaptor = new RSSListAdaptor(RssMain.this, R.layout.rssitemview,itemlist);
                    
                    return null;
            }
    
            @Override
            protected void onCancelled() {
                    super.onCancelled();
            }
            
            @Override
            protected void onPreExecute() {
                    progress = ProgressDialog.show(
                    		RssMain.this, null, "Loading RSS Feeds...");
                    
                    super.onPreExecute();
            }
            
            @Override
            protected void onPostExecute(Void result) {
                    setListAdapter(rssadaptor);
                    
                    progress.dismiss();
                    
                    super.onPostExecute(result);
            }
            
            @Override
            protected void onProgressUpdate(Void... values) {
                    super.onProgressUpdate(values);
            }
}

private class RSSListAdaptor extends ArrayAdapter<RSSItem>{
    private List<RSSItem> objects = null;
    
            public RSSListAdaptor(Context context, int textviewid, List<RSSItem> objects) {
                    super(context, textviewid, objects);
                    
                    this.objects = objects;
            }
            
            @Override
            public int getCount() {
                    return ((null != objects) ? objects.size() : 0);
            }
            
            @Override
            public long getItemId(int position) {
                    return position;
            }
            
            @Override
            public RSSItem getItem(int position) {
                    return ((null != objects) ? objects.get(position) : null);
            }
            
            public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;
                    
                    if(null == view)
                    {
                            LayoutInflater vi = (LayoutInflater)RssMain.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            view = vi.inflate(R.layout.rssitemview, null);
                    }
                    
                    RSSItem data = objects.get(position);
                    
                    if(null != data)
                    {
                            TextView title = (TextView)view.findViewById(R.id.txtTitle);
                            TextView date = (TextView)view.findViewById(R.id.txtDate);
                          
                            
                            title.setText(data.title);
                            date.setText("on " + data.date);
                            
                    }
                    
                    return view;
            }
}

@Override
public void onBackPressed() {
    // do nothing.
}



}