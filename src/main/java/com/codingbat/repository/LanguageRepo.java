package com.codingbat.repository;

import com.codingbat.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo  extends JpaRepository<Language,Long> {
}
