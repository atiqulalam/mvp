package com.mvp;

import com.mvp.interactor.LoginInteractorImpl;
import com.mvp.interactor.presenter.LoginPresenterImpl;
import com.mvp.view.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest extends BaseUnitTest{
    @Mock
    LoginView view;
    @Mock
    LoginInteractorImpl interactor;

    private LoginPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenterImpl(view, interactor);
    }

    @Test
    public void shouldShowErrorMessageWhenUserNameIsEmpty() throws  Exception{
        when(view.getetUserName()).thenReturn("");
        presenter.onLoginClicked();
        verify(view).showUsernameError("Username is empty");
    }


    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws  Exception{
        when(view.getetUserName()).thenReturn("Atiq");
        when(view.getetPassword()).thenReturn("");
        presenter.onLoginClicked();
        verify(view).showPasswordError("password is empty");
    }


    @Test
    public void shouldStartMainActivityWhenUserNameAndPasswordAreCorrect() throws Exception {
        when(view.getetUserName()).thenReturn("Atiq");
        when(view.getetPassword()).thenReturn("Alam");
        when(interactor.login("Atiq","Alam")).thenReturn(true);
        presenter.onLoginClicked();
        verify(view).navigateToHome();
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getLoginView());
    }

}
