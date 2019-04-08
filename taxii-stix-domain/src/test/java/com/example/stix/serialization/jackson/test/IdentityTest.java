package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.Identity;
import com.example.stix.impl.objects.IdentityImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IdentityTest {

    private static final String identity_0 = "{\n" +
            "\n" +
            "  \"type\": \"identity\",\n" +
            "\n" +
            "  \"id\": \"identity--023d105b-752e-4e3c-941c-7d3f3cb15e9e\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:03:00.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:03:00.000Z\",\n" +
            "\n" +
            "  \"name\": \"John Smith\",\n" +
            "\n" +
            "  \"identity_class\": \"individual\"\n" +
            "\n" +
            "}";

    private static final String identity_1 = "{\n" +
            "\n" +
            "  \"type\": \"identity\",\n" +
            "\n" +
            "  \"id\": \"identity--e5f1b90a-d9b6-40ab-81a9-8a29df4b6b65\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:03:00.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:03:00.000Z\",\n" +
            "\n" +
            "  \"name\": \"ACME Widget, Inc.\",\n" +
            "\n" +
            "  \"identity_class\": \"organization\"\n" +
            "\n" +
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
    public void deserializeAsBundleObject() throws IOException {
        asBundleObject(identity_0);
        asBundleObject(identity_1);
    }

    @Test
    public void asIdentity() throws IOException {
        asIdentity(identity_0);
        asIdentity(identity_1);
    }

    @Test
    public void deserializeAsIdentityImpl() throws IOException {
        asIdentityImpl(identity_0);
        asIdentityImpl(identity_1);
    }

    private void asIdentityImpl(String value) throws IOException {
        IdentityImpl pattern = mapper.readValue(value, IdentityImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asIdentity(String value) throws IOException {
        Identity pattern = mapper.readValue(value, Identity.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
