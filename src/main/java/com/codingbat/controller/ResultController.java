package com.codingbat.controller;

import com.codingbat.model.ResultDto;
import com.codingbat.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/result")
public class ResultController {

    private final ResultService resultService;




    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ResultDto dto) {
        return resultService.add(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody ResultDto dto) {
        return resultService.edit(id, dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return resultService.getById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return resultService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return resultService.delete(id);
    }

}
