package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.Report;
import com.example.stix.impl.objects.ReportImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ReportTest {

    private final String report_0 = "{\n" +
            "\n" +
            "  \"type\": \"report\",  \n" +
            "\n" +
            "  \"id\": \"report--84e4d88f-44ea-4bcd-bbf3-b2c1c320bcb3\",\n" +
            "\n" +
            "  \"created_by_ref\": \"identity--a463ffb3-1bd9-4d94-b02d-74e4f1658283\",\n" +
            "\n" +
            "  \"created\": \"2015-12-21T19:59:11.000Z\",\n" +
            "\n" +
            "  \"modified\": \"2015-12-21T19:59:11.000Z\",\n" +
            "\n" +
            "  \"name\": \"The Black Vine Cyberespionage Group\",\n" +
            "\n" +
            "  \"description\": \"A simple report with an indicator and report\",\n" +
            "\n" +
            "  \"published\": \"2016-01-20T17:00:00.000Z\",\n" +
            "\n" +
            "  \"labels\": [\"report\"],\n" +
            "\n" +
            "  \"object_refs\": [\n" +
            "\n" +
            "    \"indicator--26ffb872-1dd9-446e-b6f5-d58527e5b5d2\",\n" +
            "\n" +
            "    \"report--83422c77-904c-4dc1-aff5-5c38f3a2c55c\",\n" +
            "\n" +
            "    \"relationship--f82356ae-fe6c-437c-9c24-6b64314ae68a\"\n" +
            "\n" +
            "  ]\n" +
            "\n" +
            "}";

    private final String report_1 = "{\n" +
            "\n" +
            "      \"type\": \"report\",  \n" +
            "\n" +
            "      \"id\": \"report--84e4d88f-44ea-4bcd-bbf3-b2c1c320bcbd\",\n" +
            "\n" +
            "      \"created_by_ref\": \"identity--a463ffb3-1bd9-4d94-b02d-74e4f1658283\",\n" +
            "\n" +
            "      \"created\": \"2015-12-21T19:59:11.000Z\",\n" +
            "\n" +
            "      \"modified\": \"2016-05-21T19:59:11.000Z\",\n" +
            "\n" +
            "      \"name\": \"The Black Vine Cyberespionage Group\",\n" +
            "\n" +
            "      \"description\": \"A simple report with an indicator and report\",\n" +
            "\n" +
            "      \"published\": \"2016-01-201T17:00:00Z\",\n" +
            "\n" +
            "      \"labels\": [\"report\"],\n" +
            "\n" +
            "      \"object_refs\": [\n" +
            "\n" +
            "        \"indicator--26ffb872-1dd9-446e-b6f5-d58527e5b5d2\",\n" +
            "\n" +
            "        \"report--83422c77-904c-4dc1-aff5-5c38f3a2c55c\",\n" +
            "\n" +
            "        \"relationship--f82356ae-fe6c-437c-9c24-6b64314ae68a\"\n" +
            "\n" +
            "      ]\n" +
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
        asBundleObject(report_0);
        asBundleObject(report_1); // should fail published is not accurate to three digit milliseconds
    }

    @Test
    public void asReport() throws IOException {
        asReport(report_0);
        asReport(report_1); // should fail published is not accurate to three digit milliseconds
    }

    @Test
    public void deserializeAsReportImpl() throws IOException {
        asReportImpl(report_0);
        asReportImpl(report_1); // should fail published is not accurate to three digit milliseconds
    }

    private void asReportImpl(String value) throws IOException {
        ReportImpl pattern = mapper.readValue(value, ReportImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asReport(String value) throws IOException {
        Report pattern = mapper.readValue(value, Report.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
