package com.example.stix.validation;

public interface ValidationStrategy {

    void onConstraintError(String error);

    void onPropertyError(String property, String error);

    void onConstraintWarning(String warning);

    void onPropertyWarning(String property, String warning);

}
