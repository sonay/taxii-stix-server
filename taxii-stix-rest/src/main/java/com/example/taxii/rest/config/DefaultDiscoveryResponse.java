package com.example.taxii.rest.config;

import com.example.taxii.rest.api.datatypes.DiscoveryResource;
import com.example.taxii.rest.impl.objects.DiscoveryResourceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DefaultDiscoveryResponse {

    @Bean
    DiscoveryResource defaultDiscovery() {
        return new DiscoveryResourceImpl(
                "Some TAXII Server",
                "This TAXII Server contains a listing of...",
                "string containing contact information",
                "https://example.com/api2/",
                Arrays.asList(
                    "https://example.com/api1/",
                    "https://example.com/api2/",
                    "https://example.net/trustgroup1/"));
    }

}
