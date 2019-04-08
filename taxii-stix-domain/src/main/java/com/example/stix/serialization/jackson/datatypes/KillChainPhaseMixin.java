package com.example.stix.serialization.jackson.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static com.example.stix.api.datatypes.KillChainPhase.KILL_CHAIN_NAME_PROPERTY;
import static com.example.stix.api.datatypes.KillChainPhase.PHASE_NAME_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({KILL_CHAIN_NAME_PROPERTY, PHASE_NAME_PROPERTY})
public abstract class KillChainPhaseMixin {

    @JsonProperty(KILL_CHAIN_NAME_PROPERTY) abstract String getKillChainName();

    @JsonProperty(PHASE_NAME_PROPERTY) abstract String getPhaseName();

}
