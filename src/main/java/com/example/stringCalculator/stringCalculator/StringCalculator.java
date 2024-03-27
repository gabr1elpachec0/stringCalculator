package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

import java.util.List;

public class StringCalculator {
    private final List<VerificationStrategy> strategies;

    public StringCalculator(List<VerificationStrategy> strategies) {
        this.strategies = strategies;
    }

    public String add(String string) {
        for (VerificationStrategy strategy : strategies) {
            if (strategy.isStrategy(string)) {
                return strategy.processStrategy(string);
            }
        }
        return null;
    }
}
