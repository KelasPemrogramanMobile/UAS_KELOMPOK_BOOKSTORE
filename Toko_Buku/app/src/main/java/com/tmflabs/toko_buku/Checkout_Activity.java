package com.tmflabs.toko_buku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Checkout_Activity extends Activity {
	
    private ListView ls_menu;
	private String email;

	Json_Parser json_parser = new Json_Parser(); 
	
	private static String Url_Transaksi=
			"http://192.168.43.74/Toko_Buku/android/info_checkout.php";
	
	private static String Url_Checkout =
		 "http://192.168.43.74/Toko_Buku/android/checkout.php";
	
	private static final String TAG_SUKSES = "sukses";
	
	public static final String TAG_ID = "id";
	public static final String TAG_Email = "email";
	public static final String TAG_Total = "total";
	
	JSONArray Data_TB = null;
	
	ArrayList<HashMap<String, String>> Data_Transaksi = new ArrayList<HashMap<String, 
			String>>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elemen);		
		
		Bundle extras = getIntent().getExtras();
		email = extras.getString("email");
		
		Json_Parser json_parser = new Json_Parser(); 
		
		Data_Transaksi = new ArrayList<HashMap<String, String>>();
		
	    List<NameValuePair> params = new ArrayList<NameValuePair>();  
	    params.add(new BasicNameValuePair("email", email));
	    
	    JSONObject json = json_parser.makeHttpRequest(Url_Transaksi, "POST", params);
	    
	    try {
	        			
	        int sukses = json.getInt(TAG_SUKSES);
	        
	        if (sukses == 1) {
	        		        	
	    		Data_TB = json.getJSONArray("Data_TB");
		        
		        for(int i = 0; i < Data_TB.length(); i++) {
		        	
		        	JSONObject maxikom = Data_TB.getJSONObject(i);
		        	
					String id = maxikom.getString(TAG_ID);
					String email = maxikom.getString(TAG_Email);
					String total = maxikom.getString(TAG_Total);	
					HashMap<String, String> hm = new HashMap<String, String>();
					
		            hm.put(TAG_ID, id);
		            hm.put(TAG_Email, email); 
		            hm.put(TAG_Total, total);             
		            Data_Transaksi.add(hm);        
		        
		        }
		        
	        }  else {
	        	Toast.makeText(Checkout_Activity.this, "Data transaksi tidak ditemukan", 1).show();
	        	finish();
	        }
        
		} catch (JSONException e) {
			e.printStackTrace();
		}   
	    
	    ListAdapter adapter = new SimpleAdapter(this, Data_Transaksi,
	    		R.layout.activity_checkout, 
        		new String[] { TAG_ID, TAG_Email, TAG_Total}, 
        		new int[] { R.id.fakturtxt, R.id.emailtxt, R.id.totaltxt});        
	    
        ls_menu = (ListView) findViewById(R.id.listview);
        ls_menu.setAdapter(adapter);
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_checkout, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_checkout:
				    		
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("email", email));
							
			JSONObject json = json_parser.makeHttpRequest(Url_Checkout,
					"POST", params);
			
        	Toast.makeText(Checkout_Activity.this, "Terima kasih, Transaksi Anda Berhasil", 1).show();
			finish();
     		Intent checkout = new Intent(Checkout_Activity.this, Menu_Activity.class);
     		startActivity(checkout);	
         		
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	
}
