package com.andresoderlund.membership.model;

import lombok.ToString;

@ToString
public enum AgeRange {
    YOUTH("Ungdom"),
    ADULT("Vuxen"),
    RETIREE("Pensionär");

    private final String label;

    AgeRange(String label) {
        this.label = label;
    }

}
