package org.example;

import java.util.logging.Logger;

public class BracketValidationLogger {
    private static final Logger LOGGER = Logger.getLogger(BracketValidationLogger.class.getName());

    public static void main(String[] args) {
        String value = "({[]})";
        boolean valid = BracketValidationMain.isValid(value);

        LOGGER.info(() -> "String '%s' is valid: %s".formatted(value, valid));
    }
}
