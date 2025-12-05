package com.miranda.desing_patterns.strategy.tax_strategy;

import org.springframework.stereotype.Component;

@Component
public class SelicInterestStrategy implements InterestStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.1475;
    }
}
