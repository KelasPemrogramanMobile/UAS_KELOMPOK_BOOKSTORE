package com.tmflabs.toko_buku;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pelanggan_Activity extends Activity {
    
	Json_Parser json_parser = new Json_Parser(); 
	
	private static String Url_Pelanggan=
		 "http://192.168.43.74/Toko_Buku/android/pelanggan.php";

	 Button prosbtn, btlbtn;
	 EditText nmtxt,almtxt,emailtxt,tlptxt;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pelanggan);
					
		nmtxt = (EditText)findViewById(R.id.namatxt);
		almtxt = (EditText)findViewById(R.id.alamattxt);
		emailtxt = (EditText)findViewById(R.id.emailtxt);
		tlptxt = (EditText)findViewById(R.id.tlptxt);	
		
		prosbtn = (Button) findViewById(R.id.simbtn);
		btlbtn = (Button) findViewById(R.id.btlbtn);
		
		prosbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
			// TODO Auto-generated method stub
							
				String nama = nmtxt.getText().toString();		
				String alamat = almtxt.getText().toString();	
				String email = emailtxt.getText().toString();	
				String telepon = tlptxt.getText().toString();								
			
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("nama", nama));
				params.add(new BasicNameValuePair("alamat", alamat));
				params.add(new BasicNameValuePair("email", email));
				params.add(new BasicNameValuePair("telepon", telepon));									
		
				JSONObject json = json_parser.makeHttpRequest(Url_Pelanggan,
						"POST", params);
			
				try {
					if (json.getString("success") != null) {
						String res = json.getString("success");
						if(Integer.parseInt(res) == 1){			
							Toast.makeText(Pelanggan_Activity.this, "Input Data Pelanggan Selesai", 1).show();  
							finish();				          
						}else{
							Toast.makeText(Pelanggan_Activity.this, "Input Data Pelanggan Salah", 1).show();
							finish();
						}
					}
				}
				catch (JSONException e) {
					e.printStackTrace();
				}					
			}
		
		});		
		
		btlbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				batal();
			}
		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_pelanggan, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_home:
	        	finish();
	        	return true;	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	

	public void batal(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 builder.setMessage("Batal Daftar Pelanggan ?")
		 .setCancelable(false)
		 .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
		 public void onClick(DialogInterface dialog, int id) {
			finish();
		 }
		 })
		 .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
		 public void onClick(DialogInterface dialog, int id) {
			 dialog.cancel();
		 }
		 }).show();
		 
	}	
}
