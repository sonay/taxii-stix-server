package com.example.stix.impl.relationships;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.relationships.Relationship;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class RelationshipImpl extends AbstractStixRelationshipObject implements Relationship {

    private final String relationshipType;

    private final Identifier sourceRef;

    private final Identifier targetRef;

    private final String description;

    public RelationshipImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                            Identifier sourceRef, String relationshipType, Identifier targetRef) {
        this(type, created, id, modified,
             sourceRef, relationshipType, targetRef, null);
    }

    public RelationshipImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                            Identifier sourceRef, String relationshipType, Identifier targetRef, String description) {
        this(type, created, id, modified, null, null, null, null, null, null,
             sourceRef, relationshipType, targetRef, description);
    }

    public RelationshipImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                            Identifier createdByRef, List<ExternalReference> externalReferences,
                            List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                            List<String> labels, Identifier sourceRef, String relationshipType, Identifier targetRef,
                            String description) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
              objectMarkingRefs, labels);

        this.relationshipType = relationshipType;
        this.sourceRef = sourceRef;
        this.targetRef = targetRef;
        this.description = description;
    }

    // REQUIRED PROPERTIES

    @Override
    public StixType getType() {
        return Relationship.super.getType();
    }

    @Override
    public String getRelationshipType() {
        return relationshipType;
    }

    @Override
    public Identifier getSourceRef() {
        return sourceRef;
    }

    @Override
    public Identifier getTargetRef() {
        return targetRef;
    }

    // OPTIONAL PROPERTIES

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
