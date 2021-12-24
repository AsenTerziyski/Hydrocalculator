package com.example.hydrocalc.calculator;

public class VelocityInMetersPerSecond {
    private final double flowInLitersPerSecond;
    private final double crossSectionAreaInSquareMeters;
    private double velocity;

    public VelocityInMetersPerSecond(double flow, double crossSectionArea) {
        this.flowInLitersPerSecond = flow;
        this.crossSectionAreaInSquareMeters = crossSectionArea;
    }

    public double getVelocity() {
        return (flowInLitersPerSecond / 1000) / crossSectionAreaInSquareMeters;
    }
}
