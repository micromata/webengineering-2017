package com.micromata.webengineering.demo.authentication;

import com.micromata.webengineering.demo.user.User;
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


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UserToken login(@RequestBody UserLogin userLogin) {
        UserToken token = new UserToken();
        token.user = new User();
        token.user.setEmail(userLogin.email);
        token.user.setId(1L);
        token.token = "<JWT-TOKEN>";

        return token;
    }
}
