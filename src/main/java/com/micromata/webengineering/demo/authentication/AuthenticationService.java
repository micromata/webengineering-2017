package com.micromata.webengineering.demo.authentication;

import com.micromata.webengineering.demo.user.User;
import com.micromata.webengineering.demo.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserService userService;

    private String secret = "Severus Snape was a good guy!";

    public static class UserToken {
        public User user;
        public String token;
    }


    public UserToken login(String email, String password) {
        User user = userService.getUser(email, password);
        if (user == null) {
            return null;
        }

        String token = Jwts.builder()
                .setSubject(email)
                .setId(user.getId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        UserToken userToken = new UserToken();
        userToken.user = user;
        userToken.token = token;
        return userToken;
    }

    public Object parseToken(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parse(jwtToken)
                .getBody();
    }
}
