package com.example.stringCalculator.stringCalculator;

import com.example.stringCalculator.VerificationStrategy;

public class NewlineSeparatorSuccess implements VerificationStrategy {
    private int sum = 0;
    @Override
    public boolean isStrategy(String string) {
        boolean foundNewlineAsSeparator = false;

        for (int i = 0; i < string.length() - 1; i += 1) {
            char character = string.charAt(i);
            char newlineCharacter = string.charAt(i + 1);
            char lastCharacter = string.charAt(string.length() - 1);

            if (character != ',' && newlineCharacter == '\n') {
                if ((i + 2) < string.length()) {
                    char numberAfterNewlineSeparator = string.charAt(i + 2);
                    sum += Character.getNumericValue(character) + Character.getNumericValue(numberAfterNewlineSeparator);
                }
                sum += Character.getNumericValue(lastCharacter);
                foundNewlineAsSeparator = true;
            }
        }
        return foundNewlineAsSeparator;
    }

    @Override
    public String processStrategy(String string) {
        return String.valueOf(sum);
    }
}
