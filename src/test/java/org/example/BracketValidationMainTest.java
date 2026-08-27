package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketValidationMainTest {

    // Valid cases

    @Test
    void nestedAllTypes() {
        assertTrue(BracketValidationMain.isValid("({[]})"));
    }

    @Test
    void sequentialAllTypes() {
        assertTrue(BracketValidationMain.isValid("(){}[]"));
    }

    @Test
    void nestedSameType() {
        assertTrue(BracketValidationMain.isValid("(())"));
    }

    @Test
    void deeplyNestedAllTypes() {
        assertTrue(BracketValidationMain.isValid("[{()}]"));
    }

    @Test
    void mixedNestingAndSequential() {
        assertTrue(BracketValidationMain.isValid("([]{})" ));
    }

    // Invalid cases

    @Test
    void interleaved() {
        assertFalse(BracketValidationMain.isValid("({)}"));
    }

    @Test
    void wrongCloserType() {
        assertFalse(BracketValidationMain.isValid("(]"));
    }

    @Test
    void unclosedOpener() {
        assertFalse(BracketValidationMain.isValid("(()"));
    }

    @Test
    void closerWithNoOpener() {
        assertFalse(BracketValidationMain.isValid(")"));
    }

    @Test
    void nullInput() {
        assertFalse(BracketValidationMain.isValid(null));
    }
}
