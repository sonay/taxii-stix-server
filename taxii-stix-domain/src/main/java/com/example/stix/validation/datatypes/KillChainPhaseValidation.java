package com.example.stix.validation.datatypes;

import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

public class KillChainPhaseValidation {

    public void validate(KillChainPhase killChainPhase, ValidationStrategy strategy) {
        String phase = killChainPhase.getPhaseName();
        if (phase == null) {
            strategy.onPropertyError(KillChainPhase.PHASE_NAME_PROPERTY, ValidationMessages.REQUIRED_ERROR);
        } else if (hasWhiteSpaceOrLowercase(phase)) {
            strategy.onPropertyWarning(KillChainPhase.PHASE_NAME_PROPERTY, ValidationMessages.KILL_CHAIN_PHASE_NAME_WARNING);
        }

        String chain = killChainPhase.getKillChainName();
        if ((chain == null)) {
            strategy.onPropertyError(KillChainPhase.KILL_CHAIN_NAME_PROPERTY, ValidationMessages.KILL_CHAIN_NAME_WARNING);
        }
    }

    // TODO: add collation. how do we get locale information?
    private static boolean hasWhiteSpaceOrLowercase(String val) {
        boolean hasNonLowercase = false;
        boolean hasWhiteSpace = false;
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            // TODO: use word separator pattern instead, maybe?
            if (Character.isWhitespace(c)) {
                hasWhiteSpace = true;
            } else if (!Character.isLowerCase(c)) {
                hasNonLowercase = true;
            }
        }
        return hasNonLowercase || hasWhiteSpace;
    }

}
