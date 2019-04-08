package com.example.stix.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class KillChainPhase {

    private final String killChainName;

    private final String phaseName;

}
