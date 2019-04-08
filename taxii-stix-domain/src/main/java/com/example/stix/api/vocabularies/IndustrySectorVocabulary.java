package com.example.stix.api.vocabularies;

import com.example.stix.api.datatypes.OpenVocabulary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: industry-sector-ov
*
* The industry sector vocabulary is currently used in the following SDO(s):
*
*    Identity
*
* Industry sector is an open vocabulary that describes industrial and commercial sectors. It is intended to be
* holistic; it has been derived from several other lists and is not limited to "critical infrastructure" sectors.
* */
public interface IndustrySectorVocabulary extends OpenVocabulary {

    /**/
    String AGRICULTURE = "agriculture";

    /**/
    String AEROSPACE = "aerospace";

    /**/
    String AUTOMOTIVE = "automotive";

    /**/
    String COMMUNICATIONS = "communications";

    /**/
    String CONSTRUCTION = "construction";

    /**/
    String DEFENCE = "defence";

    /**/
    String EDUCATION = "education";

    /**/
    String ENERGY = "energy";

    /**/
    String ENTERTAINMENT = "entertainment";

    /**/
    String FINANCIAL_SERVICES = "financial-services";

    /**/
    String GOVERNMENT_NATIONAL = "government-national";

    /**/
    String GOVERNMENT_REGIONAL = "government-regional";

    /**/
    String GOVERNMENT_LOCAL = "government-local";

    /**/
    String GOVERNMENT_PUBLIC_SERVICES = "government-public-services";

    /**/
    String HEALTHCARE = "healthcare";

    /**/
    String HOSPITALITY_LEISURE = "hospitality-leisure";

    /**/
    String INFRASTRUCTURE = "infrastructure";

    /**/
    String INSURANCE = "insurance";

    /**/
    String MANUFACTURING = "manufacturing";

    /**/
    String MINING = "mining";

    /**/
    String NON_PROFIT = "non-profit";

    /**/
    String PHARMACEUTICALS = "pharmaceuticals";

    /**/
    String RETAIL = "retail";

    /**/
    String TECHNOLOGY = "technology";

    /**/
    String TELECOMMUNICATIONS = "telecommunications";

    /**/
    String TRANSPORTATION = "transportation";

    /**/
    String UTILITIES = "utilities";

    Set<String> INDUSTRY_SECTOR_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(AGRICULTURE, AEROSPACE, AUTOMOTIVE, COMMUNICATIONS,
                    CONSTRUCTION, DEFENCE, EDUCATION, ENERGY, ENTERTAINMENT, FINANCIAL_SERVICES, GOVERNMENT_NATIONAL,
                    GOVERNMENT_REGIONAL, GOVERNMENT_LOCAL, GOVERNMENT_PUBLIC_SERVICES, HEALTHCARE,
                    HOSPITALITY_LEISURE, INFRASTRUCTURE, INSURANCE, MANUFACTURING, MINING, NON_PROFIT,
                    PHARMACEUTICALS, RETAIL, TECHNOLOGY, TELECOMMUNICATIONS, TRANSPORTATION, UTILITIES
            )));

    static boolean isStandard(String value) {
        return INDUSTRY_SECTOR_OPEN_VOCABULARY.contains(value);
    }

}
