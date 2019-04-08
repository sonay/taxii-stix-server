package com.example.stix.serialization.jackson.test;

import com.example.stix.api.BundleObject;
import com.example.stix.api.objects.CourseOfAction;
import com.example.stix.impl.objects.CourseOfActionImpl;
import com.example.stix.serialization.jackson.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CourseOfActionTest {

    private final String courseOfAction_0 = "{\n" +
            "\n" +
            "    \"type\": \"course-of-action\",\n" +
            "\n" +
            "    \"id\": \"course-of-action--8e2e2d2b-17d4-4cbf-938f-98ee46b3cd3f\",\n" +
            "\n" +
            "    \"created_by_ref\": \"identity--f431f809-377b-45e0-aa1c-6a4751cae5ff\",\n" +
            "\n" +
            "    \"created\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "    \"modified\": \"2016-04-06T20:03:48.000Z\",\n" +
            "\n" +
            "    \"name\": \"Add TCP port 80 Filter Rule to the existing Block UDP 1434 Filter\",\n" +
            "\n" +
            "    \"description\": \"This is how to add a filter rule to block inbound access to TCP port 80 to the existing UDP 1434 filter ...\"\n" +
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
        asBundleObject(courseOfAction_0);
    }

    @Test
    public void asCourseOfAction() throws IOException {
        asCourseOfAction(courseOfAction_0);
    }

    @Test
    public void deserializeAsCourseOfActionImpl() throws IOException {
        asCourseOfActionImpl(courseOfAction_0);
    }

    private void asCourseOfActionImpl(String value) throws IOException {
        CourseOfActionImpl pattern = mapper.readValue(value, CourseOfActionImpl.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asCourseOfAction(String value) throws IOException {
        CourseOfAction pattern = mapper.readValue(value, CourseOfAction.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

    private void asBundleObject(String value) throws IOException {
        BundleObject pattern = mapper.readValue(value, BundleObject.class);
        String serialized = mapper.writeValueAsString(pattern);
        Assert.assertTrue(DiffenceChecker.areEqual(mapper, value, serialized));
    }

}
