package com.codingbat.service.impl;

import com.codingbat.entity.Result;
import com.codingbat.entity.Task;
import com.codingbat.entity.User;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.model.ResultDto;
import com.codingbat.repository.ResultRepo;
import com.codingbat.repository.TaskRepo;
import com.codingbat.repository.UserRepo;
import com.codingbat.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final ResultRepo resultRepo;
    private final UserRepo userRepo;
    private final TaskRepo taskRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(ResultDto dto) {

        Optional<User> user = userRepo.findById(dto.getUserId());
        if (user.isEmpty())
            return ResponseEntity.status(404).body("User not found");

        Optional<Task> task = taskRepo.findById(dto.getTaskId());
        if (task.isEmpty())
            return ResponseEntity.status(404).body("Task not found");

        resultRepo.save(mapstructMapper.toResult(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, ResultDto dto) {

        Optional<Result> optionalResult = resultRepo.findById(id);
        if (optionalResult.isEmpty())
            return ResponseEntity.status(404).body("Result not found");

        Optional<User> user = userRepo.findById(dto.getUserId());
        if (user.isEmpty())
            return ResponseEntity.status(404).body("User not found");

        Optional<Task> task = taskRepo.findById(dto.getTaskId());
        if (task.isEmpty())
            return ResponseEntity.status(404).body("Task not found");

        resultRepo.save(mapstructMapper.toResult(optionalResult.get(), dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Result> optionalResult = resultRepo.findById(id);
        if (optionalResult.isEmpty())
            return ResponseEntity.status(404).body("Result not found");
        return ResponseEntity.status(200).body(optionalResult.get());
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(resultRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Result> optionalResult = resultRepo.findById(id);
        if (optionalResult.isEmpty())
            return ResponseEntity.status(404).body("Result not found");
        resultRepo.delete(optionalResult.get());
        return ResponseEntity.status(200).body(mapstructMapper.toResultDto(optionalResult.get()));
    }
}
