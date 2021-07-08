package com.oga.photoeditor.pro.beauty.face.filters.effects.fragments;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.MyWorkActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.MainActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ClaudiaChanShaw.LindaBritten;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;
import com.oga.photoeditor.pro.beauty.face.filters.effects.dialoge.RateDialog;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private LindaBritten objdb;
    private ImageView iv_share;
    private ImageView iv_reta;
    private ImageView iv_privecy;

    public HomeFragment() {
    }

    RelativeLayout RL_Main;
    LinearLayout Ll_Menu;
    ImageView LL_PhotoEditor, LL_LightLikes, ll_PhotoFrame, ll_Mywork, LL_PhotoFilter;


    public static int Counter = 0;

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        try {


            switch (v.getId()) {
                case R.id.LL_PhotoFilter:
                    MainActivity.Cat = 3;
                    MainActivity.counter = 1;
                    MainActivity.pickFromGallery();
                    break;
                case R.id.LL_PhotoEditor:
                    MainActivity.Cat = 2;
                    MainActivity.counter = 1;
                    MainActivity.pickFromGallery();
                    break;

                case R.id.LL_LightLikes:
                    MainActivity.Cat = 4;
                    MainActivity.counter = 1;
                    MainActivity.pickFromGallery();
                    break;

                case R.id.LL_PhotoFrame:
                    PhotoFrameFragment previewFragment = new PhotoFrameFragment();
                    fragmentManager.beginTransaction().replace(R.id.MainContainer, previewFragment).addToBackStack(null).commit();
                    break;

//                case R.id.iv_share:
//
//                    try {
//                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                        shareIntent.setType("text/plain");
//                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
//                        String shareMessage = "\nLet me recommend you this application\n\n";
//                        shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
//                        startActivity(Intent.createChooser(shareIntent, "choose one"));
//                    } catch (Exception e) {
//                    }
//                    break;
//
//                case R.id.iv_reta:
//
//                    PatrickCox.ratingDialog(getActivity());
//                    break;
//
//                case R.id.iv_privecy:
//
//                    StormKeating privacyPolicyFragment = new StormKeating();
//                    fragmentManager.beginTransaction().replace(R.id.MainContainer, privacyPolicyFragment).addToBackStack(null).commit();
//                    break;

                case R.id.LL_Mywork:
                    startActivity(new Intent(getActivity(), MyWorkActivity.class));
                    getActivity().finish();
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void popupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.action_feedback) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{getResources().getString(R.string.email_feedback)});
                    intent.putExtra("android.intent.extra.SUBJECT", "MegaShot Feedback: ");
                    intent.putExtra("android.intent.extra.TEXT", "");
                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent, getString(R.string.choose_email) + " :"));
                } else if (itemId == R.id.action_privacy_policy) {
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://sites.google.com/view/gpsofflineapps/home")));
                    } catch (Exception e) {
                    }
                } else if (itemId == R.id.action_rate_us) {
                    new RateDialog(getActivity(), false).show();
                } else if (itemId == R.id.action_more_app) {
                    Log.d("qq", "moreApp");
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:" + getString(R.string.developerId))));
                    } catch (ActivityNotFoundException e2) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/developer?id=" + getString(R.string.developerId))));
                    }
                } else if (itemId == R.id.action_share_friend) {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
                    intent2.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=" + getActivity().getPackageName());
                    startActivity(Intent.createChooser(intent2, "Choose"));
                }
                return false;
            }
        });
        popupMenu.show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        rootView.findViewById(R.id.image_view_about).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                popupMenu(view);
            }
        });
        try {
            FindControls(rootView);

            objdb = new LindaBritten(getActivity());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    private void FindControls(View view) {
        RL_Main = view.findViewById(R.id.RL_Main);
        Ll_Menu = view.findViewById(R.id.Ll_Menu);

        LL_PhotoEditor = view.findViewById(R.id.LL_PhotoEditor);
        ll_Mywork = view.findViewById(R.id.LL_Mywork);
        LL_LightLikes = view.findViewById(R.id.LL_LightLikes);
        ll_PhotoFrame = view.findViewById(R.id.LL_PhotoFrame);
        LL_PhotoFilter = view.findViewById(R.id.LL_PhotoFilter);





        ll_Mywork.setOnClickListener(this);
        LL_LightLikes.setOnClickListener(this);
        ll_PhotoFrame.setOnClickListener(this);
        LL_PhotoEditor.setOnClickListener(this);
        LL_PhotoFilter.setOnClickListener(this);

    }


}
