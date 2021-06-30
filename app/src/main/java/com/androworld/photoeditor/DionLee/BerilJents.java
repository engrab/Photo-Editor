package com.androworld.photoeditor.DionLee;


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

import com.androworld.photoeditor.BuildConfig;
import com.androworld.photoeditor.Cantista.Jentalmenata;
import com.androworld.photoeditor.Cantista.Mantid;
import com.androworld.photoeditor.ClaudiaChanShaw.LindaBritten;
import com.androworld.photoeditor.DovCharney.PatrickCox;
import com.androworld.photoeditor.R;

public class BerilJents extends Fragment implements View.OnClickListener {


    private LindaBritten objdb;
    private ImageView iv_share;
    private ImageView iv_reta;
    private ImageView iv_privecy;

    public BerilJents() {
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
                    Mantid.Cat = 3;
                    Mantid.counter = 1;
                    Mantid.pickFromGallery();
                    break;
                case R.id.LL_PhotoEditor:
                    Mantid.Cat = 2;
                    Mantid.counter = 1;
                    Mantid.pickFromGallery();
                    break;

                case R.id.LL_LightLikes:
                    Mantid.Cat = 4;
                    Mantid.counter = 1;
                    Mantid.pickFromGallery();
                    break;

                case R.id.LL_PhotoFrame:
                    RebeccaJudd previewFragment = new RebeccaJudd();
                    fragmentManager.beginTransaction().replace(R.id.MainContainer, previewFragment).addToBackStack(null).commit();
                    break;

                case R.id.iv_share:

                    try {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                        String shareMessage = "\nLet me recommend you this application\n\n";
                        shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(shareIntent, "choose one"));
                    } catch (Exception e) {
                    }
                    break;

                case R.id.iv_reta:

                    PatrickCox.ratingDialog(getActivity());
                    break;

                case R.id.iv_privecy:

                    StormKeating privacyPolicyFragment = new StormKeating();
                    fragmentManager.beginTransaction().replace(R.id.MainContainer, privacyPolicyFragment).addToBackStack(null).commit();
                    break;

                case R.id.LL_Mywork:
                    startActivity(new Intent(getActivity(), Jentalmenata.class));
                    getActivity().finish();
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main1, container, false);

        try {
            FindControls(rootView);

            objdb = new LindaBritten(getActivity());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    private void FindControls(View view) {
        RL_Main = (RelativeLayout) view.findViewById(R.id.RL_Main);
        Ll_Menu = (LinearLayout) view.findViewById(R.id.Ll_Menu);

        LL_PhotoEditor = (ImageView) view.findViewById(R.id.LL_PhotoEditor);
        ll_Mywork = (ImageView) view.findViewById(R.id.LL_Mywork);
        LL_LightLikes = (ImageView) view.findViewById(R.id.LL_LightLikes);
        ll_PhotoFrame = (ImageView) view.findViewById(R.id.LL_PhotoFrame);
        LL_PhotoFilter = (ImageView) view.findViewById(R.id.LL_PhotoFilter);

        iv_share = (ImageView) view.findViewById(R.id.iv_share);
        iv_reta = (ImageView) view.findViewById(R.id.iv_reta);
        iv_privecy = (ImageView) view.findViewById(R.id.iv_privecy);


        iv_share.setOnClickListener(this);
        iv_reta.setOnClickListener(this);
        iv_privecy.setOnClickListener(this);

        ll_Mywork.setOnClickListener(this);
        LL_LightLikes.setOnClickListener(this);
        ll_PhotoFrame.setOnClickListener(this);
        LL_PhotoEditor.setOnClickListener(this);
        LL_PhotoFilter.setOnClickListener(this);

    }


}
