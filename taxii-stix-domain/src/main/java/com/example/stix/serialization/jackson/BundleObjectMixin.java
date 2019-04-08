package com.example.stix.serialization.jackson;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.datamarking.MarkingDefinition;
import com.example.stix.api.objects.*;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.api.relationships.Sighting;
import com.example.stix.impl.datamarking.MarkingDefinitionImpl;
import com.example.stix.impl.objects.*;
import com.example.stix.impl.relationships.RelationshipImpl;
import com.example.stix.impl.relationships.SightingImpl;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, property = CommonProperties.TYPE_PROPERTY, include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MarkingDefinitionImpl.class, name= MarkingDefinition.TYPE),
        @JsonSubTypes.Type(value = AttackPatternImpl.class, name= AttackPattern.TYPE),
        @JsonSubTypes.Type(value = CampaignImpl.class, name= Campaign.TYPE),
        @JsonSubTypes.Type(value = CourseOfActionImpl.class, name= CourseOfAction.TYPE),
        @JsonSubTypes.Type(value = IdentityImpl.class, name= Identity.TYPE),
        @JsonSubTypes.Type(value = IndicatorImpl.class, name= Indicator.TYPE),
        @JsonSubTypes.Type(value = IntrusionSetImpl.class, name= IntrusionSet.TYPE),
        @JsonSubTypes.Type(value = MalwareImpl.class, name= Malware.TYPE),
        @JsonSubTypes.Type(value = ObservedDataImpl.class, name= ObservedData.TYPE),
        @JsonSubTypes.Type(value = ReportImpl.class, name= Report.TYPE),
        @JsonSubTypes.Type(value = ThreatActorImpl.class, name= ThreatActor.TYPE),
        @JsonSubTypes.Type(value = ToolImpl.class, name= Tool.TYPE),
        @JsonSubTypes.Type(value = RelationshipImpl.class, name= Relationship.TYPE),
        @JsonSubTypes.Type(value = SightingImpl.class, name= Sighting.TYPE),
        @JsonSubTypes.Type(value = VulnerabilityImpl.class, name= Vulnerability.TYPE)

})
public interface BundleObjectMixin {

}
