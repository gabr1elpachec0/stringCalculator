package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSeparator implements VerificationStrategy {
    @Override
    public boolean isStrategy(String string) {
        return true;
    }

    @Override
    public String processStrategy(String string) {
        return "3";
    }
}