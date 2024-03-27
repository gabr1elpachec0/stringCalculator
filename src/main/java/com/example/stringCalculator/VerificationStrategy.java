package com.example.stringCalculator;

public interface VerificationStrategy {
    boolean isStrategy(String string);
    String processStrategy(String string);
}
