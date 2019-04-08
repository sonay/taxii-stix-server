package com.example.stix.api.vocabularies;

import com.example.stix.api.datatypes.OpenVocabulary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: threat-actor-label-ov
*
* The threat actor label vocabulary is currently used in the following SDO(s):
*
*    Threat Actor
*
* Threat actor label is an open vocabulary used to describe what type of threat actor the individual or group is. For
* example, some threat actors are competitors who try to steal information, while others are activists who act in
* support of a social or political cause. Actor labels are not mutually exclusive: a threat actor can be both a
* disgruntled insider and a spy. [Casey 2007])
* */
public interface ThreatActorLabelVocabulary extends OpenVocabulary {

    /*
    * Highly motivated, potentially destructive supporter of a social or political cause (e.g., trade, labor,
    * environment, etc.) that attempts to disrupt an organization's business model or damage their image.
    *
    * This category includes actors sometimes referred to as anarchists, cyber vandals, extremists, and hacktivists.
    * */
    String ACTIVIST = "activist";

    /*
    * An organization that competes in the same economic marketplace.
    *
    * The goal of a competitor is to gain an advantage in business with respect to the rival organization it targets.
    * It usually does this by copying intellectual property, trade secrets, acquisition strategies, or other
    * technical or business data from a rival organization with the intention of using the data to bolster its own assets and market position.
    * */
    String COMPETITOR = "competitor";

    /*
     * 	An enterprise organized to conduct significant, large-scale criminal activity for profit.
     *
     * Crime syndicates, also known as organized crime, are generally large, well-resourced groups that operate to
     * create profit from all types of crime.
     * */
    String CRIME_SYNDICATE = "crime-syndicate";

    /*
     * Individual who commits computer crimes, often for personal financial gain and often involves the theft of
     * something valuable.
     *
     *
     *
     * Intellectual property theft, extortion via ransomware, and physical destruction are common examples. A criminal
     * as defined here refers to those acting individually or in very small or informal groups. For sophisticated
     * organized criminal activity, see the crime syndicate descriptor.
     * */
    String CRIMINAL = "criminal";

    /*
     * An individual that tends to break into networks for the thrill or the challenge of doing so.
     *
     * Hackers may use advanced skills or simple attack scripts they have downloaded.
     * */
    String HACKER = "hacker";

    /*
     * A non-hostile insider who unintentionally exposes the organization to harm.
     *
     * “Insider” in this context includes any person extended internal trust, such as regular employees, contractors,
     consultants, and temporary workers.
     * */
    String INSIDER_ACCIDENTAL = "insider-accidental";

    /*
     * Current or former insiders who seek revengeful and harmful retaliation for perceived wrongs.
     *
     * “Insider” in this context includes any person extended internal trust, such as regular employees, contractors,
     * consultants, and temporary workers.
     *
     *
     * Disgruntled threat actors may have extensive knowledge that can be leveraged when conducting attacks and can
     * take any number of actions including sabotage, violence, theft, fraud, espionage, or embarrassing individuals
     * or the organization.
     * */
    String INSIDER_DISGRUNTLED = "insider-disgruntled";

    /*
     * Entities who work for the government or military of a nation state or who work at their direction.
     *
     * These actors typically have access to significant support, resources, training, and tools and are capable of
     * designing and executing very sophisticated and effective Intrusion Sets and Campaigns.
     * */
    String NATION_STATE = "nation-state";

    /*
     * Seeks to cause embarrassment and brand damage by exposing sensitive information in a manner designed to cause
     * a public relations crisis.
     *
     * A sensationalist may be an individual or small group of people motivated primarily by a need for notoriety.
     * Unlike the activist, the sensationalist generally has no political goal, and is not using bad PR to influence
     * the target to change its behavior or business practices.
     * */
    String SENSATIONALIST = "sensationalist";

    /*
     * Secretly collects sensitive information for use, dissemination, or sale.
     *
     * Traditional spies (governmental and industrial) are part of a well-resourced intelligence organization and are
     * capable of very sophisticated clandestine operations. However, insiders such as employees or consultants acting
     * as spies can be just as effective and damaging, even when their activities are largely opportunistic and not
     * part of an overall campaign.
     * */
    String SPY = "spy";

    /*
     * Uses extreme violence to advance a social or political agenda as well as monetary crimes to support its
     * activities.
     *
     * In this context a terrorist refers to individuals who target noncombatants with violence to send a message of
     * fear far beyond the actual events. They may act independently or as part of a terrorist organization.
     *
     * Terrorist organizations must typically raise much of their operating budget through criminal activity, which
     * often occurs online. Terrorists are also often adept at using and covertly manipulating social media for both
     * recruitment and impact.
     * */
    String TERRORIST = "terrorist";

    Set<String> THREAT_ACTOR_LABEL_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(ACTIVIST, COMPETITOR, CRIME_SYNDICATE, CRIMINAL, HACKER,
                    INSIDER_ACCIDENTAL, INSIDER_DISGRUNTLED, NATION_STATE, SENSATIONALIST, SPY, TERRORIST)));

    static boolean isStandard(String value) {
        return THREAT_ACTOR_LABEL_OPEN_VOCABULARY.contains(value);
    }

}
