package com.mvp;


import android.app.Application;

import com.mvp.networking.MvpApi;
import com.mvp.prefrences.MvpPreferencesManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Atiq on 5/9/16.
 */

public class MvpApplication extends Application {

    public static final String TAG = MvpApplication.class.getName();


    private static MvpApplication mInstance;


    private MvpApi mvpApi;
    private OkHttpClient client;
    public MvpApplication() {
        mInstance = this;
    }

    public static MvpApplication getInstance() {
        if(mInstance == null) {
            mInstance = new MvpApplication();
        }
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        createClient();
        initRetrofit();
    }


    private void initRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.app_server))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        mvpApi = retrofit.create(MvpApi.class);

    }


    /***
     *
     * Define the interceptor, add authentication headers
     *
     */

    public void createClient(){
        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("User-Agent", getUserAgent()).build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        this.client = builder.build();
    }

        public MvpApi getMvpApi(){
            return mvpApi;
        }
    /**
     * This method return user agent.
     * @return
     */
    public String getUserAgent() {
        return "Mozilla/5.0 (X11; mandroid) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.91  Safari/537.36" +
                MvpPreferencesManager.getInstance().getUniqueId();
    }
}
