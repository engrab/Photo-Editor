package com.oga.photoeditor.pro.beauty.face.filters.effects.PeterJackson.JacobLuppino;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.oga.photoeditor.pro.beauty.face.filters.effects.DovCharney.PatrickCox;
import com.oga.photoeditor.pro.beauty.face.filters.effects.KayCohen.SusienChong;
import com.oga.photoeditor.pro.beauty.face.filters.effects.PeterJackson.AnthonyPittorino.NevilleQuist;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;

import java.io.IOException;
import java.util.ArrayList;

public class DanniiMinogue extends RecyclerView.Adapter<DanniiMinogue.MyViewHolder> {

    ArrayList<SusienChong> arrayList;
    ArrayList<SusienChong> arrayListPrev;
    Context mContext;

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        try {
            final SusienChong item = arrayList.get(position);

            holder.imageViewIcon.setImageBitmap(PatrickCox.getBitmapFromAsset(arrayListPrev.get(position).getDirName(), mContext));
            holder.imageViewIcon.setTag(""+position);
            holder.imageViewIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        int po = Integer.parseInt(v.getTag().toString());
                        Bitmap bmpBlend = PatrickCox.getBitmapFromAsset(arrayList.get(position).getDirName(), mContext);
                        NevilleQuist.blendImage = bmpBlend;
                        NevilleQuist.seekbar.setMax(255);
                        NevilleQuist.seekbar.setProgress(255);
                        NevilleQuist.ApplyFilter(NevilleQuist.Value);
                        NevilleQuist.displayAds();
                        NevilleQuist.currentLens = po;
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xpro_sticker_card, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public DanniiMinogue(ArrayList<SusienChong> arrayList, Context mcContext) {
        this.arrayList = arrayList;
        this.mContext = mcContext;

        try {
            arrayListPrev = new ArrayList<>();
            AssetManager assetManager = mcContext.getResources().getAssets();

            String files[] = assetManager.list("lighten/prev");
            if (files != null) {
                for (String file : files) {
                    arrayListPrev.add(new SusienChong("lighten/prev/" + file));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imgStickerIcon);

        }
    }
}
