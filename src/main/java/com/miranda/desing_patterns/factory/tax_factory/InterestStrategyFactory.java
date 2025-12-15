package com.miranda.desing_patterns.factory.tax_factory;

import com.miranda.desing_patterns.enums.InterestType;
import com.miranda.desing_patterns.strategy.tax_strategy.InterestStrategy;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class InterestStrategyFactory {

    private final Map<InterestType, InterestStrategy> strategies;

    public InterestStrategyFactory(Map<InterestType, InterestStrategy> strategies) {
        this.strategies = strategies;
    }

    public InterestStrategy getStrategy(InterestType type) {
        InterestStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia inválida: " + type);
        }
        return strategy;
    }
}
