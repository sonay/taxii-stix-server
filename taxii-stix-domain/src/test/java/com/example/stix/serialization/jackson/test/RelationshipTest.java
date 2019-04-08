package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.impl.relationships.RelationshipImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class RelationshipTest {

    private final String relationship_0 = "{\n" +
            "\n" +
            "    \"type\": \"relationship\",\n" +
            "\n" +
            "    \"id\": \"relationship--57b56a43-b8b0-4cba-9deb-34e3e1faed9e\",\n" +
            "\n" +
            "    \"created\": \"2016-05-12T08:17:27.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-05-12T08:17:27.000Z\",\n" +
            "\n" +
            "    \"relationship_type\": \"uses\",\n" +
            "\n" +
            "    \"source_ref\": \"intrusion-set--0c7e22ad-b099-4dc3-b0df-2ea3f49ae2e6\",\n" +
            "\n" +
            "    \"target_ref\": \"attack-pattern--7e33a43e-e34b-40ec-89da-36c9bb2cacd5\"\n" +
            "\n" +
            "  }";

    private final String relationship_1 = "{\n" +
            "\n" +
            "      \"type\": \"relationship\",\n" +
            "\n" +
            "      \"id\": \"relationship--f82356ae-fe6c-437c-9c24-6b64314ae68a\",\n" +
            "\n" +
            "      \"created_by_ref\": \"identity--a463ffb3-1bd9-4d94-b02d-74e4f1658283\",\n" +
            "\n" +
            "      \"created\": \"2015-12-21T19:59:17.000Z\",\n" +
            "\n" +
            "      \"modified\": \"2015-12-21T19:59:17.000Z\",\n" +
            "\n" +
            "      \"source_ref\": \"indicator--26ffb872-1dd9-446e-b6f5-d58527e5b5d2\",\n" +
            "\n" +
            "      \"target_ref\": \"relationship--26ffb872-1dd9-446e-b6f5-d58527e5b5d2\",\n" +
            "\n" +
            "      \"relationship_type\": \"indicates\"\n" +
            "\n" +
            "    }";


    private final String relationship_2 =
            " {\n" +
            "\n" +
            "    \"type\": \"relationship\",\n" +
            "\n" +
            "    \"id\": \"relationship--44298a74-ba52-4f0c-87a3-1824e67d7fad\",\n" +
            "\n" +
            "    \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "    \"created\": \"2016-04-06T20:06:37.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-04-06T20:06:37.000Z\",\n" +
            "\n" +
            "    \"relationship_type\": \"indicates\",\n" +
            "\n" +
            "    \"source_ref\": \"indicator--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "    \"target_ref\": \"malware--31b940d4-6f7f-459a-80ea-9c1f17b5891b\"\n" +
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
        asBundleObject(relationship_0);
        asBundleObject(relationship_1);
        asBundleObject(relationship_2);
    }

    @Test
    public void asRelationship() throws IOException {
        asRelationship(relationship_0);
        asRelationship(relationship_1);
        asRelationship(relationship_2);
    }

    @Test
    public void deserializeAsRelationshipImpl() throws IOException {
        asRelationshipImpl(relationship_0);
        asRelationshipImpl(relationship_1);
        asRelationshipImpl(relationship_2);
    }

    private void asRelationshipImpl(String value) throws IOException {
        RelationshipImpl pattern = mapper.readValue(value, RelationshipImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asRelationship(String value) throws IOException {
        Relationship pattern = mapper.readValue(value, Relationship.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
