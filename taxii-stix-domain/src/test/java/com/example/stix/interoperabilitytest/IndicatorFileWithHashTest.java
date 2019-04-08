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

public class IndicatorFileWithHashTest {

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
            "      \"id\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\"," +
            "      \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "      \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "      \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
            "      \"labels\": [\n" +
            "        \"Malicious File\"\n" +
            "      ],\n" +
            "      \"name\": \"Bad File1\",\n" +
            "      \"description\": \"This indicator should be monitored when distributed or communicated\",\n" +
            "      \"pattern\": \"[file:hashes.'SHA-256' = 'bf07a7fbb825fc0aae7bf4a1177b2b31fcf8a3feeaf7092761e18c859ee52a9c' OR file:hashes.'MD5' = 'cead3f77f6cda6ec00f57d76c9a6879f']\",\n" +
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
