package com.example.stix.validation.objects;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.objects.Indicator;
import com.example.stix.api.vocabularies.IndicatorLabelVocabulary;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.api.objects.Indicator.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class IndicatorValidator extends CommonPropertiesValidator {

    public void validate(Indicator indicator, ValidationStrategy strategy) {
        super.validate(indicator, strategy);
        basicRequiredCheck(PATTERN_PROPERTY, indicator.getPattern(), strategy);
        basicRequiredCheck(VALID_FROM_PROPERTY, indicator.getValidFrom(), strategy);
        basicOptionalCheck(NAME_PROPERTY, indicator.getName(), strategy);
        basicOptionalCheck(DESCRIPTION_PROPERTY, indicator.getDescription(), strategy);
        basicOptionalCheck(KILL_CHAIN_PHASES_PROPERTY, indicator.getKillChainPhases(), strategy);
        //TODO: No need to check valid_until, however shouldn't it be later than valid_from???
    }

    @Override
    void validateLabels(CommonProperties indicator, ValidationStrategy strategy) {
        List<String> labels = indicator.getLabels();
        if (basicRequiredCheck(LABELS_PROPERTY, labels, strategy)) {
            for (String label : labels) {
                if (!IndicatorLabelVocabulary.isStandard(label)) {
                    strategy.onPropertyWarning(LABELS_PROPERTY,
                            ValidationMessages.INDICATOR_LABEL_VOCABULARY_WARNING);
                    break;
                }
            }
        }
    }

}
