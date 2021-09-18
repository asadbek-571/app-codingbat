package com.codingbat.service.impl;

import com.codingbat.entity.User;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.model.UserDto;
import com.codingbat.repository.UserRepo;
import com.codingbat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> register(UserDto dto) {
        userRepo.save(mapstructMapper.toUser(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, UserDto dto) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.status(404).body("User not found");
        userRepo.save(mapstructMapper.toUser(optionalUser.get(), dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.status(404).body("User not found");
        return ResponseEntity.status(200).body(optionalUser.get());
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(userRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.status(404).body("User not found");
        userRepo.delete(optionalUser.get());
        return ResponseEntity.status(200).body(mapstructMapper.toUserDto(optionalUser.get()));
    }
}
