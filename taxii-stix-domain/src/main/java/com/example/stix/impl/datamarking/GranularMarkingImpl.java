package com.example.stix.impl.datamarking;

import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.Identifier;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class GranularMarkingImpl implements GranularMarking {

    private final Identifier identifier;

    private final List<String> selectors;

    public GranularMarkingImpl(Identifier identifier, List<String> selectors) {
        // TODO: test this class
        this.identifier = Objects.requireNonNull(identifier, "identifier");
        this.selectors = Objects.requireNonNull(selectors, "selectors");
    }

    // REQUIRED PROPERTIES

    @Override
    public Identifier getMarkingRef() {
        return identifier;
    }

    @Override
    public List<String> getSelectors() {
        return selectors;
    }

}
