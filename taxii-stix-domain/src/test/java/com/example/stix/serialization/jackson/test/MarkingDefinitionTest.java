package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.datamarking.MarkingDefinition;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MarkingDefinitionTest extends SerializationTester {

    private final String markingDefinition_0 =
            "    {\n" +
            "      \"type\": \"marking-definition\",\n" +
            "      \"id\": \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\",\n" +
            "      \"created\": \"2017-04-14T13:07:49.812Z\",\n" +
            "      \"created_by_ref\": \"identity--81cade27-7df8-4730-836b-62d880e6d9d3\",\n" +
            "      \"definition_type\": \"statement\",\n" +
            "      \"definition\": {\n" +
            "        \"statement\": \"Copyright © 2014 FireEye, Inc. All rights reserved. FireEye is a registered trademark of FireEye, Inc. All other brands, products, or service names are or may be trademarks or service marks of their respective owners. RPT.PIVY.EN-US.082014\"\n" +
            "      }\n" +
            "    }";

    @Test
    public void deserializeAsBundleObject() throws IOException {
        asBundleObject(markingDefinition_0);
    }

    @Test
    public void deserializeMarkingDefinition_0() throws IOException {
        MarkingDefinition object = mapper.readValue(markingDefinition_0, MarkingDefinition.class);
        String serialized = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, markingDefinition_0, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject definition = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(definition);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, markingDefinition_0, serialized));
    }

}
