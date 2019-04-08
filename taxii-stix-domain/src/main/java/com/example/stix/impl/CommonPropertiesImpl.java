package com.example.stix.impl;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class CommonPropertiesImpl implements CommonProperties {

    private final StixType type;

    private final Identifier id;

    private final ZonedDateTime created;

    private final ZonedDateTime modified;

    private final Identifier createdByRef;

    private final Boolean revoked;

    private final List<ExternalReference> externalReferences;

    private final List<GranularMarking> granularMarkingRefs;

    private final List<Identifier> objectMarkingRefs;

    private final List<String> labels;

    public CommonPropertiesImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified) {
        this(type, created, id, modified, false, null, null, null, null, null);
    }

    public CommonPropertiesImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                                Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                                List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                                List<String> labels) {
        this.type = type;
        this.created = created;
        this.modified = modified;
        this.id = id;
        this.revoked = revoked;
        this.createdByRef = createdByRef;
        this.externalReferences = externalReferences;
        this.granularMarkingRefs = granularMarkingRefs;
        this.objectMarkingRefs = objectMarkingRefs;
        this.labels = labels;
    }

    // REQUIRED PROPERTIES

    @Override
    public StixType getType() {
        return type;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public ZonedDateTime getCreated() {
        return created;
    }

    @Override
    public ZonedDateTime getModified() {
        return modified;
    }

    // OPTIONAL PROPERTIES

    @Override
    public Identifier getCreatedByRef() {
        return createdByRef;
    }

    @Override
    public Boolean getRevoked() {
        return revoked;
    }

    @Override
    public List<String> getLabels() {
        return labels;
    }

    @Override
    public List<ExternalReference> getExternalReferences() {
        return externalReferences;
    }

    @Override
    public List<Identifier> getObjectMarkingRefs() {
        return objectMarkingRefs;
    }

    @Override
    public List<GranularMarking> getGranularMarkings() {
        return granularMarkingRefs;
    }

}
