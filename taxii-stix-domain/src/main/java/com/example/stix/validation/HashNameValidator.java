package com.example.stix.validation;

import com.example.stix.api.vocabularies.HashingAlgorithmVocabulary;

import java.util.regex.Pattern;

// TODO: plug this into checks
public class HashNameValidator {

    private static final Pattern ALGORITHM_NAME_PATTERN = Pattern.compile("([A-Z]|[a-z]|[0-9]-_)+");

    public void validate(String algorithm) {
        if (algorithm.length() < 3) {
            throw new IllegalArgumentException(
                    "algorithm: '" + algorithm + "' is shorter than allowed value (3 " +
                            "characters).");
        }
        if (algorithm.length() > 256) {
            throw new IllegalArgumentException(
                    "algorithm: '" + algorithm + "' is longer than maximum length allowed (256 characters).");
        }
        if (!ALGORITHM_NAME_PATTERN.matcher(algorithm).matches()) {
            throw new IllegalArgumentException(
                    "algorithm: '" + algorithm + "' does not conform to naming rules.");
        }
        // TODO: should we allow non-standard values?
        if (!HashingAlgorithmVocabulary.isStandard(algorithm)
                && !algorithm.startsWith("x_")) {
            throw new IllegalArgumentException(
                    "algorithm: '" + algorithm
                            + "' is not a standard hash algorithm and does not conform to custom hashing naming standard." );
        }
    }

}
