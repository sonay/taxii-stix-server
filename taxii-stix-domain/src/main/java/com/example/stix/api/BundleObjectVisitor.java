package com.example.stix.api;

import com.example.stix.api.datamarking.MarkingDefinition;
import com.example.stix.api.objects.*;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.api.relationships.Sighting;

public interface BundleObjectVisitor {

    void visit(AttackPattern pattern);

    void visit(Campaign campaign);

    void visit(CourseOfAction courseOfAction);

    void visit(Indicator indicator);

    void visit(Identity identity);

    void visit(IntrusionSet intrusionSet);

    void visit(Malware malware);

    void visit(ObservedData observedData);

    void visit(Report report);

    void visit(ThreatActor threatActor);

    void visit(Tool tool);

    void visit(Vulnerability vulnerability);

    void visit(Relationship relationship);

    void visit(Sighting sighting);

    void visit(MarkingDefinition markingDefinition);

}
