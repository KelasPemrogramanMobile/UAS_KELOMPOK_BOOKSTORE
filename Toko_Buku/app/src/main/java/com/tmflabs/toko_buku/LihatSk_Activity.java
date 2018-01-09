package com.tmflabs.toko_buku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LihatSk_Activity extends Activity implements OnItemClickListener {
		
    private ListView ls_menu;
    
	private static String Url_Saran_Kritik =
			"http://192.168.43.74/Toko_Buku/android/lihat_saran_kritik.php";
	
	private static final String TAG_SUKSES = "sukses";
	
	public static final String TAG_Nama = "nama";
	public static final String TAG_Tanggal = "tanggal";
	public static final String TAG_Email = "email";
	public static final String TAG_Pesan = "pesan";
	
	JSONArray Data_SK = null;
	
	ArrayList<HashMap<String, String>> Data_Saran_Kritik = new ArrayList<HashMap<String, 
			String>>();
	    			       
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elemen);
				
		Json_Parser json_parser = new Json_Parser(); 
		    
		Data_Saran_Kritik = new ArrayList<HashMap<String, String>>();
		
	    List<NameValuePair> params = new ArrayList<NameValuePair>();    
	    JSONObject json = json_parser.makeHttpRequest(Url_Saran_Kritik, "POST", params);

	    try {
	        			
	        int sukses = json.getInt(TAG_SUKSES);
	        
	        if (sukses == 1) {
	        		        	
	    		Data_SK = json.getJSONArray("Data_SK");
		        
		        for(int i = 0; i < Data_SK.length(); i++) {
		        	
		        	JSONObject maxikom = Data_SK.getJSONObject(i);
		        	
					String nama = maxikom.getString(TAG_Nama);
					String tanggal = maxikom.getString(TAG_Tanggal);
					String email = maxikom.getString(TAG_Email);
					String pesan = maxikom.getString(TAG_Pesan);	
					
					HashMap<String, String> hm = new HashMap<String, String>();
					
		            hm.put(TAG_Nama, nama);
		            hm.put(TAG_Tanggal, tanggal);     
		            hm.put(TAG_Email, email); 
		            hm.put(TAG_Pesan, pesan);             
		            Data_Saran_Kritik.add(hm);        
		        
		        }
		        
	        }  else {
	        	Toast.makeText(LihatSk_Activity.this, "Data saran kritik tidak ditemukan", 1).show();
	        	finish();
	        }
        
		} catch (JSONException e) {
			e.printStackTrace();
		}   
	    
	    ListAdapter adapter = new SimpleAdapter(this, Data_Saran_Kritik,
	    		R.layout.activity_lihatsk, 
        		new String[] { TAG_Nama, TAG_Tanggal, TAG_Email, TAG_Pesan}, 
        		new int[] { R.id.namatxt, R.id.tgltxt, R.id.emailtxt, R.id.komentxt});        
	    
        ls_menu = (ListView) findViewById(R.id.listview);
        ls_menu.setAdapter(adapter);
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lhtsk, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_home:
	        finish();
	        return true;	   
	    case R.id.menu_isi_sk:
     		Intent isisk = new Intent(LihatSk_Activity.this, IsiSk_Activity.class);
     		startActivity(isisk);	
        	return true;		        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	
	
    public void onItemClick(AdapterView<?> arg0, View arg1, int posisi, long arg3) {
    }
    
}
