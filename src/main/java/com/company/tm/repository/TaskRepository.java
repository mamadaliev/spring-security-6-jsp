package com.company.tm.repository;

import com.company.tm.entity.TaskEntity;
import com.company.tm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByUser(UserEntity user);

    List<TaskEntity> findAllByUserUsername(String username);

    long countAllByUserUsername(String username);
}
