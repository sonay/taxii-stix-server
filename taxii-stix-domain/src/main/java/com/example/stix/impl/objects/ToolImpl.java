package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.Tool;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToolImpl extends AbstractStixDomainObject implements Tool {

    private final String name;

    private final String description;

    private final List<KillChainPhase> killChainPhases;

    private final String toolVersion;

    public ToolImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name,
                    List<String> labels) {
        this(type, created, id, modified, name, labels, null, null, null);
    }

    public ToolImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, String name,
                    List<String> labels, String description, List<KillChainPhase> killChainPhases, String toolVersion) {
        this(type, created, id, modified, null, null, null, null, null,
             name, labels, description, killChainPhases, toolVersion);
    }

    public ToolImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                    Identifier createdByRef, List<ExternalReference> externalReferences,
                    List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                    String name, List<String> labels, String description, List<KillChainPhase> killChainPhases,
                    String toolVersion) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
              labels);
        this.name = name;
        this.description = description;
        this.killChainPhases = killChainPhases;
        this.toolVersion = toolVersion;
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
    public List<KillChainPhase> getKillChainPhases() {
        return killChainPhases;
    }

    @Override
    public String getToolVersion() {
        return toolVersion;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
