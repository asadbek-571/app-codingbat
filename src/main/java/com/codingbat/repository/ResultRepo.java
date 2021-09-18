package com.codingbat.repository;

import com.codingbat.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result,Long> {
}
