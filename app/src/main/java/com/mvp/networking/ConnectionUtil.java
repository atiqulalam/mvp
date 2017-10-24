package com.mvp.networking;

import android.util.Log;

import com.mvp.prefrences.MvpPreferencesManager;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Atiq on 21/9/16.
 */

public class ConnectionUtil {


    private static final String TAG = ConnectionUtil.class.getName();

    public static MvpResponse execute(Call call) {
        try {
            Response response = call.execute();
            Log.d(TAG, "Api request , request url : " + response.raw().request().url());
            Log.d(TAG, "Api request , response code : " + response.code());
            if (response.code()== HttpURLConnection.HTTP_UNAUTHORIZED){
                MvpPreferencesManager.getInstance().clear();
                //EventBus.getDefault().post(new EventObject(EventCenter.tokenExpire,0));
            }
            return new MvpResponse(response.code(), response.body(),response.errorBody(), response.headers());

        } catch (IOException e) {
            Log.d(TAG , "Error in execute api request");
        } catch (Exception ex){
            Log.d(TAG, "Error in execute api" + ex.getMessage());
        }
        return null;

    }


}
