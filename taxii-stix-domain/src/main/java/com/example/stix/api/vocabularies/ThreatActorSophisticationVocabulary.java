package com.example.stix.api.vocabularies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: threat-actor-sophistication-ov
*
* Threat actor sophistication vocabulary is currently used in the following SDO(s):
*
*    Threat Actor
*
* Threat actor sophistication vocabulary captures the skill level of a threat actor. It ranges from "none", which
* describes a complete novice, to "strategic", which describes an attacker who is able to influence supply chains to
* introduce vulnerabilities. This vocabulary is separate from resource level because an innovative, highly-skilled
* threat actor may have access to very few resources while a minimal-level actor might have the resources of an
* organized crime ring.
* */
public interface ThreatActorSophisticationVocabulary {

    /*
     * Can carry out random acts of disruption or destruction by running tools they do not understand. Actors in this
     * category have average computer skills.
     *
     * Example Roles: Average User
     *
     * These actors:
     *      can not launch targeted attacks
     */
    String NONE = "none";

    /*
     * Can minimally use existing and frequently well known and easy-to-find techniques and programs or scripts to
     * search for and exploit weaknesses in other computers. Commonly referred to as a script-kiddie.
     *
     * These actors rely on others to develop the malicious tools, delivery mechanisms, and execution strategy and
     * often do not fully understand the tool they are using or how they work. They also lack the ability to conduct
     * their own reconnaissance and targeting research.
     *
     * Example Roles: Script-Kiddie
     *
     * These actors:
     *      attack known weaknesses;
     *      use well known scripts and tools; and
     *      have minimal knowledge of the tools.
     */
    String MINIMAL = "minimal";

    /*
     * Can proficiently use existing attack frameworks and toolkits to search for and exploit vulnerabilities in
     * computers or systems. Actors in this category have computer skills equivalent to an IT professional and
     * typically have a working knowledge of networks, operating systems, and possibly even defensive techniques and
     * will typically exhibit some operational security.
     *
     * These actors rely others to develop the malicious tools and delivery mechanisms, but are able to plan their own
     * execution strategy. They are proficient in the tools they are using and how they work and can even make minimal
     * modifications as needed.
     *
     * Example Roles: Toolkit User
     *
     * These actors:
     *      attack known vulnerabilities;
     *      use attack frameworks and toolkits; and
     *      have proficient knowledge of the tools.
     */
    String INTERMEDIATE = "intermediate";

    /*
     * Can develop their own tools or scripts from publicly known vulnerabilities to target systems and users.
     * Actors in this category are very adept at IT systems and have a background in software development along with
     * a solid understanding of defensive techniques and operational security.
     *
     * These actors rely on others to find and identify weaknesses and vulnerabilities in systems, but are able to
     * create their own tools, delivery mechanisms, and execution strategies.
     *
     * Example Roles: Toolkit Developer
     *
     * These actors:
     *      attack known vulnerabilities;
     *      can create their own tools; and
     *      have proficient knowledge of the tools.
     */
    String ADVANCED = "advanced";

    /*
     * Can focus on the discovery and use of unknown malicious code, are is adept at installing user and kernel mode
     * rootkits, frequently use data mining tools, target corporate executives and key users (government and
     * industry) for the purpose of stealing personal and corporate data. Actors in this category are very adept at
     * IT systems and software development and are experts with security systems, defensive techniques, attack
     * methods, and operational security.
     *
     * Example Roles: Vulnerability Researcher, Reverse Engineer, Threat Researcher, Malware Creator
     *
     * These actors:
     *      attack unknown and known vulnerabilities;
     *      can create their own tools from scratch; and
     *      have proficient knowledge of the tools.
     */
    String EXPERT = "expert";

    /*
     * Typically criminal or state actors who are organized, highly technical, proficient, well-funded professionals
     * working in teams to discover new vulnerabilities and develop exploits.
     *
     * Demonstrates sophisticated capability. An innovator has the ability to create and script unique programs and
     * codes targeting virtually any form of technology. At this level, this actor has a deep knowledge of networks,
     * operating systems, programming languages, firmware, and infrastructure topologies and will demonstrate
     * operational security when conducting his activities. Innovators are largely responsible for the discovery of
     * 0-day vulnerabilities and the development of new attack techniques.
     *
     * Example Roles: Toolkit Innovator, 0-Day Exploit Author
     *
     * These actors:
     *      attack unknown and known vulnerabilities;
     *      create attacks against 0-Day exploits from scratch; and
     *      create new and innovative attacks and toolkits.
     */
    String INNOVATOR = "innovator";

    /*
     * State actors who create vulnerabilities through an active program to “influence” commercial products and
     * services during design, development or manufacturing, or with the ability to impact products while in the
     * supply chain to enable exploitation of networks and systems of interest.
     *
     * These actors:
     *      can create or use entire supply chains to launch an attack;
     *      can create and design attacks for any systems, software package, or device; and
     *      are responsible for APT-level attacks.
     */
    String STRATEGIC = "strategic";

    Set<String> THREAT_ACTOR_SOPHISTICATION_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(NONE, MINIMAL, INTERMEDIATE, ADVANCED, EXPERT, INNOVATOR,
                    STRATEGIC)));

    static boolean isStandard(String value) {
        return THREAT_ACTOR_SOPHISTICATION_OPEN_VOCABULARY.contains(value);
    }

}
