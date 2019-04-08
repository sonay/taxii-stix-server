package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.Tool;
import com.example.stix.impl.objects.ToolImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ToolTest {

    private final String tool_0 = "{\n" +
            "\n" +
            "  \"type\": \"tool\",\n" +
            "\n" +
            "  \"id\": \"tool--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "  \"labels\": [ \"remote-access\"],\n" +
            "\n" +
            "  \"name\": \"VNC\"\n" +
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
        asBundleObject(tool_0);
    }

    @Test
    public void asTool() throws IOException {
        asTool(tool_0);
    }

    @Test
    public void deserializeAsToolImpl() throws IOException {
        asToolImpl(tool_0);
    }

    private void asToolImpl(String value) throws IOException {
        ToolImpl pattern = mapper.readValue(value, ToolImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asTool(String value) throws IOException {
        Tool pattern = mapper.readValue(value, Tool.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
