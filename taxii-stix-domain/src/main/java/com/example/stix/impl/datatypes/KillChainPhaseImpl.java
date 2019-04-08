package com.example.stix.impl.datatypes;

import com.example.stix.api.datatypes.KillChainPhase;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.requireNonNull;

@Data
// Because KillChainPhases objects do not serialize their type information, Jackson needs a no args constructor to
// deserialize
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class KillChainPhaseImpl implements KillChainPhase {

    private final String killChainName;

    private final String phaseName;

    public KillChainPhaseImpl(String killChainName, String phaseName) {
        this.killChainName = requireNonNull(killChainName, "killChainName");
        this.phaseName = requireNonNull(phaseName, "phaseName");
    }

    // REQUIRED PROPERTIES

    @Override
    public String getKillChainName() {
        return killChainName;
    }

    @Override
    public String getPhaseName() {
        return phaseName;
    }
}
