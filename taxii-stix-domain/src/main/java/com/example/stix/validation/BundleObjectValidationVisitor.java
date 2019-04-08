package com.example.stix.validation;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.datamarking.MarkingDefinition;
import com.example.stix.api.objects.*;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.api.relationships.Sighting;
import com.example.stix.validation.objects.*;
import com.example.stix.validation.relationships.RelationshipValidator;

import java.util.Objects;

public class BundleObjectValidationVisitor implements BundleObjectVisitor {

    private final AttackPatternValidator attackPatternValidator;

    private final CampaignValidator campaignValidator;

    private final CourseOfActionValidator courseOfActionValidator;

    private final IndicatorValidator indicatorValidator;

    private final IdentityValidator identityValidator;

    private final IntrusionSetValidator intrusionSetValidator;

    private final MalwareValidator malwareValidator;

    private final ObservedDataValidator observedDataValidator;

    private final ReportValidator reportValidator;

    private final ThreatActorValidator threatActorValidator;

    private final ToolValidator toolValidator;

    private final VulnerabilityValidator vulnerabilityValidator;

    private final RelationshipValidator relationshipValidator;

    private final ValidationStrategy strategy;

    // TODO: Sightingvalidator, MarkingDefinitionValidator ????

    public BundleObjectValidationVisitor(ValidationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
        attackPatternValidator = new AttackPatternValidator();
        campaignValidator = new CampaignValidator();
        courseOfActionValidator = new CourseOfActionValidator();
        indicatorValidator = new IndicatorValidator();
        identityValidator = new IdentityValidator();
        intrusionSetValidator = new IntrusionSetValidator();
        malwareValidator = new MalwareValidator();
        observedDataValidator = new ObservedDataValidator();
        reportValidator = new ReportValidator();
        threatActorValidator = new ThreatActorValidator();
        toolValidator = new ToolValidator();
        vulnerabilityValidator = new VulnerabilityValidator();
        relationshipValidator = new RelationshipValidator();
    }


    @Override
    public void visit(AttackPattern pattern) {
        attackPatternValidator.validate(pattern, strategy);
    }

    @Override
    public void visit(Campaign campaign) {
        campaignValidator.validate(campaign, strategy);
    }

    @Override
    public void visit(CourseOfAction courseOfAction) {
        courseOfActionValidator.validate(courseOfAction, strategy);
    }

    @Override
    public void visit(Indicator indicator) {
        indicatorValidator.validate(indicator, strategy);
    }

    @Override
    public void visit(Identity identity) {
        identityValidator.validate(identity, strategy);
    }

    @Override
    public void visit(IntrusionSet intrusionSet) {
        intrusionSetValidator.validate(intrusionSet, strategy);
    }

    @Override
    public void visit(Malware malware) {
        malwareValidator.validate(malware, strategy);
    }

    @Override
    public void visit(ObservedData observedData) {
        observedDataValidator.validate(observedData, strategy);
    }

    @Override
    public void visit(Report report) {
        reportValidator.validate(report, strategy);
    }

    @Override
    public void visit(ThreatActor threatActor) {
        threatActorValidator.validate(threatActor, strategy);
    }

    @Override
    public void visit(Tool tool) {
        toolValidator.validate(tool, strategy);
    }

    @Override
    public void visit(Vulnerability vulnerability) {
        vulnerabilityValidator.validate(vulnerability, strategy);
    }

    @Override
    public void visit(Relationship relationship) {
        relationshipValidator.validate(relationship, strategy);
    }

    @Override
    public void visit(Sighting sighting) {
        // TODO: implement
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(MarkingDefinition markingDefinition) {
        // TODO: implement
//        throw new UnsupportedOperationException();
    }
}
