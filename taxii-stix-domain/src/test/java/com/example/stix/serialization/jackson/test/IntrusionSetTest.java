package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.IntrusionSet;
import com.example.stix.impl.objects.IntrusionSetImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IntrusionSetTest {

    private final String intrusionSet_0 = "{\n" +
    "    \"type\": \"intrusion-set\",\n" +
    "    \"id\": \"intrusion-set--0c7e22ad-b099-4dc3-b0df-2ea3f49ae2e6\",\n" +
    "    \"created\": \"2016-05-12T08:17:27.000Z\",\n" +
    "    \"modified\": \"2016-05-12T08:17:27.000Z\",\n" +
    "    \"name\": \"Adversary X\"\n" +
    "}";

    private final String intrusionSet_1 = "{\n" +
            "\n" +
            "  \"type\": \"intrusion-set\",\n" +
            "\n" +
            "  \"id\": \"intrusion-set--4e78f46f-a023-4e5f-bc24-71b3ca22ec29\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "  \"name\": \"Bobcat Breakin\",\n" +
            "\n" +
            "  \"description\": \"Incidents usually feature a shared TTP of a bobcat being released within the building containing network access, scaring users to leave their computers without locking them first. Still determining where the threat actors are getting the bobcats.\",\n" +
            "\n" +
            "  \"aliases\": [\"Zookeeper\"],\n" +
            "\n" +
            "  \"goals\": [\"acquisition-theft\", \"harassment\", \"damage\"]\n" +
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
        asBundleObject(intrusionSet_0);
        asBundleObject(intrusionSet_1);
    }

    @Test
    public void asIntrusionSet() throws IOException {
        asIntrusionSet(intrusionSet_0);
        asIntrusionSet(intrusionSet_1);
    }

    @Test
    public void deserializeAsIntrusionSetImpl() throws IOException {
        asIntrusionSetImpl(intrusionSet_0);
        asIntrusionSetImpl(intrusionSet_1);
    }

    private void asIntrusionSetImpl(String value) throws IOException {
        IntrusionSetImpl pattern = mapper.readValue(value, IntrusionSetImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asIntrusionSet(String value) throws IOException {
        IntrusionSet pattern = mapper.readValue(value, IntrusionSet.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
