package com.tmflabs.toko_buku;

/**
 * Created by BOWOTMF on 1/6/2018.
 */


import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.content.SharedPreferences;

import com.tmflabs.toko_buku.*;

public class splashscreen extends Activity {
    //Set waktu lama splashscreen
    private static int splashInterval = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(splashscreen.this, Menu_Activity.class);
                startActivity(i);


                //jeda selesai Splashscreen
                this.finish();


            }
            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };

}
