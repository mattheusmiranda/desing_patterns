package com.miranda.desing_patterns.factory.config;

import com.miranda.desing_patterns.enums.InterestType;
import com.miranda.desing_patterns.strategy.tax_strategy.InterestStrategy;
import com.miranda.desing_patterns.strategy.tax_strategy.SelicInterestStrategy;
import com.miranda.desing_patterns.strategy.tax_strategy.ZeroInterestStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

@Configuration
public class InterestStrategyConfig {

    @Bean
    public Map<InterestType, InterestStrategy> strategyMap(
            SelicInterestStrategy selic,
            ZeroInterestStrategy zero
    ) {
        Map<InterestType, InterestStrategy> map = new EnumMap<>(InterestType.class);
        map.put(InterestType.SELIC, selic);
        map.put(InterestType.ZERO, zero);
        return map;
    }
}
