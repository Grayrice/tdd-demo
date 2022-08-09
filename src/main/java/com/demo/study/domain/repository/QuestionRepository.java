package com.demo.study.domain.repository;

import com.demo.study.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
