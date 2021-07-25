package com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.RafSimons;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ChristopherEssex.JohnCrittle;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ChristopherEssex.LizDavenport;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ChristopherEssex.WayneCooper;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DianaVonGrüning;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.AnnDemeulemeester.BrunoPieters;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.AnnDemeulemeester.CathyPill;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.AnnDemeulemeester.MartinMargiela;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DirkBikkembergs.julesFrancoisCrahay.FrameActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.ImageBitmap;
import com.oga.photoeditor.pro.beauty.face.filters.effects.KayCohen.SusienChong;
import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;
import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.ShareImageActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.multiTouchLib.MultiTouchListener;
import com.oga.photoeditor.pro.beauty.face.filters.effects.stickerView.StickerView;
import com.oga.photoeditor.pro.beauty.face.filters.effects.textviewBubble.BubbleInputDialog;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageContrastFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageFilterGroup;
import jp.co.cyberagent.android.gpuimage.GPUImageSaturationFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSharpenFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageToneCurveFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageView;
import jp.co.cyberagent.android.gpuimage.GPUImageVignetteFilter;


public class EditImageFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, BubbleInputDialog.CompleteCallBack {

    private static final String TAG = "EditImageFragment";
    private String FinalURI;
    InterstitialAd interstitialAd;
    public static AppCompatActivity activity;


    public EditImageFragment() {
        // Required empty public constructor
    }

    GPUImageView MainGPUImageView;
    public static StickerView sticker_view;

    public static HListView curveList;
    LinearLayout MainMenuContainer;
    RelativeLayout drawing_view_container;

    String flag = "";

    private static int DisplayWidth, DisplayHeight;
    //    text Area Controls
    FrameLayout FrameLayoutText;

    int PrevCurvePosition = 0, PrevBrightness = 50, PrevContrast = 50, PrevSaturation = 50, PrevVignette = 75, PrevSharpness = 50, PrevOpacity = 255;
    ImageView imgTextClose;
    //    Bottom Menu Layout Controls
    LinearLayout LL_Brightness, LL_Contrast, LL_Saturation, LL_Vignette, LL_Sharpness, LL_Text, LL_Curve, LL_AddText, LL_FontStyle, LL_TextColor, LL_TextOpacity;
    public static TextView textbubble;

    public static View MainMenu;
    Boolean textflag = true;
    public static RecyclerView Sticker_recycler_view, Abc_recycler_view, ABCFont;
    SeekBar seekbar;
    public static LinearLayout LL_MainMenu, fragment_Blur, LL_Sticker, LL_Abc, LL_TextMainLayout;
    public static int Counter = 0, AddCounter = 0;
    ImageView ic_clear;
    BubbleInputDialog mBubbleInputDialog;
    List<LizDavenport> filters;

    public static ImageView imgButtonImage, imgReset;

    private Bitmap smallImageBackgroud;


    TextView txtProgressValue;

    // Filter Contols
    GPUImageBrightnessFilter brightnessFilter;
    private DianaVonGrüning.FilterAdjuster mVignetteFilterAdjuster;
    GPUImageContrastFilter contrastFilter;
    GPUImageVignetteFilter vignetteFilter;
    private DianaVonGrüning.FilterAdjuster mBrightnessFilterAdjuster;

    GPUImageSaturationFilter saturationFilter;
    GPUImageToneCurveFilter curveFilter;
    GPUImageFilterGroup filterGroup;
    GPUImageSharpenFilter sharpnessFilter;
    private DianaVonGrüning.FilterAdjuster mContrastFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mSaturationFilterAdjuster;

    private DianaVonGrüning.FilterAdjuster mSharpnessFilterAdjuster;
//    private static RelativeLayout adViewContainer;


    public static RelativeLayout MainContainer;


    private void viewColorPicker() {

        ColorPickerDialogBuilder
                .with(getActivity())
                .setTitle("Border Color")
                .initialColor(Color.parseColor("#ffffff"))
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        AddTextColor(selectedColor);
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        AddTextColor(selectedColor);
                        if (allColors != null) {
                            StringBuilder sb = null;

                            for (Integer color : allColors) {
                                if (color == null)
                                    continue;
                                if (sb == null)
                                    sb = new StringBuilder("Color List:");
                                sb.append("\r\n#" + Integer.toHexString(color).toUpperCase());
                            }
                        }
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .showColorEdit(true)
                .setColorEditTextColor(ContextCompat.getColor(getActivity(), android.R.color.holo_blue_bright))
                .build()
                .show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (flag) {
            case "Brightness":
                PrevBrightness = progress;
                txtProgressValue.setText("" + PrevBrightness);

                if (mBrightnessFilterAdjuster != null) {
                    mBrightnessFilterAdjuster.adjust(PrevBrightness);
                }
                MainGPUImageView.requestRender();

                break;

            case "Contrast":
                PrevContrast = progress;
                txtProgressValue.setText("" + progress);

                if (mContrastFilterAdjuster != null) {
                    mContrastFilterAdjuster.adjust(PrevContrast);
                }
                MainGPUImageView.requestRender();
                break;

            case "Saturation":
                PrevSaturation = progress;
                txtProgressValue.setText("" + PrevSaturation);

                if (mSaturationFilterAdjuster != null) {
                    mSaturationFilterAdjuster.adjust(PrevSaturation);
                }

                MainGPUImageView.requestRender();

                break;

            case "Vignette":
                PrevVignette = progress;
                txtProgressValue.setText("" + PrevVignette);

                if (mVignetteFilterAdjuster != null) {
                    mVignetteFilterAdjuster.adjust(PrevVignette);
                }

                MainGPUImageView.requestRender();

                break;

            case "Sharpness":
                PrevSharpness = progress;
                txtProgressValue.setText("" + PrevSharpness);

                if (mSharpnessFilterAdjuster != null) {
                    mSharpnessFilterAdjuster.adjust(PrevSharpness);
                }

                MainGPUImageView.requestRender();

                break;

            case "Opacity":
                PrevOpacity = progress;
                txtProgressValue.setText("" + ((PrevOpacity * 100)) / seekBar.getMax() + "%");
                textbubble.setAlpha((float) (seekbar.getProgress()) / (float) (seekBar.getMax()));

                break;
        }
    }


    public void CurveImage() {

        smallImageBackgroud = ImageBitmap.BlurBitmap;

        initCurveFilterToolBar();

    }

    public void HeaderControl(View view) {
        imgButtonImage = view.findViewById(R.id.imgButtonImage);
        imgReset = view.findViewById(R.id.imgReset);
        imgReset.setVisibility(View.VISIBLE);
        imgButtonImage.setImageResource(R.drawable.ic_next);
        imgButtonImage.setOnClickListener(this);
        imgReset.setOnClickListener(this);
        TextView txtHeaderName = view.findViewById(R.id.txtHeaderName);
//        txtHeaderName.setText("");

        MainContainer = view.findViewById(R.id.MainContainer);

    }

    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(getContext(), AdsUnits.FB_INTERSTITIAL);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_edit_image, container, false);




//        End Of FB ADD

        try {
            mContext = getActivity();

            filters = WayneCooper.getInst().getLocalFilters();

            getActivity().setTitle("Filters");

            FindControls(rootView);
            HeaderControl(rootView);

            Display display = getActivity().getWindowManager().getDefaultDisplay();
            DisplayWidth = display.getWidth();
            DisplayHeight = display.getHeight();
            FrameActivity.recycler_view.setVisibility(View.GONE);
            RelativeLayout.LayoutParams rparams = new RelativeLayout.LayoutParams(DisplayWidth, DisplayWidth);
            drawing_view_container.setLayoutParams(rparams);

            MainGPUImageView.setImage(ImageBitmap.mBitmapSketch);

            drawing_view_container.setDrawingCacheEnabled(true);
            drawing_view_container.buildDrawingCache();

            InflateBottomMenuLayout();

            CurveImage();

            setFilters();

        } catch (Exception e) {
            e.printStackTrace();
        }
//        adViewContainer = rootView.findViewById(R.id.adViewContainer);
        loadInterstitialAd();

// END OF BANNER
//        loadBannerAd();
        return rootView;
    }

//    private void loadBannerAd() {
//
//        AdView adView = new AdView(getContext(), AdsUnits.FB_BANNER, AdSize.BANNER_HEIGHT_50);
//        adViewContainer.addView(adView);
//        AdListener adListener = new AdListener() {
//            @Override
//            public void onError(Ad ad, AdError adError) {
//            }
//
//            @Override
//            public void onAdLoaded(Ad ad) {
//            }
//
//            @Override
//            public void onAdClicked(Ad ad) {
//            }
//
//            @Override
//            public void onLoggingImpression(Ad ad) {
//            }
//        };
//        AdView.AdViewLoadConfig loadAdConfig = adView.buildLoadAdConfig()
//                .withAdListener(adListener)
//                .build();
//        adView.loadAd(loadAdConfig);
//    }

    //    Initialize the Curve filter
    private void initCurveFilterToolBar() {

        final JohnCrittle adapter = new JohnCrittle(getActivity(), filters, smallImageBackgroud);
        curveList.setAdapter(adapter);
        curveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (adapter.getSelectFilter() != arg2) {


                    adapter.setSelectFilter(arg2);
                    PrevCurvePosition = arg2;
                    curveFilter.setFromCurveFileInputStream(getResources().openRawResource(filters.get(arg2).getFilterfileRaw()));

                    MainGPUImageView.setFilter(filterGroup);
                    EditImageFragment.displayAds();
                }
            }
        });
    }

    //    Set Default Filter Values
    private void setFilters() {
        curveFilter = new GPUImageToneCurveFilter();
        curveFilter.setFromCurveFileInputStream(getResources().openRawResource(filters.get(0).getFilterfileRaw()));

        contrastFilter = new GPUImageContrastFilter(1.0f);// Contrast Filter
        mContrastFilterAdjuster = new DianaVonGrüning.FilterAdjuster(contrastFilter);

        brightnessFilter = new GPUImageBrightnessFilter(0f);// Brightness Filter
        mBrightnessFilterAdjuster = new DianaVonGrüning.FilterAdjuster(brightnessFilter);

        saturationFilter = new GPUImageSaturationFilter(1.0f);// Saturation Filter
        mSaturationFilterAdjuster = new DianaVonGrüning.FilterAdjuster(saturationFilter);

        PointF centerPoint = new PointF();
        centerPoint.x = 0.5f;
        centerPoint.y = 0.5f;
        vignetteFilter = new GPUImageVignetteFilter(centerPoint, new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 1.0f);
        mVignetteFilterAdjuster = new DianaVonGrüning.FilterAdjuster(vignetteFilter);

        sharpnessFilter = new GPUImageSharpenFilter(0.0f);// Sharpness Filter
        mSharpnessFilterAdjuster = new DianaVonGrüning.FilterAdjuster(sharpnessFilter);

        filterGroup = new GPUImageFilterGroup();
        filterGroup.addFilter(curveFilter);
        filterGroup.addFilter(contrastFilter);
        filterGroup.addFilter(brightnessFilter);
        filterGroup.addFilter(saturationFilter);
        filterGroup.addFilter(vignetteFilter);
        filterGroup.addFilter(sharpnessFilter);
        MainGPUImageView.setFilter(filterGroup);

    }

    public void InflateBottomMenuLayout() {
        try {

            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            MainMenu = inflater.inflate(R.layout.shimmer_final_image_menu, MainMenuContainer, false);
            MainMenuContainer.addView(MainMenu);

            LL_MainMenu = MainMenu.findViewById(R.id.LL_MainMenu);
            fragment_Blur = MainMenu.findViewById(R.id.fragment_Blur);

            LL_Brightness = MainMenu.findViewById(R.id.LL_Brightness);
            LL_Contrast = MainMenu.findViewById(R.id.LL_Contrast);
            LL_Saturation = MainMenu.findViewById(R.id.LL_Saturation);
            LL_Vignette = MainMenu.findViewById(R.id.LL_Vignette);
            LL_Sharpness = MainMenu.findViewById(R.id.LL_Sharpness);
            LL_Text = MainMenu.findViewById(R.id.LL_Text);
            LL_Curve = MainMenu.findViewById(R.id.LL_Curve);
            LL_Sticker = MainMenu.findViewById(R.id.LL_Sticker);
            LL_Abc = MainMenu.findViewById(R.id.LL_Abc);
            Sticker_recycler_view = MainMenu.findViewById(R.id.Sticker_recycler_view);
            Abc_recycler_view = MainMenu.findViewById(R.id.Abc_recycler_view);

            ic_clear = MainMenu.findViewById(R.id.ic_clear);
            seekbar = MainMenu.findViewById(R.id.seekbar);
            txtProgressValue = MainMenu.findViewById(R.id.txtProgressValue);

//            Find TextFragment Controls

            LL_TextMainLayout = MainMenu.findViewById(R.id.LL_TextMainLayout);
            LL_AddText = MainMenu.findViewById(R.id.LL_AddText);
            LL_FontStyle = MainMenu.findViewById(R.id.LL_FontStyle);
            LL_TextColor = MainMenu.findViewById(R.id.LL_TextColor);
            LL_TextOpacity = MainMenu.findViewById(R.id.LL_TextOpacity);
            ABCFont = MainMenu.findViewById(R.id.ABCFont);

            mBubbleInputDialog = new BubbleInputDialog(getActivity());

            AddFontsRecycler();

            LL_Curve.setOnClickListener(this);
            LL_Brightness.setOnClickListener(this);
            LL_Contrast.setOnClickListener(this);
            LL_Saturation.setOnClickListener(this);
            LL_Vignette.setOnClickListener(this);
            LL_Text.setOnClickListener(this);
            ic_clear.setOnClickListener(this);
            LL_Sticker.setOnClickListener(this);
            LL_Abc.setOnClickListener(this);
            LL_AddText.setOnClickListener(this);
            LL_FontStyle.setOnClickListener(this);
            LL_TextColor.setOnClickListener(this);
            LL_TextOpacity.setOnClickListener(this);
            LL_Sharpness.setOnClickListener(this);

            seekbar.setOnSeekBarChangeListener(this);

            mBubbleInputDialog.setCompleteCallBack(this);
            stickerData();
            ABCsData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public String saveImageToSD(Bitmap bmp, String filename, Bitmap.CompressFormat format) {
//        File file2 = null;
//        try {
//            String path1 = Environment.getExternalStorageDirectory().toString();
//            FileOutputStream fos = null;
//            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//            bmp.compress(format, 100, bytes);
//            File file1 = new File(path1 + "/"+getString(R.string.app_name)+"/");
//            if (!file1.exists()) {
//                file1.mkdirs();
//            }
//            file2 = new File(file1, filename);
//            try {
//                file2.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fos = new FileOutputStream(file2);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            try {
//                fos.write(bytes.toByteArray());
//                fos.close();
//                Log.e("Success", "Final Image Saved - " + filename);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (dia.isShowing()) {
//                dia.dismiss();
//            }
//            PatrickCox.FinalBitmap = bmp;
//            FinalURI = "" + path1 + "/"+getString(R.string.app_name)+"/" + filename;
//
//
//            ContentValues image = new ContentValues();
//            String dateStr = "04/05/2010";
//
//            SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
//            Date dateObj = curFormater.parse(dateStr);
//            SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");
//
//            String newDateStr = postFormater.format(dateObj);
//            image.put(MediaStore.Images.Media.TITLE, filename);
//            image.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
//            image.put(MediaStore.Images.Media.DESCRIPTION, filename);
//            image.put(MediaStore.Images.Media.DATE_ADDED, newDateStr);
//            image.put(MediaStore.Images.Media.DATE_TAKEN, "");
//            image.put(MediaStore.Images.Media.DATE_MODIFIED, "");
//            image.put(MediaStore.Images.Media.MIME_TYPE, "image/*");
//            image.put(MediaStore.Images.Media.ORIENTATION, 0);
//
//            File parent = file2.getParentFile();
//            String path = parent.toString().toLowerCase();
//            String name = parent.getName().toLowerCase();
//            image.put(MediaStore.Images.ImageColumns.BUCKET_ID, path.hashCode());
//            image.put(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME, name);
//            image.put(MediaStore.Images.Media.SIZE, file2.length());
//
//            image.put(MediaStore.Images.Media.DATA, file2.getAbsolutePath());
//
//            Uri result = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, image);
//
//
//            return file2.getPath();
//        } catch (NullPointerException e) {
//            // TODO: handle exception
//            Log.e("error", "SAve to disk");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        return "";
//    }

    @Override
    public void onClick(View v) {

        displayAds();
        AddCounter++;
        imgButtonImage.setImageResource(R.drawable.ic_true);
        switch (v.getId()) {

            case R.id.LL_Curve:

                flyOut(MainMenu, curveList);
                if (mContrastFilterAdjuster != null) {
                    mContrastFilterAdjuster.adjust(PrevContrast);
                }

                if (mSaturationFilterAdjuster != null) {
                    mSaturationFilterAdjuster.adjust(PrevSaturation);
                }

                if (mVignetteFilterAdjuster != null) {
                    mVignetteFilterAdjuster.adjust(PrevVignette);
                }

                if (mBrightnessFilterAdjuster != null) {
                    mBrightnessFilterAdjuster.adjust(PrevBrightness);
                }
                if (mSharpnessFilterAdjuster != null) {
                    mSharpnessFilterAdjuster.adjust(PrevSharpness);
                }
                MainGPUImageView.requestRender();

                Counter = 1;
                break;

            case R.id.LL_Brightness:

                flyOut(LL_MainMenu, fragment_Blur);
                flag = "Brightness";

                seekbar.setProgress(PrevBrightness);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevBrightness);

                Counter = 2;
                break;
            case R.id.LL_Contrast:

                flyOut(LL_MainMenu, fragment_Blur);
                flag = "Contrast";

                seekbar.setProgress(PrevContrast);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevContrast);

                Counter = 2;
                break;

            case R.id.LL_Saturation:

                flyOut(LL_MainMenu, fragment_Blur);
                flag = "Saturation";

                seekbar.setProgress(PrevSaturation);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevSaturation);

                Counter = 2;
                break;

            case R.id.LL_Vignette:

                flyOut(LL_MainMenu, fragment_Blur);
                flag = "Vignette";

                seekbar.setProgress(PrevVignette);
                seekbar.setMax(75);
                txtProgressValue.setText("" + PrevVignette);

                Counter = 2;
                break;

            case R.id.LL_Sharpness:

                flyOut(LL_MainMenu, fragment_Blur);
                flag = "Sharpness";

                seekbar.setProgress(PrevSharpness);
                seekbar.setMax(50);
                txtProgressValue.setText("" + PrevSharpness);

                Counter = 2;
                break;

//            Bubble text Code
            case R.id.LL_Text:

                flyOut(LL_MainMenu, LL_TextMainLayout);
                Counter = 5;

                if (!textbubble.getText().toString().equals("")) {
                    imgTextClose.setVisibility(View.VISIBLE);
                }

                break;

            case R.id.LL_AddText:
                if (!textflag) {
                    FrameLayoutText.setVisibility(View.VISIBLE);
                    textbubble.setText("Hello World");
                    textflag = true;
                } else {
                    mBubbleInputDialog.setBubbleTextView(textbubble);
                    mBubbleInputDialog.show();
                }
                break;

            case R.id.LL_FontStyle:
                flyOut(LL_TextMainLayout, ABCFont);
                Counter = 8;
                break;

            case R.id.LL_TextColor:
                viewColorPicker();
                break;

            case R.id.LL_TextOpacity:
                flyOut(LL_TextMainLayout, fragment_Blur);
                flag = "Opacity";
                seekbar.setProgress(PrevOpacity);
                seekbar.setMax(255);
                txtProgressValue.setText("" + ((PrevOpacity * 100)) / 255 + "%");
                Counter = 7;
                break;

            case R.id.imgTextClose:
                FrameLayoutText.setVisibility(View.GONE);
                textflag = false;

                break;

            case R.id.LL_Sticker:
                flyOut(LL_MainMenu, Sticker_recycler_view);
                Counter = 3;

                break;
            case R.id.LL_Abc:
                flyOut(LL_MainMenu, Abc_recycler_view);
                Counter = 4;

                break;

//            End Of text Code

            case R.id.ic_clear:

                switch (flag) {
                    case "Brightness":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Contrast":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Saturation":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Vignette":
                        seekbar.setProgress(75);
                        txtProgressValue.setText("75");
                        break;
                    case "Opacity":
                        seekbar.setProgress(255);
                        PrevOpacity = 255;
                        txtProgressValue.setText("" + ((PrevOpacity * 100)) / 255 + "%");
                        break;
                    case "Sharpness":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;
                }

                break;

            case R.id.imgButtonImage:
                imgButtonImage.setImageResource(R.drawable.ic_next);
                if (Counter != 0) {
                    if (Counter == 1) {
                        flyOut(curveList, MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 2) {
                        flyOut(fragment_Blur, LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 3) {
                        flyOut(Sticker_recycler_view, LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 4) {

                        flyOut(Abc_recycler_view, LL_MainMenu);
                        Counter = 0;
                    }

                    if (Counter == 5) {
                        flyOut(LL_TextMainLayout, LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 7) {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        flyOut(fragment_Blur, LL_TextMainLayout);
                        Counter = 5;
                    }
                    if (Counter == 8) {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        flyOut(ABCFont, LL_TextMainLayout);
                        Counter = 5;
                    }
                } else {
//                    showProgress();
                    mergeAndSave();

//                    ((Dabdea) getActivity()).showRatingDialog(true, new LocalBaseActivity.OnRateListner() {
//                        @Override
//                        public void onReminderLater() {
//                            Ads.Loadd(new Ads.Ad_lisoner() {
//                                @Override
//                                public void onSucssec(InterstitialAd mInterstitialAd) {
//                                    Intent intent = new Intent(getActivity(), ShareImageActivity.class);
//                                    intent.putExtra("FinalURI", FinalURI);
//                                    startActivity(intent);
//                                    Dabdea.activity.finish();
//                                }
//
//                                @Override
//                                public void onun() {
//                                    Intent intent = new Intent(getActivity(), ShareImageActivity.class);
//                                    intent.putExtra("FinalURI", FinalURI);
//                                    startActivity(intent);
//                                    Dabdea.activity.finish();
//                                }
//                            });
//                        }
//                    });
                }
                break;

            case R.id.imgReset:
                imgButtonImage.setImageResource(R.drawable.ic_next);

                ((FrameActivity) getActivity()).showResetDialog(getActivity(), new LocalBaseActivity.OnResetListner() {
                    @Override
                    public void onReset() {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        MainGPUImageView.setImage(ImageBitmap.FinalBitmap);
                        PrevCurvePosition = 0;
                        PrevBrightness = 50;
                        PrevContrast = 50;
                        PrevSaturation = 50;
                        PrevSharpness = 50;
                        PrevVignette = 75;
                        setFilters();
                    }
                });

                break;

        }
    }

    public void AddFontsRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        ABCFont.setLayoutManager(layoutManager);
        try {
            ArrayList<SusienChong> arrayList = new ArrayList<>();
            AssetManager assetManager = getActivity().getResources().getAssets();

            String[] files = assetManager.list("fonts");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("fonts/" + file));
                }

                CathyPill adapter = new CathyPill(arrayList, getActivity());
                ABCFont.setAdapter(adapter);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void FindControls(View view) {
        MainGPUImageView = view.findViewById(R.id.MainGPUImageView);
        curveList = view.findViewById(R.id.curve_List);
        MainMenuContainer = view.findViewById(R.id.toolbar_area);
        drawing_view_container = view.findViewById(R.id.drawing_view_container);
        sticker_view = view.findViewById(R.id.sticker_view);
        FrameLayoutText = view.findViewById(R.id.FrameLayoutText);
        imgTextClose = view.findViewById(R.id.imgTextClose);
        textbubble = view.findViewById(R.id.textbubble);

        FrameLayoutText.setOnTouchListener(new MultiTouchListener());
        imgTextClose.setOnClickListener(this);


    }


    private void stickerData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Sticker_recycler_view.setLayoutManager(layoutManager);
        try {
            ArrayList<SusienChong> arrayList = new ArrayList<>();
            AssetManager assetManager = getActivity().getResources().getAssets();

            String[] files = assetManager.list("sticker");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("sticker/" + file));
                }

                BrunoPieters adapter = new BrunoPieters(arrayList, getActivity());
                Sticker_recycler_view.setAdapter(adapter);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void ABCsData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Abc_recycler_view.setLayoutManager(layoutManager);
        try {
            ArrayList<SusienChong> arrayList = new ArrayList<>();
            AssetManager assetManager = getActivity().getResources().getAssets();

            String[] files = assetManager.list("abc");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("abc/" + file));
                }

                MartinMargiela adapter = new MartinMargiela(arrayList, getActivity());
                Abc_recycler_view.setAdapter(adapter);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void AddTextColor(int color) {
        textbubble.setTextColor(color);
    }

    public static void displayAds() {
        if (AddCounter == 2) {

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //    Animation

    private static Context mContext;
    private static Animation animation;

    public static void flyOut(final View view, final View viewFlyIn) {

        animation = AnimationUtils.loadAnimation(mContext, R.anim.holder_bottom_back_fast);
        view.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                animation.setAnimationListener(null);
                view.clearAnimation();
                view.setVisibility(View.GONE);
                flyIn(viewFlyIn);
                viewFlyIn.setVisibility(View.VISIBLE);
            }

        });
    }

    private static void flyIn(final View view) {

        animation = AnimationUtils.loadAnimation(mContext, R.anim.holder_bottom_fast);
        view.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                animation.setAnimationListener(null);
                view.clearAnimation();
            }

        });

    }

    @Override
    public void onComplete(View bubbleTextView, String str) {
        ((TextView) bubbleTextView).setText(str);
        FrameLayoutText.setVisibility(View.VISIBLE);
    }

    public static void AddSticker(Bitmap bitmap) {
        sticker_view.addSticker(bitmap);
    }

    public static Bitmap merge(Bitmap bitmapmain, Bitmap bitmapback) {

        Bitmap bmOverlay = Bitmap.createBitmap(bitmapback.getWidth(), bitmapback.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmOverlay);

        canvas.drawBitmap(bitmapback, new Matrix(), null);
        canvas.drawBitmap(bitmapmain, 0, 0, null);

        Log.i("TAG", "Image Created");

        return bmOverlay;

    }

    // Save Image Code
    public void mergeAndSave() {

        imgTextClose.setVisibility(View.GONE);
        sticker_view.setLooked(true);

        Bitmap bmOverlay = Bitmap.createBitmap(drawing_view_container.getWidth(), drawing_view_container.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmOverlay);
        //canvas.drawBitmap(ThirdFinalBitmap, new Matrix(), null);
        canvas.drawBitmap(drawing_view_container.getDrawingCache(), 0, 0, null);
        //canvas.drawBitmap(bitmapframe, 0, 0, null);
        try {
            Bitmap gpubitmap = MainGPUImageView.capture();

            bmOverlay = merge(bmOverlay, gpubitmap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File file = saveImageToExternalStorage(bmOverlay);
        String absolutePath = file.getAbsolutePath();

        Intent intent = new Intent(getActivity(), ShareImageActivity.class);
        intent.putExtra("FinalURI", absolutePath);
        startActivity(intent);
        requireActivity().finish();

//        saveImageToSD(bmOverlay, "photox_" + generateRandomName(1000000, 5000000) + ".jpg", Bitmap.CompressFormat.JPEG);
        Log.d(TAG, "Image Created");
    }
    private File saveImageToExternalStorage(Bitmap finalBitmap) {

        File myDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/"+getString(R.string.app_name));
        if (!myDir.mkdirs()) {
            myDir.mkdirs();

        }
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);

        try {
            OutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 85, out);
            out.flush();
            out.close();
            Toast.makeText(getContext(), "Save Image Successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("TAG", "saveImageToExternalStorage: Exception: "+e.getMessage());
        }


        // Tell the media scanner about the new file so that it is
        // immediately available to the user.
        //MediaStore.Images.Media.insertImage(getContentResolver(), yourBitmap, yourTitle , yourDescription)
        MediaScannerConnection.scanFile(getContext(), new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });

        return file;
    }

    private int generateRandomName(int LowerLimit, int UpperLimit) {

        Random r = new Random();
        return r.nextInt((UpperLimit - LowerLimit) + 1) + LowerLimit;
    }

    ProgressDialog dia;

    public void showProgress() {
        //pDialog.show();

        dia = new ProgressDialog(getActivity());
        dia.setMessage("Loading ...");
        dia.setIndeterminate(false);
        dia.setCancelable(false);
        dia.setCanceledOnTouchOutside(false);
        dia.show();
    }


}
