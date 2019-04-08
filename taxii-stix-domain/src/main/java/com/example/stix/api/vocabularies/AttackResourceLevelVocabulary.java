package com.example.stix.api.vocabularies;

import com.example.stix.api.datatypes.OpenVocabulary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: attack-resource-level-ov
*
* The attack resource level vocabulary is currently used in the following SDO(s):
*
*    Intrusion Set
*    Threat Actor
*
* Attack Resource Level is an open vocabulary that captures the general level of resources that a threat actor,
* intrusion set, or campaign might have access to. It ranges from individual, a person acting alone, to government,
* the resources of a national government.
*
* This section including vocabulary items and their descriptions is based on the Threat Agent Library publication from
* Intel Corp in September 2007 [Casey 2007].
* */
public interface AttackResourceLevelVocabulary extends OpenVocabulary {

    /*
    * Resources limited to the average individual; Threat Actor acts independently.
    */
    String INDIVIDUAL = "individual";

    /*
    * Members interact on a social and volunteer basis, often with little personal interest in the specific target.
    * An example might be a core group of unrelated activists who regularly exchange tips on a particular blog.
    * Group persists long term.
    * */
    String CLUB = "club";

    /*
    * A short-lived and perhaps anonymous interaction that concludes when the participants have achieved a single
    * goal. For example, people who break into systems just for thrills or prestige may hold a contest to see who
    * can break into a specific target first. It also includes announced "operations" to achieve a specific goal,
    * such as the original "OpIsrael" call for volunteers to disrupt all of Israel's Internet functions for a day.
    * */
    String CONTEST = "contest";

    /*
    * A formally organized group with a leader, typically motivated by a specific goal and organized around that goal.
    * Group persists long term and typically operates within a single geography.
    * */
    String TEAM = "team";

    /*
    * Larger and better resourced than a team; typically a company or crime syndicate. Usually operates in multiple
    * geographic areas and persists long term.
    * */
    String ORGANIZATION = "organization";

    /*
    * Controls public assets and functions within a jurisdiction; very well resourced and persists long term.
    * */
    String GOVERNMENT = "government";

    Set<String> ATTACK_RESOURCE_LEVEL_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(AttackResourceLevelVocabulary.INDIVIDUAL, CLUB, CONTEST, TEAM,
                    AttackResourceLevelVocabulary.ORGANIZATION, GOVERNMENT)));

    static boolean isStandard(String value) {
        return ATTACK_RESOURCE_LEVEL_OPEN_VOCABULARY.contains(value);
    }
}
