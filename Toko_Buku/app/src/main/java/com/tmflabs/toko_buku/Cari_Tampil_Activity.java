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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RatingBar;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.ImageView;
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory;

public class Cari_Tampil_Activity extends Activity  {
			
    private ListView ls_menu;
    private String Cari;
       
    RatingBar ratingBar;
    ImageView imageview;
           
	private static String Url_Cari =
			"http://192.168.43.74/Toko_Buku/android/cari.php";
	
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
		Cari = extras.getString("Cari");
				
		Json_Parser json_parser = new Json_Parser(); 
		    
		Data_Buku = new ArrayList<HashMap<String, String>>();
				
	    List<NameValuePair> params = new ArrayList<NameValuePair>();   
	    params.add(new BasicNameValuePair("Cari", Cari));
	    
	    JSONObject json = json_parser.makeHttpRequest(Url_Cari, "POST", params);

	    try {
	        			
	        int sukses = json.getInt(TAG_SUKSES);
	        
	        if (sukses == 1) {
	        		        	
	        	Data_BK = json.getJSONArray("Data_BK");
		        
		        for(int i = 0; i < Data_BK.length(); i++) {
		        	
		        	JSONObject maxi = Data_BK.getJSONObject(i);
		        	
					String cover = maxi.getString(TAG_Cover);
					String judul = maxi.getString(TAG_Judul);		        	
					String penulis = maxi.getString(TAG_Penulis);
					String kode_buku = maxi.getString(TAG_Kode_Buku);
					String harga = maxi.getString(TAG_Harga);	
					String rating = maxi.getString(TAG_Rating);	
					String deskripsi = maxi.getString(TAG_Deskripsi);					
					
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
	        	Toast.makeText(Cari_Tampil_Activity.this, "Data tidak ditemukan !", 1).show();
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
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
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
	        	return true;	
        case R.id.menu_cari:
     		Intent cari = new Intent(Cari_Tampil_Activity.this, Cari_Activity.class);
     		startActivity(cari);	
     		finish();
        	return true;  	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	    
}
