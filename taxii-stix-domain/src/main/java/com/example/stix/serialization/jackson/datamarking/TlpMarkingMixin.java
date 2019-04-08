package com.example.stix.serialization.jackson.datamarking;

import com.example.stix.api.datamarking.TlpMarking;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.example.stix.api.datamarking.TlpMarking.DEFINITION_TYPE;
import static com.example.stix.api.datamarking.TlpMarking.TLP_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
public interface TlpMarkingMixin {

    @JsonProperty(TLP_PROPERTY)
    String getTlp();

    @JsonCreator static TlpMarking getInstance(@JsonProperty(DEFINITION_TYPE) String value) {
        throw new AssertionError("should not happen");
    }

}
