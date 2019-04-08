package com.example.stix.serialization.jackson.datamarking;

import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datamarking.MarkingObject;
import com.example.stix.api.datamarking.TlpMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.impl.datamarking.StatementMarkingObjectImpl;
import com.fasterxml.jackson.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

import static com.example.stix.api.datamarking.MarkingDefinition.*;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({TYPE_PROPERTY, ID_PROPERTY, CREATED_BY_REF_PROPERTY, CREATED_PROPERTY, DEFINITION_TYPE_PROPERTY,
        DEFINITION_PROPERTY})
public abstract class MarkingDefinitionImplMixin {

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = MarkingObject.TYPE_PROPERTY,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY

    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = StatementMarkingObjectImpl.class, name= StatementMarkingObjectImpl.DEFINITION_TYPE),
            @JsonSubTypes.Type(value = TlpMarking.class, name = TlpMarking.DEFINITION_TYPE)

    })
    @JsonProperty(DEFINITION_PROPERTY) abstract MarkingObject getDefinition();

    @JsonProperty(ID_PROPERTY) abstract Identifier getId();

    @JsonProperty(TYPE_PROPERTY) abstract String getType();

    @JsonProperty(DEFINITION_TYPE_PROPERTY) abstract String getDefinitionType();

    @JsonProperty(CREATED_PROPERTY) abstract ZonedDateTime getCreated();

    @JsonProperty(CREATED_BY_REF_PROPERTY) abstract Identifier getCreatedByRef();

    @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) abstract List<ExternalReference> getExternalReferences();

    @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) abstract List<Identifier> getObjectMarkingRefs();

    @JsonProperty(GRANULAR_MARKINGS_PROPERTY) abstract List<GranularMarking> getGranularMarkings();

    @JsonCreator
    MarkingDefinitionImplMixin(@JsonProperty(TYPE_PROPERTY) StixType type,
                               @JsonProperty(ID_PROPERTY) Identifier id,
                               @JsonProperty(DEFINITION_TYPE_PROPERTY) String definitionType,
                               @JsonProperty(DEFINITION_PROPERTY) MarkingObject definition,
                               @JsonProperty(CREATED_PROPERTY) ZonedDateTime created,
                               @JsonProperty(CREATED_BY_REF_PROPERTY) Identifier createdByRef,
                               @JsonProperty(EXTERNAL_REFERENCES_PROPERTY) List<ExternalReference> externalReferences,
                               @JsonProperty(OBJECT_MARKING_REFS_PROPERTY) List<Identifier> objectMarkingRefs,
                               @JsonProperty(GRANULAR_MARKINGS_PROPERTY) List<GranularMarking> granularMarkings) {}


}
