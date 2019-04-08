package com.example.stix.impl.objects;

import com.example.stix.api.BundleObjectVisitor;
import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.Identity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class IdentityImpl extends AbstractStixDomainObject implements Identity {

    private final String name;

    private final String description;

    private final String identityClass;

    private final String contactInformation;

    private final List<String> sectors;

    public IdentityImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                        String name, String identityClass) {

        this(type, created, id, modified,
             name, identityClass, null, null, null);

    }

    public IdentityImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                        String name, String identityClass, List<String> sectors, String description,
                        String contactInformation) {

        this(type, created, id, modified, null, null, null, null, null, null,
             name, identityClass, null, null, null);

    }

    public IdentityImpl(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified, Boolean revoked,
                        Identifier createdByRef, List<ExternalReference> externalReferences,
                        List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                        List<String> labels, String name, String identityClass, List<String> sectors,
                        String description, String contactInformation) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs,
              labels);
        this.name = name;
        this.description = description;
        this.identityClass = identityClass;
        this.contactInformation = contactInformation;
        this.sectors = sectors;
    }

    // REQUIRED PROPERTIES

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIdentityClass() {
        return identityClass;
    }

    // OPTIONAL PROPERTIES

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<String> getSectors() {
        return sectors;
    }

    @Override
    public String getContactInformation() {
        return contactInformation;
    }

    @Override
    public void accept(BundleObjectVisitor visitor) {
        visitor.visit(this);
    }

}
