package com.miranda.desing_patterns.factory.controller;

import com.miranda.desing_patterns.enums.InterestType;
import com.miranda.desing_patterns.factory.response.InterestResponse;
import com.miranda.desing_patterns.factory.service.InterestCalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interest")
public class InterestController {

    private final InterestCalculatorService service;

    public InterestController(InterestCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public InterestResponse calculate(
            @RequestParam InterestType type,
            @RequestParam double amount
    ) {
        return service.calculate(type, amount);
    }
}
