package com.oga.photoeditor.pro.beauty.face.filters.effects;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.oga.photoeditor.pro.beauty.face.filters.effects.ClaudiaChanShaw.LindaBritten;
public class App extends MultiDexApplication {

    private static Context mContext;

    private static App mInstance;
    LindaBritten objDb;


    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mContext = getApplicationContext();
            MultiDex.install(this);

            mInstance = this;
            objDb = new LindaBritten(getApplicationContext());
            objDb.createDatabase();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
