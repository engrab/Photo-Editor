package com.oga.photoeditor.pro.beauty.face.filters.effects.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.julesFrancoisCrahay.FrameActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;
import com.oga.photoeditor.pro.beauty.face.filters.effects.adapters.MyCreationAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class MyWorkActivity extends AppCompatActivity {


    public static ArrayList<String> IMAGEALLARY = new ArrayList();
    public static int pos;
    private ImageView Iv_back_creation;
    private GridView grid_crea;
    MyCreationAdapter myCreationAdapter;
    InterstitialAd interstitialAd;
    private static final String TAG = "MyCreationActivity";


    private void loadInterstitialAd() {
        interstitialAd = new InterstitialAd(this, AdsUnits.FB_INTERSTITIAL);
        AbstractAdListener adListener = new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {

                super.onError(ad, error);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                super.onAdLoaded(ad);

                interstitialAd.show();

            }

            @Override
            public void onAdClicked(Ad ad) {
                super.onAdClicked(ad);
            }

            @Override
            public void onInterstitialDisplayed(Ad ad) {
                super.onInterstitialDisplayed(ad);
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                super.onInterstitialDismissed(ad);

            }
        };
        InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig = interstitialAd.buildLoadAdConfig()
                .withAdListener(adListener)
                .build();
        interstitialAd.loadAd(interstitialLoadAdConfig);
    }

    private void loadBannerAd() {
        final FrameLayout adContainer = findViewById(R.id.adView);
        AdView adView = new AdView(this, AdsUnits.FB_BANNER, AdSize.BANNER_HEIGHT_50);
        adContainer.addView(adView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Toast.makeText(MyWorkActivity.this, "Ad 50 Error: " + adError.getErrorMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        AdView.AdViewLoadConfig loadAdConfig = adView.buildLoadAdConfig()
                .withAdListener(adListener)
                .build();
        adView.loadAd(loadAdConfig);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_work);

        loadInterstitialAd();
        loadBannerAd();

        if (MyCreationAdapter.imagegallary.size() == 0) {
            findViewById(R.id.text_noimage).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.text_noimage).setVisibility(View.GONE);
        }
        this.grid_crea = findViewById(R.id.grid_crea);
        this.myCreationAdapter = new MyCreationAdapter(this, IMAGEALLARY);
        IMAGEALLARY.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        stringBuilder.append("/");
        stringBuilder.append(R.string.app_name);
        listAllImages(new File(stringBuilder.toString()));
        this.grid_crea.setAdapter(this.myCreationAdapter);
        this.Iv_back_creation = findViewById(R.id.back_click_iv);
        this.Iv_back_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWorkActivity.this.finish();

            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void listAllImages(File filepath) {
        File[] files = filepath.listFiles();
        if (MyCreationAdapter.imagegallary.size() == 0) {
            findViewById(R.id.text_noimage).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.text_noimage).setVisibility(View.GONE);
        }
        if (files != null) {
            for (int j = files.length - 1; j >= 0; j--) {
                String ss = files[j].toString();
                File check = new File(ss);
                StringBuilder stringBuilder = new StringBuilder();
                String str = "";
                stringBuilder.append(str);
                stringBuilder.append(check.length());
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append(check.length());
                Log.d(stringBuilder2, stringBuilder3.toString());
                if (check.toString().contains(".jpg") || check.toString().contains(".png") || check.toString().contains(".jpeg")) {
                    IMAGEALLARY.add(ss);
                } else {
                    Log.d(TAG, "listAllImages: Image Extension not supported");
                }
                System.out.println(ss);
            }
            return;
        }
        System.out.println("Empty Folder");
    }

    protected void onResume() {
        super.onResume();

        if (MyCreationAdapter.imagegallary.size() == 0) {
            findViewById(R.id.text_noimage).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.text_noimage).setVisibility(View.GONE);
        }
    }


}
