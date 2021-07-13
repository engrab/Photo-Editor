package com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.julesFrancoisCrahay;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;
import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.MainActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.RafSimons.EditImageFragment;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.RafSimons.FragmentMagicMain;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.SharedPreferenceManager;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.PatrickCox;
import com.oga.photoeditor.pro.beauty.face.filters.effects.KayCohen.SusienChong;
import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.dd.processbutton.iml.ActionProcessButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class FrameActivity extends LocalBaseActivity {

    InterstitialAd interstitialAd;

    public static AppCompatActivity activity;
    public static RecyclerView recycler_view;
    CarlaZampatti adapter;
    ArrayList<SusienChong> arrayList;

    public void getPosterData() {

        recycler_view = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setStackFromEnd(true);
        recycler_view.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        try {
            AssetManager assetManager = getResources().getAssets();
            String[] files = assetManager.list("effect");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("effect/" + file));
                }

                adapter = new CarlaZampatti(this);
                recycler_view.setAdapter(adapter);
                adapter.notifyItemInserted(arrayList.size() - 1);
                linearLayoutManager.scrollToPosition(PatrickCox.Pos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        loadInterstitialAd();
        loadBannerAd();
        activity = FrameActivity.this;
        appPrefs = new SharedPreferenceManager(getActivity());
        handler = new Handler();
        getDownloadCompleted = new GetDownloadCompleted();

        getPosterData();
        FragmentMagicMain mainFragment = new FragmentMagicMain();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();


    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.Container);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragment instanceof FragmentMagicMain) {

            showResetDialog(getActivity(), new OnResetListner() {
                @Override
                public void onReset() {
                    startActivity(new Intent(FrameActivity.this, MainActivity.class));
                    finish();
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            });

        } else if (fragment instanceof EditImageFragment) {
            try {
                if (EditImageFragment.Counter != 0) {
                    EditImageFragment.imgButtonImage.setImageResource(R.drawable.ic_next);
                    switch (EditImageFragment.Counter) {

                        case 1:
                            EditImageFragment.flyOut(EditImageFragment.curveList, EditImageFragment.MainMenu);
                            EditImageFragment.Counter = 0;
                            break;

                        case 2:
                            EditImageFragment.flyOut(EditImageFragment.fragment_Blur, EditImageFragment.LL_MainMenu);
                            EditImageFragment.Counter = 0;
                            break;

                        case 3:
                            EditImageFragment.flyOut(EditImageFragment.Sticker_recycler_view, EditImageFragment.LL_MainMenu);
                            EditImageFragment.Counter = 0;
                            break;
                        case 4:
                            EditImageFragment.flyOut(EditImageFragment.Abc_recycler_view, EditImageFragment.LL_MainMenu);
                            EditImageFragment.Counter = 0;
                            break;

                        case 5:
                            EditImageFragment.flyOut(EditImageFragment.LL_TextMainLayout, EditImageFragment.LL_MainMenu);
                            EditImageFragment.Counter = 0;
                            break;

                        case 7:
                            EditImageFragment.imgButtonImage.setImageResource(R.drawable.ic_true);
                            EditImageFragment.flyOut(EditImageFragment.fragment_Blur, EditImageFragment.LL_TextMainLayout);
                            EditImageFragment.Counter = 5;
                            break;
                        case 8:
                            EditImageFragment.imgButtonImage.setImageResource(R.drawable.ic_true);
                            EditImageFragment.flyOut(EditImageFragment.ABCFont, EditImageFragment.LL_TextMainLayout);
                            EditImageFragment.Counter = 5;
                            break;

                    }
                } else {

                    showResetDialog(getActivity(), new OnResetListner() {
                        @Override
                        public void onReset() {
                            startActivity(new Intent(FrameActivity.this, MainActivity.class));
                            finish();
                            overridePendingTransition(R.anim.right_in, R.anim.left_out);
                        }
                    });
                }
            } catch (Exception e) {

            }
        }
    }

    public static void startWithUri(Context context, Uri _uri) {
        Intent intent = new Intent(context, FrameActivity.class);
        intent.setData(_uri);
        context.startActivity(intent);
//        activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    GetDownloadCompleted getDownloadCompleted;
    private Handler handler;
    private boolean FrameDownload = false;
    private final int Ads = -1;
    ActionProcessButton btnDownload;

    SharedPreferenceManager appPrefs;
    ArrayList<SusienChong> arrayListprev;
    String[] effectName = {"Adonias", "Bacchus", "Blackflower", "Boxingstar", "Browndown", "Dacey", "Ealasaid", "Earleen", "Flyingman", "fotospot",
            "Gotulost", "haddley", "Heriwarm", "jumpket", "kulamt", "librotus", "potruzone", "purpcore", "viscotta", "albormentio"};

    class CarlaZampatti extends RecyclerView.Adapter<CarlaZampatti.MyViewHolder> {

        Context mContext;

        public CarlaZampatti(Context mcContext) {

            this.mContext = mcContext;

            try {
                arrayListprev = new ArrayList<>();
                AssetManager assetManager = this.mContext.getResources().getAssets();
                String[] files = assetManager.list("prev");
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        arrayListprev.add(new SusienChong("prev/" + files[i], effectName[i]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xpro_sticker_card, parent, false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            Bitmap bitmapFrame = null;
            try {
                holder.imageViewIcon.setImageBitmap(getBitmapFromAsset(arrayListprev.get(position).getDirName()));

                holder.down_icon.setVisibility(View.VISIBLE);

                if (appPrefs.getDownloadArrayList() != null) {

                    ArrayList<String> stringArrayList = appPrefs.getDownloadArrayList();

                    for (int i = 0; i < stringArrayList.size(); i++) {

                        if (stringArrayList.get(i).equals(arrayListprev.get(position).getDirName())) {
                            holder.down_icon.setVisibility(View.GONE);
                        }
                    }
                }

                holder.imageViewIcon.setTag("" + position);
                holder.imageViewIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        try {

                            ArrayList<String> stringArrayList = appPrefs.getDownloadArrayList();
                            if (stringArrayList == null) {
                                stringArrayList = new ArrayList<>();
                            }


                            if (holder.down_icon.getVisibility() == View.VISIBLE) {
                                stringArrayList.add(arrayListprev.get(position).getDirName());
                                appPrefs.setDownloadArrayList(stringArrayList);
                                OpenDownloadDialog(Integer.parseInt((String) v.getTag()));
                            } else {
                                adapter.notifyDataSetChanged();

                                adapter.notifyItemChanged(position);

                                appPrefs.setPipId("" + position);
                                appPrefs.setPipName(arrayList.get(position).getDirName());

                                Log.e("Name : ", "" + appPrefs.getPipName());

                                try {
                                    FragmentMagicMain.RL_MagicEffect.removeAllViews();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
//                                        startDecodingLatestCurveData();
                                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                            FragmentMagicMain mainFragment = new FragmentMagicMain();
                                            fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, 500);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private Bitmap getBitmapFromAsset(String strName) {
            AssetManager assetManager = mContext.getAssets();
            InputStream istr = null;
            try {
                istr = assetManager.open(strName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(istr);
            return bitmap;
        }

        @Override
        public int getItemCount() {

            return arrayList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageViewIcon, down_icon;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.imageViewIcon = itemView.findViewById(R.id.imgStickerIcon);
                this.down_icon = itemView.findViewById(R.id.down_icon);

            }
        }

    }

    Dialog alertDialogBuilder;

    private void OpenDownloadDialog(final int listPosition) {
        alertDialogBuilder = new Dialog(getActivity());
//        alertDialogBuilder.setTitle("Select Language");
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialogBuilder.setContentView(R.layout.frame_download_dialog);

        final RelativeLayout nativeAdsLayout = alertDialogBuilder.findViewById(R.id.nativeAdsLayout);
        btnDownload = alertDialogBuilder.findViewById(R.id.btnDownload);

        handler.postDelayed(getDownloadCompleted, 2000);

        btnDownload.setMode(ActionProcessButton.Mode.ENDLESS);

        btnDownload.setProgress(10);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    adapter.notifyDataSetChanged();

                    adapter.notifyItemChanged(listPosition);

                    alertDialogBuilder.dismiss();
                    appPrefs.setPipId("" + listPosition);
                    appPrefs.setPipName(arrayList.get(listPosition).getDirName());

                    Log.e("Name : ", "" + appPrefs.getPipName());

                    try {
                        FragmentMagicMain.RL_MagicEffect.removeAllViews();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
//                                        startDecodingLatestCurveData();
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentMagicMain mainFragment = new FragmentMagicMain();
                                fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.show();
    }

    class GetDownloadCompleted implements Runnable {
        GetDownloadCompleted() {
        }

        public void run() {

            if (FrameDownload && (Ads == 0 || Ads == 1)) {
                Log.e("GetDownloadCompleted", "FrameDownload " + FrameDownload + " Ads " + Ads);
                btnDownload.setProgress(100);
                btnDownload.setEnabled(true);
                adapter.notifyDataSetChanged();
                handler.removeCallbacks(getDownloadCompleted);
            } else {
                Log.e("GetDownloadCompleted", "FrameDownload " + FrameDownload + " Ads " + Ads);
                handler.removeCallbacks(getDownloadCompleted);
                FrameDownload = true;
                handler.postDelayed(getDownloadCompleted, 3000);
            }
        }
    }
}

