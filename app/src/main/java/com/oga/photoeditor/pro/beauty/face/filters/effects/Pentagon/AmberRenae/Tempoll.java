package com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.AmberRenae;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.oga.photoeditor.pro.beauty.face.filters.effects.LocalBaseActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.Pentagon.SophiaTolli.AndyTruong;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;

public class Tempoll extends LocalBaseActivity {

    public static AppCompatActivity activity;
    public static Bitmap bmpBlend = null;

    public static void startWithUri(Context context, Uri _uri) {
        Intent intent = new Intent(context, Tempoll.class);
        intent.setData(_uri);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_photoeditor);

        activity = Tempoll.this;

        AndyTruong mainFragment = new AndyTruong();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.Container);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment instanceof AndyTruong) {
            AndyTruong.ManageBackPrace();
        } else {
            super.onBackPressed();
        }
    }

}
