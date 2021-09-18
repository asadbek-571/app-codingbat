package com.codingbat.service;

import com.codingbat.model.ResultDto;
import org.springframework.http.ResponseEntity;

public interface ResultService {
    ResponseEntity<?> add(ResultDto dto);

    ResponseEntity<?> edit(Long id, ResultDto dto);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> delete(Long id);
}
