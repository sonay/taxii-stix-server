package com.example.stix.serialization.jackson.config;

import com.example.stix.api.Bundle;
import com.example.stix.api.BundleObject;
import com.example.stix.api.datamarking.MarkingDefinition;
import com.example.stix.api.datamarking.TlpMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.*;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.api.relationships.Sighting;
import com.example.stix.impl.BundleImpl;
import com.example.stix.impl.datamarking.MarkingDefinitionImpl;
import com.example.stix.impl.datatypes.ExternalReferenceImpl;
import com.example.stix.impl.datatypes.KillChainPhaseImpl;
import com.example.stix.impl.objects.*;
import com.example.stix.impl.relationships.RelationshipImpl;
import com.example.stix.impl.relationships.SightingImpl;
import com.example.stix.serialization.jackson.BundleMixin;
import com.example.stix.serialization.jackson.BundleObjectMixin;
import com.example.stix.serialization.jackson.datamarking.MarkingDefinitionImplMixin;
import com.example.stix.serialization.jackson.datamarking.TlpMarkingMixin;
import com.example.stix.serialization.jackson.datatypes.ExternalReferenceMixin;
import com.example.stix.serialization.jackson.datatypes.IdentifierDeserializer;
import com.example.stix.serialization.jackson.datatypes.IdentifierSerializer;
import com.example.stix.serialization.jackson.datatypes.KillChainPhaseMixin;
import com.example.stix.serialization.jackson.objects.*;
import com.example.stix.serialization.jackson.relationships.RelationshipImplMixin;
import com.example.stix.serialization.jackson.relationships.SightingImplMixin;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class StixObjectsModule extends SimpleModule {

    public StixObjectsModule() {
        setNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        addAbstractTypeMapping(Bundle.class, BundleImpl.class);
        setMixInAnnotation(BundleImpl.class, BundleMixin.class);

        setMixInAnnotation(BundleObject.class, BundleObjectMixin.class);

        // data types
        addAbstractTypeMapping(ExternalReference.class, ExternalReferenceImpl.class);
        setMixInAnnotation(ExternalReference.class, ExternalReferenceMixin.class);

        addAbstractTypeMapping(KillChainPhase.class, KillChainPhaseImpl.class);
        setMixInAnnotation(KillChainPhase.class, KillChainPhaseMixin.class);

        addSerializer(Identifier.class, new IdentifierSerializer());
        addDeserializer(Identifier.class, new IdentifierDeserializer());

        // data marking
        addAbstractTypeMapping(MarkingDefinition.class, MarkingDefinitionImpl.class);
        setMixInAnnotation(MarkingDefinitionImpl.class, MarkingDefinitionImplMixin.class);

        setMixInAnnotation(TlpMarking.class, TlpMarkingMixin.class);

        // objects
        addAbstractTypeMapping(AttackPattern.class, AttackPatternImpl.class);
        setMixInAnnotation(AttackPatternImpl.class, AttackPatternImplMixin.class);

        addAbstractTypeMapping(Campaign.class, CampaignImpl.class);
        setMixInAnnotation(CampaignImpl.class, CampaignImplMixin.class);

        addAbstractTypeMapping(CourseOfAction.class, CourseOfActionImpl.class);
        setMixInAnnotation(CourseOfActionImpl.class, CourseOfActionImplMixin.class);

        addAbstractTypeMapping(Identity.class, IdentityImpl.class);
        setMixInAnnotation(IdentityImpl.class, IdentityImplMixin.class);

        addAbstractTypeMapping(Indicator.class, IndicatorImpl.class);
        setMixInAnnotation(IndicatorImpl.class, IndicatorImplMixin.class);

        addAbstractTypeMapping(IntrusionSet.class, IntrusionSetImpl.class);
        setMixInAnnotation(IntrusionSetImpl.class, IntrusionSetImplMixin.class);

        addAbstractTypeMapping(Malware.class, MalwareImpl.class);
        setMixInAnnotation(MalwareImpl.class, MalwareImplMixin.class);

        addAbstractTypeMapping(ObservedData.class, ObservedDataImpl.class);
        setMixInAnnotation(ObservedDataImpl.class, ObservedDataImplMixin.class);

        addAbstractTypeMapping(Report.class, ReportImpl.class);
        setMixInAnnotation(ReportImpl.class, ReportImplMixin.class);

        addAbstractTypeMapping(ThreatActor.class, ThreatActorImpl.class);
        setMixInAnnotation(ThreatActorImpl.class, ThreatActorImplMixin.class);

        addAbstractTypeMapping(Tool.class, ToolImpl.class);
        setMixInAnnotation(ToolImpl.class, ToolImplMixin.class);

        addAbstractTypeMapping(Vulnerability.class, VulnerabilityImpl.class);
        setMixInAnnotation(VulnerabilityImpl.class, VulnerabilityImplMixin.class);

        // relationships
        addAbstractTypeMapping(Relationship.class, RelationshipImpl.class);
        setMixInAnnotation(RelationshipImpl.class, RelationshipImplMixin.class);

        addAbstractTypeMapping(Sighting.class, SightingImpl.class);
        setMixInAnnotation(SightingImpl.class, SightingImplMixin.class);

    }

}
