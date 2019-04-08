package com.example.stix.impl.datamarking;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datamarking.MarkingDefinition;
import com.example.stix.api.datamarking.MarkingObject;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class MarkingDefinitionImpl implements MarkingDefinition {

    private final StixType type;

    private final Identifier id;

    // TODO: should we use createdByRef to check for this definition's vocabulary?
    private final String definitionType;

    private final MarkingObject definition;

    private final ZonedDateTime created;

    private final Identifier createdByRef;

    private final List<ExternalReference> externalReferences;

    private final List<Identifier> objectMarkingRefs;

    private final List<GranularMarking> granularMarkings;

    public MarkingDefinitionImpl(StixType type, Identifier id, String definitionType, MarkingObject definition,
                                 ZonedDateTime created, Identifier createdByRef,
                                 List<ExternalReference> externalReferences, List<Identifier> objectMarkingRefs,
                                 List<GranularMarking> granularMarkings) {
        this.type = type;
        this.id = requireNonNull(id);
        this.definitionType = requireNonNull(definitionType);
        this.definition = requireNonNull(definition);
        this.created = requireNonNull(created);

        this.createdByRef = createdByRef;
        this.externalReferences = (externalReferences != null) ? externalReferences : emptyList();
        this.objectMarkingRefs = (objectMarkingRefs != null) ? objectMarkingRefs : emptyList();
        this.granularMarkings = (granularMarkings != null) ? granularMarkings : emptyList();

    }

    // REQUIRED PROPERTIES

    @Override
    public final StixType getType() {
        return type;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public String getDefinitionType() {
        return definitionType;
    }

    @Override
    public MarkingObject getDefinition() {
        return definition;
    }

    @Override
    public ZonedDateTime getCreated() {
        return created;
    }

    // OPTIONAL PROPERTIES

    @Override
    public Identifier getCreatedByRef() {
        return createdByRef;
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
        return granularMarkings;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
