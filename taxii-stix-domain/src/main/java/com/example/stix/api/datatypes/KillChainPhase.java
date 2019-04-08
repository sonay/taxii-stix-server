package com.example.stix.api.datatypes;

import com.example.stix.api.StixType;

/*
* Type Name: kill-chain-phase
*
* The kill-chain-phase represents a phase in a kill chain, which describes the various phases an attacker may
* undertake in order to achieve their objectives.
*
* The JSON MTI serialization uses the JSON object type [RFC7159] when representing kill-chain-phase.
* */
public interface KillChainPhase {

    String TYPE = "kill-chain-phase";

    default StixType getType() {
        return StixType.KILL_CHAIN_PHASE;
    }

    /*
    * The name of the kill chain. The value of this property SHOULD be all lowercase (where lowercase is defined by
    * the locality conventions) and SHOULD use hyphens instead of spaces or underscores as word separators.
    *
    * REQUIRED
    * */
    String KILL_CHAIN_NAME_PROPERTY = "kill_chain_name";

    String getKillChainName();


    /*
    * The name of the phase in the kill chain. The value of this property SHOULD be all lowercase (where lowercase
    * is defined by the locality conventions) and SHOULD use hyphens instead of spaces or underscores as word
    * separators.
    *
    * REQUIRED
    * */
    String PHASE_NAME_PROPERTY = "phase_name";

    String getPhaseName();

}
