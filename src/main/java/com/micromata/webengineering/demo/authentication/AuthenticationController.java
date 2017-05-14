package com.micromata.webengineering.demo.authentication;

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

        @Override
        public String toString() {
            return "UserLogin{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody UserLogin userLogin) {
        return "<JWT-TOKEN>: " + userLogin;
    }
}
