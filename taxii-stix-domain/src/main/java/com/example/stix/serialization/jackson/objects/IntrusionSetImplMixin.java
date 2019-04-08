package com.example.stix.serialization.jackson.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.ZonedDateTime;
import java.util.List;

import static com.example.stix.api.CommonProperties.*;
import static com.example.stix.api.objects.IntrusionSet.*;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({TYPE_PROPERTY, ID_PROPERTY, CREATED_BY_REF_PROPERTY, CREATED_PROPERTY, MODIFIED_PROPERTY,
        REVOKED_PROPERTY, LABELS_PROPERTY, EXTERNAL_REFERENCES_PROPERTY, OBJECT_MARKING_REFS_PROPERTY,
        GRANULAR_MARKINGS_PROPERTY, NAME_PROPERTY, DESCRIPTION_PROPERTY, ALIASES_PROPERTY, FIRST_SEEN_PROPERTY,
        LAST_SEEN_PROPERTY, GOALS_PROPERTY, RESOURCE_LEVEL_PROPERTY, PRIMARY_MOTIVATION_PROPERTY,
        SECONDARY_MOTIVATIONS_PROPERTY})
public abstract class IntrusionSetImplMixin {

    // COMMON PROPERTIES

    @JsonProperty(TYPE_PROPERTY) abstract StixType getType();

    @JsonProperty(ID_PROPERTY) abstract Identifier getId();

    @JsonProperty(CREATED_BY_REF_PROPERTY) abstract Identifier getCreatedByRef();

    @JsonProperty(CREATED_PROPERTY) abstract ZonedDateTime getCreated();

    @JsonProperty(MODIFIED_PROPERTY) abstract ZonedDateTime getModified();

    @JsonProperty(REVOKED_PROPERTY) abstract Boolean getRevoked();

    @JsonProperty(LABELS_PROPERTY) abstract List<String> getLabels();

    @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) abstract List<ExternalReference> getExternalReferences();

    @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) abstract List<Identifier> getObjectMarkingRefs();

    @JsonProperty(GRANULAR_MARKINGS_PROPERTY) abstract List<GranularMarking> getGranularMarkings();

    // OBJECT PROPERTIES

    @JsonProperty(NAME_PROPERTY) abstract String getName();

    @JsonProperty(DESCRIPTION_PROPERTY) abstract String getDescription();

    @JsonProperty(ALIASES_PROPERTY) abstract List<String> getAliases();

    @JsonProperty(FIRST_SEEN_PROPERTY) abstract ZonedDateTime getFirstSeen();

    @JsonProperty(LAST_SEEN_PROPERTY) abstract ZonedDateTime getLastSeen();

    @JsonProperty(GOALS_PROPERTY) abstract List<String> getGoals();

    @JsonProperty(RESOURCE_LEVEL_PROPERTY) abstract String getResourceLevel();

    @JsonProperty(PRIMARY_MOTIVATION_PROPERTY) abstract String getPrimaryMotivation();

    @JsonProperty(SECONDARY_MOTIVATIONS_PROPERTY) abstract List<String> getSecondaryMotivations();

    @JsonCreator
    IntrusionSetImplMixin(@JsonProperty(value = TYPE_PROPERTY, required = true) StixType type,
            @JsonProperty(value = CREATED_PROPERTY, required = true) ZonedDateTime created,
            @JsonProperty(value = ID_PROPERTY, required = true) Identifier id,
            @JsonProperty(value = MODIFIED_PROPERTY, required = true) ZonedDateTime modified,
            @JsonProperty(REVOKED_PROPERTY) Boolean revoked,
            @JsonProperty(CREATED_BY_REF_PROPERTY) Identifier createdByRef,
            @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) List<ExternalReference> externalReferences,
            @JsonProperty(GRANULAR_MARKINGS_PROPERTY) List<GranularMarking> granularMarkingRefs,
            @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) List<Identifier> objectMarkingRefs,
            @JsonProperty(LABELS_PROPERTY) List<String> labels,
            @JsonProperty(value = NAME_PROPERTY, required = true) String name,
            @JsonProperty(ALIASES_PROPERTY) List<String> aliases,
            @JsonProperty(DESCRIPTION_PROPERTY) String description,
            @JsonProperty(FIRST_SEEN_PROPERTY) ZonedDateTime firstSeen,
            @JsonProperty(GOALS_PROPERTY) List<String> goals,
            @JsonProperty(LAST_SEEN_PROPERTY) ZonedDateTime lastSeen,
            @JsonProperty(PRIMARY_MOTIVATION_PROPERTY) String primaryMotivation,
            @JsonProperty(SECONDARY_MOTIVATIONS_PROPERTY) List<String> secondaryMotivations,
            @JsonProperty(RESOURCE_LEVEL_PROPERTY) String resourceLevel) {
        throw new AssertionError("DO NOT INSTANTIATE, THIS IS AN INTERFACE");
    }


}
