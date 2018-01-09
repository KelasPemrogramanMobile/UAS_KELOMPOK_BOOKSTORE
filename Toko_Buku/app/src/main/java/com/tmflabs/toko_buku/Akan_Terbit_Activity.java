package com.tmflabs.toko_buku;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.RatingBar;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.ImageView;
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory;

public class Akan_Terbit_Activity extends Activity {

	private ListView ls_menu;
	RatingBar ratingBar;
	ImageView imageview;

	private static String Url_Terbit =
			"http://192.168.43.74/Toko_Buku/android/akan_terbit.php";

	private static final String TAG_SUKSES = "sukses";

	public static final String TAG_Cover = "cover";
	public static final String TAG_Judul = "judul";
	public static final String TAG_Penulis = "penulis";
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

		Json_Parser json_parser = new Json_Parser();

		Data_Buku = new ArrayList<HashMap<String, String>>();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = json_parser.makeHttpRequest(Url_Terbit, "POST", params);

		try {

			int sukses = json.getInt(TAG_SUKSES);

			if (sukses == 1) {

				Data_BK = json.getJSONArray("Data_BK");

				for (int i = 0; i < Data_BK.length(); i++) {

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

			} else {
				Toast.makeText(Akan_Terbit_Activity.this, "Tidak ada buku akan terbit", 1).show();
				finish();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		SimpleAdapter adapter = new SimpleAdapter(this, Data_Buku,
				R.layout.activity_akan_terbit,
				new String[]{TAG_Cover, TAG_Judul, TAG_Penulis, TAG_Kode_Buku,
						TAG_Harga, TAG_Rating, TAG_Deskripsi},
				new int[]{R.id.gbrimg, R.id.judtxt, R.id.penulistxt, R.id.kodetxt,
						R.id.hrgtxt, R.id.ratingbar, R.id.deskripsitxt});

		ls_menu = (ListView) findViewById(R.id.listview);
		adapter.setViewBinder(new Data());
		ls_menu.setAdapter(adapter);

	}

	class Data implements ViewBinder {
		@Override
		public boolean setViewValue(View view, Object data, String textRepresentation) {
			if (view.getId() == R.id.ratingbar) {
				String stringval = (String) data;
				float ratingValue = Float.parseFloat(stringval);
				RatingBar ratingBar = (RatingBar) view;
				ratingBar.setRating(ratingValue);
				return true;
			} else if (view.getId() == R.id.gbrimg) {
				String gambar = (String) data;
				new Cover((ImageView) view.findViewById(R.id.gbrimg))
						.execute("http://192.168.43.74/Toko_Buku/cover/" + gambar + "");
				return true;
			}
			return false;
		}
	}

	private class Cover extends AsyncTask<String, Void, Bitmap> {
		ImageView imageview;

		public Cover(ImageView imageview) {
			this.imageview = imageview;
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
			Log.d("debugging", "c");
			imageview.setImageBitmap(result);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_terbit, menu);
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