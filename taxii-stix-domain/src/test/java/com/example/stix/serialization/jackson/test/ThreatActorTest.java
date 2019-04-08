package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.ThreatActor;
import com.example.stix.impl.objects.ThreatActorImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ThreatActorTest {

    private final String threatActor_0 = "{\n" +
            "\n" +
            "  \"type\": \"threat-actor\",\n" +
            "\n" +
            "  \"id\": \"threat-actor--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "  \"labels\": [ \"crime-syndicate\"],\n" +
            "\n" +
            "  \"name\": \"Evil Org\",\n" +
            "\n" +
            "  \"description\": \"The Evil Org threat actor group\",\n" +
            "\n" +
            "  \"aliases\": [\"Syndicate 1\", \"Evil Syndicate 99\"],\n" +
            "\n" +
            "  \"roles\": \"director\",\n" +
            "\n" +
            "  \"goals\": [\"Steal bank money\", \"Steal credit cards\"],\n" +
            "\n" +
            "  \"sophistication\": \"advanced\",\n" +
            "\n" +
            "  \"resource_level\": \"team\",\n" +
            "\n" +
            "  \"primary_motivation\": \"organizational-gain\"\n" +
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
        asBundleObject(threatActor_0); // should fail roles is not a list in the example
    }

    @Test
    public void asThreatActor() throws IOException {
        asThreatActor(threatActor_0);  // should fail roles is not a list in the example
    }

    @Test
    public void deserializeAsThreatActorImpl() throws IOException {
        asThreatActorImpl(threatActor_0);  // should fail roles is not a list in the example
    }

    private void asThreatActorImpl(String value) throws IOException {
        ThreatActorImpl pattern = mapper.readValue(value, ThreatActorImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asThreatActor(String value) throws IOException {
        ThreatActor pattern = mapper.readValue(value, ThreatActor.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
