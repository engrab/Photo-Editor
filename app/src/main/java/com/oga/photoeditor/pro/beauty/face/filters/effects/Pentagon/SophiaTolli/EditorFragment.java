package com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.SophiaTolli;


import android.app.ProgressDialog;
import android.content.ContentValues;
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
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.oga.photoeditor.pro.beauty.face.filters.effects.RuthTarvydas.RichardTyler.Pnanterist;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;
import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.MainActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.ShareImageActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ChristopherEssex.JohnCrittle;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ChristopherEssex.LizDavenport;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ChristopherEssex.WayneCooper;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DianaVonGrüning;
import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.PatrickCox;
import com.oga.photoeditor.pro.beauty.face.filters.effects.KayCohen.SusienChong;
import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.AmberRenae.Tempoll;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.BrunoSchiavi.JoeSaba;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.BrunoSchiavi.PaulaStafford;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.BrunoSchiavi.SheilaScotter;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.multiTouchLib.MultiTouchListener;
import com.oga.photoeditor.pro.beauty.face.filters.effects.stickerView.StickerView;
import com.oga.photoeditor.pro.beauty.face.filters.effects.textviewBubble.BubbleInputDialog;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorBalanceFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageContrastFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageExposureFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageFilterGroup;
import jp.co.cyberagent.android.gpuimage.GPUImageHueFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLevelsFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageMonochromeFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSaturationFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSepiaFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSharpenFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageToneCurveFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageView;
import jp.co.cyberagent.android.gpuimage.GPUImageVignetteFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageWhiteBalanceFilter;

public class EditorFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, BubbleInputDialog.CompleteCallBack {

    InterstitialAd interstitialAd;
    private String FinalURI;

    public EditorFragment() {
    }

    GPUImageView MainGPUImageView;

    public static StickerView sticker_view;

    FrameLayout FrameLayoutText;

    public static RelativeLayout MainContainer;

    public static ImageView imgTextClose;
    public static TextView textbubble;
    Boolean textflag = true;

    public static RecyclerView ABCsCategory, ABCFont;
    BubbleInputDialog mBubbleInputDialog;

    public static HListView curveList;
    LinearLayout MainMenuContainer;
    RelativeLayout drawing_view_container;

    private static int DisplayWidth, DisplayHeight;

    String flag = "";
    int PrevCurvePosition = 0, PrevBrightness = 50, PrevContrast = 50, PrevSaturation = 50, PrevVignette = 75, PrevSharpness = 50, PrevHue = 0, PrevSepia = 0, PrevMonochrome = 0, PrevWhiteBalance = 100, PrevColorBalance = 0, PrevLevels = 100, PrevExposure = 50, PrevOpacity = 255;

    public static View MainMenu;
    LinearLayout LL_Brightness, LL_Contrast, LL_Saturation, LL_Vignette, LL_Curve, LL_Sharpness, LL_hue, LL_Sepia, LL_Monochrome, LL_WhiteBalance, LL_ColorBalance, LL_Level, LL_Exposure, LL_Text, LL_AddText, LL_FontStyle, LL_TextColor, LL_TextOpacity, LL_ABCs;
    public static LinearLayout LL_MainMenu, fragment_Blur, LL_Sticker, LL_TextMainLayout;
    public static int Counter = 0, AddCounter = 0;
    ImageView ic_clear;
    SeekBar seekbar;
    TextView txtProgressValue;

    private Bitmap smallImageBackgroud;

    List<LizDavenport> filters;

    public static ImageView imgButtonImage, imgReset;

    static RelativeLayout adViewContainer;

    ImageView imgTemp;

    boolean flagimgtemp = true;

    private void loadInterstitialAd() {
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

        View rootView = inflater.inflate(R.layout.photoeditor_fragment_filters, container, false);

        loadInterstitialAd();


        try {
            mContext = getActivity();
            showProgress();

            filters = WayneCooper.getInst().getLocalFilters();

            getActivity().setTitle("Filters");

            FindControls(rootView);
            HeaderControl(rootView);

            Display display = getActivity().getWindowManager().getDefaultDisplay();
            DisplayWidth = display.getWidth();
            DisplayHeight = display.getHeight();


            imgTemp = rootView.findViewById(R.id.imgTemp);

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(PatrickCox.bitmap.getWidth(), PatrickCox.bitmap.getHeight());

            imgTemp.setImageBitmap(PatrickCox.bitmap);

            ViewTreeObserver vto = imgTemp.getViewTreeObserver();
            vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {

                    if (flagimgtemp) {
                        int finalHeight = imgTemp.getMeasuredHeight();
                        int finalWidth = imgTemp.getMeasuredWidth();
                        flagimgtemp = false;
                        RelativeLayout.LayoutParams imageLayoutParams = new RelativeLayout.LayoutParams(DisplayWidth, DisplayWidth);
                        imageLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                        drawing_view_container.setLayoutParams(imageLayoutParams);
                        imgTemp.setVisibility(View.GONE);
                        MainGPUImageView.setImage(PatrickCox.bitmap);
                    }

                    return true;
                }
            });

            InflateBottomMenuLayout();

            CurveImage();

            setFilters();

            dia.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
            dia.dismiss();
        }

        loadBannerAd();
        return rootView;
    }

    public void getFilesFromAssets(String FolderName) {
        ArrayList<SusienChong> arrayList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        ABCsCategory.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        ABCFont.setLayoutManager(layoutManager1);

        switch (FolderName) {

            case "ABC":
                try {
                    arrayList = new ArrayList<>();
                    AssetManager assetManager = getActivity().getResources().getAssets();

                    String[] files = assetManager.list(FolderName.toLowerCase());
                    if (files != null) {
                        for (String file : files) {
                            arrayList.add(new SusienChong(FolderName.toLowerCase() + "/" + file));
                        }

                        JoeSaba adapter = new JoeSaba(arrayList, getActivity());
                        ABCsCategory.setAdapter(adapter);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "Sticker":
                try {
                    arrayList = new ArrayList<>();
                    AssetManager assetManager = getActivity().getResources().getAssets();

                    String[] files = assetManager.list(FolderName.toLowerCase());
                    if (files != null) {
                        for (String file : files) {
                            arrayList.add(new SusienChong(FolderName.toLowerCase() + "/" + file));
                        }

                        SheilaScotter adapter = new SheilaScotter(arrayList, getActivity());
                        ABCsCategory.setAdapter(adapter);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "Fonts":
                try {
                    arrayList = new ArrayList<>();
                    AssetManager assetManager = getActivity().getResources().getAssets();

                    String[] files = assetManager.list(FolderName.toLowerCase());
                    if (files != null) {
                        for (String file : files) {
                            arrayList.add(new SusienChong(FolderName.toLowerCase() + "/" + file));
                        }

                        PaulaStafford adapter = new PaulaStafford(arrayList, getActivity());
                        ABCFont.setAdapter(adapter);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }

    }

    public void HeaderControl(View view) {
        imgButtonImage = view.findViewById(R.id.imgButtonImage);
        imgReset = view.findViewById(R.id.imgReset);
        imgReset.setVisibility(View.VISIBLE);
        imgButtonImage.setImageResource(R.drawable.ic_next);
        imgButtonImage.setOnClickListener(this);
        imgReset.setOnClickListener(this);
    }

    private void loadBannerAd() {
        AdView adView = new AdView(getContext(), AdsUnits.FB_BANNER, AdSize.BANNER_HEIGHT_50);
        adViewContainer.addView(adView);
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

    public void FindControls(View view) {

        MainGPUImageView = view.findViewById(R.id.MainGPUImageView);
        curveList = view.findViewById(R.id.curve_List);
        MainMenuContainer = view.findViewById(R.id.toolbar_area);
        adViewContainer = view.findViewById(R.id.adViewContainer);
        drawing_view_container = view.findViewById(R.id.drawing_view_container);
        drawing_view_container.setDrawingCacheEnabled(true);
        drawing_view_container.buildDrawingCache();

        MainContainer = view.findViewById(R.id.MainContainer);

        sticker_view = view.findViewById(R.id.sticker_view);
        FrameLayoutText = view.findViewById(R.id.FrameLayoutText);
        imgTextClose = view.findViewById(R.id.imgTextClose);
        textbubble = view.findViewById(R.id.textbubble);

        FrameLayoutText.setOnTouchListener(new MultiTouchListener());
        imgTextClose.setOnClickListener(this);


    }

    public void CurveImage() {

        smallImageBackgroud = PatrickCox.bitmap;

        initCurveFilterToolBar();

    }

    public void InflateBottomMenuLayout() {
        try {

            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            MainMenu = inflater.inflate(R.layout.photoeditor_final_image_menu, MainMenuContainer, false);
            MainMenuContainer.addView(MainMenu);

            LL_MainMenu = MainMenu.findViewById(R.id.LL_MainMenu);
            fragment_Blur = MainMenu.findViewById(R.id.fragment_Blur);

            LL_Sharpness = MainMenu.findViewById(R.id.LL_Sharpness);

            LL_Brightness = MainMenu.findViewById(R.id.LL_Brightness);
            LL_Contrast = MainMenu.findViewById(R.id.LL_Contrast);
            LL_Saturation = MainMenu.findViewById(R.id.LL_Saturation);
            LL_Vignette = MainMenu.findViewById(R.id.LL_Vignette);
            LL_hue = MainMenu.findViewById(R.id.LL_hue);
            LL_Sepia = MainMenu.findViewById(R.id.LL_Sepia);

            LL_Monochrome = MainMenu.findViewById(R.id.LL_Monochrome);
            LL_WhiteBalance = MainMenu.findViewById(R.id.LL_WhiteBalance);
            LL_ColorBalance = MainMenu.findViewById(R.id.LL_ColorBalance);
            LL_Level = MainMenu.findViewById(R.id.LL_Level);
            LL_Exposure = MainMenu.findViewById(R.id.LL_Exposure);

            LL_Curve = MainMenu.findViewById(R.id.LL_Curve);
            LL_ABCs = MainMenu.findViewById(R.id.LL_ABCs);

            LL_Sticker = MainMenu.findViewById(R.id.LL_Sticker);
            LL_Text = MainMenu.findViewById(R.id.LL_Text);

            LL_TextMainLayout = MainMenu.findViewById(R.id.LL_TextMainLayout);
            LL_AddText = MainMenu.findViewById(R.id.LL_AddText);
            LL_FontStyle = MainMenu.findViewById(R.id.LL_FontStyle);
            LL_TextColor = MainMenu.findViewById(R.id.LL_TextColor);
            LL_TextOpacity = MainMenu.findViewById(R.id.LL_TextOpacity);

            ABCsCategory = MainMenu.findViewById(R.id.ABCsCategory);
            ABCFont = MainMenu.findViewById(R.id.ABCFont);

            ic_clear = MainMenu.findViewById(R.id.ic_clear);
            seekbar = MainMenu.findViewById(R.id.seekbar);
            txtProgressValue = MainMenu.findViewById(R.id.txtProgressValue);

            LL_Curve.setOnClickListener(this);
            LL_Brightness.setOnClickListener(this);
            LL_Contrast.setOnClickListener(this);
            LL_Saturation.setOnClickListener(this);
            LL_Vignette.setOnClickListener(this);
            LL_Sharpness.setOnClickListener(this);
            LL_hue.setOnClickListener(this);
            LL_Sepia.setOnClickListener(this);

            LL_Text.setOnClickListener(this);
            LL_FontStyle.setOnClickListener(this);
            LL_TextColor.setOnClickListener(this);
            LL_TextOpacity.setOnClickListener(this);

            LL_Monochrome.setOnClickListener(this);
            LL_WhiteBalance.setOnClickListener(this);
            LL_ColorBalance.setOnClickListener(this);
            LL_Level.setOnClickListener(this);
            LL_Exposure.setOnClickListener(this);

            LL_Sticker.setOnClickListener(this);
            LL_ABCs.setOnClickListener(this);
            LL_AddText.setOnClickListener(this);

            ic_clear.setOnClickListener(this);

            seekbar.setOnSeekBarChangeListener(this);

            mBubbleInputDialog = new BubbleInputDialog(getActivity());
            mBubbleInputDialog.setCompleteCallBack(this);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                    EditorFragment.displayAds();
                }
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar.getId() == R.id.seekbar) {

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

                case "Hue":
                    PrevHue = progress;
                    txtProgressValue.setText("" + PrevHue);

                    if (mHueFilterAdjuster != null) {
                        mHueFilterAdjuster.adjust(PrevHue);
                    }
                    MainGPUImageView.requestRender();
                    break;

                case "Sepia":
                    PrevSepia = progress;
                    txtProgressValue.setText("" + PrevSepia);

                    if (mSepiaFilterAdjuster != null) {
                        mSepiaFilterAdjuster.adjust(PrevSepia);
                    }
                    MainGPUImageView.requestRender();
                    break;

                case "Monochrome":
                    PrevMonochrome = progress;
                    txtProgressValue.setText("" + PrevMonochrome);

                    if (mMonochromeFilterAdjuster != null) {
                        mMonochromeFilterAdjuster.adjust(PrevMonochrome);
                    }
                    MainGPUImageView.requestRender();
                    break;

                case "WhiteBalance":
                    PrevWhiteBalance = progress;
                    txtProgressValue.setText("" + PrevWhiteBalance);

                    if (mWhiteBalanceFilterAdjuster != null) {
                        mWhiteBalanceFilterAdjuster.adjust(PrevWhiteBalance);
                    }
                    MainGPUImageView.requestRender();
                    break;

                case "ColorBalance":
                    PrevColorBalance = progress;
                    txtProgressValue.setText("" + PrevColorBalance);

                    if (mColorBalanceFilterAdjuster != null) {
                        mColorBalanceFilterAdjuster.adjust(PrevColorBalance);
                    }
                    MainGPUImageView.requestRender();
                    break;
                case "Level":
                    PrevLevels = progress;
                    txtProgressValue.setText("" + PrevLevels);

                    if (mLevelsFilterAdjuster != null) {
                        mLevelsFilterAdjuster.adjust(PrevLevels);
                    }
                    MainGPUImageView.requestRender();
                    break;

                case "Exposure":
                    PrevExposure = progress;
                    txtProgressValue.setText("" + PrevExposure);

                    if (mExposureFilterAdjuster != null) {
                        mExposureFilterAdjuster.adjust(PrevExposure);
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
    }

    private void setFilters() {
        curveFilter = new GPUImageToneCurveFilter();
        curveFilter.setFromCurveFileInputStream(getResources().openRawResource(filters.get(0).getFilterfileRaw()));

        contrastFilter = new GPUImageContrastFilter(1.0f);
        mContrastFilterAdjuster = new DianaVonGrüning.FilterAdjuster(contrastFilter);

        brightnessFilter = new GPUImageBrightnessFilter(0f);
        mBrightnessFilterAdjuster = new DianaVonGrüning.FilterAdjuster(brightnessFilter);

        saturationFilter = new GPUImageSaturationFilter(1.0f);
        mSaturationFilterAdjuster = new DianaVonGrüning.FilterAdjuster(saturationFilter);

        PointF centerPoint = new PointF();
        centerPoint.x = 0.5f;
        centerPoint.y = 0.5f;
        vignetteFilter = new GPUImageVignetteFilter(centerPoint, new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 1.0f);
        mVignetteFilterAdjuster = new DianaVonGrüning.FilterAdjuster(vignetteFilter);

        sharpnessFilter = new GPUImageSharpenFilter(0.0f);
        mSharpnessFilterAdjuster = new DianaVonGrüning.FilterAdjuster(sharpnessFilter);

        hueFilter = new GPUImageHueFilter(0.0f);
        mHueFilterAdjuster = new DianaVonGrüning.FilterAdjuster(hueFilter);


        whiteBalanceFilter = new GPUImageWhiteBalanceFilter(5000.0f, 0.0f);
        mWhiteBalanceFilterAdjuster = new DianaVonGrüning.FilterAdjuster(whiteBalanceFilter);

        colorBalanceFilter = new GPUImageColorBalanceFilter();
        mColorBalanceFilterAdjuster = new DianaVonGrüning.FilterAdjuster(colorBalanceFilter);

        exposureFilter = new GPUImageExposureFilter(0.0f);
        mExposureFilterAdjuster = new DianaVonGrüning.FilterAdjuster(exposureFilter);

        levelsFilter = new GPUImageLevelsFilter();
        levelsFilter.setMin(0.0f, 3.0f, 1.0f);
        mLevelsFilterAdjuster = new DianaVonGrüning.FilterAdjuster(levelsFilter);

        filterGroup = new GPUImageFilterGroup();
        filterGroup.addFilter(curveFilter);
        filterGroup.addFilter(contrastFilter);
        filterGroup.addFilter(brightnessFilter);
        filterGroup.addFilter(saturationFilter);
        filterGroup.addFilter(vignetteFilter);
        filterGroup.addFilter(sharpnessFilter);
        filterGroup.addFilter(hueFilter);

        filterGroup.addFilter(whiteBalanceFilter);
        filterGroup.addFilter(colorBalanceFilter);
        filterGroup.addFilter(exposureFilter);
        MainGPUImageView.setFilter(filterGroup);

    }

    public static void AddTextColor(int color) {
        textbubble.setTextColor(color);
    }

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
                if (mHueFilterAdjuster != null) {
                    mHueFilterAdjuster.adjust(PrevHue);
                }
                if (mSepiaFilterAdjuster != null) {
                    mSepiaFilterAdjuster.adjust(PrevSepia);
                }
                if (mMonochromeFilterAdjuster != null) {
                    mMonochromeFilterAdjuster.adjust(PrevMonochrome);
                }
                if (mWhiteBalanceFilterAdjuster != null) {
                    mWhiteBalanceFilterAdjuster.adjust(PrevWhiteBalance);
                }
                if (mColorBalanceFilterAdjuster != null) {
                    mColorBalanceFilterAdjuster.adjust(PrevColorBalance);
                }
                if (mLevelsFilterAdjuster != null) {
                    mLevelsFilterAdjuster.adjust(PrevLevels);
                }
                if (mExposureFilterAdjuster != null) {
                    mExposureFilterAdjuster.adjust(PrevExposure);
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

            case R.id.LL_hue:
                flag = "Hue";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevHue);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevHue);

                Counter = 2;
                break;

            case R.id.LL_Sepia:

                break;

            case R.id.LL_Monochrome:

                break;

            case R.id.LL_WhiteBalance:
                flag = "WhiteBalance";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevWhiteBalance);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevWhiteBalance);

                Counter = 2;
                break;

            case R.id.LL_ColorBalance:
                flag = "ColorBalance";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevColorBalance);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevColorBalance);

                Counter = 2;
                break;

            case R.id.LL_Level:
                flag = "Level";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevLevels);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevLevels);

                Counter = 2;
                break;
            case R.id.LL_Exposure:
                flag = "Exposure";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevExposure);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevExposure);

                Counter = 2;
                break;

            case R.id.LL_Vignette:
                flag = "Vignette";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevVignette);
                seekbar.setMax(75);
                txtProgressValue.setText("" + PrevVignette);

                Counter = 2;
                break;

            case R.id.LL_Sharpness:
                flag = "Sharpness";
                flyOut(LL_MainMenu, fragment_Blur);

                seekbar.setProgress(PrevSharpness);
                seekbar.setMax(50);
                txtProgressValue.setText("" + PrevSharpness);

                Counter = 2;
                break;

            case R.id.LL_Text:

                flyOut(LL_MainMenu, LL_TextMainLayout);
                Counter = 4;

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

                getFilesFromAssets("Fonts");
                flyOut(LL_TextMainLayout, ABCFont);
                Counter = 5;
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
                Counter = 6;
                break;

            case R.id.imgTextClose:
                FrameLayoutText.setVisibility(View.GONE);
                textflag = false;

                break;

            case R.id.LL_Sticker:
                getFilesFromAssets("Sticker");
                flyOut(LL_MainMenu, ABCsCategory);
                Counter = 7;

                break;
            case R.id.LL_ABCs:
                getFilesFromAssets("ABC");
                flyOut(LL_MainMenu, ABCsCategory);
                Counter = 10;

                break;

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
                    case "Sharpness":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;
                    case "Hue":
                        seekbar.setProgress(100);
                        txtProgressValue.setText("100");
                        break;
                    case "Sepia":
                        seekbar.setProgress(0);
                        txtProgressValue.setText("0%");
                        break;
                    case "Monochrome":
                        seekbar.setProgress(0);
                        txtProgressValue.setText("0%");
                        break;
                    case "WhiteBalance":
                        seekbar.setProgress(100);
                        txtProgressValue.setText("100");
                        break;
                    case "ColorBalance":
                        seekbar.setProgress(0);
                        txtProgressValue.setText("0%");
                        break;
                    case "Level":
                        seekbar.setProgress(100);
                        txtProgressValue.setText("100%");
                        break;

                    case "Exposure":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Opacity":
                        seekbar.setProgress(255);
                        PrevOpacity = 255;
                        txtProgressValue.setText("" + ((PrevOpacity * 100)) / 255 + "%");
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
                    if (Counter == 4) {
                        flyOut(LL_TextMainLayout, LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 5) {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        flyOut(ABCFont, LL_TextMainLayout);
                        Counter = 4;
                    }
                    if (Counter == 6) {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        flyOut(fragment_Blur, LL_TextMainLayout);
                        Counter = 4;
                    }
                    if (Counter == 7) {
                        flyOut(ABCsCategory, LL_MainMenu);
                        MainContainer.setVisibility(View.VISIBLE);
                        Counter = 0;
                    }

                    if (Counter == 10) {
                        flyOut(ABCsCategory, LL_MainMenu);
                        Counter = 0;
                    }
                } else {
                    new SaveImage().execute();

                }
                break;

            case R.id.imgReset:

                ((Tempoll) getActivity()).showResetDialog(getActivity(), new LocalBaseActivity.OnResetListner() {
                    @Override
                    public void onReset() {
                        MainGPUImageView.setImage(PatrickCox.bitmap);
                        PrevCurvePosition = 0;
                        PrevBrightness = 50;
                        PrevContrast = 50;
                        PrevSaturation = 50;
                        PrevVignette = 75;
                        PrevSharpness = 50;
                        PrevSepia = 0;
                        PrevHue = 100;

                        PrevExposure = 50;
                        PrevLevels = 100;
                        PrevColorBalance = 0;
                        PrevWhiteBalance = 100;
                        PrevMonochrome = 0;
                        setFilters();
                    }
                });

                break;

        }
    }


    public static void AddSticker(Bitmap bitmap) {
        sticker_view.addSticker(bitmap);
    }

    @Override
    public void onComplete(View bubbleTextView, String str) {
        ((TextView) bubbleTextView).setText(str);
        FrameLayoutText.setVisibility(View.VISIBLE);
    }

    public static void displayAds() {
        if (AddCounter == 2) {

        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    GPUImageBrightnessFilter brightnessFilter;
    GPUImageContrastFilter contrastFilter;
    GPUImageVignetteFilter vignetteFilter;
    GPUImageSaturationFilter saturationFilter;
    GPUImageToneCurveFilter curveFilter;
    GPUImageSharpenFilter sharpnessFilter;

    GPUImageHueFilter hueFilter;
    GPUImageSepiaFilter sepiaFilter;
    GPUImageMonochromeFilter monochromeFilter;
    GPUImageWhiteBalanceFilter whiteBalanceFilter;
    GPUImageColorBalanceFilter colorBalanceFilter;
    GPUImageLevelsFilter levelsFilter;
    GPUImageExposureFilter exposureFilter;

    GPUImageFilterGroup filterGroup;
    private DianaVonGrüning.FilterAdjuster mContrastFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mBrightnessFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mVignetteFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mSaturationFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mSharpnessFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mHueFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mSepiaFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mMonochromeFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mWhiteBalanceFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mColorBalanceFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mExposureFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mLevelsFilterAdjuster;


    private static Context mContext;

    private static Animation animation;
    static View SecoundView = null;

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
                SecoundView = viewFlyIn;
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

    public static void ManageBackPrace() {
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
            if (Counter == 4) {
                flyOut(LL_TextMainLayout, LL_MainMenu);
                Counter = 0;
                imgTextClose.setVisibility(View.GONE);
            }

            if (Counter == 5) {
                imgButtonImage.setImageResource(R.drawable.ic_true);
                flyOut(ABCFont, LL_TextMainLayout);
                Counter = 4;
            }
            if (Counter == 6) {
                imgButtonImage.setImageResource(R.drawable.ic_true);
                flyOut(fragment_Blur, LL_TextMainLayout);
                Counter = 4;
            }
            if (Counter == 7) {
                flyOut(ABCsCategory, LL_MainMenu);
                Counter = 0;
            }
            if (Counter == 10) {
                flyOut(ABCsCategory, LL_MainMenu);
                Counter = 0;
            }
        } else {

            ((Tempoll) mContext).showResetDialog(mContext, new LocalBaseActivity.OnResetListner() {
                @Override
                public void onReset() {
                    Tempoll.activity.finish();
                    mContext.startActivity(new Intent(mContext, MainActivity.class));
                    Tempoll.activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            });


        }
    }

    public static void SingleflyOut(final View view) {

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
            }

        });
    }

    private static void SingleflyIn(final View view) {

        animation = AnimationUtils.loadAnimation(mContext, R.anim.holder_bottom_fast);
        view.setVisibility(View.VISIBLE);
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

    public static Bitmap merge(Bitmap bitmapmain, Bitmap bitmapback) {

        Bitmap bmOverlay = Bitmap.createBitmap(bitmapback.getWidth(), bitmapback.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmOverlay);

        canvas.drawBitmap(bitmapback, new Matrix(), null);
        canvas.drawBitmap(bitmapmain, 0, 0, null);

        Log.i("TAG", "Image Created");

        return bmOverlay;

    }

    private class SaveImage extends AsyncTask<Object, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgress();
        }

        @Override
        protected String doInBackground(Object... params) {

            try {
                mergeAndSave();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dia.dismiss();

            Intent intent = new Intent(getActivity(), ShareImageActivity.class);
            intent.putExtra("FinalURI", FinalURI);
            startActivity(intent);
            Tempoll.activity.finish();

        }
    }

    public void mergeAndSave() {

        imgTextClose.setVisibility(View.GONE);

        Bitmap bmOverlay = Bitmap.createBitmap(drawing_view_container.getWidth(), drawing_view_container.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(drawing_view_container.getDrawingCache(), 0, 0, null);
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
        Log.i("TAG", "Image Created");
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

        dia = new ProgressDialog(getActivity());
        dia.setMessage("Loading ...");
        dia.setIndeterminate(false);
        dia.setCancelable(false);
        dia.setCanceledOnTouchOutside(false);
        dia.show();
    }

//    public String saveImageToSD(Bitmap bmp, String filename, Bitmap.CompressFormat format) {
//        File file2 = null;
//        try {
//            String path1 = Environment.getExternalStorageDirectory().toString();
//            FileOutputStream fos = null;
//            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//            bmp.compress(format, 100, bytes);
//            File file1 = new File(path1 + "/" + getString(R.string.app_name) + "/");
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
//            FinalURI = "" + path1 + "/" + getString(R.string.app_name) + "/" + filename;
//
//
//            ContentValues image = new ContentValues();
//            String dateStr = "07/03/2021";
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
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        return "";
//    }

}
