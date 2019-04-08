package com.example.stix.impl.relationships;

import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.relationships.StixRelationshipObject;
import com.example.stix.impl.CommonPropertiesImpl;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class AbstractStixRelationshipObject extends CommonPropertiesImpl implements StixRelationshipObject {

    public AbstractStixRelationshipObject(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified) {
        this(type, created, id, modified, false, null, null, null, null, null);
    }

    AbstractStixRelationshipObject(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                                   Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                                   List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                                   List<String> labels) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs, labels);
    }

}
