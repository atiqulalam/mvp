/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.mvp.interactor.presenter;

import android.text.TextUtils;
import com.mvp.interactor.LoginInteractor;
import com.mvp.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter/*, LoginInteractor.OnLoginFinishedListener*/ {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void onLoginClicked() {
        if (loginView != null) {
            loginView.showProgress();
        }

    String username=loginView.getUserName();
    String password=loginView.getPassword();
        boolean isLogged;

        if (TextUtils.isEmpty(username)){
            loginView.showUsernameError("Username is empty");
            loginView.hideProgress();
            return;
        }else
        if (username.length()<4){
            loginView.showUsernameError("Username should be 4 or more character");
            loginView.hideProgress();
            return;
        }else if (username.contains(" ")){
            loginView.showUsernameError("Username contains space");
            loginView.hideProgress();
            return;
        }else
        if (TextUtils.isEmpty(password)){
            loginView.showPasswordError("password is empty");
            loginView.hideProgress();
            return;
        }else
        if (password.length()<4){
            loginView.showPasswordError("password should be 4 or more character");
            loginView.hideProgress();
            return;
        }else if (password.contains(" ")){
            loginView.showPasswordError("password contains space");
            loginView.hideProgress();
            return;
        }else{
            isLogged=loginInteractor.login(username, password);
            if (isLogged){
                if (loginView != null) {
                    loginView.hideProgress();
                    loginView.navigateToHome();
                }
            }else {
                if (loginView != null) {
                    loginView.hideProgress();
                    loginView.loginFail();
                }
            }
        }

    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onResume() {

    }

   /* @Override
    public void onUsernameError(String error) {
        if (loginView != null) {
            loginView.showUsernameError(error);
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError(String error) {
        if (loginView != null) {
            loginView.showPasswordError(error);
            loginView.hideProgress();
        }
    }

    @Override
    public void onLoginSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void onLoginFail() {
        if (loginView != null) {
            loginView.loginFail();
        }
    }*/


    public LoginView getLoginView() {
        return loginView;
    }


}
