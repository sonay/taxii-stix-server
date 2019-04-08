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

public class IndicatorWithIdentityAndDateCreationTest {

    private final String bundle_0 = "{\n" +
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
            "      \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
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

    private final String bundle_1 = "{\n" +
            "  \"type\": \"bundle\"," +
            "  \"id\": \"bundle--5d0092c5-5f74-4287-9642-33f4c354e56d\",\n" +
            "  \"spec_version\": \"2.0\",\n" +
            "  \"objects\": [\n" +
            "    {\n" +
            "      \"type\": \"identity\",\n" +
            "      \"name\": \"ACME Corp Sighting, Inc.\",\n" +
            "      \"identity_class\": \"organization\",\n" +
            "      \"id\": \"identity--29898928432-377b-45e0-aa1c-6a4751cae5ff\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"sighting\",\n" +
            "      \"id\": \"sighting--ee20065d-2555-424f-ad9e-0f8428623c75\",\n" +
            "      \"created_by_ref\": \"identity--29898928432-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "      \"created\": \"2016-04-06T20:08:31.000Z\",\n" +
            "      \"modified\": \"2016-04-06T20:08:31.000Z\",\n" +
            "      \"first_seen\": \"2015-12-21T19:00:00Z\",\n" +
            "      \"last_seen\": \"2015-12-21T19:00:00Z\",\n" +
            "      \"count\": 50,\n" +
            "      \"sighting_of_ref\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "      \"observed_data_refs\": [\n" +
            "        \"observed-data--b67d30ff-02ac-498a-92f9-32f845f448cf\"\n" +
            "      ],\n" +
            "      \"where_sighted_refs\": [\n" +
            "        \"identity--b67d30ff-02ac-498a-92f9-32f845f448ff\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"observed-data\",\n" +
            "      \"id\": \"observed-data--b67d30ff-02ac-498a-92f9-32f845f448cf\",\n" +
            "      \"created_by_ref\": \"identity--29898928432-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "      \"created\": \"2016-04-06T19:58:16.000Z\",\n" +
            "      \"modified\": \"2016-04-06T19:58:16.000Z\",\n" +
            "      \"start\": \"2015-12-21T19:00:00Z\",\n" +
            "      \"stop\": \"2016-04-06T19:58:16Z\",\n" +
            "      \"count\": 1,\n" +
            "      \"objects\": {\n" +
            "        \"0\": {\n" +
            "          \"type\": \"ipv4-addr\",\n" +
            "          \"value\": \"198.51.100.1\"\n" +
            "        }\n" +
            "      }\n" +
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
