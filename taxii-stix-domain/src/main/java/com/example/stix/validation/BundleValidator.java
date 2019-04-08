package com.example.stix.validation;

import com.example.stix.api.Bundle;
import com.example.stix.api.BundleObject;

import java.util.List;

import static com.example.stix.api.Bundle.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class BundleValidator {


    // This method only validates the Bundle object itself, to validate objects in its object properties
    // call their specific validators.
    public void validate(Bundle bundle, ValidationStrategy strategy) {
        String spec = bundle.getSpecVersion();
        if (basicRequiredCheck(SPEC_VERSION_PROPERTY, spec, strategy)) {
            if (!SPEC_VERSION.equals(spec)) {
                strategy.onPropertyError(SPEC_VERSION_PROPERTY, ValidationMessages.BUNDLE_SPEC_VERSION_ERROR);
            }
        }
        List<BundleObject> objects = bundle.getObjects();
        if ((objects != null) && basicOptionalCheck(OBJECTS_PROPERTY, objects, strategy)) {
            BundleObjectValidationVisitor visitor = new BundleObjectValidationVisitor(strategy);
            for (BundleObject object : bundle.getObjects()) {
                object.accept(visitor);
            }
        }

    }

}
