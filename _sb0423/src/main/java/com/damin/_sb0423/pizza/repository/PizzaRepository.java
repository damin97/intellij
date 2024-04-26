package com.damin._sb0423.pizza.repository;

import com.damin._sb0423.pizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByCompleteFalse(); //select * from pizza where complete = 0 랑 같은 의미
}
