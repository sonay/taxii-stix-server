package com.example.stix.api.vocabularies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: attack-motivation-ov
*
* The attack motivation vocabulary is currently used in the following SDOs:
*
*    Intrusion Set
*    Threat Actor
*
* Knowing a Threat Actor or Intrusion Set's motivation may allow an analyst or defender to better understand likely
* targets and behaviors.
*
* Motivation shapes the intensity and the persistence of an attack. Threat Actors and Intrusion Sets usually act in a
* manner that reflects their underlying emotion or situation, and this informs defenders of the manner of attack.
* For example, a spy motivated by nationalism (ideology) likely has the patience to achieve long-term goals and work
* quietly for years, whereas a cyber-vandal out for notoriety can create an intense and attention-grabbing attack
* but may quickly lose interest and move on. Understanding these differences allows defenders to implement controls
* tailored to each type of attack for greatest efficiency.
*
* This section including vocabulary items and their descriptions is based on the Threat Agent Motivations publication
* from Intel Corp in February 2015 [Casey 2015].
*
* */
public interface AttackMotivationVocabulary {

    /*
    * A non-hostile actor whose benevolent or harmless intent inadvertently causes harm.
    *
    * For example, a well-meaning and dedicated employee who through distraction or poor training unintentionally 
    * causes harm to his or her organization.
    */
    String ACCIDENTAL = "accidental";

    /*
    * Being forced to act on someone else's behalf.
    *
    * Adversaries who are motivated by coercion are often forced through intimidation or blackmail to act illegally
    * for someone else’s benefit. Unlike the other motivations, a coerced person does not act for personal gain, but
    * out of fear of incurring a loss.
    * */
    String COERCION = "coercion";

    /*
    * A desire to assert superiority over someone or something else.
    *
    * Adversaries who are seeking dominance over a target are focused on using their power to force their target into
    * submission or irrelevance. Dominance may be found with ideology in some state-sponsored attacks and with
    * notoriety in some cyber vandalism based attacks.
    * */
    String DOMINANCE = "dominance";

    /*
    * A passion to express a set of ideas, beliefs, and values that may shape and drive harmful and illegal acts.
    *
    * Adversaries who act for ideological reasons (e.g., political, religious, human rights, environmental, desire to
    * cause chaos/anarchy, etc.) are not usually motivated primarily by the desire for profit; they are acting on
    * their own sense of morality, justice, or political loyalty.
    *
    * For example, an activist group may sabotage a company’s equipment because they believe the company is harming
    * the environment.
    * */
    String IDEOLOGY = "ideology";

    /*
    * Seeking prestige or to become well known through some activity.
    *
    * Adversaries motivated by notoriety are often seeking either personal validation or respect within a community
    * and staying covert is not a priority. In fact one of the main goals is to garner the respect of their target
    * audience.
    * */
    String NOTORIETY= "notoriety";

    /*
    * Seeking advantage over a competing organization, including a military organization.
    *
    * Adversaries motivated by increased profit or other gains through an unfairly obtained competitive advantage are
    * often seeking theft of intellectual property, business processes, or supply chain agreements and thus
    * accelerating their position in a market or capability.
    * */
    String ORGANIZATIONAL_GAIN = "organizational-gain";

    /*
    * The desire to improve one’s own financial status.
    *
    * Adversaries motivated by a selfish desire for personal gain are often out for gains that come from financial
    * fraud, hacking for hire, or intellectual property theft.
    *
    * While a Threat Actor or Intrusion Set may be seeking personal gain this does not mean they are acting alone.
    * Individuals can band together solely to maximize their own personal profits.
    * */
    String PERSONAL_GAIN = "personal-gain";

    /*
    * A desire to satisfy a strictly personal goal, including curiosity, thrill-seeking, amusement, etc.
    *
    * Threat Actors or Intrusion Set driven by personal satisfaction may incidentally receive some other gain from
    * their actions, such as a profit, but their primary motivation is to gratify a personal, emotional need.
    * Individuals can band together with others toward a mutual, but not necessarily organizational, objective.
    * */
    String PERSONAL_SATISFACTION = "personal-satisfaction";

    /*
    * A desire to avenge perceived wrongs through harmful actions such as sabotage, violence, theft, fraud, or
    * embarrassing certain individuals or the organization.
    *
    * A disgruntled Threat Actor or Intrusion Set seeking revenge can include current or former employees, who may
    * have extensive knowledge to leverage when conducting attacks. Individuals can band together with others if the
    * individual believes that doing so will enable them to cause more harm.
    * */
    String REVENGE = "revenge";

    /*
    * Acting without identifiable reason or purpose and creating unpredictable events.
    *
    * Unpredictable is not a miscellaneous or default category. Unpredictable means a truly random and likely bizarre
    * event, which seems to have no logical purpose to the victims.
    * */
    String UNPREDICTABLE = "unpredictable";

    Set<String> ATTACK_MOTIVATION_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(ACCIDENTAL, COERCION, DOMINANCE, IDEOLOGY, NOTORIETY,
                    ORGANIZATIONAL_GAIN, PERSONAL_GAIN, PERSONAL_SATISFACTION, REVENGE, UNPREDICTABLE)));

    static boolean isStandard(String value) {
        return ATTACK_MOTIVATION_OPEN_VOCABULARY.contains(value);
    }
}
