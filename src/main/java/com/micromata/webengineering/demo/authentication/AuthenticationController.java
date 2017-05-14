package com.micromata.webengineering.demo.authentication;

import com.micromata.webengineering.demo.user.User;
import com.micromata.webengineering.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthenticationController {
    public static class UserLogin {
        public String email;
        public String password;
    }

    public static class UserToken {
        public User user;
        public String token;
    }


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UserToken login(@RequestBody UserLogin userLogin) {
        // Test, that retrieval of user works.
        User user = userRepository.login(userLogin.email, userLogin.password);

        UserToken token = new UserToken();
        token.user = user;
        token.token = "<JWT-TOKEN>";

        return token;
    }
}
