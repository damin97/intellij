package com.damin._sb0423.pizza.controller;

import com.damin._sb0423.pizza.entity.Pizza;
import com.damin._sb0423.pizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    @GetMapping("/pizza")
    public String form() {
        return "pizza/form";
    }

    @PostMapping("/pizza")
    public String result(Pizza pizza) {
        log.info("{}", pizza);
        pizzaRepository.save(pizza);
        return "pizza/result";
    }

    @GetMapping("/orderList")
    public String orderList(Model model) {
        model.addAttribute("list", pizzaRepository.findAllByCompleteFalse());
        return "pizza/orderList";
    }

    @GetMapping("/orderList2")
    public String orderList2(Model model) {
        model.addAttribute("list", pizzaRepository.findAllByCompleteFalse());
        return "pizza/orderList2";
    }

    @GetMapping("/orderList3")
    public String orderList3(Model model) {
        model.addAttribute("list", pizzaRepository.findAllByCompleteFalse());
        return "pizza/orderList3";
    }

    @GetMapping("/complete")
    public String complete(Long id) {
        log.info("피자 번호 {}", id);
        Pizza pizza = pizzaRepository.findById(id).orElseThrow();
        pizza.setComplete(true);
        pizzaRepository.save(pizza);
        return "redirect:/orderList2";
    }
}
