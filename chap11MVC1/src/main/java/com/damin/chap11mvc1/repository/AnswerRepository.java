package com.damin.chap11mvc1.repository;

import com.damin.chap11mvc1.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
}
