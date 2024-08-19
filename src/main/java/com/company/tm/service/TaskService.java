package com.company.tm.service;

import com.company.tm.entity.TaskEntity;
import com.company.tm.entity.UserEntity;
import com.company.tm.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> getAllTasksByUsername(String username) {
        return taskRepository.findAllByUserUsername(username);
    }

    public long getTasksCountByUsername(String username) {
        return taskRepository.countAllByUserUsername(username);
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<TaskEntity> getTasksByUser(UserEntity user) {
        return taskRepository.findByUser(user);
    }

    public void saveTask(TaskEntity task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
