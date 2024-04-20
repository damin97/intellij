package com.damin.chap11mvc1.repository;

import com.damin.chap11mvc1.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}