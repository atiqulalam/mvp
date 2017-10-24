package com.mvp.interactor;

import android.os.Handler;
import android.text.TextUtils;

import com.mvp.MvpApplication;
import com.mvp.model.User;
import com.mvp.networking.ConnectionUtil;
import com.mvp.networking.MvpApi;
import com.mvp.networking.MvpResponse;
import com.mvp.prefrences.MvpPreferencesManager;

import java.net.HttpURLConnection;

public class LoginInteractor {

    public boolean login(final String username, final String password) {
        boolean isSuccess=false ;
        // Mock login. I'm creating a handler to delay the answer a couple of seconds

        final User user=new User(username,password);


        if (username.equalsIgnoreCase("Atiq") && password.equalsIgnoreCase("Alam")){
            MvpPreferencesManager.getInstance().setLogin(true);
            isSuccess =true;
        }else {
            isSuccess =false;
        }

        /*
            webservice call for login user
         */
        /*new Handler().post(new Runnable() {
            @Override
            public void run() {
                MvpApi mvpApi = MvpApplication.getInstance().getMvpApi();
                MvpResponse mvpResponse= ConnectionUtil.execute(mvpApi.login(user));


                if (mvpResponse.getResponseCode()== HttpURLConnection.HTTP_OK){
                    isSuccess =true;
                }else{
                    isSuccess =false;
                }
            }
        });*/

        return isSuccess;
    }



}
