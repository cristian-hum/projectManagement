package com.fm.project.management.service;

import com.fm.project.management.exceptions.ResourceAlreadyExistsException;
import com.fm.project.management.model.User;
import com.fm.project.management.repository.RoleRepository;
import com.fm.project.management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        log.info("save user {}", user);

        String email = user.getEmail();
        userRepository.findByEmail(email).map((existingUser) -> {
            log.error("The user with the " + email + "email already exists in the db");
            throw new ResourceAlreadyExistsException("The user with the " + email + "email already exists in the db");
        }).orElse(userRepository.save(user));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}
