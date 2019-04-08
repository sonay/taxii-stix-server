package com.example.stix.impl.datatypes;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class IdentifierImpl implements Identifier {

    private final StixType type;

    private final UUID id;

    public IdentifierImpl(StixType type, UUID id) {
        this.type = type;
        this.id = id;
    }

    // REQUIRED PROPERTIES

    @Override
    public StixType getType() {
        return type;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getSerializedId() {
        return toString();
    }

    /* This is used by serializedId() for STIX specification DO NOT change it*/
    @Override
    public String toString() {
        return type + "--" + id;
    }

    public static Identifier from(String serializedId) {
        int ind = serializedId.indexOf("--");
        if (ind == -1) {
            // TODO: throw a more sensible exception
            throw new IllegalArgumentException();
        }
        StixType type = StixType.from(serializedId.substring(0, ind));
        // TODO: throw a more sensible exception
        UUID id = UUID.fromString(serializedId.substring(ind + 2));
        return new IdentifierImpl(type, id);
    }

}
