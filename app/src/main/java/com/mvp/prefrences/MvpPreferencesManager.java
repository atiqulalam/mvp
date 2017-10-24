package com.mvp.prefrences;

import com.mvp.MvpApplication;

import java.util.UUID;

/**
 * Created by Atiq on 21/9/16.
 */

public class MvpPreferencesManager extends MvpPreferences {


    public final static String TAG = MvpPreferencesManager.class.getSimpleName();

    private static MvpPreferencesManager mInstance;

    private static final String SHARED_PREF_NAME = "mvp_pref";
    private static final int PRIVATE_MODE = 0;
    private String lastVideoThumbnail;

    private interface Keys{
        String LOGIN = "login";
        String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";
    }

    private MvpPreferencesManager() {
        super(MvpApplication.getInstance().
                getSharedPreferences(SHARED_PREF_NAME, PRIVATE_MODE));
    }

    public static MvpPreferencesManager getInstance() {
        if(mInstance == null ) {
            synchronized (MvpPreferencesManager.class) {
                if(mInstance == null ) {
                    mInstance = new MvpPreferencesManager();
                }
            }
        }
        return mInstance;
    }


    public void setLogin(boolean login){
        setBoolean(Keys.LOGIN , login);
    }
    public boolean isLogin(){
        return getBoolean(Keys.LOGIN , false);
    }

    public synchronized String getUniqueId() {
        String uniqueID = getString(Keys.PREF_UNIQUE_ID, null);
        if (uniqueID == null) {
            uniqueID = UUID.randomUUID().toString();
            setString(Keys.PREF_UNIQUE_ID , uniqueID);
        }
        return uniqueID;
    }

}
