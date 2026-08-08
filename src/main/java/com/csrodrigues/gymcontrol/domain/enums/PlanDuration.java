package com.csrodrigues.gymcontrol.domain.enums;

public enum PlanDuration {
    MONTHLY(30),
    BIMONTHLY(60),
    QUARTERLY(90);

    private final int days;

    PlanDuration(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}


