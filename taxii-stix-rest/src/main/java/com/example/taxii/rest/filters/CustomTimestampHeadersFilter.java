package com.example.taxii.rest.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.taxii.rest.api.CustomHeaders.X_TAXII_DATE_ADDED_FIRST;
import static com.example.taxii.rest.api.CustomHeaders.X_TAXII_DATE_ADDED_LAST;


public class CustomTimestampHeadersFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomTimestampHeadersFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        // We are looking for /roots/<root>/collections/<collection-id>/objects
        // or /roots/<root>/collections/<collection-id>/manifest
        if (uri != null) {
            String[] parts = uri.split("/");
            if (parts.length == 4
                    && "collections".equals(parts[1])
                    && (("objects").equals(parts[3]) || "manifest".equals(parts[3]))) {

                HttpServletResponse res = (HttpServletResponse) response;
                String firstAdded = res.getHeader(X_TAXII_DATE_ADDED_FIRST);
                if (firstAdded == null) {
                    LOGGER.warn("Missing header: {}", X_TAXII_DATE_ADDED_FIRST);
                }
                String lastAdded = res.getHeader(X_TAXII_DATE_ADDED_LAST);
                if (lastAdded == null) {
                    LOGGER.warn("Missing header: {}", X_TAXII_DATE_ADDED_LAST);
                }
            }
        }
        chain.doFilter(request, response);
    }

}
