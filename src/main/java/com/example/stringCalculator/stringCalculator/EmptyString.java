package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

public class EmptyString implements VerificationStrategy {
    @Override
    public boolean isStrategy(String string) {
        return string.isEmpty();
    }

    @Override
    public String processStrategy(String string) {
        return "0";
    }
}
