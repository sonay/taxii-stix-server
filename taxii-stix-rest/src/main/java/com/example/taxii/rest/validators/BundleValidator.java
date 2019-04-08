package com.example.taxii.rest.validators;

import com.example.stix.api.Bundle;
import com.example.stix.validation.ThrowOnValidationError;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BundleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Bundle.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bundle bundle = (Bundle) target;
        new com.example.stix.validation.BundleValidator().validate(bundle, new ThrowOnValidationError());
    }
}
