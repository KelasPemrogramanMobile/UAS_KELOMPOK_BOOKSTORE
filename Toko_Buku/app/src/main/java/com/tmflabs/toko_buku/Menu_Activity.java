package com.tmflabs.toko_buku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Menu_Activity extends Activity implements OnItemClickListener {
	private ListView ls_menu;    
    private String KatPos="",email;
    
    TextView emailtv;
    
    String[] Kategori = new String[] {
            "Design Grafis",
            "Pemrograman",
            "Office",
            "Sistem Operasi (OS)",
            "Jaringan Komputer"
    };	
    
    String[] Desk = new String[]{
    	"Design Foto, Web, Manipulasi, 3D, ...",
    	"Pemrograman Desktop, Web, Trik, ...",
    	"Pengenalan Word, Excel, Access, ...",    	
    	"Trik Windows, Optimalisasi Windows, ...",
    	"LAN, Wifi, Hotspot, ...",	
    };     
        

    int[] logoimg = new int[]{
    		R.drawable.design,
    		R.drawable.pemrograman,
    		R.drawable.office,    		
    		R.drawable.system, 
    		R.drawable.jaringan, 
    };    
    	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elemen);
		
		try	{
		Bundle extras = getIntent().getExtras();
		email = extras.getString("email");
		
		emailtv = (TextView) findViewById(R.id.emailtxt);	
		emailtv.setText(email);
	    } catch (Exception e) {
	    }
	    
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        
        
        for(int i=0;i<5;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("Judul", Kategori[i]);
            hm.put("Deskripsi", Desk[i]);            
            hm.put("Logo", Integer.toString(logoimg[i]) );            
            aList.add(hm);        
        }
        
        String[] from = { "Logo","Judul", "Deskripsi"};
        
        int[] to = { R.id.gbrimg,R.id.judtxt, R.id.destxt};
        

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), 
        		aList, R.layout.activity_menu, from, to);
        		
        ls_menu = (ListView) findViewById(R.id.listview);
        ls_menu.setAdapter(adapter);
        ls_menu.setOnItemClickListener(this);     
       
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {		
	    switch (item.getItemId()) {
	        case R.id.menu_info:
         		Intent log = new Intent(Menu_Activity.this, TentKami_Activity.class);
         		startActivity(log);	
	        	return true;        		
	        case R.id.menu_terbit:
         		Intent terbit = new Intent(Menu_Activity.this, Akan_Terbit_Activity.class);
         		startActivity(terbit);	
	        	return true;	
	        case R.id.menu_daftar:
         		Intent daftar = new Intent(Menu_Activity.this, Pelanggan_Activity.class);
         		startActivity(daftar);	
	        	return true;		        	
	        case R.id.menu_isi_sk:
         		Intent isisk = new Intent(Menu_Activity.this, IsiSk_Activity.class);
         		startActivity(isisk);	
	        	return true;	        	
	        case R.id.menu_lihat_sk:            
         		Intent lhtsk = new Intent(Menu_Activity.this, LihatSk_Activity.class);
         		startActivity(lhtsk);	
	        	return true;
	        case R.id.menu_cari:
         		Intent cari = new Intent(Menu_Activity.this, Cari_Activity.class);
         		startActivity(cari);	
	        	return true;  	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	

    public void onItemClick(AdapterView<?> arg0, View arg1, int posisi, long arg3) {   
    	switch (posisi) {
    		case 0: // Design Grafis
    			finish();
         		Intent kategori_0 = new Intent(Menu_Activity.this, Buku_Activity.class);
         		kategori_0.putExtra("KatPos", KatPos="1"); 
         		kategori_0.putExtra("email", email);  
         		startActivity(kategori_0);	
    			break;
    		case 1: // Pemrograman
    			finish();
         		Intent kategori_1 = new Intent(Menu_Activity.this, Buku_Activity.class);
         		kategori_1.putExtra("KatPos", KatPos="2"); 
         		kategori_1.putExtra("email", email); 
         		startActivity(kategori_1);
    			break;
    		case 2: // Office
    			finish();
         		Intent kategori_2 = new Intent(Menu_Activity.this, Buku_Activity.class);
         		kategori_2.putExtra("KatPos", KatPos="3");  
         		kategori_2.putExtra("email", email); 
         		startActivity(kategori_2);  			
    			break;    			
    		case 3: // Sistem Operasi
    			finish();
         		Intent kategori_3 = new Intent(Menu_Activity.this, Buku_Activity.class);
         		kategori_3.putExtra("KatPos", KatPos="4"); 
         		kategori_3.putExtra("email", email); 
         		startActivity(kategori_3);  			
    			break;
    		case 4: // Jaringan
    			finish();
         		Intent kategori_4 = new Intent(Menu_Activity.this, Buku_Activity.class);
         		kategori_4.putExtra("KatPos", KatPos="5");  
         		kategori_4.putExtra("email", email); 
         		startActivity(kategori_4);   			
    			break;
    	}
    } 

}
