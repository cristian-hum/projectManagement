package com.fm.project.management.integration;

import com.fm.project.management.model.User;
import com.fm.project.management.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceIT {

    @Autowired
    UserService userService;

    @Test
    void whenSaveUserWithUniqueEmail_shouldSaveUser() {
        // given
        User user = new User("test@gmail.com", "pass", "John", "Snow");

        // when
        userService.save(user);

        // then
        User actualUser = userService.findByEmail("test@gmail.com");

        assertThat(actualUser.getEmail()).isEqualTo("test@gmail.com");
    }
}
