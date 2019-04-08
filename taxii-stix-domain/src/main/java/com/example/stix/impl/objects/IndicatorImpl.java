package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.Indicator;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndicatorImpl extends AbstractStixDomainObject implements Indicator {

    private final String name;

    private final String description;

    // TODO: make StixPattern class???
    private final String pattern;

    private final ZonedDateTime validFrom;

    private final ZonedDateTime validUntil;

    private final List<KillChainPhase> killChainPhases;

    public IndicatorImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String pattern,
                         ZonedDateTime validFrom) {
        this(type, created, id, modified,
             pattern, validFrom, null, null, null, null);
    }

    public IndicatorImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String pattern,
                         ZonedDateTime validFrom, String name, ZonedDateTime validUntil, String description,
                         List<KillChainPhase> killChainPhases) {
        this(type, created, id, modified, null, null, null, null, null, null,
             pattern, validFrom, name, validUntil, description, killChainPhases);
    }

    public IndicatorImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                         Identifier createdByRef, List<ExternalReference> externalReferences,
                         List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                         List<String> labels, String pattern,
                         ZonedDateTime validFrom, String name, ZonedDateTime validUntil, String description,
                         List<KillChainPhase> killChainPhases) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
                labels);
        this.pattern = pattern;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.name = name;
        this.description = description;
        this.killChainPhases = killChainPhases;
    }

    // REQUIRED PROPERTIES

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public ZonedDateTime getValidFrom() {
        return validFrom;
    }

    // OPTIONAL PROPERTIES

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ZonedDateTime getValidUntil() {
        return validUntil;
    }

    @Override
    public List<KillChainPhase> getKillChainPhases() {
        return killChainPhases;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
