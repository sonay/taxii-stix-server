package com.example.stix.validation;

import com.example.stix.api.datatypes.Identifier;

import java.util.*;

public class ValidationReport implements ValidationStrategy {

    private Identifier id;

    private List<String> constraintErrors = new ArrayList<>();

    private Map<String, List<String>> propertyErrors = new HashMap<>();

    private List<String> warnings = new ArrayList<>();

    private Map<String, List<String>> propertyWarnings = new HashMap<>();

    ValidationReport() {
        this(null);
    }

    ValidationReport(Identifier id) {
        this.id = id;
    }

    // MUTATORS

    public void onConstraintError(String error) {
        constraintErrors.add(error);
    }

    public void onPropertyError(String property, String error) {
        propertyErrors.computeIfAbsent(property, p -> new ArrayList<>()).add(error);
    }

    public void onConstraintWarning(String warning) {
        warnings.add(warning);
    }

    public void onPropertyWarning(String property, String warning) {
        propertyWarnings.computeIfAbsent(property,
            p -> new ArrayList<>()).add(warning);
    }

    // QUERIES

    public boolean hasErrors() {
        return hasConstraintErrors() || hasPropertyErrors();
    }

    public boolean hasConstraintErrors() {
        return !constraintErrors.isEmpty();
    }

    public boolean hasPropertyErrors() {
        return !propertyErrors.isEmpty();
    }

    public List<String> getConstraintErrors() {
        return Collections.unmodifiableList(constraintErrors);
    }

    public Map<String, List<String>> getPropertyErrors() {
        return Collections.unmodifiableMap(propertyErrors);
    }

    public Map<String, List<String>> getPropertyWarnings() {
        return Collections.unmodifiableMap(propertyWarnings);
    }

    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

}
