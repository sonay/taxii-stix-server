package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.Report;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReportImpl extends AbstractStixDomainObject implements Report {

    private final String name;

    private final ZonedDateTime published;

    private final List<Identifier> objectRefs;

    private final String description;

    public ReportImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, List<String> labels,
                      String name, ZonedDateTime published, List<Identifier> objectRefs) {
        this(type, created, id, modified, labels, name, published, objectRefs, null);
    }

    public ReportImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, List<String> labels,
                      String name, ZonedDateTime published, List<Identifier> objectRefs, String description) {
        this(type, created, id, modified, null, null, null, null, null, labels,
             name, published, objectRefs, description);
    }

    public ReportImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                      Identifier createdByRef, List<ExternalReference> externalReferences,
                      List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                      List<String> labels, String name, ZonedDateTime published, List<Identifier> objectRefs,
                      String description) {

        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
              objectMarkingRefs, labels);
        this.name = name;
        this.published = published;
        this.objectRefs = objectRefs;
        this.description = description;
    }

    // REQUIRED PROPERTIES

    @Override
    public List<String> getLabels() {
        return super.getLabels();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ZonedDateTime getPublished() {
        return published;
    }

    @Override
    public List<Identifier> getObjectRefs() {
        return objectRefs;
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
