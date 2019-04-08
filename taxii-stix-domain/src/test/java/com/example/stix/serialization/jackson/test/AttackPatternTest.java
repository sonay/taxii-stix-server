package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.AttackPattern;
import com.example.stix.impl.objects.AttackPatternImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AttackPatternTest {

    private final String pattern_0 = "{\n" +
            "      \"type\": \"attack-pattern\",\n" +
            "      \"id\": \"attack-pattern--19da6e1c-69a8-4c2f-886d-d620d09d3b5a\",\n" +
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"object_marking_refs\": [\n" +
            "        \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\"\n" +
            "      ],\n" +
            "      \"external_references\": [\n" +
            "        {\n" +
            "          \"source_name\": \"capec\",\n" +
            "          \"description\": \"spear phishing\",\n" +
            "          \"external_id\": \"CAPEC-163\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"name\": \"Spear Phishing Attack Pattern used by admin@338\",\n" +
            "      \"description\": \"The preferred attack vector used by admin@338 is spear-phishing emails. Using content that is relevant to the target, these emails are designed to entice the target to open an attachment that contains the malicious PIVY server code.\",\n" +
            "      \"kill_chain_phases\": [\n" +
            "        {\n" +
            "          \"kill_chain_name\": \"mandiant-attack-lifecycle-model\",\n" +
            "          \"phase_name\": \"initial-compromise\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }";

    private final String pattern_1 = "{\n" +
            "      \"type\": \"attack-pattern\",\n" +
            "      \"id\": \"attack-pattern--ea2c747d-4aa3-4573-8853-37b7159bc180\",\n" +
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n" +
            "      \"object_marking_refs\": [\n" +
            "        \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\"\n" +
            "      ],\n" +
            "      \"name\": \"Strategic Web Compromise Attack Pattern used by th3bug\",\n" +
            "      \"description\": \"Attacks attributed to th3bug use a strategic Web compromise to infect targets. This approach is more indiscriminate, which probably accounts for the more disparate range of targets.\",\n" +
            "      \"kill_chain_phases\": [\n" +
            "        {\n" +
            "          \"kill_chain_name\": \"mandiant-attack-lifecycle-model\",\n" +
            "          \"phase_name\": \"initial-compromise\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }";

    private final String pattern_2 = "{\n"+
            "      \"type\": \"attack-pattern\",\n"+
            "      \"id\": \"attack-pattern--fb6aa549-c94a-4e45-b4fd-7e32602dad85\",\n"+
            "      \"created\": \"2015-05-15T09:00:00.000Z\",\n"+
            "      \"modified\": \"2015-05-15T09:00:00.000Z\",\n"+
            "      \"object_marking_refs\": [\n"+
            "        \"marking-definition--71f8e024-2c02-4350-a627-a71fa9de3437\"\n"+
            "      ],\n"+
            "      \"external_references\": [\n"+
            "        {\n"+
            "          \"source_name\": \"capec\",\n"+
            "          \"description\": \"spear phishing\",\n"+
            "          \"external_id\": \"CAPEC-163\"\n"+
            "        }\n"+
            "      ],\n"+
            "      \"name\": \"Spear Phishing Attack Pattern used by menuPass\",\n"+
            "      \"description\": \"menuPass appears to favor spear phishing to deliver payloads to the intended targets. While the attackers behind menuPass have used other RATs in their campaign, it appears that they use PIVY as their primary persistence mechanism.\",\n"+
            "      \"kill_chain_phases\": [\n"+
            "        {\n"+
            "          \"kill_chain_name\": \"mandiant-attack-lifecycle-model\",\n"+
            "          \"phase_name\": \"initial-compromise\"\n"+
            "        }\n"+
            "      ]\n"+
            "    }";

    private String pattern_3 = "{\n" +
            "\n" +
            "  \"type\": \"attack-pattern\",\n" +
            "\n" +
            "  \"id\": \"attack-pattern--0c7b5b88-8ff7-4a4d-aa9d-feb398cd0061\",\n" +
            "\n" +
            "  \"created\": \"2016-05-12T08:17:27.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2016-05-12T08:17:27.000Z\",\n" +
            "\n" +
            "  \"name\": \"Spear Phishing\",\n" +
            "\n" +
            "  \"description\": \"...\",\n" +
            "\n" +
            "  \"external_references\": [\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"source_name\": \"capec\",\n" +
            "\n" +
            "      \"external_id\": \"CAPEC-163\"\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "  ]\n" +
            "\n" +
            "}";

    private String pattern_4 = "{\n" +
            "\n" +
            "    \"type\": \"attack-pattern\",\n" +
            "\n" +
            "    \"id\": \"attack-pattern--7e33a43e-e34b-40ec-89da-36c9bb2cacd5\",\n" +
            "\n" +
            "    \"created\": \"2016-05-12T08:17:27.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-05-12T08:17:27.000Z\",\n" +
            "\n" +
            "    \"name\": \"Spear Phishing as Practiced by Adversary X\",\n" +
            "\n" +
            "    \"description\": \"A particular form of spear phishing where the attacker claims that the target had won a contest, including personal details, to get them to click on a link.\",\n" +
            "\n" +
            "    \"external_references\": [\n" +
            "\n" +
            "      {\n" +
            "\n" +
            "        \"source_name\": \"capec\",\n" +
            "\n" +
            "        \"id\": \"CAPEC-163\"\n" +
            "\n" +
            "      }\n" +
            "\n" +
            "    ]\n" +
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
        asBundleObject(pattern_0);
        asBundleObject(pattern_1);
        asBundleObject(pattern_2);
        asBundleObject(pattern_3);
        asBundleObject(pattern_4); // should fail id instead of external_id
    }

    @Test
    public void asAttackPattern() throws IOException {
        asAttackPattern(pattern_0);
        asAttackPattern(pattern_1);
        asAttackPattern(pattern_2);
        asAttackPattern(pattern_3);
        asAttackPattern(pattern_4); // should fail id instead of external_id
    }

    @Test
    public void deserializeAsAttackPatternImpl() throws IOException {
        asAttackPatternImpl(pattern_0);
        asAttackPatternImpl(pattern_1);
        asAttackPatternImpl(pattern_2);
        asAttackPatternImpl(pattern_3);
        asAttackPatternImpl(pattern_4); // should fail id instead of external_id
    }

    private void asAttackPatternImpl(String value) throws IOException {
        AttackPatternImpl pattern = mapper.readValue(value, AttackPatternImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asAttackPattern(String value) throws IOException {
        AttackPattern pattern = mapper.readValue(value, AttackPattern.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
