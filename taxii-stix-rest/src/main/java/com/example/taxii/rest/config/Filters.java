package com.example.taxii.rest.config;

import com.example.taxii.rest.filters.CustomTimestampHeadersFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Filters {

    @Bean
    FilterRegistrationBean<CustomTimestampHeadersFilter> customHeaders() {
        FilterRegistrationBean<CustomTimestampHeadersFilter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new CustomTimestampHeadersFilter());
        filterRegistration.addUrlPatterns("/roots/*");
        return filterRegistration;
    }

}
