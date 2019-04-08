package com.example.stix.validation.datatypes;

import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

public class ExternalReferenceValidator {

    // TODO: what is a CAPEC ID? how do we check for its constraints? relating to externalReferences
    public void validate(ExternalReference externalReference, ValidationStrategy strategy) {
        if (externalReference.getSourceName() == null) {
            strategy.onPropertyError(ExternalReference.SOURCE_NAME_PROPERTY, ValidationMessages.REQUIRED_ERROR);
        }
        if ((externalReference.getUrl() == null)
                && (externalReference.getDescription() == null)
                && (externalReference.getExternalId() == null)) {
            strategy.onConstraintError(ValidationMessages.EXTERNAL_REFERENCE_MISSING_VALUE_ERROR);
        }
    }

}
