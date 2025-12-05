package com.miranda.desing_patterns.strategy.service;

import com.miranda.desing_patterns.strategy.tax_strategy.InterestStrategy;
import com.miranda.desing_patterns.strategy.tax_strategy.InterestType;
import com.miranda.desing_patterns.strategy.tax_strategy.SelicInterestStrategy;
import com.miranda.desing_patterns.strategy.tax_strategy.ZeroInterestStrategy;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class InterestCalculatorService {

    private final Map<InterestType, InterestStrategy> strategies = new EnumMap<>(InterestType.class);

    public InterestCalculatorService(List<InterestStrategy> strategiesList) {
        for (InterestStrategy s : strategiesList) {
            if (s instanceof SelicInterestStrategy) {
                strategies.put(InterestType.SELIC, s);
            } else if (s instanceof ZeroInterestStrategy) {
                strategies.put(InterestType.ZERO, s);
            }
        }
    }

    public double calculate(InterestType type, double amount) {
        InterestStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia inválida: " + type);
        }
        return strategy.calculate(amount);
    }
}
