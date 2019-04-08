package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.ObservableObjects;
import com.example.stix.api.objects.ObservedData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ObservedDataImpl extends AbstractStixDomainObject implements ObservedData {

    private final ZonedDateTime firstObserved;

    private final ZonedDateTime lastObserved;

    private final int numberObserved;

    private final ObservableObjects observableObjects;

    public ObservedDataImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                            ZonedDateTime firstObserved, int numberObserved, ZonedDateTime lastObserved,
                            ObservableObjects observableObjects) {
        this(type, created, id, modified, null, null, null, null, null, null,
             firstObserved, numberObserved, lastObserved, observableObjects);
    }

    public ObservedDataImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                            Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                            List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                            List<String> labels, ZonedDateTime firstObserved, int numberObserved,
                            ZonedDateTime lastObserved, ObservableObjects observableObjects) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
            labels);
        this.firstObserved = firstObserved;
        this.lastObserved = lastObserved;
        this.numberObserved = numberObserved;
        this.observableObjects = observableObjects;
    }

    // REQUIRED PROPERTIES

    @Override
    public ZonedDateTime getFirstObserved() {
        return firstObserved;
    }

    @Override
    public ZonedDateTime getLastObserved() {
        return lastObserved;
    }

    @Override
    public int getNumberObserved() {
        return numberObserved;
    }

    @Override
    public ObservableObjects getObjects() {
        return observableObjects;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }


}
