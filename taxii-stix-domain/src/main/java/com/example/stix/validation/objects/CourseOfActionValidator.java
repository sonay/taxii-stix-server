package com.example.stix.validation.objects;

import com.example.stix.api.objects.CourseOfAction;
import com.example.stix.validation.ValidationStrategy;

import static com.example.stix.api.objects.CourseOfAction.DESCRIPTION_PROPERTY;
import static com.example.stix.api.objects.CourseOfAction.NAME_PROPERTY;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class CourseOfActionValidator extends CommonPropertiesValidator {

    public void validate(CourseOfAction action, ValidationStrategy strategy) {
        super.validate(action, strategy);
        basicRequiredCheck(NAME_PROPERTY, action.getName(), strategy);
        basicOptionalCheck(DESCRIPTION_PROPERTY, action.getDescription(), strategy);
    }

}
