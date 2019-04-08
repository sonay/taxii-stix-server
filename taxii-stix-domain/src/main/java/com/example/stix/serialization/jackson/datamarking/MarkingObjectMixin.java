package com.example.stix.serialization.jackson.datamarking;

import com.example.stix.api.datamarking.MarkingObject;
import com.example.stix.api.datamarking.TlpMarking;
import com.example.stix.impl.datamarking.StatementMarkingObjectImpl;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = MarkingObject.TYPE_PROPERTY,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY

)
@JsonSubTypes({
        @JsonSubTypes.Type(value = StatementMarkingObjectImpl.class, name= StatementMarkingObjectImpl.DEFINITION_TYPE),
        @JsonSubTypes.Type(value = TlpMarking.class, name = TlpMarking.DEFINITION_TYPE)

})
public class MarkingObjectMixin {
}
