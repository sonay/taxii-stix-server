package com.example.stix.serialization.jackson.test;

import com.example.stix.api.Bundle;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.example.stix.validation.BundleValidator;
import com.example.stix.validation.ThrowOnValidationError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class DirtyFastTest {

    private static String BUNDLE = "{" +
            "\"type\" : \"bundle\"" +
            ",\"id\" : \"bundle--ac946f1d-6a0e-4a9d-bc83-3f1f3bfda6ba\"" +
            ",\"spec_version\" : \"2.0\"" +
            ",\"objects\" : [" +
            "   {\n" +
            "      \"type\": \"threat-actor\",\n" +
            "      \"id\": \"threat-actor--6d179234-61fc-40c4-ae86-3d53308d8e65\",\n" +
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"object_marking_refs\": [\n" +
            "        \"marking-definition--3444e29e-2aa6-46f7-a01c-1c174820fa67\"\n" +
            "      ],\n" +
            "      \"name\": \"Ugly Gorilla\",\n" +
            "      \"labels\": [\n" +
            "        \"nation-state\",\n" +
            "        \"spy\"\n" +
            "      ],\n" +
            "      \"roles\": [\n" +
            "        \"malware-author\",\n" +
            "        \"agent\",\n" +
            "        \"infrastructure-operator\"\n" +
            "      ],\n" +
            "      \"resource_level\": \"government\",\n" +
            "      \"aliases\": [\n" +
            "        \"Greenfield\",\n" +
            "        \"JackWang\",\n" +
            "        \"Wang Dong\"\n" +
            "      ],\n" +
            "      \"primary_motivation\": \"organizational-gain\"\n" +
            "    }" +
            "]" +
            "}";

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = ObjectMapperConfiguration.buildObjectMapper();
    }

    @After
    public void tearDown() {
        mapper = null;
    }

    @Test
    public void bundleTest() throws IOException {
        Bundle bundle = mapper.readValue(BUNDLE, Bundle.class);
        String serialized = mapper.writeValueAsString(bundle);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, BUNDLE, serialized));
    }



    @Test
    public void serializeTest() throws IOException {
        serializeTest(new File("src/test/resources/poison-ivy.json"));
//        serializeTest(new File("src/test/resources/imddos.json"));
        serializeTest(new File("src/test/resources/apt1.json"));
    }


    private void serializeTest(File input) throws IOException {

        Bundle bundle = mapper.readValue(input, Bundle.class);

        new BundleValidator().validate(bundle, new ThrowOnValidationError());

        String serialized = mapper.writeValueAsString(bundle);
        // TODO: test difference

    }

}
