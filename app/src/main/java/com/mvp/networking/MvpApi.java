package com.mvp.networking;

import com.mvp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Atiq on 21/9/16.
 */

public interface MvpApi {
    @POST("api/v1/users/login")
    Call<User> login(@Body User user);

}
