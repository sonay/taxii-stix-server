package com.example.stix.api.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.KillChainPhase;

import java.util.List;


/*
* Type Name: attack-pattern
*
* Attack Patterns are a type of TTP that describe ways that adversaries attempt to compromise targets. Attack Patterns
* are used to help categorize attacks, generalize specific attacks to the patterns that they follow, and provide
* detailed information about how attacks are performed. An example of an attack pattern is "spear phishing": a common
* type of attack where an attacker sends a carefully crafted e-mail message to a party with the intent of getting them
* to click a link or open an attachment to deliver malware. Attack Patterns can also be more specific; spear phishing
* as practiced by a particular threat actor (e.g., they might generally say that the target won a contest) can also be
* an Attack Pattern.
*
* The Attack Pattern SDO contains textual descriptions of the pattern along with references to externally-defined
* taxonomies of attacks such as CAPEC [CAPEC]. Relationships from Attack Pattern can be used to relate it to what it
* targets (Vulnerabilities and Identities) and which tools and malware use it (Tool and Malware).
* */
public interface AttackPattern extends StixDomainObject {

    /*
    * The value of property field MUST be "attack-pattern".
    *
    * REQUIRED
     */
    String TYPE = "attack-pattern";

    @Override
    default StixType getType() {
        return StixType.ATTACK_PATTERN;
    }

    /*
    * A name used to identify the Attack Pattern.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();

    /*
    * A list of external references which refer to non-STIX information.
    * This property MAY be used to provide one or more Attack Pattern identifiers,
    * such as a CAPEC ID. When specifying a CAPEC ID, the source_name property of
    * the external reference MUST be set to capec and the external_id property MUST
    * be formatted as CAPEC-[id].
    *
    * OPTIONAL
     */
    @Override
    List<ExternalReference> getExternalReferences();

    /*
    * A description that provides more details and context about the Attack Pattern,
    * potentially including its purpose and its key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * The list of Kill Chain Phases for which this Attack Pattern is used.
    *
    * OPTIONAL
    * */
    String KILL_CHAIN_PHASES_PROPERTY = "kill_chain_phases";

    List<KillChainPhase> getKillChainPhases();

}
