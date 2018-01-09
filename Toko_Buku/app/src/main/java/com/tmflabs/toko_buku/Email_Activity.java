package com.tmflabs.toko_buku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email_Activity extends Activity {
   			
	 private String KatPos;
	
	 Button prosesbtn;
	 EditText emailtxt;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		Bundle extras = getIntent().getExtras();
		KatPos = extras.getString("KatPos");
		
		emailtxt = (EditText)findViewById(R.id.emailtxt);
		prosesbtn = (Button) findViewById(R.id.prosesbtn);
		
		prosesbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
												
				String email = emailtxt.getText().toString();	
									
         		Intent Pencarian = new Intent(Email_Activity.this, Buku_Activity.class);
         		Pencarian.putExtra("email", email);  
         		Pencarian.putExtra("KatPos", KatPos);  
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
