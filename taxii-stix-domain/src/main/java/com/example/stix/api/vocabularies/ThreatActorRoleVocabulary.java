package com.example.stix.api.vocabularies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: threat-actor-role-ov
*
* The threat actor role vocabulary is currently used in the following SDO(s):
*
*    Threat Actor
*
* Threat actor role is an open vocabulary that is used to describe the different roles that a threat actor can play.
* For example, some threat actors author malware or operate botnets while other actors actually carry out attacks
* directly.
*
* Threat actor roles are not mutually exclusive. For example, an actor can be both a financial backer for attacks and
* also direct attacks.
* */
public interface ThreatActorRoleVocabulary {

    /*
     * Threat actor executes attacks either on behalf of themselves or at the direction of someone else.
     * */
    String AGENT = "agent";

    /*
     * The threat actor who directs the activities, goals, and objectives of the malicious activities.
     * */
    String DIRECTOR = "director";

    /*
     * A threat actor acting by themselves.
     * */
    String INDEPENDENT = "independent";

    /*
     * Someone who designs the battle space.
     * */
    String INFRASTRUCTURE_ARCHITECT = "infrastructure-architect";

    /*
     * The threat actor who provides and supports the attack infrastructure that is used to deliver the attack
     * (botnet providers, cloud services, etc.).
     * */
    String INFRASTRUCTE_OPERATOR = "infrastructure-operator";

    /*
     * The threat actor who authors malware or other malicious tools.
     * */
    String MALWARE_AUTHOR = "malware-author";

    /*
     * The threat actor who funds the malicious activities.
     * */
    String AUTHOR = "author";

    Set<String> THREAT_ACTOR_ROLE_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(AGENT, DIRECTOR, INDEPENDENT, INFRASTRUCTURE_ARCHITECT,
                    INFRASTRUCTE_OPERATOR, MALWARE_AUTHOR, AUTHOR)));

    static boolean isStandard(String value) {
        return THREAT_ACTOR_ROLE_OPEN_VOCABULARY.contains(value);
    }

}
