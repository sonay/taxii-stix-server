package com.example.stix.validation.datamarking;

import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;
import java.util.Objects;

import static com.example.stix.api.datamarking.GranularMarking.MARKING_REF_PROPERTY;
import static com.example.stix.api.datamarking.GranularMarking.SELECTORS_PROPERTY;

public class GranularMarkingValidator {

    private final SelectorValidator selectorValidator;

    GranularMarkingValidator() {
        this(new SelectorValidator());
    }

    public GranularMarkingValidator(SelectorValidator validator) {
        this.selectorValidator = Objects.requireNonNull(validator);
    }


    public void validate(GranularMarking marking, ValidationStrategy strategy) {
        // TODO: what is the identifier constraint???
        Identifier ref = marking.getMarkingRef();
        if (ref == null) {
            strategy.onPropertyError(MARKING_REF_PROPERTY, ValidationMessages.REQUIRED_ERROR);
        }

        List<String> selectors = marking.getSelectors();
        if ((selectors == null) || selectors.isEmpty()) {
            strategy.onPropertyError(SELECTORS_PROPERTY, ValidationMessages.EMPTY_LIST_ERROR);
        } else {
            for (String selector : selectors) {
                selectorValidator.validate(selector, strategy);
            }
        }
    }

}
