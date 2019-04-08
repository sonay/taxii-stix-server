package com.example.stix.serialization.jackson.relationships;

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
import static com.example.stix.api.relationships.Relationship.*;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({TYPE_PROPERTY, ID_PROPERTY, CREATED_BY_REF_PROPERTY, CREATED_PROPERTY, MODIFIED_PROPERTY,
        REVOKED_PROPERTY, LABELS_PROPERTY, EXTERNAL_REFERENCES_PROPERTY, OBJECT_MARKING_REFS_PROPERTY,
        GRANULAR_MARKINGS_PROPERTY, RELATIONSHIP_TYPE_PROPERTY, DESCRIPTION_PROPERTY, SOURCE_REF_PROPERTY,
        TARGET_REF_PROPERTY})
public abstract class RelationshipImplMixin {

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

    @JsonProperty(RELATIONSHIP_TYPE_PROPERTY) abstract String getRelationshipType();

    @JsonProperty(SOURCE_REF_PROPERTY) abstract Identifier getSourceRef();

    @JsonProperty(TARGET_REF_PROPERTY) abstract Identifier getTargetRef();

    @JsonProperty(DESCRIPTION_PROPERTY) abstract String getDescription();

    @JsonCreator
    RelationshipImplMixin(@JsonProperty(value = TYPE_PROPERTY, required = true) StixType type,
            @JsonProperty(value = CREATED_PROPERTY, required = true) ZonedDateTime created,
            @JsonProperty(value = ID_PROPERTY, required = true) Identifier id,
            @JsonProperty(value = MODIFIED_PROPERTY, required = true) ZonedDateTime modified,
            @JsonProperty(REVOKED_PROPERTY) Boolean revoked,
            @JsonProperty(CREATED_BY_REF_PROPERTY) Identifier createdByRef,
            @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) List<ExternalReference> externalReferences,
            @JsonProperty(GRANULAR_MARKINGS_PROPERTY) List<GranularMarking> granularMarkingRefs,
            @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) List<Identifier> objectMarkingRefs,
            @JsonProperty(LABELS_PROPERTY) List<String> labels,
            @JsonProperty(value = SOURCE_REF_PROPERTY, required = true) Identifier sourceRef,
            @JsonProperty(value = RELATIONSHIP_TYPE_PROPERTY, required = true) String relationshipType,
            @JsonProperty(value = TARGET_REF_PROPERTY, required = true) Identifier targetRef,
            @JsonProperty(DESCRIPTION_PROPERTY) String description) {
        throw new AssertionError("DO NOT INSTANTIATE, THIS IS AN INTERFACE");
    }


}
