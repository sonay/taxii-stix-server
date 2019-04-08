package com.example.stix.serialization.jackson.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.Indicator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.ZonedDateTime;
import java.util.List;

import static com.example.stix.api.CommonProperties.*;
import static com.example.stix.api.objects.Indicator.*;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({TYPE_PROPERTY, ID_PROPERTY, CREATED_BY_REF_PROPERTY, CREATED_PROPERTY, MODIFIED_PROPERTY,
        REVOKED_PROPERTY, Indicator.LABELS_PROPERTY, EXTERNAL_REFERENCES_PROPERTY, OBJECT_MARKING_REFS_PROPERTY,
        GRANULAR_MARKINGS_PROPERTY, NAME_PROPERTY, DESCRIPTION_PROPERTY, PATTERN_PROPERTY, VALID_FROM_PROPERTY,
        VALID_UNTIL_PROPERTY, KILL_CHAIN_PHASES_PROPERTY})
public abstract class IndicatorImplMixin {

    // COMMON PROPERTIES

    @JsonProperty(TYPE_PROPERTY) abstract StixType getType();

    @JsonProperty(ID_PROPERTY) abstract Identifier getId();

    @JsonProperty(CREATED_BY_REF_PROPERTY) abstract Identifier getCreatedByRef();

    @JsonProperty(CREATED_PROPERTY) abstract ZonedDateTime getCreated();

    @JsonProperty(MODIFIED_PROPERTY) abstract ZonedDateTime getModified();

    @JsonProperty(REVOKED_PROPERTY) abstract Boolean getRevoked();

    @JsonProperty(Indicator.LABELS_PROPERTY) abstract List<String> getLabels();

    @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) abstract List<ExternalReference> getExternalReferences();

    @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) abstract List<Identifier> getObjectMarkingRefs();

    @JsonProperty(GRANULAR_MARKINGS_PROPERTY) abstract List<GranularMarking> getGranularMarkings();

    // OBJECT PROPERTIES

    @JsonProperty(PATTERN_PROPERTY) abstract String getPattern();

    @JsonProperty(VALID_FROM_PROPERTY) abstract ZonedDateTime getValidFrom();

    @JsonProperty(NAME_PROPERTY) abstract String getName();

    @JsonProperty(DESCRIPTION_PROPERTY) abstract String getDescription();

    @JsonProperty(VALID_UNTIL_PROPERTY) abstract ZonedDateTime getValidUntil();

    @JsonProperty(KILL_CHAIN_PHASES_PROPERTY) abstract List<KillChainPhase> getKillChainPhases();

    @JsonCreator
    IndicatorImplMixin(@JsonProperty(value = TYPE_PROPERTY, required = true) StixType type,
            @JsonProperty(value = CREATED_PROPERTY, required = true) ZonedDateTime created,
            @JsonProperty(value = ID_PROPERTY, required = true) Identifier id,
            @JsonProperty(value = MODIFIED_PROPERTY, required = true) ZonedDateTime modified,
            @JsonProperty(REVOKED_PROPERTY) Boolean revoked,
            @JsonProperty(CREATED_BY_REF_PROPERTY) Identifier createdByRef,
            @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) List<ExternalReference> externalReferences,
            @JsonProperty(GRANULAR_MARKINGS_PROPERTY) List<GranularMarking> granularMarkingRefs,
            @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) List<Identifier> objectMarkingRefs,
            @JsonProperty(value = Indicator.LABELS_PROPERTY, required = true) List<String> labels,
            @JsonProperty(value = PATTERN_PROPERTY, required = true) String pattern,
            @JsonProperty(value = VALID_FROM_PROPERTY, required = true) ZonedDateTime validFrom,
            @JsonProperty(NAME_PROPERTY) String name,
            @JsonProperty(VALID_UNTIL_PROPERTY)ZonedDateTime validUntil,
            @JsonProperty(DESCRIPTION_PROPERTY) String description,
            @JsonProperty(KILL_CHAIN_PHASES_PROPERTY) List<KillChainPhase> killChainPhases) {
        throw new AssertionError("DO NOT INSTANTIATE, THIS IS AN INTERFACE");
    }


}

