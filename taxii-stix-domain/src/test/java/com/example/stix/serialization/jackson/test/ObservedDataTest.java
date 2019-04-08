package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.ObservedData;
import com.example.stix.impl.objects.ObservedDataImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


// TODO: This won't work yet. Need to implement ObservableObjects
public class ObservedDataTest {

    private final String observedData_0 = "{\n" +
            "\n" +
            "  \"type\": \"observed-data\",\n" +
            "\n" +
            "  \"id\": \"observed-data--b67d30ff-02ac-498a-92f9-32f845f448cf\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T19:58:16.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T19:58:16.000Z\",\n" +
            "\n" +
            "  \"first_observed\": \"2015-12-21T19:00:00Z\",\n" +
            "\n" +
            "  \"last_observed\": \"2015-12-21T19:00:00Z\",\n" +
            "\n" +
            "  \"number_observed\": 50,\n" +
            "\n" +
            "  \"objects\": {\n" +
            "\n" +
            "    \"0\": {\n" +
            "\n" +
            "      \"type\": \"file\",\n" +
            "\n" +
            "      ...\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "  }\n" +
            "\n" +
            "}";

    private final String observedData_1 = "{\n" +
            "\n" +
            "    \"type\": \"observed-data\",\n" +
            "\n" +
            "    \"id\": \"observed-data--b67d30ff-02ac-498a-92f9-32f845f448cf\",\n" +
            "\n" +
            "    \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "    \"created\": \"2016-04-06T19:58:16.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-04-06T19:58:16.000Z\",\n" +
            "\n" +
            "    \"start\": \"2015-12-21T19:00:00Z\",\n" +
            "\n" +
            "    \"stop\": \"2016-04-06T19:58:16Z\",\n" +
            "\n" +
            "    \"count\": 50,\n" +
            "\n" +
            "    \"objects\": {\n" +
            "\n" +
            "      \"0\": {\n" +
            "\n" +
            "        \"type\": \"file\",\n" +
            "\n" +
            "        ...\n" +
            "\n" +
            "      }\n" +
            "\n" +
            "    }\n" +
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
        asBundleObject(observedData_0);
        asBundleObject(observedData_1);
    }

    @Test
    public void asObservedData() throws IOException {
        asObservedData(observedData_0);
        asObservedData(observedData_1);
    }

    @Test
    public void deserializeAsObservedDataImpl() throws IOException {
        asObservedDataImpl(observedData_0);
        asObservedDataImpl(observedData_1);
    }

    private void asObservedDataImpl(String value) throws IOException {
        ObservedDataImpl pattern = mapper.readValue(value, ObservedDataImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asObservedData(String value) throws IOException {
        ObservedData pattern = mapper.readValue(value, ObservedData.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
