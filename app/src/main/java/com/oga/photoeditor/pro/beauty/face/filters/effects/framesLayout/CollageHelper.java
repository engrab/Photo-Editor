package com.oga.photoeditor.pro.beauty.face.filters.effects.framesLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CollageHelper {
    protected static final String TAG = "CollageHelper";

    public static GalleryFragment getGalleryFragment(FragmentActivity activity) {
        return (GalleryFragment) activity.getSupportFragmentManager().findFragmentByTag("myFragmentTag");
    }

    public static GalleryFragment addGalleryFragment(FragmentActivity activity, int gallery_fragment_container, Object o, boolean showInter, View view) {
        FragmentManager fm = activity.getSupportFragmentManager();
        String str = "myFragmentTag";
        GalleryFragment galleryFragment = (GalleryFragment) fm.findFragmentByTag(str);
        if (galleryFragment == null) {
            galleryFragment = new GalleryFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(gallery_fragment_container, galleryFragment, str);
            ft.commitAllowingStateLoss();
            galleryFragment.setGalleryListener(createGalleryListener(activity, galleryFragment, showInter, view));
            activity.findViewById(gallery_fragment_container).bringToFront();
            return galleryFragment;
        }
        activity.getSupportFragmentManager().beginTransaction().show(galleryFragment).commitAllowingStateLoss();
        return galleryFragment;
    }

    public static GalleryFragment.GalleryListener createGalleryListener(FragmentActivity activity, GalleryFragment galleryFragment, boolean showInter, View view) {
        final View view2 = view;
        final FragmentActivity fragmentActivity = activity;
        final GalleryFragment galleryFragment2 = galleryFragment;
        boolean z = showInter;
        return new GalleryFragment.GalleryListener() {
            @SuppressLint({"WrongConstant"})
            public void onGalleryCancel() {
                View view = view2;
                if (!(view == null || view.getVisibility() == 0)) {
                    view2.setVisibility(0);
                }
                fragmentActivity.getSupportFragmentManager().beginTransaction().hide(galleryFragment2).commitAllowingStateLoss();
            }

            @SuppressLint({"WrongConstant"})
            public void onGalleryOkImageArray(long[] jArr, int[] iArr, boolean x, boolean y, boolean isMirror) {
                Intent localIntent;
                View view = view2;
                if (!(view == null || view.getVisibility() == 0)) {
                    view2.setVisibility(0);
                }
                localIntent = new Intent(fragmentActivity, CollageActivity.class);
                localIntent.putExtra("photo_id_list", jArr);
                localIntent.putExtra("photo_orientation_list", iArr);
                localIntent.putExtra("is_scrap_book", x);
                localIntent.putExtra("is_shape", y);
                fragmentActivity.startActivity(localIntent);
            }

            public void onGalleryOkImageArrayRemoveFragment(long[] jArt, int[] iArr, boolean x, boolean y) {
            }

            public void onGalleryOkSingleImage(long j, int i, boolean x, boolean y) {
            }
        };
    }
}
