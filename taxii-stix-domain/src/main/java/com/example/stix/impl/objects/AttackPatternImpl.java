package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.AttackPattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AttackPatternImpl extends AbstractStixDomainObject implements AttackPattern {

    private final String name;

    private final String description;

    private final List<KillChainPhase> killChainPhases;

    public AttackPatternImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name) {
        this(type, created, id, modified,
             name, null, null);
    }

    public AttackPatternImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name,
                             List<KillChainPhase> killChainPhases, String description) {
        this(type, created, id, modified, null, null, null, null, null, null,
             name, killChainPhases, description);
    }

    public AttackPatternImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                             Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                             List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                             List<String> labels, String name, List<KillChainPhase> killChainPhases,
                             String description) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
              objectMarkingRefs, labels);
        this.name = name;
        this.description = description;
        this.killChainPhases = killChainPhases;
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

    @Override
    public List<KillChainPhase> getKillChainPhases() {
        return killChainPhases;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
