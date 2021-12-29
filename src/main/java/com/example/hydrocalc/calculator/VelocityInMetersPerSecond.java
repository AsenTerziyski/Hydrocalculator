package com.example.hydrocalc.calculator;

public class VelocityInMetersPerSecond {
    private final double flowInLitersPerSecond;
    private final double crossSectionAreaInSquareMeters;

    protected VelocityInMetersPerSecond(double flow, double crossSectionArea) {
        this.flowInLitersPerSecond = flow;
        this.crossSectionAreaInSquareMeters = crossSectionArea;
    }

    protected double getVelocity() {
        return (flowInLitersPerSecond / 1000) / crossSectionAreaInSquareMeters;
    }
}
