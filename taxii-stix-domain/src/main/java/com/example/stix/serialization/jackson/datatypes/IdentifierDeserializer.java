package com.example.stix.serialization.jackson.datatypes;

import com.example.stix.api.datatypes.Identifier;
import com.example.stix.impl.datatypes.IdentifierImpl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class IdentifierDeserializer extends StdDeserializer<Identifier> {


    public IdentifierDeserializer() {
        super(Identifier.class);
    }

    @Override
    public Identifier deserialize(JsonParser parser, DeserializationContext deserializationContext)
            throws IOException {
        if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
            parser.nextToken();
        }
        return IdentifierImpl.from(parser.getText());
    }

}
