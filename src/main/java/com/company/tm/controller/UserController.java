package com.company.tm.controller;

import com.company.tm.entity.UserEntity;
import com.company.tm.service.TaskService;
import com.company.tm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final AuthenticationManager authenticationManager;

    @GetMapping({"/", "/home"})
    public String home(Model model, @AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            model.addAttribute("username", user.getUsername());
        }
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ModelAndView("redirect:/tasks");
        } catch (AuthenticationException ex) {
            return new ModelAndView("redirect:/login?error=true");
        }
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        if (userService.findByUsername(username) != null) {
            return "redirect:/register?error=true";
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("ROLE_USER");
        userService.registerUser(user);
        return "redirect:/users/" + username;
    }

    @GetMapping("/users/{username}")
    public String getUserByUsername(@PathVariable String username, Model model, @AuthenticationPrincipal UserEntity user) {
        UserEntity userEntity = userService.findByUsername(username);
        long taskCount = taskService.getTasksCountByUsername(username);
        model.addAttribute("user", userEntity);
        model.addAttribute("taskCount", taskCount);
        return "user/view";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model, @AuthenticationPrincipal UserEntity user) {
        List<UserEntity> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user/list";
    }
}
