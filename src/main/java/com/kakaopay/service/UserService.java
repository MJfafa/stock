package com.kakaopay.service;

import com.kakaopay.exception.UserNotFoundException;
import com.kakaopay.model.User;
import com.kakaopay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This service provides operations related to users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a user by their ID.
     * @param userId the user ID
     * @return the user
     * @throws UserNotFoundException if the user is not found
     */
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    /**
     * Creates a new user.
     * @param user the user to create
     * @return the created user
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes a user by their ID.
     * @param userId the user ID
     */
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
