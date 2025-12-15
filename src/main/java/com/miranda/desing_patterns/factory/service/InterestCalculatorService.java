package com.miranda.desing_patterns.factory.service;

import com.miranda.desing_patterns.enums.InterestType;
import com.miranda.desing_patterns.factory.response.InterestResponse;
import com.miranda.desing_patterns.factory.tax_factory.InterestStrategyFactory;
import com.miranda.desing_patterns.strategy.tax_strategy.InterestStrategy;
import org.springframework.stereotype.Service;

@Service
public class InterestCalculatorService {

    private final InterestStrategyFactory factory;

    public InterestCalculatorService(InterestStrategyFactory factory) {
        this.factory = factory;
    }

    public InterestResponse calculate(InterestType type, double amount) {

        InterestStrategy strategy = factory.getStrategy(type);

        double interest = strategy.calculate(amount);

        return new InterestResponse.Builder()
                .type(type)
                .originalAmount(amount)
                .interestValue(interest)
                .finalValue(amount + interest)
                .build();
    }
}
