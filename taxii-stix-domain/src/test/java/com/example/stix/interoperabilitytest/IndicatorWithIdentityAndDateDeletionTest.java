package com.example.stix.interoperabilitytest;

import com.example.stix.api.BundleObject;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.example.stix.serialization.jackson.test.DiffenceChecker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IndicatorWithIdentityAndDateDeletionTest {

    private final String bundle = "{\n" +
            "  \"type\": \"bundle\",\n" +
            "  \"id\": \"bundle--5d0092c5-5f74-4287-9642-33f4c354e56d\",\n" +
            "  \"spec_version\": \"2.0\",\n" +
            "  \"objects\": [\n" +
            "    {\n" +
            "      \"type\": \"identity\",\n" +
            "      \"name\": \"ACME Corp, Inc.\",\n" +
            "      \"identity_class\": \"organization\",\n" +
            "      \"id\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"indicator\",\n" +
            "      \"id\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "      \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "      \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "      \"modified\": \"2016-04-06T20:12:50.000Z\",\n" +
            "      \"revoked\": \"true\",\n" +
            "      \"labels\": [\n" +
            "        \"Malicious IP\"\n" +
            "      ],\n" +
            "      \"name\": \"Bad IP1\",\n" +
            "      \"description\": \"This indicator should be monitored for malicious activity\",\n" +
            "      \"pattern\": \"[ ipv4-addr:value: '198.51.100.1' ]\",\n" +
            "      \"valid_from\": \"2016-01-01T00:00:00Z\"\n" +
            "    }\n" +
            "  ]\n" +
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
    public void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
