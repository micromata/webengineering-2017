package com.micromata.webengineering.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Service for all user-related functional operations.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    /**
     * Retrieve the currently active user or null, if no user is logged in.
     *
     * @return the current user.
     */
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    /**
     * Retrieve a user with the given email and password.
     *
     * @param email    email
     * @param password password
     * @return the user or null if none could be found
     */
    public User getUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
