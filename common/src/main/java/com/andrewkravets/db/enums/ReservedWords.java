package com.andrewkravets.db.enums;

/**
 * User: andrey.kravets
 * Date: 2/19/14 2:41 PM
 */
public enum ReservedWords {
    ID("__id__"),
    ADD("add"),
    CREATE("create"),
    REMOVE("remove"),
    UPDATE("update"),
    DELETE("delete"),
    PERSIST("persist"),
    LOAD("load"),
    WRONG("wrong");

    private ReservedWords(String representation) {
        this.representation = representation;
    }

    private String representation;

    public String getRepresentation() {
        return representation;
    }

}
