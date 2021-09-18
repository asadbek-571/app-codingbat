package com.codingbat.service;

import com.codingbat.model.UserDto;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> register(UserDto dto);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> edit(Long id, UserDto dto);

    ResponseEntity<?> delete(Long id);
}
