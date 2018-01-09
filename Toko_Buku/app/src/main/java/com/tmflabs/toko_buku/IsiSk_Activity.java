package com.tmflabs.toko_buku;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IsiSk_Activity extends Activity {

    private ProgressDialog Dialog;
    
	Json_Parser json_parser = new Json_Parser(); 

	private static String Url_Input_Saran_Kritik =
		 "http://192.168.43.74/Toko_Buku/android/isi_saran_kritik.php";

	Button prosbtn, btlbtn;
	EditText nmtxt,emtxt,komentxt,jwbtxt;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_isisk);
					
		nmtxt = (EditText)findViewById(R.id.namatxt);
		emtxt = (EditText)findViewById(R.id.emailtxt);
		komentxt = (EditText)findViewById(R.id.komentartxt);
		jwbtxt = (EditText)findViewById(R.id.jawabtxt);	
		
		prosbtn = (Button) findViewById(R.id.simbtn);
		btlbtn = (Button) findViewById(R.id.btlbtn);
		
		prosbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
			// TODO Auto-generated method stub
				
				Dialog = ProgressDialog.show(IsiSk_Activity.this, "Input Saran Kritik",
						"Tunggu sebentar ... !", true);
				
				String nama = nmtxt.getText().toString();		
				String email = emtxt.getText().toString();	
				String pesan = komentxt.getText().toString();	
				String jawab = jwbtxt.getText().toString();								
			
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("nama", nama));
				params.add(new BasicNameValuePair("email", email));
				params.add(new BasicNameValuePair("pesan", pesan));
				params.add(new BasicNameValuePair("jawab", jawab));									
		
				JSONObject json = json_parser.makeHttpRequest(Url_Input_Saran_Kritik,
						"POST", params);
			
				try {
					if (json.getString("success") != null) {
						String res = json.getString("success");
						if(Integer.parseInt(res) == 1){			
							Toast.makeText(IsiSk_Activity.this, "Input Saran Kritik Selesai", 1).show();  
							finish();				          
						}else{
							Toast.makeText(IsiSk_Activity.this, "Input Saran Kritik Salah", 1).show();
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
		getMenuInflater().inflate(R.menu.activity_isisk, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_home:
	        finish();
	        return true;	 
	    case R.id.menu_lihat_sk:
     		Intent lhtsk = new Intent(IsiSk_Activity.this, LihatSk_Activity.class);
     		startActivity(lhtsk);
        	return true;	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	
	public void batal(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 builder.setMessage("Batal Input Saran Kritik ?")
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
