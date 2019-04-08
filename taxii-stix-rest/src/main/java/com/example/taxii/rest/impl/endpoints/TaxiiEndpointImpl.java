package com.example.taxii.rest.impl.endpoints;

import com.example.taxii.rest.api.datatypes.DiscoveryResource;
import com.example.taxii.rest.api.endpoints.TaxiiEndpoint;
import com.example.taxii.rest.impl.objects.DiscoveryResourceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/taxii", produces = "application/json")
public class TaxiiEndpointImpl implements TaxiiEndpoint {
    @Override
    public DiscoveryResource serverDiscovery() {
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
