package com.damin.chap11mvc1.repository;

import com.damin.chap11mvc1.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
