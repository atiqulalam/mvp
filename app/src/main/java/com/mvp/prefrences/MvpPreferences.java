package com.mvp.prefrences;

import android.content.SharedPreferences;

/**
 * Created by Atiq on 21/9/16.
 */

public class MvpPreferences {

    public static final String TAG = MvpPreferences.class.getName();

    private final SharedPreferences mPref;

    public MvpPreferences(SharedPreferences pref) {
        mPref = pref;
    }

    /**
     *
     * @param key
     * @param value
     */
    protected void setString(String key, String value) {
        if(key != null && value != null ) {
            try {
                if(mPref != null) {
                    SharedPreferences.Editor editor = mPref.edit();
                    editor.putString(key, value);
                    editor.apply();
                }
            } catch (Exception e) {
               // LogManager.forceE(TAG, "Unable to set " + key + "= " + value + "in shared preference", e);
            }
        }
    }


    /**
     *
     * @param key
     * @param value
     */
    protected void setLong(String key, long value) {
        if(key != null) {
            try {
                if(mPref != null) {
                    SharedPreferences.Editor editor = mPref.edit();
                    editor.putLong(key, value);
                    editor.apply();
                }
            } catch (Exception e) {
                //LogManager.forceE(TAG, "Unable to set " + key + "= " + value + "in shared preference", e);
            }
        }
    }

    /**
     *
     * @param key
     * @param value
     */
    protected void setInt(String key, int value) {
        if(key != null) {
            try {
                if(mPref != null) {
                    SharedPreferences.Editor editor = mPref.edit();
                    editor.putInt(key, value);
                    editor.apply();
                }
            } catch (Exception e) {
               // LogManager.forceE(TAG, "Unable to set " + key + "= " + value + "in shared preference", e);
            }
        }
    }

    /**
     *
     * @param key
     * @param value
     */
    protected void setDouble(String key, double value) {
        if(key != null) {
            try {
                if(mPref != null) {
                    SharedPreferences.Editor editor = mPref.edit();
                    editor.putFloat(key, (float) value);
                    editor.apply();
                }
            } catch (Exception e) {
              //  LogManager.forceE(TAG, "Unable to set " + key + "= " + value + "in shared preference", e);
            }
        }
    }

    /**
     *
     * @param key
     * @param value
     */
    protected void setBoolean(String key, boolean value) {
        if(key != null) {
            try {
                if(mPref != null) {
                    SharedPreferences.Editor editor = mPref.edit();
                    editor.putBoolean(key, value);
                    editor.apply();
                }
            } catch (Exception e) {
               // LogManager.forceE(TAG, "Unable to set " + key + "= " + value + "in shared preference", e);
            }
        }
    }

    /**
     *
     * @param key
     * @param defaultValue
     * @return
     */
    protected int getInt(String key, int defaultValue) {
        if(mPref != null && key != null && mPref.contains(key)) {
            return mPref.getInt(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     *
     * @param key
     * @param defaultValue
     * @return
     */
    protected long getLong(String key, long defaultValue) {
        if(mPref != null && key != null && mPref.contains(key)) {
            return mPref.getLong(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     *
     * @param key
     * @param defaultValue
     * @return
     */
    protected boolean getBoolean(String key, boolean defaultValue) {
        if(mPref != null && key != null && mPref.contains(key)) {
            return mPref.getBoolean(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     *
     * @param key
     * @param defaultValue
     * @return
     */
    protected String getString(String key, String defaultValue) {
        if(mPref != null && key != null && mPref.contains(key)) {
            return mPref.getString(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     *
     * @param key
     * @param defaultValue
     * @return
     */
    protected double getDouble(String key, double defaultValue) {
        if(mPref != null && key != null && mPref.contains(key)) {
            return mPref.getFloat(key, (float) defaultValue);
        }
        return defaultValue;
    }

    /**
     *
     * @param key
     */
    protected void removeString(String key) {
        if(key != null) {
            try {
                if(mPref != null && mPref.contains(key)) {
                    SharedPreferences.Editor editor = mPref.edit();
                    editor.remove(key);
                    editor.apply();
                }
            } catch (Exception e) {
               // LogManager.forceE(TAG, "Unable to remove key" + key, e);
            }
        }
    }

    /**
     * This Method Clear shared preference.
     */
    public void clear() {
        SharedPreferences.Editor editor = mPref.edit();
        editor.clear();
        editor.apply();
    }


}
