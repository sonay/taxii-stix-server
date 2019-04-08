package com.example.stix.api.vocabularies;

import com.example.stix.api.datatypes.OpenVocabulary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: identity-class-ov
*
* The identity class vocabulary is currently used in the following SDO(s):
*
*   Identity
*
* This vocabulary describes the type of entity that the Identity represents: whether it describes an organization,
* group, individual, or class.
* */
public interface IdentityClassVocabulary extends OpenVocabulary {

    /*
     * A single person.
     */
    String INDIVIDUAL = "individual";

    /*
     * An informal collection of people, without formal governance, such as a distributed hacker group.
     */
    String GROUP = "group";

    /*
     * A formal organization of people, with governance, such as a company or country.
     */
    String ORGANIZATION = "organization";

    /*
     * A class of entities, such as all hospitals, all Europeans, or the Domain Administrators in a system.
     */
    String CLASS = "class";

    /*
     * It is unknown whether the classification is individual, group, organization, or class.
     */
    String UNKNOWN = "unknown";

    Set<String> IDENTITY_CLASS_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(INDIVIDUAL, GROUP,
                    IdentityClassVocabulary.ORGANIZATION, CLASS, UNKNOWN)));

    static boolean isStandard(String value) {
        return IDENTITY_CLASS_OPEN_VOCABULARY.contains(value);
    }

}
