package com.example.stix.validation.objects;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;
import com.example.stix.validation.datamarking.GranularMarkingValidator;
import com.example.stix.validation.datamarking.SelectorValidator;
import com.example.stix.validation.datatypes.ExternalReferenceValidator;
import com.example.stix.validation.datatypes.IdentifierValidator;

import java.time.ZonedDateTime;
import java.util.List;

import static com.example.stix.api.CommonProperties.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;


// TODO: consider making this class abstract and use template pattern
public class CommonPropertiesValidator {

    private final ExternalReferenceValidator exRefValidator;

    private final GranularMarkingValidator granularMarkingValidator;

    private final IdentifierValidator markingRefsValidator;

    public CommonPropertiesValidator() {
        this(new ExternalReferenceValidator(),
                new GranularMarkingValidator(new SelectorValidator()),
                new IdentifierValidator());
    }

    private CommonPropertiesValidator(ExternalReferenceValidator exRefValidator,
                                      GranularMarkingValidator granularMarkingValidator,
                                      IdentifierValidator markingRefsValidator) {
        this.exRefValidator = exRefValidator;
        this.granularMarkingValidator = granularMarkingValidator;
        this.markingRefsValidator = markingRefsValidator;
    }

    public void validate(CommonProperties object, ValidationStrategy strategy) {
        validateRequiredProperties(object, strategy);
        validateOptionalProperties(object, strategy);
        validateConstraints(object, strategy);
    }

    private void validateRequiredProperties(CommonProperties object, ValidationStrategy strategy) {
        validateId(object, strategy);
        validateCreated(object, strategy);
        validateModified(object, strategy);
    }

    private void validateOptionalProperties(CommonProperties object, ValidationStrategy strategy) {
        validateCreatedBy(object, strategy);
        validateLabels(object, strategy);
        validateExternalReferences(object, strategy);
        validateMarkingRefs(object, strategy);
        validateGranularMarkings(object, strategy);
    }

    private void validateCreatedBy(CommonProperties object, ValidationStrategy strategy) {
        Identifier id = object.getCreatedByRef();
        if (id != null && StixType.IDENTITY != id.getType()) {
            strategy.onPropertyError(CREATED_BY_REF_PROPERTY, ValidationMessages.CREATED_BY_NOT_IDENTITY_ERROR);
        }
    }

    private void validateConstraints(CommonProperties object, ValidationStrategy strategy) {
        ZonedDateTime created = object.getCreated();
        ZonedDateTime modified = object.getModified();
        if ((modified != null) && (created != null)) {
            if (modified.isBefore(created)) {
                strategy.onConstraintError(
                        ValidationMessages.MODIFIED_BEFORE_CREATED_ERROR);
            }
        }
    }

    private void validateId(CommonProperties object, ValidationStrategy strategy) {
        Identifier id = object.getId();
        if (id == null) {
            strategy.onPropertyError(ID_PROPERTY, ValidationMessages.REQUIRED_ERROR);
        } else {
            if (!id.getType().equals(object.getType())) {
                strategy.onPropertyError(ID_PROPERTY, ValidationMessages.ID_MISMATCH_ERROR);
            }
            // TODO: identifierDeserializer checks for UUID should find a way to merge
        }
    }

    private void validateCreated(CommonProperties object, ValidationStrategy strategy) {
        ZonedDateTime created = object.getCreated();
        basicRequiredCheck(CREATED_PROPERTY, created, strategy);
    }

    private void validateModified(CommonProperties object, ValidationStrategy strategy) {
        ZonedDateTime modified = object.getModified();
        basicRequiredCheck(MODIFIED_PROPERTY, modified, strategy);
    }

    private void validateGranularMarkings(CommonProperties object, ValidationStrategy strategy) {
        List<GranularMarking> markings = object.getGranularMarkings();
        if ((markings != null) && basicOptionalCheck(GRANULAR_MARKINGS_PROPERTY, markings, strategy)) {
            for (GranularMarking marking : markings) {
                granularMarkingValidator.validate(marking, strategy);
            }
        }
    }

    private void validateMarkingRefs(CommonProperties object, ValidationStrategy strategy) {
        List<Identifier> markingRefs = object.getObjectMarkingRefs();
        if ((markingRefs != null) && basicOptionalCheck(OBJECT_MARKING_REFS_PROPERTY, markingRefs, strategy)) {
            //TODO: identifier checks
        }
    }

    private void validateExternalReferences(CommonProperties object, ValidationStrategy strategy) {
        List<ExternalReference> refs = object.getExternalReferences();
        if ((refs != null) && basicOptionalCheck(EXTERNAL_REFERENCES_PROPERTY, refs, strategy)) {
            for (ExternalReference reference : refs) {
                exRefValidator.validate(reference, strategy);
            }
        }
    }

    void validateLabels(CommonProperties object, ValidationStrategy strategy) {
        basicOptionalCheck(LABELS_PROPERTY, object.getLabels(), strategy);
    }

}
