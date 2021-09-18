package com.codingbat.service.impl;

import com.codingbat.entity.Language;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.model.LanguageDto;
import com.codingbat.repository.LanguageRepo;
import com.codingbat.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepo languageRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(LanguageDto dto) {
        languageRepo.save(mapstructMapper.toLanguage(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, LanguageDto dto) {

        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        languageRepo.save(mapstructMapper.toLanguage(optionalLanguage.get(), dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        return ResponseEntity.status(200).body(optionalLanguage.get());
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(languageRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        languageRepo.delete(optionalLanguage.get());
        return ResponseEntity.status(200).body(mapstructMapper.toLanguageDto(optionalLanguage.get()));
    }
}
