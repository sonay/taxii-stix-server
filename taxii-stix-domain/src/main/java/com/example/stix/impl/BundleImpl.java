package com.example.stix.impl;

import com.example.stix.api.Bundle;
import com.example.stix.api.BundleObject;
import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;
import lombok.Data;

import java.util.List;

@Data
public class BundleImpl implements Bundle {

    private final StixType type;

    private final List<BundleObject> objects;

    private final Identifier id;

    private final String specVersion;

    public BundleImpl(StixType type, Identifier id, String specVersion, List<BundleObject> objects) {
        this.type = type;
        this.id = id;
        this.specVersion = specVersion;
        this.objects = objects;
    }

    @Override
    public StixType getType() {
        return Bundle.super.getType();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public String getSpecVersion() {
        return specVersion;
    }

    @Override
    public List<BundleObject> getObjects() {
        return objects;
    }

}
