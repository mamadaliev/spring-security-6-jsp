package com.company.tm.controller;

import com.company.tm.entity.TaskEntity;
import com.company.tm.entity.UserEntity;
import com.company.tm.repository.UserRepository;
import com.company.tm.service.TaskService;
import com.company.tm.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public String listTasks(Model model, @AuthenticationPrincipal UserDetails user) {
        List<TaskEntity> tasks = taskService.getAllTasks();
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        model.addAttribute("tasks", tasks);
        model.addAttribute("currentUserId", userEntity.getId());
        model.addAttribute("currentUserRole", userEntity.getRole());
        return "task/list";
    }

    @GetMapping("/{id}")
    public String viewTask(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetails user) {
        TaskEntity task = taskService.getTaskById(id);
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        model.addAttribute("task", task);
        model.addAttribute("currentUserId", userEntity.getId());
        model.addAttribute("currentUserRole", userEntity.getRole());
        return "task/view";
    }

    @GetMapping("/create")
    public String createTaskForm() {
        return "task/create";
    }

    @PostMapping("/create")
    public String createTask(@AuthenticationPrincipal UserDetails userDetails,
                             @RequestParam("title") String title,
                             @RequestParam("description") String description) {
        UserEntity user = userService.findByUsername(userDetails.getUsername());
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setUser(user);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        TaskEntity task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @RequestParam String title, @RequestParam String description) {
        TaskEntity task = taskService.getTaskById(id);
        task.setTitle(title);
        task.setDescription(description);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
