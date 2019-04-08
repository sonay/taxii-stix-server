package com.example.stix.api.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.KillChainPhase;

import java.util.List;

/*
* Type Name: tool
*
* Tools are legitimate software that can be used by threat actors to perform attacks. Knowing how and when threat
* actors use such tools can be important for understanding how campaigns are executed. Unlike malware, these tools or
* software packages are often found on a system and have legitimate purposes for power users, system administrators,
* network administrators, or even normal users. Remote access tools (e.g., RDP) and network scanning tools (e.g., Nmap)
* are examples of Tools that may be used by a Threat Actor during an attack.
*
* The Tool SDO characterizes the properties of these software tools and can be used as a basis for making an assertion
* about how a Threat Actor uses them during an attack. It contains properties to name and describe the tool, a list of
* Kill Chain Phases the tool can be used to carry out, and the version of the tool.
*
* This SDO MUST NOT be used to characterize malware. Further, Tool MUST NOT be used to characterise tools used as part
* of a course of action in response to an attack. Tools used during response activities can be included directly as part
* of a Course of Action SDO.
* */
public interface Tool extends StixDomainObject {

    /*
    * The value of this property MUST be tool.
    *
    * REQUIRED
    * */
    String TYPE = "tool";

    @Override
    default StixType getType() {
        return StixType.TOOL;
    }


    /*
    * The kind(s) of tool(s) being described.
    *
    * This is an open vocabulary and values SHOULD come from the tool-label-ov vocabulary.
    *
    * REQUIRED
    * */
    String LABELS_PROPERTY = "labels";

    @Override
    List<String> getLabels();


    /*
    * The name used to identify the Tool.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
    * A description that provides more details and context about the Tool, potentially including its purpose and its
    * key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * The list of kill chain phases for which this Tool can be used.
    *
    * OPTIONAL
     * */
    String KILL_CHAIN_PHASES_PROPERTY = "kill_chain_phases";

    List<KillChainPhase> getKillChainPhases();


    /*
    * The version identifier associated with the Tool.
    *
    * OPTIONAL
    * */
    String TOOL_VERSION_PROPERTY = "tool_version";

    String getToolVersion();

}
