package com.codingbat.controller;

import com.codingbat.model.UserDto;
import com.codingbat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return userService.getAll();
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto dto) {
        return userService.register(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody UserDto dto) {
        return userService.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return userService.delete(id);
    }

}
