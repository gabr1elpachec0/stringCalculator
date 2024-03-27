package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

import java.util.ArrayList;

public class NegativeNumbers implements VerificationStrategy {
    private ArrayList<String> negativeNumbers = new ArrayList<>();

    @Override
    public boolean isStrategy(String string) {
        boolean foundNegative = false;

        for (int i = 0; i < string.length() - 1; i += 1) {
            char character = string.charAt(i);
            char nextCharacter = string.charAt(i + 1);

            if (character == '-') {
                negativeNumbers.add(String.valueOf(nextCharacter));
                foundNegative = true;
            }
        }
        return foundNegative;
    }

    @Override
    public String processStrategy(String string) {
        StringBuilder result = new StringBuilder();

        result.append("Negative not allowed : ");

        for (int i = 0; i < negativeNumbers.size(); i += 1) {
            result.append("-" + negativeNumbers.get(i));
            if (i < negativeNumbers.size() - 1) {
                result.append(", ");
            }
        }

        System.out.println(result);
        return result.toString();
    }
}
