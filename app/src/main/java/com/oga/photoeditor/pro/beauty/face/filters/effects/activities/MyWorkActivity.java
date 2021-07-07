package com.oga.photoeditor.pro.beauty.face.filters.effects.activities;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
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
import androidx.core.app.ActivityCompat;
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

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyWorkActivity extends AppCompatActivity {


    public static List<String> IMAGEALLARY = new ArrayList<>();
    public static int pos;
    private ImageView Iv_back_creation;
    private GridView grid_crea;
    MyCreationAdapter myCreationAdapter;
    InterstitialAd interstitialAd;
    private static final String TAG = "MyCreationActivity";
    ArrayList<String> imageArray = new ArrayList<>();


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


        this.grid_crea = findViewById(R.id.grid_crea);


        this.Iv_back_creation = findViewById(R.id.back_click_iv);
        this.Iv_back_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWorkActivity.this.finish();
                startActivity(new Intent(MyWorkActivity.this, MainActivity.class));

            }
        });

//        if (Build.VERSION.SDK_INT >= 23) {
//            if (isReadStoragePermissionGranted()) {
//
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                        == PackageManager.PERMISSION_GRANTED) {
//                    Log.v(TAG, "Permission is granted1");
//                    readImageFromFolder();
//                }
//            } else {
//
//                Log.v(TAG, "Permission is revoked1");
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
//
//
//            }
//        } else {
//            readImageFromFolder();
//        }

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + getString(R.string.app_name));

        imageArray = getFile(file);
        Log.d(TAG, "onCreate: "+imageArray.size());
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void listAllImages(File filepath) {
        File[] files = filepath.listFiles();
//        if (MyCreationAdapter.imagegallary.size() == 0) {
//            findViewById(R.id.text_noimage).setVisibility(View.VISIBLE);
//        } else {
//            findViewById(R.id.text_noimage).setVisibility(View.GONE);
//        }
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
                    myCreationAdapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "listAllImages: Image Extension not supported");
                }
                System.out.println(ss);
            }
            Log.d(TAG, "listAllImages: " + files.length);
            return;
        }
        System.out.println("Empty Folder");
    }

    protected void onResume() {
        super.onResume();

//        if (MyCreationAdapter.imagegallary.size() == 0) {
//            findViewById(R.id.text_noimage).setVisibility(View.VISIBLE);
//        } else {
//            findViewById(R.id.text_noimage).setVisibility(View.GONE);
//        }
    }

    public boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted1");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked1");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted1");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String @NotNull [] permissions, int @NotNull [] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 2:
                Log.d(TAG, "External storage2");
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
                    //resume tasks needing this permission
                    readImageFromFolder();
                }
                break;

            case 3:
                Log.d(TAG, "External storage1");
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
                    //resume tasks needing this permission

                }
                break;
        }
    }

    private void readImageFromFolder() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        stringBuilder.append("/");
        stringBuilder.append(R.string.app_name);
        stringBuilder.append("/");
        IMAGEALLARY.clear();
        listAllImages(new File(stringBuilder.toString()));
        Log.d(TAG, "readImageFromFolder: "+IMAGEALLARY.size());
        this.myCreationAdapter = new MyCreationAdapter(this, IMAGEALLARY);
        this.grid_crea.setAdapter(this.myCreationAdapter);
    }

    public ArrayList<String> getFile(File dir) {


        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (File file : listFile) {
                if (file.isDirectory()) {
                    getFile(file);
                }
                else {
                    if (file.getName().endsWith(".png")
                            || file.getName().endsWith(".jpg")
                            || file.getName().endsWith(".jpeg")
                            || file.getName().endsWith(".gif")
                            || file.getName().endsWith(".bmp")
                            || file.getName().endsWith(".webp"))
                    {
                        String temp = file.getPath().substring(0, file.getPath().lastIndexOf('/'));
                        if (!imageArray.contains(temp)){

                            imageArray.add(temp);
                        }
                    }
                }
            }
        }
        return imageArray;
    }
}
