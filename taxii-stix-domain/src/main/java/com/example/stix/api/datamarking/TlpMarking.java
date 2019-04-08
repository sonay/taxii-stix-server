package com.example.stix.api.datamarking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* The TLP marking type defines how you would represent a Traffic Light Protocol (TLP) marking in a definition
* property. The value of the definition_type property MUST be tlp when using this marking type.
*
* */
public class TlpMarking implements MarkingObject {

    /* IMPLEMENTATION NOTE: Even though it would be nicer to have this class as an enum, doing so, Jackson
     *  (de)serialization prevents us from keeping the API clear of library specific annotations.
     */
    private static final List<TlpMarking> INSTANCES;

    /*
     * The following standard marking definitions MUST be used to reference or represent TLP markings. Other
     * instances of tlp-marking MUST NOT be used (the only instances of TLP marking definitions permitted are those
     * defined here).
     * */

    private static final TlpMarking WHITE = new TlpMarking("white");

    private static final TlpMarking AMBER = new TlpMarking("amber");

    private static final TlpMarking RED = new TlpMarking("red");

    private static final TlpMarking GREEN = new TlpMarking("green");

    static {
        List<TlpMarking> instances = new ArrayList<>();
        instances.add(WHITE);
        instances.add(AMBER);
        instances.add(RED);
        instances.add(GREEN);
        INSTANCES = Collections.unmodifiableList(instances);
    }

    private final String tlp;

    private TlpMarking(String value) {
        this.tlp = value;
    }

    public static TlpMarking red() {
        return RED;
    }

    public static TlpMarking green() {
        return GREEN;
    }

    public static TlpMarking amber() {
        return AMBER;
    }

    public static TlpMarking white() {
        return WHITE;
    }

    public static TlpMarking getInstance(String value) {
        for (TlpMarking instance : INSTANCES) {
            if (instance.getTlp().equals(value)) {
                return instance;
            }
        }
        throw new IllegalArgumentException("No such TlpMarking: " + value);
    }

    public static final String TLP_PROPERTY = "tlp";

    /*
    * The TLP level [TLP] of the content marked by this marking definition, as defined in this section.
    *
    * REQUIRED
    * */
    public static final String DEFINITION_TYPE = "tlp";

    public String getTlp() {
        return tlp;
    }

    // TODO: write a mixin then comment out
//    public StixType getType() {
//        return StixType.TLP_MARKING;
//    }

}
