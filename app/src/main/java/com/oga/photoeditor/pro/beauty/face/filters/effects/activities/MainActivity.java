package com.oga.photoeditor.pro.beauty.face.filters.effects.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ClaudiaChanShaw.LindaBritten;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;
import com.oga.photoeditor.pro.beauty.face.filters.effects.fragments.HomeFragment;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.julesFrancoisCrahay.FrameActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.SharedPreferenceManager;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.PatrickCox;
import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.AmberRenae.Tempoll;
import com.oga.photoeditor.pro.beauty.face.filters.effects.PeterJackson.JennyKee.Bentesta;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.RuthTarvydas.RichardTyler.Pnanterist;

import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;

import java.io.File;
import java.io.IOException;

public class MainActivity extends LocalBaseActivity {

    public static AppCompatActivity activity;
    private String TAG = "MainActivity";
    SharedPreferenceManager objPref;
    boolean doubleBackToExitPressedOnce = false;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objDb = new LindaBritten(getActivity());

        verifyStoragePermissions(MainActivity.this);

        activity = MainActivity.this;
        objPref = new SharedPreferenceManager(this);
        PatrickCox.FinalBitmap = null;

        HomeFragment mainFragment = new HomeFragment(MainActivity.this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.MainContainer, mainFragment).commit();

    }



    @Override
    public void onBackPressed() {


        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.MainContainer);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (frag instanceof HomeFragment) {

                if (HomeFragment.Counter != 0) {
                    HomeFragment.Counter = 0;
                } else {
                    if (doubleBackToExitPressedOnce) {
                        super.onBackPressed();
                        return;
                    }

                    this.doubleBackToExitPressedOnce = true;
                    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            doubleBackToExitPressedOnce = false;
                        }
                    }, 2000);
                }
            } else {
                HomeFragment homeFragment = new HomeFragment(MainActivity.this);
                fragmentManager.beginTransaction().replace(R.id.MainContainer, homeFragment).commit();
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
                    Toast.makeText(MainActivity.this, "Cannot Retrieve Selected Image", Toast.LENGTH_SHORT).show();
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
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), MainActivity.REQUEST_SELECT_PICTURE);
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

        uCrop.start(MainActivity.this);
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
                FrameActivity.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

            if (Cat == 2) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Tempoll.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            if (Cat == 3) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Pnanterist.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            if (Cat == 4) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Bentesta.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }


            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else {
            Toast.makeText(MainActivity.this, "Cannot retrieve cropped image", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            Log.e(TAG, "handleCropError: ", cropError);
            Toast.makeText(MainActivity.this, cropError.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Unexpected error", Toast.LENGTH_SHORT).show();
        }
    }


}

