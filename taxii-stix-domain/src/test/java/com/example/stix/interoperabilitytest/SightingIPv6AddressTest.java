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

public class SightingIPv6AddressTest {

    private final String bundle = "{\n" +
            "  \"type\": \"bundle\",\n" +
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
            "      ]," +
            "      \"where_sighted_refs\": [\n" +
            "        \"identity--29898928432-377b-45e0-aa1c-6a4751cae5ff\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"observed-data\",\n" +
            "      \"id\": \"observed-data--b67d30ff-02ac-498a-92f9-32f845f448cf\",\n" +
            "      \"created_by_ref\": \"identity--29898928432-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "      \"created\": \"2016-04-06T19:58:16.000Z\",\n" +
            "      \"modified\": \"2016-04-06T19:58:16.000Z\",\n" +
            "      \"first_observed\": \"2015-12-21T19:00:00Z\",\n" +
            "      \"last_observed\": \"2016-04-06T19:58:16Z\",\n" +
            "      \"number_observed\": 1,\n" +
            "      \"objects\": {\n" +
            "        \"0\": {\n" +
            "          \"type\": \"ipv6-addr\",\n" +
            "          \"value\": \"2001:0db8:85a3:0000:0000:8a2e:0370:7334\"\n" +
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
