package com.damin._sb0402.repository;

import com.damin._sb0402.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyDataRepository extends JpaRepository<MyData, Long> {

    List<MyData> findByIdBetween(Long id1, Long id2); //쿼리 메소드

    @Query("select m from MyData m order by m.id desc ") //쿼리 애노테이션
    List<MyData> findAll2();
}
