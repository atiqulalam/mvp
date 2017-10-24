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

package com.mvp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.R;
import com.mvp.interactor.LoginInteractorImpl;
import com.mvp.interactor.presenter.LoginPresenter;
import com.mvp.interactor.presenter.LoginPresenterImpl;
import com.mvp.prefrences.MvpPreferencesManager;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin=(Button) findViewById(R.id.button);
        btnLogin.setOnClickListener(this);

        if (MvpPreferencesManager.getInstance().isLogin()){
            navigateToHome();
        }

        presenter = new LoginPresenterImpl(this,new LoginInteractorImpl());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsernameError(String error) {
        Snackbar.make(password,error,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError(String error) {
        Snackbar.make(password,error,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Snackbar.make(password,"User Login Successfully !",Snackbar.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void loginFail() {
        Snackbar.make(password,getString(R.string.login_fail),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public String getetUserName() {
        return username.getText().toString().trim();
    }

    @Override
    public String getetPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {
        presenter.onLoginClicked();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
