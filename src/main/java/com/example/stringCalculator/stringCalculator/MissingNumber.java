package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

public class MissingNumber implements VerificationStrategy {
    @Override
    public boolean isStrategy(String string) {
        return (String.valueOf(string.charAt(string.length() - 1)).equals(","));
    }

    @Override
    public String processStrategy(String string) {
        return "Number expected but EOF found.";
    }
}
