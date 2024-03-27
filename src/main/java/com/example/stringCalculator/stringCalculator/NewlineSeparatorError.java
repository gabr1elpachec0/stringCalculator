package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

public class NewlineSeparatorError implements VerificationStrategy {
    private String newlinePosition = "";
    @Override
    public boolean isStrategy(String string) {
        boolean foundNewlineAsSeparator = false;

        for (int i = 0; i < string.length() - 1; i += 1) {
            char character = string.charAt(i);
            char newlineCharacter = string.charAt(i + 1);

            if (character == ',' && newlineCharacter == '\n') {
                newlinePosition = String.valueOf(i + 1);
                foundNewlineAsSeparator = true;
            }
        }
        return foundNewlineAsSeparator;
    }

    @Override
    public String processStrategy(String string) {
        return "Number expected but ' \n ' found at position " + newlinePosition + ".";
    }
}
