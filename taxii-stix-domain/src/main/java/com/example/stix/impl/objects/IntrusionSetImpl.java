package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.IntrusionSet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class IntrusionSetImpl extends AbstractStixDomainObject implements IntrusionSet {

    private final String name;

    private final String description;

    private final List<String> aliases;

    private final ZonedDateTime firstSeen;

    private final ZonedDateTime lastSeen;

    private final List<String> goals;

    private final String primaryMotivation;

    private final List<String> secondaryMotivations;

    private final String resourceLevel;

    public IntrusionSetImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name) {
        this(type, created, id, modified,
             name, null, null, null, null, null, null, null, null);
    }

    public IntrusionSetImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name,
                            List<String> aliases, String description, ZonedDateTime firstSeen, List<String> goals,
                            ZonedDateTime lastSeen, String primaryMotivation, List<String> secondaryMotivations,
                            String resourceLevel) {

        this(type, created, id, modified, null, null, null, null, null, null,
             name, aliases, description, firstSeen, goals, lastSeen, primaryMotivation, secondaryMotivations,
             resourceLevel);

    }

    public IntrusionSetImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                            Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                            List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                            List<String> labels, String name, List<String> aliases, String description,
                            ZonedDateTime firstSeen, List<String> goals, ZonedDateTime lastSeen,
                            String primaryMotivation, List<String> secondaryMotivations, String resourceLevel) {

        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
              labels);
        this.name = name;
        this.description = description;
        this.aliases = aliases;
        this.firstSeen = firstSeen;
        this.lastSeen = lastSeen;
        this.goals = goals;
        this.primaryMotivation = primaryMotivation;
        this.secondaryMotivations = secondaryMotivations;
        this.resourceLevel = resourceLevel;

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
    public List<String> getGoals() {
        return goals;
    }

    @Override
    public String getResourceLevel() {
        return resourceLevel;
    }

    @Override
    public String getPrimaryMotivation() {
        return primaryMotivation;
    }

    @Override
    public List<String> getSecondaryMotivations() {
        return secondaryMotivations;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
