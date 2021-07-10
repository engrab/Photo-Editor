package com.oga.photoeditor.pro.beauty.face.filters.effects.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.material.button.MaterialButton;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.EXTRA_DOCK_STATE_LE_DESK;
import static android.content.Intent.FILL_IN_CLIP_DATA;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class ShareImageActivity extends BaseActivity implements View.OnClickListener {
    private File file;
    NativeAd nativeAd;
    NativeAdLayout nativeAdLayout;
    private static final String TAG = "ShareImageActivity";
    Bundle bundle;

    private void loadAd() {
    }

    String finalURI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        makeFullScreen();
        setContentView(R.layout.activity_image_share);
        nativeAdLayout = findViewById(R.id.native_ad_container);

        loadNativeAd();

        finalURI = getIntent().getExtras().getString("FinalURI");

        this.file = new File(finalURI);
        Picasso.get().load(this.file).into((ImageView) findViewById(R.id.image_view_preview));

        findViewById(R.id.image_view_preview).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });

        findViewById(R.id.image_view_home).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_Wallpaper).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_share_more).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_insta).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_facebook).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_whatsapp).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_twitter).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_gmail).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });
        findViewById(R.id.image_view_messenger).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.this.onClick(view);
            }
        });

        findViewById(R.id.linear_layout_shares).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareImageActivity.lamb(ShareImageActivity.this, view);
            }
        });

    }

//    @Override
//    public void onClick(View v) {
//        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//        ArrayList<Uri> streamUris = new ArrayList<Uri>();
//        for (int i = 0; i < 10; i++) {
//            File tmpFile = new File(finalURI);
//            String authority = getPackageName() + ".provider";
//            Uri tmp = FileProvider.getUriForFile(ShareImageActivity.this, authority, tmpFile);
//            streamUris.add(tmp);
//        }
//        switch (v.getId()) {
//            case R.id.image_view_share_more:
//                shareImage(streamUris);
//                break;
//            case R.id.image_view_gmail:
//                shareImage(streamUris);
//                break;
//            case R.id.image_view_about:
//                startActivity(new Intent(this, MyWorkActivity.class));
//                this.finish();
//                break;
//            case R.id.imgButtonImage:
//                startActivity(new Intent(ShareImageActivity.this, MainActivity.class));
//                finish();
//                break;
//            case R.id.image_view_whatsapp:
//                if (!streamUris.isEmpty()) {
//                    whatsappIntent.setType("*/*");
//                    whatsappIntent.setPackage("com.whatsapp");
//                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Download App From here : https://play.google.com/store/apps/details?id=" + getPackageName());
//                    whatsappIntent.putExtra(Intent.EXTRA_STREAM, streamUris.get(0));
//                    try {
//                        startActivity(Intent.createChooser(whatsappIntent, "Share Image!"));
//                    } catch (android.content.ActivityNotFoundException ex) {
//                        Toast.makeText(this, "Whatsapp have not been installed.", Toast.LENGTH_LONG).show();
//                    }
//                }
//                break;
//            case R.id.image_view_insta:
//                if (!streamUris.isEmpty()) {
//                    whatsappIntent.setType("*/*");
//                    whatsappIntent.setPackage("com.instagram.android");
//                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Download App From here : https://play.google.com/store/apps/details?id=" + getPackageName());
//                    whatsappIntent.putExtra(Intent.EXTRA_STREAM, streamUris.get(0));
//                    try {
//                        startActivity(Intent.createChooser(whatsappIntent, "Share Image!"));
//                    } catch (android.content.ActivityNotFoundException ex) {
//                        Toast.makeText(this, "Instagram have not been installed.", Toast.LENGTH_LONG).show();
//                        shareImage(streamUris);
//                    }
//                }
//                break;
//            case R.id.image_view_messenger:
//                if (!streamUris.isEmpty()) {
//                    whatsappIntent.setType("*/*");
//                    whatsappIntent.setPackage("com.snapchat.android");
//                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Download App From here : https://play.google.com/store/apps/details?id=" + getPackageName());
//                    whatsappIntent.putExtra(Intent.EXTRA_STREAM, streamUris.get(0));
//                    try {
//                        startActivity(Intent.createChooser(whatsappIntent, "Share Image!"));
//                    } catch (android.content.ActivityNotFoundException ex) {
//                        Toast.makeText(this, "Snapchat have not been installed.", Toast.LENGTH_LONG).show();
//                        shareImage(streamUris);
//                    }
//                }
//                break;
//            case R.id.image_view_facebook:
//                if (!streamUris.isEmpty()) {
//                    whatsappIntent.setType("*/*");
//                    whatsappIntent.setPackage("com.facebook.katana");
//                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Download App From here : https://play.google.com/store/apps/details?id=" + getPackageName());
//                    whatsappIntent.putExtra(Intent.EXTRA_STREAM, streamUris.get(0));
//                    try {
//                        startActivity(Intent.createChooser(whatsappIntent, "Share Image!"));
//                    } catch (android.content.ActivityNotFoundException ex) {
//                        Toast.makeText(this, "Snapchat have not been installed.", Toast.LENGTH_LONG).show();
//                        shareImage(streamUris);
//                    }
//                }
//
//                break;
//        }
//    }
//
//    private void shareImage(ArrayList<Uri> uris) {
//
//        try {
//            Intent share = new Intent(Intent.ACTION_SEND);
//            share.setType("*/*");
//            share.putExtra(Intent.EXTRA_TEXT, "Download App From here : https://play.google.com/store/apps/details?id=" + getPackageName());
//            share.putExtra(Intent.EXTRA_STREAM, uris.get(0));
//            startActivity(Intent.createChooser(share, "Share Image!"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void lamb(ShareImageActivity saveAndShareActivity, View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(saveAndShareActivity.getApplicationContext(), "" + saveAndShareActivity.getPackageName() + ".provider", saveAndShareActivity.file));
        intent.addFlags(3);
        saveAndShareActivity.startActivity(Intent.createChooser(intent, "Share"));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    private void loadNativeAd() {
        nativeAd = new NativeAd(this, AdsUnits.FB_NATIVE);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                inflateAd(nativeAd);
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeAd.loadAd(nativeAd.buildLoadAdConfig()
                .withAdListener(nativeAdListener)
                .build());

    }

    private void inflateAd(NativeAd nativeAd) {
        nativeAd.unregisterView();
        nativeAdLayout = findViewById(R.id.native_ad_container);
        LayoutInflater inflater = LayoutInflater.from(ShareImageActivity.this);
        View adView = inflater.inflate(R.layout.item_native_ad, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(ShareImageActivity.this, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        MediaView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        MaterialButton nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(nativeAdIcon);

        nativeAd.registerViewForInteraction(
                adView, nativeAdMedia, nativeAdIcon, clickableViews);
    }

    public void onResume() {
        super.onResume();
    }

    public void onClick(View view) {

        ArrayList<Uri> streamUris;
        if (view != null) {

            streamUris = new ArrayList<Uri>();
            for (int i = 0; i < 10; i++) {
                File tmpFile = new File(finalURI);
                String authority = getPackageName() + ".provider";
                Uri tmp = FileProvider.getUriForFile(ShareImageActivity.this, authority, tmpFile);
                streamUris.add(tmp);
            }
            int id = view.getId();
            if (id != R.id.image_view_preview) {
                switch (id) {
                    case R.id.image_view_facebook:
                        sharePhoto(Constants.FACE, streamUris);
                        return;
                    case R.id.image_view_gmail:
                        sharePhoto(Constants.GMAIL, streamUris);
                        return;
                    case R.id.image_view_insta:
                        sharePhoto(Constants.INSTA, streamUris);
                        return;
                    case R.id.image_view_messenger:
                        sharePhoto(Constants.MESSEGER, streamUris);
                        return;
                    case R.id.image_view_share_more:
                        Uri createCacheFile = createCacheFile();
                        if (createCacheFile != null) {
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.SEND");
                            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            intent.setDataAndType(createCacheFile, getContentResolver().getType(createCacheFile));
                            intent.putExtra("android.intent.extra.STREAM", createCacheFile);
                            startActivity(Intent.createChooser(intent, "Choose an app"));
                            return;
                        }
                        Toast.makeText(this, "Fail to sharing", Toast.LENGTH_SHORT).show();
                        return;
                    case R.id.image_view_twitter:
                        sharePhoto(Constants.TWITTER, streamUris);
                        return;
                    case R.id.image_view_whatsapp:
                        sharePhoto(Constants.WHATSAPP, streamUris);
                        return;
                    default:
                        switch (id) {
                            case R.id.image_view_Wallpaper:
                                Uri createCacheFile2 = createCacheFile();
                                if (createCacheFile2 != null) {
                                    Intent intent2 = new Intent("android.intent.action.ATTACH_DATA");
                                    intent2.setDataAndType(createCacheFile2, getContentResolver().getType(createCacheFile2));
                                    intent2.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                    startActivity(Intent.createChooser(intent2, "Use as"));
                                    return;
                                }
                                Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
                                return;
                            case R.id.image_view_home:
                                Intent intent3 = new Intent(this, MainActivity.class);
                                intent3.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent3);
                                finish();

                                return;

                            default:
                                return;
                        }
                }
            } else {
                Intent intent4 = new Intent();
                intent4.setAction("android.intent.action.VIEW");
                intent4.setDataAndType(FileProvider.getUriForFile(getApplicationContext(), ShareImageActivity.this.getPackageName() + ".provider", this.file), "image/*");
                intent4.addFlags(EXTRA_DOCK_STATE_LE_DESK);
                startActivity(intent4);
            }
        }
    }

    public void sharePhoto(String packageName, ArrayList<Uri> streamUris) {
        if (!streamUris.isEmpty()) {
            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("*/*");
            whatsappIntent.setPackage(packageName);
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Download App From here : https://play.google.com/store/apps/details?id=" + getPackageName());
            whatsappIntent.putExtra(Intent.EXTRA_STREAM, streamUris.get(0));
            try {
                startActivity(Intent.createChooser(whatsappIntent, "Share Image!"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "Whatsapp have not been installed.", Toast.LENGTH_LONG).show();
            }
        }
    }


    public static boolean isPackageInstalled(Context context, String str) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(TAG, "isPackageInstalled: " + e.toString());
        }

        return false;
    }

    private Uri createCacheFile() {
        return FileProvider.getUriForFile(getApplicationContext(), "" + getPackageName() + ".provider", this.file);
    }

    private boolean getInstallAppList(String uri) {
        List<ApplicationInfo> listApplicationInfo = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        String[] stringsList = new String[listApplicationInfo.size()];
        int i = 0;
        for (ApplicationInfo applicationInfo : listApplicationInfo) {
            stringsList[i] = applicationInfo.packageName;
            i++;
            if (applicationInfo.packageName.equals(uri)) {
                return true;
            }
        }
        return false;


    }

    public boolean isAppInstalled(Context context, String uri) {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = context.getPackageManager().queryIntentActivities(mainIntent, 0);
        for (ResolveInfo resolveInfo : pkgAppsList) {
            Log.d(TAG, "__<>" + resolveInfo.activityInfo.packageName);
            if (resolveInfo.activityInfo.packageName != null
                    && resolveInfo.activityInfo.packageName.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPackageAvailable(String name) {
        boolean available = true;
        try {
            getPackageManager().getPackageInfo(name, 0);
        } catch (PackageManager.NameNotFoundException e) {
            available = false;
        }
        return available;
    }

}
