package com.example.stix.api.vocabularies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: tool-label-ov
*
* The tool label vocabulary is currently used in the following SDO(s):
*
*    Tool
*
* Tool labels describe the categories of tools that can be used to perform attacks.
* */
public interface ToolLabelVocabulary {

    /*
    * Tools used to perform denial of service attacks or DDoS attacks, such as Low Orbit Ion Cannon (LOIC) and DHCPig.
    * */
    String DENIAL_OF_SERVICE = "denial-of-service";

    /*
     * Tools used to exploit software and systems, such as sqlmap and Metasploit.
     * */
    String EXPLOITATION = "exploitation";

    /*
     * Tools used to enumerate system and network information, e.g., NMAP.
     * */
    String INFORMATION_GATHERING = "information-gathering";

    /*
     * Tools used to capture network traffic, such as Wireshark and Kismet.
     * */
    String NETWORK_CAPTURE = "network-capture";

    /*
     * Tools used to crack password databases or otherwise exploit/discover credentials, either locally or remotely,
     * such as John the Ripper and NCrack.
     * */
    String CREDENTIAL_EXPLOITATION = "credential-exploitation";

    /*
     * Tools used to access machines remotely, such as VNC and Remote Desktop.
     * */
    String REMOTE_ACCESS = "remote-access";

    /*
    * Tools used to scan systems and networks for vulnerabilities, e.g., Nessus.
    * */
    String VULNERABILITY_SCANNING = "vulnerability-scanning";

    Set<String> TOOL_LABEL_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(DENIAL_OF_SERVICE, EXPLOITATION, INFORMATION_GATHERING,
                    NETWORK_CAPTURE, CREDENTIAL_EXPLOITATION, REMOTE_ACCESS, VULNERABILITY_SCANNING)));

    static boolean isStandard(String value) {
        return TOOL_LABEL_OPEN_VOCABULARY.contains(value);
    }

}
