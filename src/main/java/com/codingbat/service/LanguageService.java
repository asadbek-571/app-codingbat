package com.codingbat.service;

import com.codingbat.model.LanguageDto;
import org.springframework.http.ResponseEntity;

public interface LanguageService {
    ResponseEntity<?> add(LanguageDto dto);

    ResponseEntity<?> edit(Long id, LanguageDto dto);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> delete(Long id);
}
