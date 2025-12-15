package com.miranda.desing_patterns.factory.response;

import com.miranda.desing_patterns.enums.InterestType;

public class InterestResponse {

    private InterestType type;
    private double originalAmount;
    private double interestValue;
    private double finalValue;

    private InterestResponse(Builder builder) {
        this.type = builder.type;
        this.originalAmount = builder.originalAmount;
        this.interestValue = builder.interestValue;
        this.finalValue = builder.finalValue;
    }

    public static class Builder {
        private InterestType type;
        private double originalAmount;
        private double interestValue;
        private double finalValue;

        public Builder type(InterestType type) {
            this.type = type;
            return this;
        }

        public Builder originalAmount(double value) {
            this.originalAmount = value;
            return this;
        }

        public Builder interestValue(double value) {
            this.interestValue = value;
            return this;
        }

        public Builder finalValue(double value) {
            this.finalValue = value;
            return this;
        }

        public InterestResponse build() {
            return new InterestResponse(this);
        }
    }
}
