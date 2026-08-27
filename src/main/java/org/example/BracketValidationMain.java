package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.logging.Logger;

public class BracketValidationMain {
    private static final Logger LOGGER = Logger.getLogger(BracketValidationMain.class.getName());

    private static final Map<Character, Character> CLOSING_TO_OPENING_BRACKETS = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public static void main(String[] args) {
        String value = "({[]})";
        boolean valid = isValid(value);

        LOGGER.info(() -> "String '%s' is valid: %s".formatted(value, valid));
    }

    static boolean isValid(String value) {
        if (value == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char current : value.toCharArray()) {
            if (isOpeningBracket(current)) {
                stack.push(current);
            } else if (isClosingBracket(current)) {
                Character expectedOpeningBracket = CLOSING_TO_OPENING_BRACKETS.get(current);

                if (stack.isEmpty() || !expectedOpeningBracket.equals(stack.pop())) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(char value) {
        return value == '(' || value == '{' || value == '[';
    }

    private static boolean isClosingBracket(char value) {
        return CLOSING_TO_OPENING_BRACKETS.containsKey(value);
    }
}
