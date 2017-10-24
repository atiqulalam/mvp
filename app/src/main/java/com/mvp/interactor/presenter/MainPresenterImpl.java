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

import com.mvp.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;


    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onLogoutClicked() {
        if (mainView != null) {
            mainView.logout();
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }



    public MainView getMainView() {
        return mainView;
    }
}
