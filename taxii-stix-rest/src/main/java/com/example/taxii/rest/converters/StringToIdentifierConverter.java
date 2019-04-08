package com.example.taxii.rest.converters;

import com.example.stix.api.datatypes.Identifier;
import com.example.stix.impl.datatypes.IdentifierImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIdentifierConverter implements Converter<String, Identifier> {

    @Override
    public Identifier convert(String serializedId) {
        return IdentifierImpl.from(serializedId);
    }

}
