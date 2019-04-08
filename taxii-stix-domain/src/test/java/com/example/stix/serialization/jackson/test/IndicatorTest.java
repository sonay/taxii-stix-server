package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.Indicator;
import com.example.stix.impl.objects.IndicatorImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IndicatorTest {

    private final String indicator_0 = "{\n" +
            "\n" +
            "    \"type\": \"indicator\",\n" +
            "\n" +
            "    \"id\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "    \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "    \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "    \"labels\": [\"malicious-activity\"],\n" +
            "\n" +
            "    \"name\": \"Poison Ivy Malware\",\n" +
            "\n" +
            "    \"description\": \"This file is part of Poison Ivy\",\n" +
            "\n" +
            "    \"pattern\": \"[ file:hashes.'SHA-256' = '4bac27393bdd9777ce02453256c5577cd02275510b2227f473d03f533924f877' ]\",\n" +
            "\n" +
            "    \"valid_from\": \"2016-01-01T00:00:00Z\"\n" +
            "\n" +
            "  }";

    private final String indicator_1 = "{\n" +
            "\n" +
            "      \"type\": \"indicator\",\n" +
            "\n" +
            "      \"id\": \"indicator--26ffb872-1dd9-446e-b6f5-d58527e5b5d2\",\n" +
            "\n" +
            "      \"created\": \"2015-12-21T19:59:17.000Z\",\n" +
            "\n" +
            "      \"modified\": \"2016-05-21T19:59:17.000Z\",\n" +
            "\n" +
            "      \"name\": \"Some indicator\",\n" +
            "\n" +
            "      \"labels\": [\"malicious-activity\"],\n" +
            "\n" +
            "      \"pattern\": \"[ file:hashes.MD5 = '3773a88f65a5e780c8dff9cdc3a056f3' ]\",\n" +
            "\n" +
            "      \"valid_from\": \"2015-12-21T19:59:17Z\",\n" +
            "\n" +
            "      \"created_by_ref\": \"identity--a463ffb3-1bd9-4d94-b02d-74e4f1658283\"\n" +
            "\n" +
            "    }";

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
        asBundleObject(indicator_0); // invalid valid_from
        asBundleObject(indicator_1); // invalid valid_from
    }

    @Test
    public void asIndicator() throws IOException {
        asIndicator(indicator_0);
        asIndicator(indicator_1);
    }

    @Test
    public void deserializeAsIndicatorImpl() throws IOException {
        asIndicatorImpl(indicator_0);
        asIndicatorImpl(indicator_1);
    }

    private void asIndicatorImpl(String value) throws IOException {
        IndicatorImpl pattern = mapper.readValue(value, IndicatorImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asIndicator(String value) throws IOException {
        Indicator pattern = mapper.readValue(value, Indicator.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
