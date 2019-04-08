package com.example.stix.impl.datamarking;

import com.example.stix.api.datamarking.StatementMarkingObject;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class StatementMarkingObjectImpl implements StatementMarkingObject {

    private final String statement;

    public StatementMarkingObjectImpl(String statement) {
        this.statement = Objects.requireNonNull(statement);
    }

    @Override
    public String getStatement() {
        return statement;
    }

}
