package com.company.tm;

import com.company.tm.entity.UserEntity;
import com.company.tm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        if (userService.findByUsername("admin") == null) {
            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setRole("ROLE_ADMIN");
            userService.registerUser(user);
        }
        if (userService.findByUsername("user") == null) {
            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setPassword("user");
            user.setRole("ROLE_USER");
            userService.registerUser(user);
        }
    }
}
