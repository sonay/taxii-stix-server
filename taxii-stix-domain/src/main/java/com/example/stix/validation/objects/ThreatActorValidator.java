package com.example.stix.validation.objects;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.objects.ThreatActor;
import com.example.stix.api.vocabularies.*;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.api.objects.ThreatActor.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

/*
*   A STIX object validator specialized for ThreatActor datatypes.
* */
public class ThreatActorValidator extends CommonPropertiesValidator {


    public void validate(ThreatActor actor, ValidationStrategy strategy) {
        super.validate(actor, strategy);

        basicRequiredCheck(NAME_PROPERTY, actor.getName(), strategy);
        basicOptionalCheck(DESCRIPTION_PROPERTY, actor.getDescription(), strategy);
        basicOptionalCheck(ALIASES_PROPERTY, actor.getAliases(), strategy);

        List<String> roles = actor.getRoles();
        if ((roles != null) && basicOptionalCheck(ROLES_PROPERTY, roles, strategy)) {
            for (String role : roles) {
                if (!ThreatActorRoleVocabulary.isStandard(role)) {
                    strategy.onPropertyWarning(ROLES_PROPERTY,
                            ValidationMessages.THREAT_ACTOR_ROLE_VOCABULARY_WARNING);
                }
            }
        }

        // Interestingly goals don't have a defined open-vocabulary
        basicOptionalCheck(GOALS_PROPERTY, actor.getGoals(), strategy);

        String sophistication = actor.getSophistication();
        if ((sophistication != null)
                && basicOptionalCheck(SOPHISTICATION_PROPERTY, sophistication, strategy)) {
            if (!ThreatActorSophisticationVocabulary.isStandard(sophistication)) {
                strategy.onPropertyWarning(SOPHISTICATION_PROPERTY,
                        ValidationMessages.THREAT_ACTOR_SOPHISTICATION_VOCABULARY_WARNING);
            }
        }

        String resourceLevel = actor.getResourceLevel();
        if ((resourceLevel != null)
                && basicOptionalCheck(RESOURCE_LEVEL_PROPERTY, resourceLevel, strategy)) {
            if (!AttackResourceLevelVocabulary.isStandard(resourceLevel)) {
                strategy.onPropertyWarning(RESOURCE_LEVEL_PROPERTY,
                        ValidationMessages.ATTACK_RESOURCE_LEVEL_VOCABULARY_WARNING);
            }
        }

        String primaryMotivation = actor.getPrimaryMotivation();
        if ((primaryMotivation != null)
                && basicOptionalCheck(PRIMARY_MOTIVATION_PROPERTY, primaryMotivation, strategy)) {
            if (!AttackMotivationVocabulary.isStandard(primaryMotivation)) {
                strategy.onPropertyWarning(PRIMARY_MOTIVATION_PROPERTY,
                        ValidationMessages.ATTACK_MOTIVATION_VOCABULARY_WARNING);
            }
        }

        List<String> secondaryMotivations = actor.getSecondaryMotivations();
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

        List<String> personalMotivations = actor.getPersonalMotivations();
        if ((personalMotivations != null)
                && basicOptionalCheck(PERSONAL_MOTIVATIONS_PROPERTY, personalMotivations, strategy)) {
            for (String pm : personalMotivations) {
                if (!AttackMotivationVocabulary.isStandard(pm)) {
                    strategy.onPropertyWarning(PERSONAL_MOTIVATIONS_PROPERTY,
                            ValidationMessages.ATTACK_MOTIVATION_VOCABULARY_WARNING);
                    break;
                }
            }
        }
    }

    @Override
    public void validateLabels(CommonProperties actor, ValidationStrategy strategy) {
        List<String> labels = actor.getLabels();
        if (basicRequiredCheck(LABELS_PROPERTY, labels, strategy)) {
            for (String label : labels) {
                if (!ThreatActorLabelVocabulary.isStandard(label)) {
                    strategy.onPropertyWarning(LABELS_PROPERTY,
                            ValidationMessages.THREAT_ACTOR_LABEL_VOCABULARY_WARNING);
                }
            }
        }
    }

}
