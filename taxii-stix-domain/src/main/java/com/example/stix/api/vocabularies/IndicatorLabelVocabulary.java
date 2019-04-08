package com.example.stix.api.vocabularies;

import com.example.stix.api.datatypes.OpenVocabulary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: indicator-label-ov
*
* The indicator label vocabulary is currently used in the following SDO(s):
*
*   Indicator
*
* Indicator labels is an open vocabulary used to categorize Indicators. It is intended to be high-level to promote
* consistent practices. Indicator labels should not be used to capture information that can be better captured via
* related Malware or Attack Pattern datatypes. It is better to link an Indicator to a Malware object describing Poison
* Ivy rather than simply labeling it with "poison-ivy".
* */
public interface IndicatorLabelVocabulary extends OpenVocabulary {

    /*
    * Unexpected, or unusual activity that may not necessarily be malicious or indicate compromise. This type of
    * activity may include reconnaissance-like behavior such as port scans or version identification, network
    * behavior anomalies, and asset and/or user behavioral anomalies.
    * */
    String ANOMALOUS_ACTIVITY = "anomalous-activity";

    /*
     * Suspected anonymization tools or infrastructure (proxy, TOR, VPN, etc.).
     * */
    String ANONYMIZATION = "anonymization";

    /*
     * Activity that is not suspicious or malicious in and of itself, but when combined with other activity may
     * indicate suspicious or malicious behavior.
     * */
    String BENIGN = "benign";

    /*
     * Assets that are suspected to be compromised.
     * */
    String COMPROMISED = "compromised";

    /*
     * Patterns of suspected malicious datatypes and/or activity.
     * */
    String MALICIOUS_ACTIVITY = "malicious-activity";

    /*
     * Patterns of behavior that indicate attribution to a particular Threat Actor or Campaign.
     * */
    String ATTRIBUTION = "attribution";

    Set<String> INDICATOR_LABEL_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(ANOMALOUS_ACTIVITY, ANONYMIZATION, BENIGN, COMPROMISED,
                    MALICIOUS_ACTIVITY, ATTRIBUTION)));

    static boolean isStandard(String value) {
        return INDICATOR_LABEL_OPEN_VOCABULARY.contains(value);
    }

}
