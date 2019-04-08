package com.example.stix.api.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.KillChainPhase;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Type Name: indicator
*
* Indicators contain a pattern that can be used to detect suspicious or malicious cyber activity. For example, an
* Indicator may be used to represent a set of malicious domains and use the STIX Patterning Language (STIX™ Version 2.0.
* Part 5: STIX Patterning) to specify these domains.
*
* The Indicator SDO contains a simple textual description, the Kill Chain Phases that it detects behavior in, a time
* window for when the Indicator is valid or useful, and a required pattern property to capture a structured detection
* pattern. Conforming STIX implementations MUST support the STIX Patterning Language as defined in STIX™ Version 2.0.
* Part 5: STIX Patterning. While each structured pattern language has different syntax and potentially different
* semantics, in general an Indicator is considered to have "matched" (or been "sighted") when the conditions specified
* in the structured pattern are satisfied in whatever context they are evaluated in.
*
* Relationships from the Indicator can describe the malicious or suspicious behavior that it directly detects
* (Malware, Tool, and Attack Pattern) as well as the Campaigns, Intrusion Sets, and Threat Actors that it might indicate
* the presence of.
* */
public interface Indicator extends StixDomainObject {

    /*
    * The value of this property MUST be "indicator".
    *
    * REQUIRED
    * */
    String TYPE = "indicator";

    @Override
    default StixType getType() {
        return StixType.INDICATOR;
    }


    /*
     * The detection pattern for this Indicator is a STIX Pattern as specified in STIX™ Version 2.0. Part 5: STIX
     * Patterning.
     *
     * REQUIRED
     * */
    String PATTERN_PROPERTY = "pattern";

    String getPattern();


    /*
     * The time from which this Indicator should be considered valuable intelligence.
     *
     * REQUIRED
     * */
    String VALID_FROM_PROPERTY = "valid_from";

    ZonedDateTime getValidFrom();


    /*
    * This property is an Open Vocabulary that specifies the type of indicator.
    *
    * This is an open vocabulary and values SHOULD come from the indicator-label-ov vocabulary.
    *
    * REQUIRED
    * */
    String LABELS_PROPERTY = "labels";

    @Override
    List<String> getLabels();


    /*
    * A name used to identify the Indicator.
    *
    * OPTIONAL
    * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
    * A description that provides more details and context about the Indicator, potentially including its purpose
    * and its key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * The time at which this Indicator should no longer be considered valuable intelligence.
    * If the valid_until property is omitted, then there is no constraint on the latest time for which the Indicator
    * should be used.
    *
    * OPTIONAL
    * */
    String VALID_UNTIL_PROPERTY = "valid_until";

    ZonedDateTime getValidUntil();


    /*
    * The kill chain phase(s) to which this Indicator corresponds.
    *
    * OPTIONAL
    * */
    String KILL_CHAIN_PHASES_PROPERTY = "kill_chain_phases";

    List<KillChainPhase> getKillChainPhases();

}
