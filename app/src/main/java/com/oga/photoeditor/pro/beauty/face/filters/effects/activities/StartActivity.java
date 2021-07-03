package com.oga.photoeditor.pro.beauty.face.filters.effects.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.oga.photoeditor.pro.beauty.face.filters.effects.ClaudiaChanShaw.LindaBritten;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.SharedPreferenceManager;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.PatrickCox;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.SimonChang;
import com.oga.photoeditor.pro.beauty.face.filters.effects.JuliGrbac.FrederickFox.AlannahHill;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;


public class StartActivity extends Activity {

    AlannahHill cd;

    public static String name = "";
    SharedPreferenceManager objPref;
    LindaBritten objDb;
    private boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        objPref = new SharedPreferenceManager(StartActivity.this);
        PatrickCox.SDCardPath = objPref.getSaveDirURL();
        cd = new AlannahHill(this);
        objDb = new LindaBritten(StartActivity.this);


        new BASE_AGREEMENT_CIPHER().execute();
        try {
            if (cd.isConnectingToInternet()) {
                Log.e("Service", "Started from splash");
            } else {

            }
            callHome();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class BASE_AGREEMENT_CIPHER extends AsyncTask<Void, Integer, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                SimonChang.CIPHER_TO_DHKEY_AGREEMENT_256BIT_KEYGENERATOR("oauthentication_base64_hash64", "MODE_BASE_24_PRIVATE", getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


    public void callHome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isFirstTime) {
                    isFirstTime = false;
                    Intent localIntent = new Intent(StartActivity.this, MainActivity.class);
                    StartActivity.this.startActivity(localIntent);
                    finish();
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        }, 500);
    }



}
