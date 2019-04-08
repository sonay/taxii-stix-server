package com.example.stix.validation.objects;

import com.example.stix.api.objects.IntrusionSet;
import com.example.stix.api.vocabularies.AttackMotivationVocabulary;
import com.example.stix.api.vocabularies.AttackResourceLevelVocabulary;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.api.objects.IntrusionSet.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class IntrusionSetValidator extends CommonPropertiesValidator {

    public void validate(IntrusionSet intrusionSet, ValidationStrategy strategy) {
        super.validate(intrusionSet, strategy);

        basicRequiredCheck(NAME_PROPERTY, intrusionSet.getName(), strategy);

        basicOptionalCheck(DESCRIPTION_PROPERTY, intrusionSet.getDescription(), strategy);
        basicOptionalCheck(ALIASES_PROPERTY, intrusionSet.getAliases(), strategy);
        basicOptionalCheck(GOALS_PROPERTY, intrusionSet.getGoals(), strategy);
        // TODO: no need to check first_seen??

        String resourceLevel = intrusionSet.getResourceLevel();
        if ((resourceLevel != null) && basicOptionalCheck(RESOURCE_LEVEL_PROPERTY, resourceLevel, strategy)) {
            if (!AttackResourceLevelVocabulary.isStandard(resourceLevel)) {
                strategy.onPropertyWarning(RESOURCE_LEVEL_PROPERTY,
                        ValidationMessages.ATTACK_RESOURCE_LEVEL_VOCABULARY_WARNING);
            }
        }

        String primaryMotivation = intrusionSet.getPrimaryMotivation();
        if ((primaryMotivation != null)
                && basicOptionalCheck(PRIMARY_MOTIVATION_PROPERTY, primaryMotivation, strategy)) {
            if (!AttackMotivationVocabulary.isStandard(primaryMotivation)) {
                strategy.onPropertyWarning(PRIMARY_MOTIVATION_PROPERTY,
                        ValidationMessages.ATTACK_MOTIVATION_VOCABULARY_WARNING);
            }
        }


        List<String> secondaryMotivations = intrusionSet.getSecondaryMotivations();
        if ((secondaryMotivations != null)
                && basicOptionalCheck(SECONDARY_MOTIVATIONS_PROPERTY, secondaryMotivations, strategy)) {
            for (String sm : secondaryMotivations) {
                if (!AttackMotivationVocabulary.isStandard(sm)) {
                    strategy.onPropertyWarning(SECONDARY_MOTIVATIONS_PROPERTY,
                            ValidationMessages.ATTACK_MOTIVATION_VOCABULARY_WARNING);
                    break;
                }
            }
        }
    }

}
