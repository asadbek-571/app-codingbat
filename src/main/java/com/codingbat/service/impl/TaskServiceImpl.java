package com.codingbat.service.impl;

import com.codingbat.entity.Language;
import com.codingbat.entity.Task;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.model.TaskDto;
import com.codingbat.repository.LanguageRepo;
import com.codingbat.repository.TaskRepo;
import com.codingbat.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {


    private final LanguageRepo languageRepo;
    private final TaskRepo taskRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(TaskDto dto) {
        Optional<Language> optionalLanguage = languageRepo.findById(dto.getLanguageId());
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        taskRepo.save(mapstructMapper.toTask(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, TaskDto dto) {

        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity.status(404).body("Task not found");
        Optional<Language> optionalLanguage = languageRepo.findById(dto.getLanguageId());
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        taskRepo.save(mapstructMapper.toTask(optionalTask.get(), dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity.status(404).body("Task not found");
        return ResponseEntity.status(200).body(optionalTask.get());
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(taskRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity.status(404).body("Task not found");
        taskRepo.delete(optionalTask.get());
        return ResponseEntity.status(200).body(mapstructMapper.toTaskDto(optionalTask.get()));
    }
}
