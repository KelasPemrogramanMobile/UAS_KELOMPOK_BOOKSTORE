package com.tmflabs.toko_buku;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RatingBar;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.ImageView;
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory;

public class Buku_Activity extends Activity  {
			
    private ListView ls_menu;
    private String KatPos, email;
          
    RatingBar ratingBar;
    ImageView imageview;
    TextView kode, emailtv;
           
	private static String Url_Buku =
			"http://192.168.43.74/Toko_Buku/android/buku.php";
	
	private static String Url_Beli = 
			"http://192.168.43.74/Toko_Buku/android/beli.php";
	
	private static final String TAG_SUKSES = "sukses";
	
	public static final String TAG_Cover= "cover";
	public static final String TAG_Judul = "judul";	
	public static final String TAG_Penulis= "penulis";
	public static final String TAG_Kode_Buku = "kode_buku";
	public static final String TAG_Harga = "harga";
	public static final String TAG_Rating = "rating";
	public static final String TAG_Deskripsi = "deskripsi";	
	
	JSONArray Data_BK = null;
	
	ArrayList<HashMap<String, String>> Data_Buku = new ArrayList<HashMap<String, 
			String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elemen);
					
		Bundle extras = getIntent().getExtras();
		KatPos = extras.getString("KatPos");
		email = extras.getString("email");
		
		emailtv = (TextView) findViewById(R.id.emailtxt);	
		emailtv.setText(email);
		
		Json_Parser json_parser = new Json_Parser(); 
		    
		Data_Buku = new ArrayList<HashMap<String, String>>();
				
	    List<NameValuePair> params = new ArrayList<NameValuePair>();   
	    params.add(new BasicNameValuePair("KatPos", KatPos));
	    
	    JSONObject json = json_parser.makeHttpRequest(Url_Buku, "GET", params);

	    try {
	        			
	        int sukses = json.getInt(TAG_SUKSES);
	        
	        if (sukses == 1) {
	        		        	
	        	Data_BK = json.getJSONArray("Data_BK");
		        
		        for(int i = 0; i < Data_BK.length(); i++) {
		        	
		        	JSONObject maxikom = Data_BK.getJSONObject(i);
		        	
					String cover = maxikom.getString(TAG_Cover);
					String judul = maxikom.getString(TAG_Judul);		        	
					String penulis = maxikom.getString(TAG_Penulis);
					String kode_buku = maxikom.getString(TAG_Kode_Buku);
					String harga = maxikom.getString(TAG_Harga);	
					String rating = maxikom.getString(TAG_Rating);	
					String deskripsi = maxikom.getString(TAG_Deskripsi);					
					
					HashMap<String, String> hm = new HashMap<String, String>();
					

		            hm.put(TAG_Cover, cover); 
		            hm.put(TAG_Judul, judul); 					
		            hm.put(TAG_Penulis, penulis);    
		            hm.put(TAG_Kode_Buku, kode_buku); 
		            hm.put(TAG_Harga, harga);      
		            hm.put(TAG_Rating, rating); 		            	
		            hm.put(TAG_Deskripsi, deskripsi); 		            
		            Data_Buku.add(hm);        
		        
		        }
		        
	        }  else {
	        	Toast.makeText(Buku_Activity.this, "Email tidak ditemukan", 1).show();
	        	finish();
	        }

    	} catch (JSONException e) {
			e.printStackTrace();
		}   
	    
	     SimpleAdapter adapter = new SimpleAdapter(this, Data_Buku,
	    		R.layout.activity_buku, 
        		new String[] { TAG_Cover, TAG_Judul, TAG_Penulis, TAG_Kode_Buku, 
	    		TAG_Harga, TAG_Rating, TAG_Deskripsi }, 
        		
	    		new int[] { R.id.gbrimg, R.id.judtxt, R.id.penulistxt, R.id.kodetxt, 
	    		R.id.hrgtxt, R.id.ratingbar, R.id.deskripsitxt });        
	    
			
	    ls_menu = (ListView) findViewById(R.id.listview);
        adapter.setViewBinder(new Data());
        ls_menu.setAdapter(adapter);     
        
    	ls_menu.setOnItemClickListener(new OnItemClickListener()
    	{
	    	public void onItemClick(AdapterView<?> parent, View view, int position, long id) { 	    		
	    		if (emailtv.getText().toString() == "") {
	         		Intent Cek_Email = new Intent(Buku_Activity.this, Email_Activity.class);
	         		Cek_Email.putExtra("KatPos", KatPos);
	         		startActivity(Cek_Email);	
	         		finish();
	    		}else{         			
		    		String kode = ((TextView)view.findViewById(R.id.kodetxt)).getText().toString();
		    		String total = ((TextView)view.findViewById(R.id.hrgtxt)).getText().toString();
		    		
		    		Json_Parser json_parser = new Json_Parser(); 
		    		
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("email", email));
					params.add(new BasicNameValuePair("kode", kode));
					params.add(new BasicNameValuePair("total", total));
					
					JSONObject json = json_parser.makeHttpRequest(Url_Beli,
							"POST", params);
	         		
			    	Intent beli = new Intent(Buku_Activity.this, Beli_Activity.class);
		         	beli.putExtra("email", email);  
		         	startActivity(beli);
	    		}
	    	} 
    	}); 		
	}
	
	class Data implements ViewBinder{
		@Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {    		
    		if(view.getId() == R.id.ratingbar){
                String stringval = (String) data;
                float ratingValue = Float.parseFloat(stringval);
                RatingBar ratingBar = (RatingBar) view;
                ratingBar.setRating(ratingValue);
                return true;

            }else if (view.getId() == R.id.gbrimg){
                String gambar =  (String) data;  
                ImageView imageview = (ImageView) view;
                new Cover((ImageView) view.findViewById(R.id.gbrimg))
        	    .execute("http://192.168.43.74/Toko_Buku/cover/"+gambar+"");
        		return true;
            }
            return false;
        }
    }

	private class Cover extends AsyncTask<String, Void, Bitmap> {
	    ImageView imageview;	    
	    		
	    public Cover(ImageView imageview) {
	       this.imageview= imageview;
	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
			imageview.setImageBitmap(result);
	    }
	}
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_buku, menu);
		return true;
	}

    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_home:
	        finish();
     		Intent home = new Intent(Buku_Activity.this, Menu_Activity.class);
     		home.putExtra("email", email);  
     		startActivity(home);	
	        return true;	
        case R.id.menu_cari:
     		Intent cari = new Intent(Buku_Activity.this, Cari_Activity.class);  		
     		startActivity(cari);	
        	return true;  	        	
	    	default:
	            return super.onOptionsItemSelected(item);
	    }
	}	
       
}
