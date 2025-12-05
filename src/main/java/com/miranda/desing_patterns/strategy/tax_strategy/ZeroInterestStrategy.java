package com.miranda.desing_patterns.strategy.tax_strategy;

import org.springframework.stereotype.Component;

@Component
public class ZeroInterestStrategy implements InterestStrategy {
    @Override
    public double calculate(double amount) {
        return 0;
    }
}
