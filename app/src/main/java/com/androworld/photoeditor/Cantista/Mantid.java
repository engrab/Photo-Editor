package com.androworld.photoeditor.Cantista;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.androworld.photoeditor.ClaudiaChanShaw.LindaBritten;
import com.androworld.photoeditor.DionLee.BerilJents;
import com.androworld.photoeditor.DirkBikkembergs.julesFrancoisCrahay.Dabdea;
import com.androworld.photoeditor.DovCharney.DeanandDanCaten;
import com.androworld.photoeditor.DovCharney.PatrickCox;
import com.androworld.photoeditor.LocalBaseActivity;
import com.androworld.photoeditor.Pentagon.AmberRenae.Tempoll;
import com.androworld.photoeditor.PeterJackson.JennyKee.Bentesta;
import com.androworld.photoeditor.R;
import com.androworld.photoeditor.RuthTarvydas.RichardTyler.Pnanterist;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class Mantid extends LocalBaseActivity {

    public static AppCompatActivity activity;
    private String TAG = "MainActivity";
    DeanandDanCaten objPref;

    public static int Cat = 0;
    public static int counter = 0;
    float finalratings = 5;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    boolean flag = false;
    private LindaBritten objDb;
        private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        objDb = new LindaBritten(getActivity());

        verifyStoragePermissions(Mantid.this);

        activity = Mantid.this;
        objPref = new DeanandDanCaten(this);
        PatrickCox.FinalBitmap = null;

        BerilJents mainFragment = new BerilJents();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.MainContainer, mainFragment).commit();

    }


    @Override
    public void onBackPressed() {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.MainContainer);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (frag instanceof BerilJents) {

                if (BerilJents.Counter != 0) {
                    BerilJents.Counter = 0;
                } else {
                    showRatingDialog(false, new OnRateListner() {
                        @Override
                        public void onReminderLater() {
                            finish();
                        }
                    });
                }
            } else {
                BerilJents MainFragment = new BerilJents();
                fragmentManager.beginTransaction().replace(R.id.MainContainer, MainFragment).commit();
            }
        } catch (Exception e) {

        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_SELECT_PICTURE) {
                final Uri selectedUri = data.getData();
                if (selectedUri != null) {
                    startCropActivity(data.getData());
                } else {
                    Toast.makeText(Mantid.this, "Cannot Retrieve Selected Image", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == UCrop.REQUEST_CROP) {
                handleCropResult(data);
            }
        }
        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(data);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage";
    private static final int REQUEST_SELECT_PICTURE = 0x01;

    public static void pickFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), Mantid.REQUEST_SELECT_PICTURE);
    }


    private void startCropActivity(@NonNull Uri uri) {
        String destinationFileName = SAMPLE_CROPPED_IMAGE_NAME;

        destinationFileName += ".jpg";
        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), destinationFileName)));

        UCrop.Options options = new UCrop.Options();

        switch (counter) {
            case 1:
                uCrop = uCrop.withAspectRatio(1, 1);
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                options.setCompressionQuality(100);
                options.setHideBottomControls(false);
                options.setFreeStyleCropEnabled(false);
                uCrop = uCrop.withOptions(options);
                break;
            case 2:
                options = new UCrop.Options();
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                options.setCompressionQuality(100);
                options.setHideBottomControls(false);
                options.setFreeStyleCropEnabled(false);

                options.setAspectRatioOptions(2,
                        new AspectRatio("3:4", 3, 4),
                        new AspectRatio("9:16", 9, 16),
                        new AspectRatio("1:2", 1, 2),
                        new AspectRatio("3:7", 3, 7),
                        new AspectRatio("9:24", 9, 24));

                uCrop = uCrop.withOptions(options);
                break;
            case 3:
                options = new UCrop.Options();
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                options.setCompressionQuality(100);
                options.setHideBottomControls(false);
                options.setFreeStyleCropEnabled(false);

                options.setAspectRatioOptions(2,
                        new AspectRatio("4:3", 4, 3),
                        new AspectRatio("16:9", 16, 9),
                        new AspectRatio("2:1", 2, 1),
                        new AspectRatio("7:3", 7, 3),
                        new AspectRatio("24:9", 24, 9));


                uCrop = uCrop.withOptions(options);
                break;
            case 4:
                options = new UCrop.Options();
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                options.setCompressionQuality(100);
                options.setHideBottomControls(false);
                options.setFreeStyleCropEnabled(true);
                uCrop = uCrop.withOptions(options);
                break;
        }

        uCrop.start(Mantid.this);
    }

    private void handleCropResult(@NonNull Intent result) {
        final Uri resultUri = UCrop.getOutput(result);
        if (resultUri != null) {

            try {
                PatrickCox.bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), resultUri);
                PatrickCox.BlurBitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, PatrickCox.bitmap.getWidth() * 10 / 100, PatrickCox.bitmap.getHeight() * 10 / 100, false);

                Display display = getWindowManager().getDefaultDisplay();
                int w = display.getWidth();
                int h = display.getHeight();

                if (PatrickCox.bitmap.getHeight() > PatrickCox.bitmap.getWidth()) {
                    if (PatrickCox.bitmap.getHeight() > h)
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, ((PatrickCox.bitmap.getWidth() * h) / PatrickCox.bitmap.getHeight()), h, false);

                    if (PatrickCox.bitmap.getWidth() > w) {
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, w, ((PatrickCox.bitmap.getHeight() * w) / PatrickCox.bitmap.getWidth()), false);
                    }
                } else {
                    if (PatrickCox.bitmap.getWidth() > w) {
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, w, ((PatrickCox.bitmap.getHeight() * w) / PatrickCox.bitmap.getWidth()), false);
                    }

                    if (PatrickCox.bitmap.getHeight() > h)
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, ((PatrickCox.bitmap.getWidth() * h) / PatrickCox.bitmap.getHeight()), h, false);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (Cat == 1) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Dabdea.startWithUri(Mantid.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

            if (Cat == 2) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Tempoll.startWithUri(Mantid.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            if (Cat == 3) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Pnanterist.startWithUri(Mantid.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            if (Cat == 4) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Bentesta.startWithUri(Mantid.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }


            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else {
            Toast.makeText(Mantid.this, "Cannot retrieve cropped image", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            Log.e(TAG, "handleCropError: ", cropError);
            Toast.makeText(Mantid.this, cropError.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Mantid.this, "Unexpected error", Toast.LENGTH_SHORT).show();
        }
    }

}

