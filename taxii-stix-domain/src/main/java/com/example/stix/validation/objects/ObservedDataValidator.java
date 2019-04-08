package com.example.stix.validation.objects;

import com.example.stix.api.objects.ObservedData;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import static com.example.stix.api.objects.ObservedData.*;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class ObservedDataValidator extends CommonPropertiesValidator {

    public void validate(ObservedData observedData, ValidationStrategy strategy) {
        super.validate(observedData, strategy);
        basicRequiredCheck(FIRST_OBSERVED_PROPERTY, observedData.getFirstObserved(), strategy);
        basicRequiredCheck(LAST_OBSERVED_PROPERTY, observedData.getLastObserved(), strategy);
        basicRequiredCheck(OBJECTS_PROPERTY, observedData.getObjects(), strategy);
        int numberObserved = observedData.getNumberObserved();
        if ((numberObserved < MIN_OBSERVED) || (numberObserved > MAX_OBSERVED)) {
            strategy.onPropertyError(NUMBER_OBSERVED_PROPERTY, ValidationMessages.INVALID_NUMBER_OBSERVED_ERROR);
        }
    }

}
