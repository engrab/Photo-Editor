package com.oga.photoeditor.pro.beauty.face.filters.effects.framesLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Util.AdsUnits;

import java.util.ArrayList;
import java.util.List;

public class LayoutActivity extends AppCompatActivity {

    int position = 0;

    private List<DataModle> list;
    GalleryFragment galleryFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        prepareInfo();




        prepareInfo();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ImageAdapter imageAdapter = new ImageAdapter(this, list);
        recyclerView.setAdapter(imageAdapter);

    }

    public void openCollage(boolean isblur, boolean isScrapBook, boolean isShape, boolean isMirror) {
        this.galleryFragment = CollageHelper.addGalleryFragment(this, R.id.gallery_fragment_container, null, true, null);
        this.galleryFragment.setCollageSingleMode(isblur);
        this.galleryFragment.setIsMirrorSelector(isMirror);
        this.galleryFragment.setIsScrapbook(isScrapBook);
        this.galleryFragment.setIsShape(isShape);
        if (!isScrapBook) {
            this.galleryFragment.setLimitMax(GalleryFragment.MAX_COLLAGE);
        }
    }

    public void openCollage(boolean isblur, boolean isScrapBook, boolean isShape) {
        openCollage(isblur, isScrapBook, isShape, false);
    }


    private void prepareInfo() {
        list = new ArrayList<>();
        list.add(new DataModle(R.drawable.collage_1_0, R.drawable.collage_1_1, R.drawable.collage_1_10));
        list.add(new DataModle(R.drawable.collage_1_11, R.drawable.collage_1_2, R.drawable.collage_1_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_1_4, R.drawable.collage_1_5, R.drawable.collage_1_6));

        list.add(new DataModle(R.drawable.collage_1_7, R.drawable.collage_1_8, R.drawable.collage_1_9));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_2_1, R.drawable.collage_2_10, R.drawable.collage_2_11));

        list.add(new DataModle(R.drawable.collage_2_2, R.drawable.collage_2_3, R.drawable.collage_2_4));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_2_5, R.drawable.collage_2_6, R.drawable.collage_2_7));

        list.add(new DataModle(R.drawable.collage_2_0, R.drawable.collage_2_8, R.drawable.collage_2_9));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_3_0, R.drawable.collage_3_1, R.drawable.collage_3_10));

        list.add(new DataModle(R.drawable.collage_3_11, R.drawable.collage_3_2, R.drawable.collage_3_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_3_4, R.drawable.collage_3_5, R.drawable.collage_3_6));

        list.add(new DataModle(R.drawable.collage_3_7, R.drawable.collage_3_8, R.drawable.collage_3_9));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_4_0, R.drawable.collage_4_1, R.drawable.collage_4_10));

        list.add(new DataModle(R.drawable.collage_4_11, R.drawable.collage_4_2, R.drawable.collage_4_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_4_4, R.drawable.collage_4_5, R.drawable.collage_4_6));

        list.add(new DataModle(R.drawable.collage_4_7, R.drawable.collage_4_8, R.drawable.collage_4_9));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_5_0, R.drawable.collage_5_1, R.drawable.collage_5_10));

        list.add(new DataModle(R.drawable.collage_5_11, R.drawable.collage_5_2, R.drawable.collage_5_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_5_4, R.drawable.collage_5_5, R.drawable.collage_5_6));

        list.add(new DataModle(R.drawable.collage_5_7, R.drawable.collage_5_8, R.drawable.collage_5_9));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_6_0, R.drawable.collage_6_1, R.drawable.collage_6_10));

        list.add(new DataModle(R.drawable.collage_6_11, R.drawable.collage_6_2, R.drawable.collage_6_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_6_4, R.drawable.collage_6_5, R.drawable.collage_6_6));

        list.add(new DataModle(R.drawable.collage_6_7, R.drawable.collage_6_8, R.drawable.collage_6_9));
        list.add(new DataModle(123, 123, 123));
        list.add(new DataModle(R.drawable.collage_7_0, R.drawable.collage_7_1, R.drawable.collage_7_5));

        list.add(new DataModle(R.drawable.collage_7_0, R.drawable.collage_7_2, R.drawable.collage_7_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_7_4, R.drawable.collage_7_5, R.drawable.collage_7_6));

        list.add(new DataModle(R.drawable.collage_7_7, R.drawable.collage_7_8, R.drawable.collage_7_9));
        list.add(new DataModle(123, 123, 123));
        list.add(new DataModle(R.drawable.collage_8_0, R.drawable.collage_8_1, R.drawable.collage_8_5));

        list.add(new DataModle(R.drawable.collage_8_0, R.drawable.collage_8_2, R.drawable.collage_8_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_8_4, R.drawable.collage_8_5, R.drawable.collage_8_6));

        list.add(new DataModle(R.drawable.collage_8_7, R.drawable.collage_8_8, R.drawable.collage_8_9));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_9_0, R.drawable.collage_9_1, R.drawable.collage_9_5));

        list.add(new DataModle(R.drawable.collage_9_0, R.drawable.collage_9_2, R.drawable.collage_9_3));
        list.add(new DataModle(123, 123, 123));

        list.add(new DataModle(R.drawable.collage_9_4, R.drawable.collage_9_5, R.drawable.collage_9_6));

        list.add(new DataModle(R.drawable.collage_9_7, R.drawable.collage_9_8, R.drawable.collage_9_5));
        list.add(new DataModle(123, 123, 123));


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Context mContext;
        private List<DataModle> dataInfoList;

        ImageAdapter(Context c, List<DataModle> nearByInfoList) {
            mContext = c;
            this.dataInfoList = nearByInfoList;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            if (viewType == 1) {
                LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams attributLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                attributLayoutParams.gravity = Gravity.CENTER;
                linearLayout.setLayoutParams(attributLayoutParams);
                linearLayout.setGravity(Gravity.CENTER);
                AdView adView = new AdView(mContext, AdsUnits.FB_BANNER, AdSize.BANNER_HEIGHT_50);
                linearLayout.addView(adView);
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
                return new AdviewViewHolder(linearLayout);
            } else {

                return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.template_row_new, parent, false));
            }


        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            DataModle DataClass = dataInfoList.get(position);

            if (holder.getItemViewType() == 1)
                return;

            if (holder instanceof ViewHolder) {
                ViewHolder viewHolder = (ViewHolder) holder;
                Glide.with(mContext).load(DataClass.drawableId).into(viewHolder.IvImg);
                Glide.with(mContext).load(DataClass.drawableId1).into(viewHolder.IvImg1);
                Glide.with(mContext).load(DataClass.drawableId2).into(viewHolder.IvImg2);


            }
        }

        @Override
        public int getItemCount() {
            return dataInfoList.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (dataInfoList.get(position).drawableId == 123) {
                return 1;

            } else
                return 2;

        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView IvImg, IvImg1, IvImg2;

            ViewHolder(View itemView) {
                super(itemView);

                IvImg = itemView.findViewById(R.id.grid_image);
                IvImg1 = itemView.findViewById(R.id.grid_image1);
                IvImg2 = itemView.findViewById(R.id.grid_image2);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            position = getAdapterPosition();
                            openCollage(false, false, false);

                        } catch (Exception ignored) {
                        }
                    }
                });
            }
        }

        class AdviewViewHolder extends RecyclerView.ViewHolder {

            AdviewViewHolder(View itemView) {
                super(itemView);


            }
        }
    }
}