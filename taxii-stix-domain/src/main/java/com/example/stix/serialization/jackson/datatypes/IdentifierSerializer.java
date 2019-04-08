package com.example.stix.serialization.jackson.datatypes;

import com.example.stix.api.datatypes.Identifier;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class IdentifierSerializer extends StdSerializer<Identifier> {

    public IdentifierSerializer() {
        super(Identifier.class);
    }

    @Override
    public void serialize(Identifier identifier, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(identifier.getType() + "--" + identifier.getId());
    }

}
