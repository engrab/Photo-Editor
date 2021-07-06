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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class MyWorkActivity extends LocalBaseActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    public ArrayList<ImageDetails> arListGallery;
    private RecyclerView.Adapter mAdapter;

    private GridLayoutManager layoutManager;
    public static ProgressDialog dia;
    LinearLayout LL_NoDataFound;
    Activity activity;

    InterstitialAd interstitialAd;
    int DisplayWidth;

    public void showProgress() {

        dia = new ProgressDialog(this);
        dia.setMessage("Loading ...");
        dia.setIndeterminate(false);
        dia.setCancelable(false);
        dia.setCanceledOnTouchOutside(false);
        dia.show();
    }

    private void loadInterstitialAd() {
        interstitialAd = new InterstitialAd(this, AdsUnits.FB_INTERSTITIAL);
        AbstractAdListener adListener = new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {

                Toast.makeText(MyWorkActivity.this, "Error loading ad: " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
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

    private void fillData() {

        try {
            String path = Environment.getExternalStorageDirectory().toString() + "/" + getString(R.string.app_name);
            File f = new File(path);
            File[] file = f.listFiles();
            String selection = null;
            String[] selectionArgs = null;
            String[] projection = {
                    MediaStore.Images.Media.DATA
            };
            if (file.length > 0) {
                for (int i = 0; i < file.length; i++) {
                    try {

                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
                        String time = sdf.format(new Date(file[i].lastModified()));


                        ImageDetails object = new ImageDetails();
                        object.ImageName = file[i].getName();
                        object.uri = Uri.fromFile(file[i]);
                        arListGallery.add(object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (NullPointerException e) {
            LL_NoDataFound.setVisibility(View.VISIBLE);
        } catch (Exception e) {
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    public void dismissProgress() {
        if (dia.isShowing())
            dia.dismiss();
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
                Toast.makeText(MyWorkActivity.this, "Ad Loaded", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_work);
        loadInterstitialAd();
        loadBannerAd();
        Display display = getWindowManager().getDefaultDisplay();
        DisplayWidth = display.getWidth();

        ImageView imgButtonImage = findViewById(R.id.imgButtonImage);
        imgButtonImage.setImageResource(R.drawable.ic_home);
        imgButtonImage.setOnClickListener(this);


        activity = MyWorkActivity.this;

        LL_NoDataFound = findViewById(R.id.LL_NoDataFound);
        LL_NoDataFound.setOnClickListener(this);
        showProgress();

        arListGallery = new ArrayList<ImageDetails>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        fillData();

        Collections.reverse(arListGallery);

        if (arListGallery.size() == 0) {
            LL_NoDataFound.setVisibility(View.VISIBLE);
            dismissProgress();
        } else {
            LL_NoDataFound.setVisibility(View.GONE);
            mAdapter = new GalleryViewAdapter();
            recyclerView.setAdapter(mAdapter);
            dismissProgress();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LL_NoDataFound:
                finish();
                startActivity(new Intent(MyWorkActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                break;
            case R.id.imgButtonImage:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                break;
        }
    }


    class ImageDetails {
        String ImageName;
        Uri uri;
    }

    class GalleryViewAdapter extends RecyclerView.Adapter<GalleryViewAdapter.MyViewHolder> {

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageViewIcon;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.imageViewIcon = itemView.findViewById(R.id.ThemePreviewImage);


                this.imageViewIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {

                        Intent intent = new Intent(MyWorkActivity.this, Zeqale.class);
                        intent.putExtra("FileName", "" + arListGallery.get(Integer.parseInt(v.getTag().toString())).ImageName);
                        startActivity(intent);
                        activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);

                    }
                });
            }
        }

        public GalleryViewAdapter() {
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_view_row, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

            Log.e("position", "" + listPosition);

            holder.imageViewIcon.setLayoutParams(new FrameLayout.LayoutParams(DisplayWidth / 3, DisplayWidth / 3));

            if (listPosition == 4) {
                holder.imageViewIcon.setImageURI(arListGallery.get(listPosition).uri);

            } else {
                holder.imageViewIcon.setImageURI(arListGallery.get(listPosition).uri);
            }

            holder.imageViewIcon.setTag("" + listPosition);

        }

        @Override
        public int getItemCount() {
            return arListGallery.size();
        }
    }
}
