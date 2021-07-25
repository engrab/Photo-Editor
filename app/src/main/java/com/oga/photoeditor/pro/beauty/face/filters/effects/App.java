package com.oga.photoeditor.pro.beauty.face.filters.effects;

import android.content.Context;


import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.oga.photoeditor.pro.beauty.face.filters.effects.ClaudiaChanShaw.LindaBritten;
public class App extends MultiDexApplication {

    private static Context mContext;

    private static App mInstance;
    LindaBritten objDb;

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mContext = getApplicationContext();
//            MultiDex.install(this);
            AudienceNetworkAds.initialize(this);

            //This will make the ad run on the test device, let's say your Android AVD emulator
            if (BuildConfig.DEBUG){
                AdSettings.setTestMode(true);
            }
            mInstance = this;
            objDb = new LindaBritten(getApplicationContext());
            objDb.createDatabase();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
