package com.example.stix.impl.relationships;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.relationships.Sighting;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SightingImpl extends AbstractStixRelationshipObject implements Sighting {

    private final Identifier sightingOfRef;

    private final ZonedDateTime firstSeen;

    private final ZonedDateTime lastSeen;

    private final Integer count;

    private final List<Identifier> observedDataRefs;

    private final List<Identifier> whereSightedRefs;

    private final Boolean isSummary;

    public SightingImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                        Identifier sightingOfRef) {
        this(type, created, id, modified,
             sightingOfRef, null, null, null, null, null, null);
    }

    public SightingImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Identifier sightingOfRef,
                        ZonedDateTime firstSeen, List<Identifier> observedDataRefs, ZonedDateTime lastSeen,
                        List<Identifier> whereSightedRefs, Integer count, Boolean isSummary) {
        this(type, created, id, modified, null, null, null, null, null, null,
             sightingOfRef, firstSeen, observedDataRefs, lastSeen, whereSightedRefs, count, isSummary);
    }

    public SightingImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                        Identifier createdByRef, List<ExternalReference> externalReferences,
                        List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                        List<String> labels, Identifier sightingOfRef, ZonedDateTime firstSeen,
                        List<Identifier> observedDataRefs,  ZonedDateTime lastSeen, List<Identifier> whereSightedRefs,
                        Integer count,  Boolean isSummary) {

        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
              objectMarkingRefs, labels);

        this.sightingOfRef = sightingOfRef;
        this.firstSeen = firstSeen;
        this.lastSeen = lastSeen;
        this.observedDataRefs = observedDataRefs;
        this.count = count;
        this.whereSightedRefs = whereSightedRefs;
        this.isSummary = isSummary;
    }

    // REQUIRED PROPERTIES

    @Override
    public StixType getType() {
        return Sighting.super.getType();
    }


    @Override
    public Identifier getSightingOfRef() {
        return sightingOfRef;
    }

    // OPTIONAL PROPERTIES

    @Override
    public ZonedDateTime getFirstSeen() {
        return firstSeen;
    }

    @Override
    public ZonedDateTime getLastSeen() {
        return lastSeen;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public List<Identifier> getObservedDataRefs() {
        return observedDataRefs;
    }

    @Override
    public List<Identifier> getWhereSightedRefs() {
        return whereSightedRefs;
    }

    @Override
    public Boolean isSummary() {
        return isSummary;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
