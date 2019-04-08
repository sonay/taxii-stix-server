package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.CourseOfAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CourseOfActionImpl extends AbstractStixDomainObject implements CourseOfAction {

    private final String name;

    private final String description;

    public CourseOfActionImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name) {
        this(type, created, id, modified,
             name, null);
    }

    public CourseOfActionImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name, String description) {
        this(type, created, id, modified, null, null, null, null, null, null,
             name, description);
    }

    public CourseOfActionImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                              Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                              List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                              List<String> labels, String name, String description) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
            labels);
        this.name = name;
        this.description = description;
    }

    // REQUIRED PROPERTIES
    @Override
    public String getName() {
        return name;
    }

    // OPTIONAL PROPERTIES

    @Override
    public String getDescription() {
        return description;
    }

    /*
     * RESERVED – To capture structured/automated courses of action.
     * */
    // RESERVED getAction();

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
