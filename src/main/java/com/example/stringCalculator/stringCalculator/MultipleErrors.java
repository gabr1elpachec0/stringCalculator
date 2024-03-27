package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

import java.util.ArrayList;

public class MultipleErrors implements VerificationStrategy {
    private ArrayList<String> negativeNumbers = new ArrayList<>();
    private String commaPosition = "";

    @Override
    public boolean isStrategy(String string) {
        boolean foundNegative = false;
        boolean foundExtraComma = false;

        for (int i = 0; i < string.length() - 1; i += 1) {
            char character = string.charAt(i);
            char nextCharacter = string.charAt(i + 1);

            if (character == '-') {
                negativeNumbers.add(String.valueOf(nextCharacter));
                foundNegative = true;
            }
            if (character == ',' && nextCharacter == ',') {
                commaPosition = String.valueOf(i + 1);
                foundExtraComma = true;
            }
        }
        if (foundNegative && foundExtraComma) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String processStrategy(String string) {
        StringBuilder result = new StringBuilder();

        result.append("Negative not allowed : ");

        for (int i = 0; i < negativeNumbers.size(); i+= 1) {
            result.append("-" + negativeNumbers.get(i));
            if (i < negativeNumbers.size() - 1) {
                result.append(", ");
            }
        }

        result.append("\nNumber expected but found ',' at position " + commaPosition);

        System.out.println(result);
        return result.toString();
    }
}
