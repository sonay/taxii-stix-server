package com.example.stix.validation;

public class ThrowOnValidationError implements ValidationStrategy {

    @Override
    public void onConstraintError(String error) {
        throw new InvalidStixObjectException();
    }

    @Override
    public void onPropertyError(String property, String error) {

        throw new InvalidStixObjectException();
    }

    @Override
    public void onConstraintWarning(String warning) {
        // Do nothing
    }

    @Override
    public void onPropertyWarning(String property, String warning) {
        // Do nothing
    }

}
