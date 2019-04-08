package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.ThreatActor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ThreatActorImpl extends AbstractStixDomainObject implements ThreatActor {

    private final String name;

    private final List<String> goals;

    private final String sophistication;

    private final String description;

    private final String resourceLevel;

    private final List<String> aliases;

    private final List<String> personalMotivations;

    private final List<String> roles;

    private final String primaryMotivation;

    private final List<String> secondaryMotivations;

    public ThreatActorImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                           List<String> labels, String name) {
        this(type, created, id, modified, labels,
             name, null, null, null, null, null, null, null, null, null);
    }

    public ThreatActorImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                           List<String> labels, String name, List<String> goals, String description,
                           List<String> aliases, String sophistication, List<String> personalMotivations,
                           String resourceLevel, List<String> roles, String primaryMotivation,
                           List<String> secondaryMotivations) {
        this(type, created, id, modified, null, null, null, null, null, labels,
             name, goals, description, aliases, sophistication, personalMotivations, resourceLevel, roles,
             primaryMotivation, secondaryMotivations);
    }

    public ThreatActorImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                           Identifier createdByRef, List<ExternalReference> externalReferences,
                           List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                           List<String> labels, String name, List<String> goals, String description,
                           List<String> aliases, String sophistication, List<String> personalMotivations,
                           String resourceLevel, List<String> roles, String primaryMotivation,
                           List<String> secondaryMotivations) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs, labels);
        this.name = name;
        this.sophistication = sophistication;
        this.description = description;
        this.resourceLevel = resourceLevel;
        this.aliases = aliases;
        this.roles = roles;
        this.goals = goals;
        this.primaryMotivation = primaryMotivation;
        this.secondaryMotivations = secondaryMotivations;
        this.personalMotivations = personalMotivations;
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
    public List<String> getRoles() {
        return roles;
    }

    @Override
    public List<String> getGoals() {
        return goals;
    }

    @Override
    public String getSophistication() {
        return sophistication;
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
    public List<String> getPersonalMotivations() {
        return personalMotivations;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }
}
