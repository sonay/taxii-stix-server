package com.example.stix.api;

import com.example.stix.api.datamarking.MarkingDefinition;
import com.example.stix.api.datamarking.StatementMarkingObject;
import com.example.stix.api.datamarking.TlpMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.*;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.api.relationships.Sighting;

import java.util.*;

public enum StixType {

    BUNDLE(Bundle.TYPE),

    MARKING_DEFINITION(MarkingDefinition.TYPE),
    STATEMENT_MARKING_OBJECT(StatementMarkingObject.DEFINITION_TYPE),
    TLP_MARKING(TlpMarking.DEFINITION_TYPE),
    // TODO: Marking Object


    EXTERNAL_REFERENCE(ExternalReference.TYPE),
    KILL_CHAIN_PHASE(KillChainPhase.TYPE),

    ATTACK_PATTERN(AttackPattern.TYPE),
    CAMPAIGN(Campaign.TYPE),
    COURSE_OF_ACTION(CourseOfAction.TYPE),
    IDENTITY(Identity.TYPE),
    INDICATOR(Indicator.TYPE),
    INTRUSION_SET(IntrusionSet.TYPE),
    MALWARE(Malware.TYPE),
    // TODO: ObservableObjects
    OBSERVED_DATA(ObservedData.TYPE),
    REPORT(Report.TYPE),
    THREAT_ACTOR(ThreatActor.TYPE),
    TOOL(Tool.TYPE),
    VULNERABILITY(Vulnerability.TYPE),

    RELATIONSHIP(Relationship.TYPE),
    SIGHTING(Sighting.TYPE);

    private static final Map<String, StixType> TYPES;

    private static final Set<StixType> DOMAIN_TYPES;

    private static final Set<StixType> RELATIONSHIP_TYPES;

    static {
        Map<String, StixType> types = new HashMap<>();
        types.put(Bundle.TYPE, BUNDLE);

        types.put(MarkingDefinition.TYPE, MARKING_DEFINITION);
        types.put(ExternalReference.TYPE, EXTERNAL_REFERENCE);
        types.put(KillChainPhase.TYPE, KILL_CHAIN_PHASE);

        types.put(AttackPattern.TYPE, ATTACK_PATTERN);
        types.put(Campaign.TYPE, CAMPAIGN);
        types.put(CourseOfAction.TYPE, COURSE_OF_ACTION);
        types.put(Identity.TYPE, IDENTITY);
        types.put(Indicator.TYPE, INDICATOR);
        types.put(IntrusionSet.TYPE, INTRUSION_SET);
        types.put(Malware.TYPE, MALWARE);
        types.put(ObservedData.TYPE, OBSERVED_DATA);
        types.put(Report.TYPE, REPORT);
        types.put(ThreatActor.TYPE, THREAT_ACTOR);
        types.put(Tool.TYPE, TOOL);
        types.put(Vulnerability.TYPE, VULNERABILITY);

        types.put(Relationship.TYPE, RELATIONSHIP);
        types.put(Sighting.TYPE, SIGHTING);

        TYPES = Collections.unmodifiableMap(types);

        DOMAIN_TYPES = Collections.unmodifiableSet(EnumSet.of(ATTACK_PATTERN, CAMPAIGN, COURSE_OF_ACTION, IDENTITY,
                INDICATOR, INTRUSION_SET, MALWARE, OBSERVED_DATA, REPORT, THREAT_ACTOR, TOOL, VULNERABILITY));

        RELATIONSHIP_TYPES = Collections.unmodifiableSet(EnumSet.of(RELATIONSHIP, SIGHTING));
    }

    private String value;

    StixType(String value) {
        this.value = value;
    }

    public static StixType from(String type) {
        return TYPES.get(type);
    }

    public boolean isSDO() {
        return DOMAIN_TYPES.contains(this);
    }

    public boolean isSRO() {
        return RELATIONSHIP_TYPES.contains(this);
    }

    @Override
    public String toString() {
        return value;
    }

}
