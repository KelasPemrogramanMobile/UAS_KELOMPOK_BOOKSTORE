package com.tmflabs.toko_buku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cari_Activity extends Activity {
   			
	Button caribtn;
	EditText caritxt;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cari);
		
		caritxt = (EditText)findViewById(R.id.caritxt);
		caribtn = (Button) findViewById(R.id.caribtn);
		
		caribtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
			// TODO Auto-generated method stub
												
				String Cari = caritxt.getText().toString();								
					
         		Intent Pencarian = new Intent(Cari_Activity.this, Cari_Tampil_Activity.class);
         		Pencarian.putExtra("Cari", Cari);  
         		startActivity(Pencarian);
				
         		finish();
			}
			
		});		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_cari, menu);
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
}
