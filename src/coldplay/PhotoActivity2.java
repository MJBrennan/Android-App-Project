package coldplay;





import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import app.ColdplayApp.R;

public class PhotoActivity2 extends Activity {	
	
    Integer[] imageIDs = {
            R.drawable.who1,
            R.drawable.who2,
            R.drawable.who3,
            R.drawable.who4,
            R.drawable.who5,
            R.drawable.who6,
            R.drawable.who7, 
            R.drawable.who8,
            R.drawable.who9,
            R.drawable.who10,
            R.drawable.who11,
            R.drawable.who12,
            R.drawable.who13,
            
    };
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photolayout);
        
        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        

        
        
    	ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
		NetworkInfo ninfo = cManager.getActiveNetworkInfo();
		if(ninfo!=null && ninfo.isConnected()) {
		//do nothing
			
		} else {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Sorry There is no internet please check your connection!");
            builder1.setCancelable(false);
            builder1.setPositiveButton("I Will!",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                   
                }
            });
       


            AlertDialog alert11 = builder1.create();
            alert11.show();
			
		}
		
        
        
        
        
        
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        
        gallery.setAdapter(new ImageAdapter(this));        
        gallery.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {                
                
                
                //---display the images selected---
                ImageView imageView = (ImageView) findViewById(R.id.image1);                
                imageView.setImageResource(imageIDs[position]);
            }
        });
    }
    
    public class ImageAdapter extends BaseAdapter 
    {
        private Context context;
        private int itemBackground;
 
        public ImageAdapter(Context c) 
        {
            context = c;
          
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = a.getResourceId(
                R.styleable.Gallery1_android_galleryItemBackground, 0);
            a.recycle();                    
        }
 
        
        public int getCount() {
            return imageIDs.length;
        } 
        
       
        public Object getItem(int position) {
            return position;
        }            
        
                
        public long getItemId(int position) {
            return position;
        }
  
        
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
        
        
        
    }    
    
    @Override
    public void onBackPressed() {
      
    }
    
    
    
}