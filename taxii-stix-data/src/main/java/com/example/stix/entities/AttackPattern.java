package com.example.stix.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AttackPattern {

    private Long id;

    private final String name;

    private final String description;

    private final List<KillChainPhase> killChainPhases;

}
