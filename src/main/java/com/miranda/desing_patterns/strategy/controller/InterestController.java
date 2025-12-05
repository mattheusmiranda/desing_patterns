package com.miranda.desing_patterns.strategy.controller;

import com.miranda.desing_patterns.strategy.service.InterestCalculatorService;
import com.miranda.desing_patterns.strategy.tax_strategy.InterestType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interest")
public class InterestController {

    private final InterestCalculatorService service;

    public InterestController(InterestCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public double calculate(
            @RequestParam InterestType type,
            @RequestParam double amount
    ) {
        return service.calculate(type, amount);
    }
}
