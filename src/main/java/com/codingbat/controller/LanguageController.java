package com.codingbat.controller;

import com.codingbat.model.LanguageDto;
import com.codingbat.model.ResultDto;
import com.codingbat.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/language")
public class LanguageController {

    private final LanguageService languageService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LanguageDto dto) {
        return languageService.add(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody LanguageDto dto) {
        return languageService.edit(id, dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return languageService.getById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return languageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return languageService.delete(id);
    }

}
