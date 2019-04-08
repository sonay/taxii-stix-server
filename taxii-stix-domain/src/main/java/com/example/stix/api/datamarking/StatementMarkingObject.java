package com.example.stix.api.datamarking;

/*
* The Statement marking type defines the representation of a textual marking statement (e.g., copyright, terms of
* use, etc.) in a definition. The value of the definition_type property MUST be "statement" when using this marking
* type. Statement markings are generally not machine-readable and this specification does not define any behavior or
* actions based on their values.
*
* Content may be marked with multiple Statement marking types that do not override each other. In other words, the
* same content can be marked both with a statement saying "Copyright 2016" and a statement saying "Terms of use are
*  ..." and both statements apply.
*
* */
public interface StatementMarkingObject extends MarkingObject {

    /*
    * The Statement marking type defines the representation of a textual marking statement (e.g., copyright, terms
    * of use, etc.) in a definition. The value of the definition_type property MUST be statement when using this marking type. Statement markings are generally not machine-readable and this specification does not define any behavior or actions based on their values.
    *
    * Content may be marked with multiple Statement marking types that do not override each other. In other words, the
    * same content can be marked both with a statement saying "Copyright 2016" and a statement saying "Terms of use
    * are ..." and both statements apply.
    *
    * REQUIRED
    * */
    String DEFINITION_TYPE = "statement";

    String getStatement();

    // TODO: write a mixin then uncomment
//    default StixType getType() {
//        return StixType.MARKING_DEFINITION;
//    }

}
