package com.codingbat.service;

import com.codingbat.model.TaskDto;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity<?> add(TaskDto dto);

    ResponseEntity<?> edit(Long id, TaskDto dto);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> delete(Long id);
}
