package com.micromata.webengineering.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
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
        // Temporary fix.
        return userRepository.findByEmail("mlesniak@micromata.de");
    }
}
