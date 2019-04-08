package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.relationships.Sighting;
import com.example.stix.impl.relationships.SightingImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SightingTest {

    private final String sighting_0 = "{\n" +
            "\n" +
            "  \"type\": \"sighting\",\n" +
            "\n" +
            "  \"id\": \"sighting--ee20065d-2555-424f-ad9e-0f8428623c75\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:08:31.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:08:31.000Z\",\n" +
            "\n" +
            "  \"sighting_of_ref\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\"\n" +
            "\n" +
            "}";

    private final String sighting_1 = "{\n" +
            "\n" +
            "    \"type\": \"sighting\",\n" +
            "\n" +
            "    \"id\": \"sighting--ee20065d-2555-424f-ad9e-0f8428623c75\",\n" +
            "\n" +
            "    \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "    \"created\": \"2016-04-06T20:08:31.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-04-06T20:08:31.000Z\",\n" +
            "\n" +
            "    \"first_seen\": \"2015-12-21T19:00:00Z\",\n" +
            "\n" +
            "    \"last_seen\": \"2015-12-21T19:00:00Z\",\n" +
            "\n" +
            "    \"count\": 50,\n" +
            "\n" +
            "    \"sighting_of_ref\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "    \"observed_data_refs\": [\"observed-data--b67d30ff-02ac-498a-92f9-32f845f448cf\"],\n" +
            "\n" +
            "    \"where_sighted_refs\": [\"identity--b67d30ff-02ac-498a-92f9-32f845f448ff\"]\n" +
            "\n" +
            "  }";

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
        asBundleObject(sighting_0);
        asBundleObject(sighting_1);
    }

    @Test
    public void asSighting() throws IOException {
        asSighting(sighting_0);
        asSighting(sighting_1);
    }

    @Test
    public void deserializeAsSightingImpl() throws IOException {
        asSightingImpl(sighting_0);
        asSightingImpl(sighting_1);
    }

    private void asSightingImpl(String value) throws IOException {
        SightingImpl pattern = mapper.readValue(value, SightingImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asSighting(String value) throws IOException {
        Sighting pattern = mapper.readValue(value, Sighting.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
