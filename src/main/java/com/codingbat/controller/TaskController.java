package com.codingbat.controller;

import com.codingbat.entity.Task;
import com.codingbat.model.LanguageDto;
import com.codingbat.model.TaskDto;
import com.codingbat.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/language")
public class TaskController {

    private final TaskService taskService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TaskDto dto) {
        return taskService.add(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody TaskDto dto) {
        return taskService.edit(id, dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return taskService.getById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return taskService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return taskService.delete(id);
    }

}
