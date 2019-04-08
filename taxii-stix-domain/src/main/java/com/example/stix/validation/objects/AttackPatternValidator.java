package com.example.stix.validation.objects;

import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.AttackPattern;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class AttackPatternValidator extends CommonPropertiesValidator {

    public void validate(AttackPattern attackPattern, ValidationStrategy strategy) {
        super.validate(attackPattern, strategy);
        // TODO: external references CAPEC-ID specification
        basicRequiredCheck(AttackPattern.NAME_PROPERTY, attackPattern.getName(), strategy);
        basicOptionalCheck(AttackPattern.DESCRIPTION_PROPERTY, attackPattern.getDescription(), strategy);

        List<KillChainPhase> phases = attackPattern.getKillChainPhases();
        if ((phases != null) && basicOptionalCheck(AttackPattern.KILL_CHAIN_PHASES_PROPERTY, phases, strategy)) {
            for (KillChainPhase phase : phases) {
                // TODO
            }
        }
    }
}
