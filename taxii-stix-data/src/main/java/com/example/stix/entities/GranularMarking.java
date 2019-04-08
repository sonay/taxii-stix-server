package com.example.stix.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class GranularMarking {

    private final Identifier identifier;

    private final List<String> selectors;

}
