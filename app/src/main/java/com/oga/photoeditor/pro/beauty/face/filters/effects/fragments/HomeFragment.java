package com.oga.photoeditor.pro.beauty.face.filters.effects.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.MyWorkActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.activities.MainActivity;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ClaudiaChanShaw.LindaBritten;
import com.oga.photoeditor.pro.beauty.face.filters.effects.R;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

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
