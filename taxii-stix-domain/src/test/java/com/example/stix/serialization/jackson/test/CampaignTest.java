package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.Campaign;
import com.example.stix.impl.objects.CampaignImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CampaignTest {

    private final String campaign_0 =
            "    {\n" +
            "      \"type\": \"campaign\",\n" +
            "      \"id\": \"campaign--752c225d-d6f6-4456-9130-d9580fd4007b\",\n" +
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"object_marking_refs\": [\n" +
            "        \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\"\n" +
            "      ],\n" +
            "      \"name\": \"admin@338\",\n" +
            "      \"description\": \"Active since 2008, this campaign mostly targets the financial services industry, though we have also seen activity in the telecom, government, and defense sectors.\",\n" +
            "      \"first_seen\": \"2008-01-07T00:00:00.000Z\"\n" +
            "    }";

    private final String campaign_1 =
            "    {\n" +
            "      \"type\": \"campaign\",\n" +
            "      \"id\": \"campaign--d02a1560-ff69-49f4-ac34-919b8aa4b91e\",\n" +
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"object_marking_refs\": [\n" +
            "        \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\"\n" +
            "      ],\n" +
            "      \"name\": \"th3bug\",\n" +
            "      \"description\": \"This ongoing campaign targets a number of industries but appears to prefer targets in higher education and the healthcare sectors.\",\n" +
            "      \"first_seen\": \"2009-10-26T00:00:00.000Z\"\n" +
            "    }";

    private final String campaign_2 =
            "    {\n" +
            "      \"type\": \"campaign\",\n" +
            "      \"id\": \"campaign--721976f9-56d7-4749-8c69-b3ac7c315f05\",\n" +
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"object_marking_refs\": [\n" +
            "        \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\"\n" +
            "      ],\n" +
            "      \"name\": \"menuPass\",\n" +
            "      \"description\": \"The threat actor behind menuPass prefers to target U.S. and foreign defense contractors.\",\n" +
            "      \"first_seen\": \"2009-12-14T00:00:00.000Z\"\n" +
            "    }";

    private final String campaign_3 =
            "{\n" +
            "\n" +
            "  \"type\": \"campaign\",\n" +
            "\n" +
            "  \"id\": \"campaign--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "  \"created\": \"2016-04-06T20:03:00.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-04-06T20:03:00.000Z\",\n" +
            "\n" +
            "  \"name\": \"Green Group Attacks Against Finance\",\n" +
            "\n" +
            "  \"description\": \"Campaign by Green Group against a series of targets in the financial services sector.\"\n" +
            "\n" +
            "}";

    private final String campaign_4 = "{\n" +
            "\n" +
            "      \"type\": \"campaign\",\n" +
            "\n" +
            "      \"id\": \"campaign--83422c77-904c-4dc1-aff5-5c38f3a2c55c\",\n" +
            "\n" +
            "      \"created_by_ref\": \"identity--a463ffb3-1bd9-4d94-b02d-74e4f1658283\",\n" +
            "\n" +
            "      \"created\": \"2015-12-21T19:59:17.000Z\",\n" +
            "\n" +
            "      \"modified\": \"2016-05-21T19:59:17.000Z\",\n" +
            "\n" +
            "      \"name\": \"Some Campaign\"\n" +
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
        asBundleObject(campaign_0);
        asBundleObject(campaign_1);
        asBundleObject(campaign_2);
        asBundleObject(campaign_3);
        asBundleObject(campaign_4);
    }

    @Test
    public void asCampaign() throws IOException {
        asCampaign(campaign_0);
        asCampaign(campaign_1);
        asCampaign(campaign_2);
        asCampaign(campaign_3);
        asCampaign(campaign_4);
    }

    @Test
    public void deserializeAsCampaignImpl() throws IOException {
        asCampaignImpl(campaign_0);
        asCampaignImpl(campaign_1);
        asCampaignImpl(campaign_2);
        asCampaignImpl(campaign_3);
        asCampaignImpl(campaign_4);
    }

    private void asCampaignImpl(String value) throws IOException {
        CampaignImpl pattern = mapper.readValue(value, CampaignImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asCampaign(String value) throws IOException {
        Campaign pattern = mapper.readValue(value, Campaign.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }
}
