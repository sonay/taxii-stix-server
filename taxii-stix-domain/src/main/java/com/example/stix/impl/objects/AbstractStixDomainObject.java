package com.example.stix.impl.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.objects.StixDomainObject;
import com.example.stix.impl.CommonPropertiesImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractStixDomainObject extends CommonPropertiesImpl implements StixDomainObject {

    public AbstractStixDomainObject(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified) {
        this(type, created, id, modified, false, null, null, null, null, null);
    }

    public AbstractStixDomainObject(StixType type, ZonedDateTime created, Identifier id, ZonedDateTime modified,
                                Boolean revoked, Identifier createdByRef, List<ExternalReference> externalReferences,
                                List<GranularMarking> granularMarkingRefs, List<Identifier> objectMarkingRefs,
                                List<String> labels) {
        super(type, created, id, modified, revoked, createdByRef, externalReferences, granularMarkingRefs,
                objectMarkingRefs, labels);
    }

}
