package com.example.stix.validation;

import java.util.List;
import java.util.Objects;
/*
* Basic checks for STIX object properties
* */
public class ValidationHelper {

    public static boolean basicRequiredCheck(String name, Object value, ValidationStrategy strategy) {
        if (value == null) {
            strategy.onPropertyError(name, ValidationMessages.REQUIRED_ERROR);
            return false;
        }
        return true;
    }

    public static boolean basicRequiredCheck(String name, String value, ValidationStrategy strategy) {
        if (value == null || isBlank(value)) {
            strategy.onPropertyError(name, ValidationMessages.EMPTY_VALUE_ERROR);
            return false;
        }
        return true;
    }

    public static boolean basicRequiredCheck(String name, List<?> value, ValidationStrategy strategy) {
        if (value == null || value.isEmpty()) {
            strategy.onPropertyError(name, ValidationMessages.EMPTY_LIST_ERROR);
            return false;
        }
        return true;
    }

    public static boolean basicOptionalCheck(String name, String value, ValidationStrategy strategy) {
        if (value != null && isBlank(value)) {
            strategy.onPropertyError(name, ValidationMessages.EMPTY_VALUE_ERROR);
            return false;
        }
        return true;
    }

    public static boolean basicOptionalCheck(String name, List<?> value, ValidationStrategy strategy) {
        if (value != null && value.isEmpty()) {
            strategy.onPropertyError(name, ValidationMessages.EMPTY_LIST_ERROR);
            return false;
        }
        return true;
    }

    // TODO: add basic dictionary check


    private static boolean isBlank(String s) {
        Objects.requireNonNull(s);
        for (int i = 0; i < s.length(); i++) {
            // TODO: there should be a better check
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
