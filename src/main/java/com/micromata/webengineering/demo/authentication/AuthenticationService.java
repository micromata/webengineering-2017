package com.micromata.webengineering.demo.authentication;

import com.micromata.webengineering.demo.user.User;
import com.micromata.webengineering.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserService userService;

    public static class UserToken {
        public User user;
        public String token;
    }

    public UserToken login(String email, String password) {
        User user = userService.getUser(email, password);
        if (user == null) {
            return null;
        }

        UserToken token = new UserToken();
        token.user = user;
        token.token = "<JWT-TOKEN>";
        return token;
    }
}
