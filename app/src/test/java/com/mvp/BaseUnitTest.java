package com.mvp;

import com.mvp.model.User;

/**
 * Created by atiq on 23/10/17.
 */

public class BaseUnitTest {

    protected User createMockUser(
            String username, String password) {
        User u = new User(username,password);

        return u;
    }



}
