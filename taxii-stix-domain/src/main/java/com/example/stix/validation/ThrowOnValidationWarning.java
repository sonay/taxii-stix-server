package com.example.stix.validation;

public class ThrowOnValidationWarning extends ThrowOnValidationError {

    @Override
    public void onConstraintWarning(String warning) {
        throw new InvalidStixObjectException();
    }

    @Override
    public void onPropertyWarning(String property, String warning) {
        throw new InvalidStixObjectException();
    }

}
