package com.tmflabs.toko_buku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TentKami_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tentkami);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tentkami, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_home:
	        	finish();
         		Intent log = new Intent(TentKami_Activity.this, Menu_Activity.class);
         		startActivity(log);	
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	

}
