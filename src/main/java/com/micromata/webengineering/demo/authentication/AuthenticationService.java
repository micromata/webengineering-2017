package com.micromata.webengineering.demo.authentication;

import com.micromata.webengineering.demo.user.User;
import com.micromata.webengineering.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    // TODO ML Use userService for clean architecture.
    @Autowired
    private UserRepository repository;

    public static class UserToken {
        public User user;
        public String token;
    }

    public UserToken login(String email, String password) {
        User user = repository.login(email, password);
        if (user == null) {
            return null;
        }

        UserToken token = new UserToken();
        token.user = user;
        token.token = "<JWT-TOKEN>";
        return token;
    }
}
