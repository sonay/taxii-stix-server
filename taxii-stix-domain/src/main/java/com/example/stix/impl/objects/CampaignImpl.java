package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.Campaign;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CampaignImpl extends AbstractStixDomainObject implements Campaign {

    private final String name;

    private final String description;

    private final ZonedDateTime firstSeen;

    private final ZonedDateTime lastSeen;

    private final List<String> aliases;

    private final String objective;

    public CampaignImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name) {
        this(type, created, id, modified,
             name, null, null, null, null, null);
    }

    public CampaignImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name,
                        ZonedDateTime firstSeen, String description, ZonedDateTime lastSeen, List<String> aliases,
                        String objective) {
        this(type, created, id, modified, null, null, null, null, null, null,
             name, firstSeen, description, lastSeen, aliases, objective);
    }

    public CampaignImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                        Identifier createdByRef, List<ExternalReference> externalReferences,
                        List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                        List<String> labels, String name, ZonedDateTime firstSeen, String description,
                        ZonedDateTime lastSeen, List<String> aliases, String objective) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
              labels);
        this.name = name;
        this.description = description;
        this.firstSeen = firstSeen;
        this.lastSeen = lastSeen;
        this.aliases = aliases;
        this.objective = objective;
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
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public ZonedDateTime getFirstSeen() {
        return firstSeen;
    }

    @Override
    public ZonedDateTime getLastSeen() {
        return lastSeen;
    }

    @Override
    public String getObjective() {
        return objective;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
